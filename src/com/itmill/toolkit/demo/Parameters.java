package com.itmill.toolkit.demo;

import java.net.URL;
import java.util.Iterator;
import java.util.Map;

import com.itmill.toolkit.terminal.DownloadStream;
import com.itmill.toolkit.terminal.ExternalResource;
import com.itmill.toolkit.terminal.ParameterHandler;
import com.itmill.toolkit.terminal.URIHandler;
import com.itmill.toolkit.ui.*;

/**
 * This is a demonstration of how URL parameters can be recieved and handled.
 * Parameters and URL:s can be received trough the windows by registering
 * URIHandler and ParameterHandler classes window.
 * 
 * @since 3.1.1
 */
public class Parameters extends com.itmill.toolkit.Application implements
		URIHandler, ParameterHandler {

	private Label context = new Label();

	private Label relative = new Label();

	private Table params = new Table();

	public void init() {
		Window main = new Window("Table demo");
		setMainWindow(main);

		// set the application to use Corporate -theme
		setTheme("corporate");

		// This class acts both as URI handler and parameter handler
		main.addURIHandler(this);
		main.addParameterHandler(this);

		OrderedLayout layout = new OrderedLayout();
		Label info = new Label("To test URI and Parameter Handlers, "
				+ "add get parameters to URL. For example try examples below: ");
		info.setCaption("Usage info");
		layout.addComponent(info);
		try {
			URL u1 = new URL(getURL(), "test/uri?test=1&test=2");
			URL u2 = new URL(getURL(), "foo/bar?mary=john&count=3");
			layout.addComponent(new Link(u1.toString(),
					new ExternalResource(u1)));
			layout.addComponent(new Label("Or this: "));
			layout.addComponent(new Link(u2.toString(),
					new ExternalResource(u2)));
		} catch (Exception e) {
			System.out.println("Couldn't get hostname for this machine: "
					+ e.toString());
			e.printStackTrace();
		}

		// URI
		Panel panel1 = new Panel("URI Handler");
		context.setCaption("Last URI handler context");
		panel1.addComponent(context);
		relative.setCaption("Last relative URI");
		panel1.addComponent(relative);
		layout.addComponent(panel1);

		// Parameters
		params.addContainerProperty("Values", String.class, "");
		Panel panel2 = new Panel("Parameter Handler");
		params.setCaption("Last parameters");
		params.setColumnHeaderMode(Table.COLUMN_HEADER_MODE_ID);
		params.setRowHeaderMode(Table.ROW_HEADER_MODE_ID);
		panel2.addComponent(params);
		layout.addComponent(panel2);

		main.addComponent(layout);
	}

	/**
	 * Update URI
	 * 
	 * @see com.itmill.toolkit.terminal.URIHandler#handleURI(URL, String)
	 */
	public DownloadStream handleURI(URL context, String relativeUri) {
		this.context.setValue(context.toString());
		this.relative.setValue(relativeUri);
		return null;
	}

	/**
	 * Handles GET parameters, in this demo GET parameteres are used to
	 * communicate with EmbeddedToolkit.jsp
	 */
	public void handleParameters(Map parameters) {
		// TODO: disabled, see bug #550
		// params.removeAllItems();
		for (Iterator i = parameters.keySet().iterator(); i.hasNext();) {
			String name = (String) i.next();
			String[] values = (String[]) parameters.get(name);
			String v = "";
			for (int j = 0; j < values.length; j++) {
				if (v.length() > 0)
					v += ", ";
				v += "'" + values[j] + "'";
			}
			params.addItem(new Object[] { v }, name);
		}
	}
}
