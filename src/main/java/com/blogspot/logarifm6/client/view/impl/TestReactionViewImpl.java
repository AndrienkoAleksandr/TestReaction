package com.blogspot.logarifm6.client.view.impl;

import com.blogspot.logarifm6.client.TestReactResources;
import com.blogspot.logarifm6.client.game_component.Settings;
import com.blogspot.logarifm6.client.presenter.TestReactionPresenter;
import com.blogspot.logarifm6.client.view.TestReactionView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyPressEvent;
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
    ListBox columnBox;
  
    @UiField
    ListBox rowBox;
  
    @UiField
    TextBox amountFlash;

    @UiField
    Label result;
  
    private Settings settings;
  
    @Inject
    public TestReactionViewImpl(TestReactResources reactResources, 
                                Settings settings) {
      GWT.log(settings.hashCode() + "{}");
        this.res = reactResources;
        this.settings = settings;
        initWidget(ourUiBinder.createAndBindUi(this));
        generateListOfSize();
        displaySettings();
    }

    private void displaySettings() {
//        columnBox.setSelectedIndex(1);
//        rowBox.setSelectedIndex(1);
        amountFlash.setValue(String.valueOf(settings.getAmountFlash()));
    }

    private void generateListOfSize() {
       for (int i = settings.getMinAmountColumn(); i <= settings.getMaxAmountColumn(); i++) {
         columnBox.addItem(String.valueOf(i));
       }
       for (int j = settings.getMinAmountRow(); j <= settings.getMaxAmountRow(); j++) {
         rowBox.addItem(String.valueOf(j));
       }
    }

    @UiHandler("startButton")
    public void onClickedStartButton(ClickEvent clickEvent) {
        if (startButton.getText().equals("Stop")) {
            reactionPresenter.stopAction();
        } else {
            reactionPresenter.startButtonClicked();
        }
    }
    
    @UiHandler("save")
    public void onClickedSaveButton(ClickEvent clickEvent) {
      reactionPresenter.saveButtonClicked();
    }
  
     @UiHandler("amountFlash")
    public void onKeyUp(KeyPressEvent event) {
        if (!Character.isDigit(event.getCharCode())) {
          amountFlash.cancelKey();
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

    @Override
    public int getAmounColumn() {
        String result = columnBox.getValue(columnBox.getSelectedIndex());
        return Integer.valueOf(result);
    }

    @Override
    public int getAmountRow() {
        String result = rowBox.getValue(rowBox.getSelectedIndex());
        return Integer.valueOf(result);
    }

    @Override
    public int getAmountFlash() {
        return Integer.parseInt(amountFlash.getValue());
    }
}