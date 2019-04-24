/*
 * Copyright 2000-2018 Vaadin Ltd.
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
package com.vaadin.flow.component.littemplate;

import java.io.Serializable;

import com.vaadin.flow.component.polymertemplate.IdMapper;
import com.vaadin.flow.component.polymertemplate.TemplateDataAnalyzer.ParserData;
import com.vaadin.flow.internal.ReflectionCache;
import com.vaadin.flow.server.VaadinService;

/**
 * Template initialization related logic (parse template, create sub-templates,
 * inject elements by id).
 *
 * @author Vaadin Ltd
 * @since 1.0
 *
 */
public class LitTemplateInitializer implements Serializable {
    private static final ReflectionCache<LitTemplate<?>, ParserData> CACHE = new ReflectionCache<>(
            templateClass -> {
                return new LitTemplateDataAnalyzer(templateClass)
                        .parseTemplate();
            });

    private final LitTemplate<?> template;

    private final ParserData parserData;

    /**
     * Creates a new initializer instance.
     *
     * @param template
     *            a template to initialize
     * @param service
     *            the related service
     */
    @SuppressWarnings("unchecked")
    public LitTemplateInitializer(LitTemplate<?> template,
            VaadinService service) {
        this.template = template;

        boolean productionMode = service.getDeploymentConfiguration()
                .isProductionMode();

        Class<? extends LitTemplate<?>> templateClass = (Class<? extends LitTemplate<?>>) template
                .getClass();

        ParserData data = null;
        if (productionMode) {
            data = CACHE.get(templateClass);
        }
        if (data == null) {
            data = new LitTemplateDataAnalyzer(templateClass).parseTemplate();
        }
        parserData = data;
    }

    public void mapComponents() {
        IdMapper idMapper = new IdMapper(template);
        parserData.forEachInjectedField((field, id, tag) -> {
            idMapper.mapComponentOrElement(field, id, tag, element -> {
            });
        });
    }

}