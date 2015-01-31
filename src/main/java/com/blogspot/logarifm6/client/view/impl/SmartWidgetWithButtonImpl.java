package com.blogspot.logarifm6.client.view.impl;

import com.blogspot.logarifm6.client.TestReactResources;
import com.blogspot.logarifm6.client.presenter.TestReactionPresenter;
import com.blogspot.logarifm6.client.view.SmartWidget;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.inject.Inject;

/**
 * Created by logarifm on 15.09.14.
 */
public class SmartWidgetWithButtonImpl extends Composite implements SmartWidget {

    private boolean isChecked;

    private boolean isClicked;

    private final Button button ;

    private final TestReactResources style;

    private TestReactionPresenter presenter;

    @Inject
    public SmartWidgetWithButtonImpl(TestReactResources style) {
        button = new Button("test");
        initWidget(button);
        this.style = style;

        initClickHandler();
    }

    public void setPresenter(TestReactionPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public boolean isChecked() {
        return isChecked;
    }

    @Override
    public void setChecked(boolean isChecked) {
        this.isChecked = isChecked;
        if (isChecked) {
            setRedStyle();
        } else {
            setWhiteStyle();
        }
    }

    private void setRedStyle() {
        button.setStyleName(style.getStyle().redCSS());
    }

    private void setWhiteStyle() {
        button.setStyleName(style.getStyle().whiteCSS());
    }

    private void initClickHandler() {

        button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                presenter.userClickedButton(isChecked(), isClicked);
            }
        });
    }

    public void setClicked(boolean isClicked) {
        this.isClicked = isClicked;
    }

    @Override
    public void addStyleName(String style) {
        button.addStyleName(style);
    }


}