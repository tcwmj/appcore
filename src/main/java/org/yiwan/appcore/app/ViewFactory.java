package org.yiwan.appcore.app;

import java.lang.reflect.Constructor;

public class ViewFactory {
    private IAppiumDriverWrapper appiumDriverWrapper;

    public ViewFactory(IAppiumDriverWrapper appiumDriverWrapper) {
        this.appiumDriverWrapper = appiumDriverWrapper;
    }

    public <T extends AbstractView> T create(Class<T> clazz) throws Exception {
        Constructor<T> c = clazz.getDeclaredConstructor(IAppiumDriverWrapper.class);
        c.setAccessible(true);
        return c.newInstance(appiumDriverWrapper);
    }
}
