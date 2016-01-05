package com.vaadin.tests.themes.valo;

import com.vaadin.annotations.StyleSheet;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;

@StyleSheet("vaadin://themes/valo/styles.css")
public class NonDraggableWindow extends AbstractTestUI {
    @Override
    protected void setup(VaadinRequest request) {
        Window window = new Window("Non-draggable window", new Label());
        window.setDraggable(false);

        addWindow(window);
    }
}
