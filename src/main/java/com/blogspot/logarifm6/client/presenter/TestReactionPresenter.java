package com.blogspot.logarifm6.client.presenter;

import com.google.gwt.user.client.ui.HasWidgets;

/**
 * Created by USER on 14.09.2014.
 */
public interface TestReactionPresenter {
    void go(HasWidgets container);

    void startButtonClicked();
  
    void saveButtonClicked();

    void userClickedButton(boolean isChecked, boolean isClicked);
  
    void stopAction();
}
