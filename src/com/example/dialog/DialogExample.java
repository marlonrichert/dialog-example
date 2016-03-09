package com.example.dialog;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;

@SuppressWarnings("serial")
@Theme("dialog-example")
public class DialogExample extends UI {
	private static final String VERTICAL = "vertical";

	Window window = new Window() {
		{
			setResizable(false);
			setDraggable(true);

			setContent(new CssLayout() {
				{
					addComponent(new Image() {
						{
							setSource(new ThemeResource("icon-beta.png"));
							addStyleName("badge");
						}
					});
					addComponent(new CssLayout() {
						{
							addStyleName(VERTICAL);

							addComponent(new Label(
									"<header><h1>September golf trip</h1><p>Robert Trent Jones Golf Trail</p></header>",
									ContentMode.HTML) {
								{
									setSizeUndefined();
									addStyleName("v-panel-caption");
								}
							});
							addComponent(new CssLayout() {
								{
									addStyleName(VERTICAL);
									addStyleName("content-area");

									addComponent(textField("Email"));
									addComponent(new CssLayout() {
										{
											addStyleName(VERTICAL);

											addComponent(textField("Card number"));
											addComponent(new CssLayout() {
												{
													addStyleName("horizontal");

													addComponent(textField("MM / YY"));
													addComponent(textField("CVC"));
												}
											});
										}
									});
									addComponent(new CheckBox("Remember me"));
									addComponent(new Button("Pay $499.99") {
										{
											addStyleName(ValoTheme.BUTTON_PRIMARY);
										}
									});
								}
							});
						}
					});
				}
			});
		}
	};

	private Component textField(String label) {
		return new CssLayout() {
			{
				addStyleName("text-field");

				addComponent(new Image() {
					{
						setSource(new ThemeResource("star_12x11.png"));
					}
				});
				addComponent(new TextField() {
					{
						setInputPrompt(label);
					}
				});
			}
		};
	}

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = DialogExample.class, widgetset = "com.example.dialog.widgetset.Dialog_exampleWidgetset")
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		addWindow(window);
		window.center();
	}

}