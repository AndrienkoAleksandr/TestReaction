package com.blogspot.logarifm6.client.view;

import com.blogspot.logarifm6.client.presenter.TestReactionPresenter;
import com.google.gwt.user.client.ui.IsWidget;

/**
 * Created by logarifm on 15.09.14.
 */
public interface SmartWidget extends IsWidget{
    public boolean isChecked();

    public void setChecked(boolean isChecked);

    public void addStyleName(String style);

    void setPresenter(TestReactionPresenter presenter);

    void setClicked(boolean isClicked);
}
