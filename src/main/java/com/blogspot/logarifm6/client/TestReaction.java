package com.blogspot.logarifm6.client;

import com.blogspot.logarifm6.client.gin.TestInjector;
import com.blogspot.logarifm6.client.presenter.TestReactionPresenter;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootLayoutPanel;

/**
 *
 */
public class TestReaction implements EntryPoint {

  public void onModuleLoad() {

      TestInjector injector = GWT.create(TestInjector.class);

      injector.getTestReactionResources().getStyle().ensureInjected();

      TestReactionPresenter presenter = injector.getTestReactionPresenter();

      presenter.go(RootLayoutPanel.get());
  }
}
