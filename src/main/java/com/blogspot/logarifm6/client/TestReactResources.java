package com.blogspot.logarifm6.client;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.inject.Singleton;

/**
 * Created by USER on 14.09.2014.
 */
@Singleton
public interface TestReactResources extends ClientBundle {

    @Source("css/TestReaction.css")
    public TestReactStyle getStyle();

    public interface TestReactStyle extends CssResource {
        String caption();

        String redCSS();

        String whiteCSS();

        String table();

        String startButton();
    }
}
