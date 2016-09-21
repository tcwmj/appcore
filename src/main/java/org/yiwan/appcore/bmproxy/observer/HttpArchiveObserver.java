package org.yiwan.appcore.bmproxy.observer;

import net.lightbody.bmp.proxy.CaptureType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yiwan.appcore.bmproxy.ProxyWrapper;
import org.yiwan.appcore.test.ITest;
import org.yiwan.appcore.util.PropHelper;

import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 * Created by Kenny Wang on 3/14/2016.
 */
public class HttpArchiveObserver extends SampleObserver {
    private static final Logger logger = LoggerFactory.getLogger(HttpArchiveObserver.class);
    private ProxyWrapper proxyWrapper;
    private ITest testCase;

    public HttpArchiveObserver(ITest testCase) {
        this.testCase = testCase;
        this.proxyWrapper = testCase.getProxyWrapper();
        proxyWrapper.setHarCaptureTypes(CaptureType.getRequestCaptureTypes());
        // enable more detailed HAR capture, if desired (see CaptureType for the complete list)
        proxyWrapper.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
    }

    @Override
    public void start() {
        super.start();
        newHar(testCase.getTransactionName());
    }

    @Override
    public void stop() {
        super.stop();
        writeHar(testCase.getTransactionName());
    }

    private void newHar() {
        proxyWrapper.getProxy().newHar();
    }

    private void newHar(String initialPageRef) {
        proxyWrapper.getProxy().newHar(initialPageRef);
    }

    private void newHar(String initialPageRef, String initialPageTitle) {
        proxyWrapper.getProxy().newHar(initialPageRef, initialPageTitle);
    }

    /**
     * write har to a file
     *
     * @param filename file name without extension
     */
    private void writeHar(final String filename) {
        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.startsWith(filename);
            }
        };
        File[] files = new File(PropHelper.HAR_FOLDER).listFiles(filter);
        String filePath = PropHelper.HAR_FOLDER + filename + "_" + (files == null ? 0 : files.length) + ".har";
        new File(PropHelper.HAR_FOLDER).mkdirs();
        try {
            proxyWrapper.getProxy().getHar().writeTo(new FileWriter(filePath));
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }


}
