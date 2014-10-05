package com.blogspot.logarifm6.client.view.impl;

import com.blogspot.logarifm6.client.TestReactResources;
import com.blogspot.logarifm6.client.presenter.TestReactionPresenter;
import com.blogspot.logarifm6.client.view.TestReactionView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.*;
import com.google.inject.Inject;

/**
 * Created by USER on 14.09.2014.
 */
public class TestReactionViewImpl extends Composite implements TestReactionView {
    interface TestReactionViewUiBinder extends UiBinder<Widget, TestReactionViewImpl> {
    }

    private static TestReactionViewUiBinder ourUiBinder = GWT.create(TestReactionViewUiBinder.class);

    private TestReactionPresenter reactionPresenter;

    @UiField
    Button startButton;

    @UiField
    FlowPanel content;

    @UiField(provided = true)
    final TestReactResources res;

    @UiField
    Label result;

    @Inject
    public TestReactionViewImpl(TestReactResources reactResources) {
        this.res = reactResources;
        initWidget(ourUiBinder.createAndBindUi(this));
    }

    @UiHandler("startButton")
    public void onClickedStartButton(ClickEvent clickEvent) {
        if (startButton.getText().equals("Stop")) {
            reactionPresenter.stopAction();
        } else {
            reactionPresenter.startButtonClicked();
        }
    }

    public void setReactionPresenter(TestReactionPresenter reactionPresenter) {
        this.reactionPresenter = reactionPresenter;
    }

    public HasWidgets getContent() {
        return content;
    }

    public void setResult(String result) {
        this.result.setText(result);
    }

    public Button getStartButton() {
        return startButton;
    }
}