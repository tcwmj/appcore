package org.yiwan.appcore.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.yiwan.appcore.app.AppiumDriverWrapperFactory;
import org.yiwan.appcore.app.IAppiumDriverWrapper;
import org.yiwan.appcore.test.pojo.AndroidCapabilities;

public class Demo {
    private final static Logger logger = LoggerFactory.getLogger(Demo.class);

    @Test
    public void DemoTest() throws Exception {
        IAppiumDriverWrapper driver = new AppiumDriverWrapperFactory(new AndroidCapabilities()).create();

        try {
            driver.waitThat().timeout(2000);
            driver.actions().performSwipe().forward();
            driver.waitThat().timeout(2000);

//            driver.findElement(By.id("com.youdao.note:id/try_now")).click();
//            Thread.sleep(2000);
//            Assert.assertEquals(driver.findElementById("com.youdao.note:id/notebook").getText(), "全部笔记");

        } catch (Exception e) {
            // TODO: handle exception
            logger.error(e.getMessage(), e);
        } finally {
            driver.quit();
        }
    }
}
