/*
 * Copyright 2000-2017 Vaadin Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.vaadin.hummingbird.nodefeature;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

import com.vaadin.annotations.EventData;
import com.vaadin.annotations.EventHandler;
import com.vaadin.annotations.RepeatIndex;
import com.vaadin.hummingbird.StateNode;
import com.vaadin.hummingbird.template.PolymerTemplate;

/**
 * Methods which are published as event-handlers on the client side.
 *
 * @author Vaadin Ltd
 *
 */
public class PolymerServerEventHandlers
        extends AbstractServerHandlers<PolymerTemplate<?>> {
    private static final String REPEAT_INDEX_VALUE = "event.model.index";

    /**
     * Creates a new meta information list for the given state node.
     *
     * @param node
     *            the state node this list belongs to
     */
    public PolymerServerEventHandlers(StateNode node) {
        super(node);
    }

    @Override
    protected void addHandlerMethod(Method method, Collection<Method> methods) {
        super.addHandlerMethod(method, methods);

        addMethodParameters(method);
    }

    @Override
    protected void ensureSupportedParameterTypes(Method method) {
        Stream.of(method.getParameters())
                .forEach(parameter -> checkParameterTypeAndAnnotation(method,
                        parameter));
    }

    @Override
    protected Class<? extends Annotation> getHandlerAnnotation() {
        return EventHandler.class;
    }

    private void checkParameterTypeAndAnnotation(Method method,
            Parameter parameter) {
        boolean hasEventDataAnnotation = parameter
                .isAnnotationPresent(EventData.class);
        boolean hasRepeatIndexAnnotation = parameter
                .isAnnotationPresent(RepeatIndex.class);

        if (!Boolean.logicalXor(hasEventDataAnnotation,
                hasRepeatIndexAnnotation)) {
            throw new IllegalStateException(String.format(
                    "EventHandler method '%s' should have the parameter with index %s annotated either with @EventData annotation (to get any particular data from the event)"
                            + " or have 'int' or 'Integer' type and be annotated with @RepeatIndex annotation (to get element index in dom-repeat)",
                    method.getName(), getParameterIndex(parameter)));
        } else if (hasEventDataAnnotation) {
            ensureSupportedParameterType(method, parameter.getType());
        } else {
            Class<?> parameterType = parameter.getType();
            if (!parameterType.equals(int.class)
                    && !parameterType.equals(Integer.class)) {
                throw new IllegalStateException(String.format(
                        "EventHandler method '%s' has parameter with index %s, annotated with @RepeatIndex that has incorrect type '%s', should be 'int' or 'Integer'",
                        method.getName(), getParameterIndex(parameter),
                        parameterType));
            }
        }
    }

    private static String getParameterIndex(Parameter parameter) {
        return parameter.getName().replace("arg", "");
    }

    private void addMethodParameters(Method method) {
        getNode().getFeature(PolymerEventListenerMap.class)
                .add(method.getName(), getParameters(method));
    }

    private String[] getParameters(Method method) {
        return Stream.of(method.getParameters()).flatMap(parameter -> Stream.of(
                Optional.ofNullable(parameter.getAnnotation(EventData.class))
                        .map(EventData::value),
                Optional.ofNullable(parameter.getAnnotation(RepeatIndex.class))
                        .map(annotation -> REPEAT_INDEX_VALUE)))
                .filter(Optional::isPresent).map(Optional::get)
                .toArray(String[]::new);
    }

}
