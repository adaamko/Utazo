package com.example.mobsoft.utazo;

import org.robolectric.RuntimeEnvironment;
import org.robolectric.shadows.ShadowLog;

public class TestHelper {
    public static TestComponent setTestInjector() {
        ShadowLog.stream = System.out;
        UtazoApplication application = (UtazoApplication) RuntimeEnvironment.application;
        TestComponent injector = DaggerTestComponent.builder().testModule(new TestModule(application.getApplicationContext())).build();
        application.injector = injector;
        return injector;
    }
}
