package com.blogspot.logarifm6.client.presenter;

import com.blogspot.logarifm6.client.TestReactResources;
import com.blogspot.logarifm6.client.game_component.Settings;
import com.blogspot.logarifm6.client.gin.TestInjector;
import com.blogspot.logarifm6.client.view.SmartWidget;
import com.blogspot.logarifm6.client.view.TestReactionView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 14.09.2014.
 */
public class TestReactionPresenterImpl implements TestReactionPresenter {

    private TestReactionView reactionView;

    private boolean isClicked;

    private int counter = 1;

    private int randomNumber = -1;

    private List<SmartWidget> buttons = new ArrayList<>();

    private TestReactResources resources;

    private float successTrying;

    private String message;

    private int amountSwitch;

    private Timer timer;

    private int nextNumber = -1;
  
    private HasWidgets container;
  
    private Settings settings;

    @Inject
    public TestReactionPresenterImpl(TestReactionView reactionView,
                                     TestReactResources resources,
                                     Settings settings) {
        this.reactionView = reactionView;
        this.resources = resources;
        this.settings = settings;
        this.amountSwitch = settings.getAmountFlash();
        reactionView.setReactionPresenter(this);
        initPanelButton();
    }

    private void initPanelButton() {
      buttons.clear();
      for(int i = 0; i < settings.getAmountRow(); i++) {
            createColumn(reactionView.getContent(), new FlowPanel());
        }
    }
  
    private void createColumn(HasWidgets contentPanel, FlowPanel flowPanel) {
        TestInjector injector = GWT.create(TestInjector.class);
        for(int i = 0; i < settings.getAmountColumn(); i++) {

          SmartWidget smartWidget = injector.getSmartWidget();
          smartWidget.setPresenter(this);

          buttons.add(smartWidget);

          flowPanel.add(smartWidget);

          smartWidget.addStyleName(resources.getStyle().whiteCSS());

          contentPanel.add(flowPanel);
        }
    }

    @Override
    public void go(HasWidgets container) {
        this.container = container;
        container.add(reactionView.asWidget());
    }

    @Override
    public void startButtonClicked() {

        reactionView.getStartButton().setText("Stop");
        reactionView.setResult("Come on!!! Let's go!!! Quickly!");

        timer = new Timer() {
            @Override
            public void run() {
                if (randomNumber != -1) {
                    buttons.get(randomNumber).setChecked(false);
                    buttons.get(randomNumber).setClicked(false);
                }

                randomNumber = getRandomNumber();

                buttons.get(randomNumber).setChecked(true);
                counter++;
                if (counter > amountSwitch + 1) {
                    cancel();
                }
            }

            private int getRandomNumber() {
                while (true) {
                    nextNumber = Random.nextInt(settings.getAmountColumn() * settings.getAmountRow());
                    if (nextNumber != randomNumber) {
                        break;
                    }
                }
                return nextNumber;
            }

            @Override
            public void cancel() {
                message = "Your winning percentage " + successTrying / amountSwitch * 100 + " %";
                reactionView.setResult(message);
                super.cancel();
                buttons.get(randomNumber)
                        .setChecked(false);
                randomNumber = -1;
                counter = 1;
                successTrying = 0;
                reactionView.getStartButton().setText("Start!!!");
            }
        };
        timer.scheduleRepeating(1000);
    }

    @Override
    public void userClickedButton(boolean isChecked, boolean isClicked) {
        if (isChecked && !isClicked) {
            successTrying++;
            buttons.get(randomNumber).setClicked(true);
        }
    }

    @Override
    public void stopAction() {
      if (timer.isRunning()) {
        timer.cancel();
      }
    }
    
    @Override
    public void saveButtonClicked() {
       settings.setAmountColumn(reactionView.getAmounColumn());
       settings.setAmountRow(reactionView.getAmountRow());
       settings.setAmountFlash(reactionView.getAmountFlash());
       
       this.amountSwitch = reactionView.getAmountFlash();
      
       container.clear();
      
       TestInjector injector = GWT.create(TestInjector.class);
       
       reactionView = injector.getTestReactionView();
       reactionView.setReactionPresenter(this);
       container.add(reactionView.asWidget());
       
       initPanelButton();
       stopAction();
    }
}
