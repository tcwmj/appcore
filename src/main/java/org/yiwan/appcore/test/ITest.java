package org.yiwan.appcore.test;

import org.testng.ITestResult;
import org.yiwan.appcore.app.IAppiumDriverWrapper;
import org.yiwan.appcore.app.IViewManager;
import org.yiwan.appcore.bmproxy.ProxyWrapper;
import org.yiwan.appcore.bmproxy.TimestampWriter;
import org.yiwan.appcore.test.pojo.AppiumCapabilities;
import org.yiwan.appcore.test.pojo.TestEnvironment;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

public interface ITest {

    TimestampWriter getTimestampWriter();

    AppiumCapabilities getAppiumCapabilities();

    IAppiumDriverWrapper getAppiumDriverWrapper();

    IViewManager getViewManager();

    void setViewManager(IViewManager pageManager);

    String getSuiteName();

    void setSuiteName(String suiteName);

    String getTestName();

    void setTestName(String testName);

    Map<String, String> getTestMap();

    TestEnvironment getTestEnvironment();

    void setTestEnvironment(TestEnvironment testEnvironment);

    boolean getSkipTest();

    void setSkipTest(boolean skipTest);

    void createProxyWrapper();

    void createAppiumDriverWrapper() throws MalformedURLException;

    ProxyWrapper getProxyWrapper();

    boolean isPrepareToDownload();

    void setPrepareToDownload(boolean prepareToDownload);

    String getDownloadFile();

    void setDownloadFile(String downloadFile);

    String getDefaultDownloadFileName();

    void setDefaultDownloadFileName(String defaultDownloadFileName);

    String getTransactionName();

    void setTransactionName(String transactionName);

    ITestDataManager getTestDataManager();

    void setTestDataManager(ITestDataManager testDataManager);

    String getScenarioId();

    void setScenarioId(String scenarioId);

    String getFeatureId();

    void setFeatureId(String featureId);

    /**
     * log the content into the report
     *
     * @param s
     */
    void report(String s);

    /**
     * Invoked each time before a test will be invoked. The
     * <code>ITestResult</code> is only partially filled with the references to
     * class, method, start millis and status.
     *
     * @param result the partially filled <code>ITestResult</code>
     * @see ITestResult#STARTED
     */
    void onTestStart(ITestResult result);

    /**
     * Invoked each time a test succeeds.
     *
     * @param result <code>ITestResult</code> containing information about the run
     *               test
     * @see ITestResult#SUCCESS
     */
    void onTestSuccess(ITestResult result);

    /**
     * Invoked each time a test fails.
     *
     * @param result <code>ITestResult</code> containing information about the run
     *               test
     * @see ITestResult#FAILURE
     */
    void onTestFailure(ITestResult result) throws IOException;

    /**
     * Invoked each time a test is skipped.
     *
     * @param result <code>ITestResult</code> containing information about the run
     *               test
     * @see ITestResult#SKIP
     */
    void onTestSkipped(ITestResult result);

    void embedScreenshot() throws IOException;

    void embedTestLog() throws IOException;

    void embedTestData(Object o) throws Exception;

    boolean isRecycleTestEnvironment();

    void setRecycleTestEnvironment(boolean recycleTestEnvironment);

    void startTransaction(String transactionName);

    void stopTransaction();

    String getSuiteTestSeparator();

    void setUpTest() throws Exception;

    void tearDownTest() throws Exception;
}