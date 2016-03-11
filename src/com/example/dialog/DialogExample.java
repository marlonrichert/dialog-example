package com.example.dialog;

import static com.example.dialog.Button.PRIMARY;
import static com.example.dialog.TextField.SECTION_TOP;
import static com.example.dialog.TextField.SECTION_RIGHT;
import static com.example.dialog.TextField.SECTION_BOTTOM;
import static com.example.dialog.TextField.SECTION_LEFT;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
@Theme("dialog-example")
public class DialogExample extends UI {
	private static final String BADGE = "badge";

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = DialogExample.class, widgetset = "com.example.dialog.widgetset.Dialog_exampleWidgetset")
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		addWindow(new Dialog(new Layout() {
			{
				add(new Image(new ThemeResource("icon-beta.png"), BADGE));
				add(new Layout(VERTICAL) {
					{
						add(new Header("September golf trip", "Robert Trent Jones Golf Trail"));
						add(new Layout(VERTICAL, PADDED) {
							{
								add(new TextField("Email"));
								addSpace();
								add(new Layout(VERTICAL) {
									{
										add(new TextField("Card number", SECTION_BOTTOM));
										add(new Layout(HORIZONTAL) {
											{
												add(new TextField("MM / YY", SECTION_TOP, SECTION_RIGHT));
												add(new TextField("CVC", SECTION_TOP, SECTION_LEFT));
											}
										});
									}
								});
								addSpace();
								add(new CheckBox("Remember me"));
								addSpace();
								addSpace();
								add(new Button("Pay $499.99", PRIMARY));
							}
						});
					}
				});
			}
		}));
	}
}