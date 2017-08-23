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
package com.vaadin.generated.vaadin.date.picker;

import com.vaadin.ui.Component;
import com.vaadin.ui.ComponentSupplier;
import com.vaadin.ui.HasStyle;
import javax.annotation.Generated;
import com.vaadin.annotations.Tag;
import com.vaadin.annotations.HtmlImport;
import elemental.json.JsonObject;
import com.vaadin.annotations.EventData;
import com.vaadin.annotations.DomEvent;
import com.vaadin.ui.ComponentEvent;
import com.vaadin.flow.event.ComponentEventListener;
import com.vaadin.shared.Registration;

@Generated({"Generator: com.vaadin.generator.ComponentGenerator#0.1-SNAPSHOT",
		"WebComponent: DatePickerOverlayElement#2.0.2", "Flow#0.1-SNAPSHOT"})
@Tag("vaadin-date-picker-overlay")
@HtmlImport("frontend://bower_components/vaadin-date-picker/vaadin-date-picker-overlay.html")
public class GeneratedVaadinDatePickerOverlay<R extends GeneratedVaadinDatePickerOverlay<R>>
		extends
			Component implements ComponentSupplier<R>, HasStyle {

	/**
	 * <p>
	 * Description copied from corresponding location in WebComponent:
	 * </p>
	 * <p>
	 * The value for this element.
	 * <p>
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 * </p>
	 */
	protected JsonObject protectedGetSelectedDate() {
		return (JsonObject) getElement().getPropertyRaw("selectedDate");
	}

	/**
	 * <p>
	 * Description copied from corresponding location in WebComponent:
	 * </p>
	 * <p>
	 * The value for this element.
	 * </p>
	 * 
	 * @param selectedDate
	 *            the JsonObject value to set
	 * @return this instance, for method chaining
	 */
	protected R setSelectedDate(elemental.json.JsonObject selectedDate) {
		getElement().setPropertyJson("selectedDate", selectedDate);
		return get();
	}

	/**
	 * <p>
	 * Description copied from corresponding location in WebComponent:
	 * </p>
	 * <p>
	 * Date value which is focused using keyboard.
	 * <p>
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 * </p>
	 */
	protected JsonObject protectedGetFocusedDate() {
		return (JsonObject) getElement().getPropertyRaw("focusedDate");
	}

	/**
	 * <p>
	 * Description copied from corresponding location in WebComponent:
	 * </p>
	 * <p>
	 * Date value which is focused using keyboard.
	 * </p>
	 * 
	 * @param focusedDate
	 *            the JsonObject value to set
	 * @return this instance, for method chaining
	 */
	protected R setFocusedDate(elemental.json.JsonObject focusedDate) {
		getElement().setPropertyJson("focusedDate", focusedDate);
		return get();
	}

	/**
	 * <p>
	 * Description copied from corresponding location in WebComponent:
	 * </p>
	 * <p>
	 * Date which should be visible when there is no value selected.
	 * <p>
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 * </p>
	 */
	protected JsonObject protectedGetInitialPosition() {
		return (JsonObject) getElement().getPropertyRaw("initialPosition");
	}

	/**
	 * <p>
	 * Description copied from corresponding location in WebComponent:
	 * </p>
	 * <p>
	 * Date which should be visible when there is no value selected.
	 * </p>
	 * 
	 * @param initialPosition
	 *            the JsonObject value to set
	 * @return this instance, for method chaining
	 */
	protected R setInitialPosition(elemental.json.JsonObject initialPosition) {
		getElement().setPropertyJson("initialPosition", initialPosition);
		return get();
	}

	/**
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	protected JsonObject protectedGetI18n() {
		return (JsonObject) getElement().getPropertyRaw("i18n");
	}

	/**
	 * @param i18n
	 *            the JsonObject value to set
	 * @return this instance, for method chaining
	 */
	protected R setI18n(elemental.json.JsonObject i18n) {
		getElement().setPropertyJson("i18n", i18n);
		return get();
	}

	/**
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	public boolean isShowWeekNumbers() {
		return getElement().getProperty("showWeekNumbers", false);
	}

	/**
	 * @param showWeekNumbers
	 *            the boolean value to set
	 * @return this instance, for method chaining
	 */
	public R setShowWeekNumbers(boolean showWeekNumbers) {
		getElement().setProperty("showWeekNumbers", showWeekNumbers);
		return get();
	}

	/**
	 * <p>
	 * Description copied from corresponding location in WebComponent:
	 * </p>
	 * <p>
	 * The earliest date that can be selected. All earlier dates will be
	 * disabled.
	 * <p>
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 * </p>
	 */
	protected JsonObject protectedGetMinDate() {
		return (JsonObject) getElement().getPropertyRaw("minDate");
	}

	/**
	 * <p>
	 * Description copied from corresponding location in WebComponent:
	 * </p>
	 * <p>
	 * The earliest date that can be selected. All earlier dates will be
	 * disabled.
	 * </p>
	 * 
	 * @param minDate
	 *            the JsonObject value to set
	 * @return this instance, for method chaining
	 */
	protected R setMinDate(elemental.json.JsonObject minDate) {
		getElement().setPropertyJson("minDate", minDate);
		return get();
	}

	/**
	 * <p>
	 * Description copied from corresponding location in WebComponent:
	 * </p>
	 * <p>
	 * The latest date that can be selected. All later dates will be disabled.
	 * <p>
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 * </p>
	 */
	protected JsonObject protectedGetMaxDate() {
		return (JsonObject) getElement().getPropertyRaw("maxDate");
	}

	/**
	 * <p>
	 * Description copied from corresponding location in WebComponent:
	 * </p>
	 * <p>
	 * The latest date that can be selected. All later dates will be disabled.
	 * </p>
	 * 
	 * @param maxDate
	 *            the JsonObject value to set
	 * @return this instance, for method chaining
	 */
	protected R setMaxDate(elemental.json.JsonObject maxDate) {
		getElement().setPropertyJson("maxDate", maxDate);
		return get();
	}

	/**
	 * <p>
	 * Description copied from corresponding location in WebComponent:
	 * </p>
	 * <p>
	 * Input label
	 * <p>
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 * </p>
	 */
	public String getLabel() {
		return getElement().getProperty("label");
	}

	/**
	 * <p>
	 * Description copied from corresponding location in WebComponent:
	 * </p>
	 * <p>
	 * Input label
	 * </p>
	 * 
	 * @param label
	 *            the String value to set
	 * @return this instance, for method chaining
	 */
	public R setLabel(java.lang.String label) {
		getElement().setProperty("label", label == null ? "" : label);
		return get();
	}

	public void connectedCallback() {
		getElement().callFunction("connectedCallback");
	}

	public void announceFocusedDate() {
		getElement().callFunction("announceFocusedDate");
	}

	/**
	 * <p>
	 * Description copied from corresponding location in WebComponent:
	 * </p>
	 * <p>
	 * Focuses the cancel button
	 * </p>
	 */
	public void focusCancel() {
		getElement().callFunction("focusCancel");
	}

	/**
	 * <p>
	 * Description copied from corresponding location in WebComponent:
	 * </p>
	 * <p>
	 * Scrolls the list to the given Date.
	 * </p>
	 * 
	 * @param date
	 *            Missing documentation!
	 * @param animate
	 *            Missing documentation!
	 */
	protected void scrollToDate(elemental.json.JsonObject date,
			elemental.json.JsonObject animate) {
		getElement().callFunction("scrollToDate", date, animate);
	}

	/**
	 * <p>
	 * Description copied from corresponding location in WebComponent:
	 * </p>
	 * <p>
	 * Scrolls the month and year scrollers enough to reveal the given date.
	 * </p>
	 * 
	 * @param date
	 *            Missing documentation!
	 */
	protected void revealDate(elemental.json.JsonObject date) {
		getElement().callFunction("revealDate", date);
	}

	@DomEvent("scroll-animation-finished")
	public static class ScrollAnimationFinishedEvent<R extends GeneratedVaadinDatePickerOverlay<R>>
			extends
				ComponentEvent<R> {
		private final double detailPosition;
		private final double detailOldPosition;

		public ScrollAnimationFinishedEvent(R source, boolean fromClient,
				@EventData("event.detail.position") double detailPosition,
				@EventData("event.detail.oldPosition") double detailOldPosition) {
			super(source, fromClient);
			this.detailPosition = detailPosition;
			this.detailOldPosition = detailOldPosition;
		}

		public double getDetailPosition() {
			return detailPosition;
		}

		public double getDetailOldPosition() {
			return detailOldPosition;
		}
	}

	public Registration addScrollAnimationFinishedListener(
			ComponentEventListener<ScrollAnimationFinishedEvent<R>> listener) {
		return addListener(ScrollAnimationFinishedEvent.class,
				(ComponentEventListener) listener);
	}

	@DomEvent("selected-date-changed")
	public static class SelectedDateChangeEvent<R extends GeneratedVaadinDatePickerOverlay<R>>
			extends
				ComponentEvent<R> {
		public SelectedDateChangeEvent(R source, boolean fromClient) {
			super(source, fromClient);
		}
	}

	public Registration addSelectedDateChangeListener(
			ComponentEventListener<SelectedDateChangeEvent<R>> listener) {
		return addListener(SelectedDateChangeEvent.class,
				(ComponentEventListener) listener);
	}

	@DomEvent("focused-date-changed")
	public static class FocusedDateChangeEvent<R extends GeneratedVaadinDatePickerOverlay<R>>
			extends
				ComponentEvent<R> {
		public FocusedDateChangeEvent(R source, boolean fromClient) {
			super(source, fromClient);
		}
	}

	public Registration addFocusedDateChangeListener(
			ComponentEventListener<FocusedDateChangeEvent<R>> listener) {
		return addListener(FocusedDateChangeEvent.class,
				(ComponentEventListener) listener);
	}
}