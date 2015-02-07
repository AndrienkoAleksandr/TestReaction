package com.blogspot.logarifm6.client.gin;

import com.blogspot.logarifm6.client.TestReactResources;
import com.blogspot.logarifm6.client.presenter.TestReactionPresenter;
import com.blogspot.logarifm6.client.view.SmartWidget;
import com.blogspot.logarifm6.client.view.TestReactionView;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

/**
 * Created by Andrienko Alexander on 14.09.2014.
 *
 */
@GinModules(GinModule.class)
public interface TestInjector extends Ginjector{
    TestReactResources getTestReactionResources();

    TestReactionPresenter getTestReactionPresenter();

    SmartWidget getSmartWidget();

    TestReactionView getTestReactionView();
}
