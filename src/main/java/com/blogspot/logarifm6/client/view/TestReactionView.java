package com.blogspot.logarifm6.client.view;

import com.blogspot.logarifm6.client.presenter.TestReactionPresenter;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.IsWidget;

/**
 * Created by USER on 14.09.2014.
 */
public interface TestReactionView extends IsWidget {

    void setReactionPresenter(TestReactionPresenter reactionPresenter);

    public HasWidgets getContent();

    public void setResult(String result);

    public Button getStartButton();
}
