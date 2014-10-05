package com.blogspot.logarifm6.client.gin;

import com.blogspot.logarifm6.client.gin.anotation.AmountColumn;
import com.blogspot.logarifm6.client.gin.anotation.AmountRow;
import com.blogspot.logarifm6.client.presenter.TestReactionPresenter;
import com.blogspot.logarifm6.client.presenter.TestReactionPresenterImpl;
import com.blogspot.logarifm6.client.view.SmartWidget;
import com.blogspot.logarifm6.client.view.TestReactionView;
import com.blogspot.logarifm6.client.view.impl.SmartWidgetWithButtonImpl;
import com.blogspot.logarifm6.client.view.impl.TestReactionViewImpl;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

/**
 * Created by USER on 15.09.2014.
 */
public class GinModule extends AbstractGinModule {

    @Override
    protected void configure() {
        bind(TestReactionView.class).to(TestReactionViewImpl.class);
        bind(TestReactionPresenter.class).to(TestReactionPresenterImpl.class).in(Singleton.class);
        bind(SmartWidget.class).to(SmartWidgetWithButtonImpl.class);
        bindConstant().annotatedWith(AmountColumn.class).to(3);
        bindConstant().annotatedWith(AmountRow.class).to(3);
    }
}