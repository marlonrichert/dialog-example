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
							addStyleName("layout--vertical");

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
									addStyleName("content-area");
									addStyleName("layout--vertical");

									addComponent(new ExampleTextField("Email"));
									addComponent(new CssLayout() {
										{
											addStyleName("layout--vertical");

											addComponent(new ExampleTextField("Card number") {
												{
													addStyleName("text-field--top");
												}
											});
											addComponent(new CssLayout() {
												{
													addStyleName("layout--horizontal");

													addComponent(new ExampleTextField("MM / YY") {
														{
															addStyleName("text-field--lower-left");
														}
													});
													addComponent(new ExampleTextField("CVC") {
														{
															addStyleName("text-field--lower-right");
														}
													});
												}
											});
										}
									});
									addComponent(new CheckBox("Remember me"));
									addComponent(new Label());
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

	private class ExampleTextField extends CssLayout {
		public ExampleTextField(String label) {
			addStyleName("text-field");

			addComponent(new Image() {
				{
					addStyleName("text-field__icon");
					setSource(new ThemeResource("star_12x11.png"));
				}
			});
			addComponent(new TextField() {
				{
					addStyleName("text-field__input");
					setInputPrompt(label);
				}
			});
		}
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