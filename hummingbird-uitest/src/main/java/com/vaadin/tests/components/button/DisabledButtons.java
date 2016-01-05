package com.vaadin.tests.components.button;

import com.vaadin.server.ExternalResource;
import com.vaadin.tests.components.TestBase;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

public class DisabledButtons extends TestBase {

    private static final ExternalResource ICON = new ExternalResource(
            "vaadin://themes/runo/icons/16/ok.png");
    private String CAPTION = "Caption";

    @Override
    protected String getTestDescription() {
        return "The disabled buttons should be identical to the enabled buttons but grayed out.";
    }

    @Override
    protected Integer getTicketNumber() {
        return 3110;
    }

    @Override
    protected void setup() {
        HorizontalLayout hl = new HorizontalLayout();
        hl.addComponent(createButtons(true));
        hl.addComponent(createButtons(false));

        add(hl);

    }

    private Component createButtons(boolean enabled) {
        VerticalLayout vl = new VerticalLayout();
        Button b;

        // Button w/ text
        b = new Button(CAPTION);
        b.setEnabled(enabled);
        vl.addComponent(b);

        // Button w/ text, icon
        b = new Button(CAPTION);
        b.setEnabled(enabled);
        b.setIcon(ICON);
        vl.addComponent(b);

        // Button w/ icon
        b = new Button();
        b.setEnabled(enabled);
        b.setIcon(ICON);
        vl.addComponent(b);

        return vl;
    }

}
