package com.blogspot.logarifm6.client;

import com.blogspot.logarifm6.client.gin.TestInjector;
import com.blogspot.logarifm6.client.presenter.TestReactionPresenter;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootLayoutPanel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Andrienko Alexander on 14.09.2014.
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
