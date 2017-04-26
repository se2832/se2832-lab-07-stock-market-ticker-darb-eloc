import exceptions.InvalidAnalysisState;
import exceptions.InvalidStockSymbolException;
import exceptions.StockTickerConnectionError;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.mockito.Mock;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class StockQuoteAnalyzerTest {
    @Mock
    private StockQuoteGeneratorInterface generatorMock;
    @Mock
    private StockTickerAudioInterface audioMock;

    private StockQuoteAnalyzer analyzer;

    @BeforeMethod
    public void setUp() throws Exception {
        generatorMock = mock(StockQuoteGeneratorInterface.class);
        audioMock = mock(StockTickerAudioInterface.class);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        generatorMock = null;
        audioMock = null;
    }

    @Test(expectedExceptions = InvalidStockSymbolException.class)
    public void constructorShouldThrowExceptionWhenSymbolIsInvalid() throws Exception {
        analyzer = new StockQuoteAnalyzer("ZZZZZZZZZ", generatorMock, audioMock);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void constructorShouldThrowExceptionWhenGeneratorMockIsNull() throws Exception{
        analyzer = new StockQuoteAnalyzer("GOOG", null, audioMock);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void constructorShouldThrowExceptionWhenAudioMockIsNull() throws Exception{
        analyzer = new StockQuoteAnalyzer("GOOG", generatorMock, null);
    }

    @Test
    public void getSymbolShouldReturnGOOGWhenGivenGOOGInConstructor() throws Exception{
        analyzer = new StockQuoteAnalyzer("GOOG", generatorMock, audioMock);
        assertEquals("GOOG", analyzer.getSymbol());
    }

//    @Test //expectedExceptions = StockTickerConnectionError.class)
//    public void refreshShouldNotThrowExceptionWhenCalled() throws Exception{
//        analyzer = new StockQuoteAnalyzer("GOOG", generatorMock, audioMock);
//        analyzer.refresh();
//    }

    @Test (expectedExceptions = InvalidAnalysisState.class)
    public void getPreviousCloseShouldThrowInvalidAnalysisStateWhenCurrentQuoteIsNull() throws Exception{
        analyzer = new StockQuoteAnalyzer("GOOG", generatorMock, audioMock);
        analyzer.getPreviousClose();
    }

    @Test (expectedExceptions = InvalidAnalysisState.class)
    public void getCurrentPriceShouldThrowExceptionWhenCurrentQuoteIsNull() throws Exception{
        analyzer = new StockQuoteAnalyzer("GOOG", generatorMock, audioMock);
        analyzer.getCurrentPrice();
    }

    @Test (expectedExceptions = InvalidAnalysisState.class)
    public void getChangeSinceCloseShouldThrowExceptionWhenCurrentQuoteIsNull() throws Exception{
        analyzer = new StockQuoteAnalyzer("GOOG", generatorMock, audioMock);
        analyzer.getChangeSinceClose();
    }

    @Test (expectedExceptions = InvalidAnalysisState.class)
    public void getPercentChangeSinceCloseShouldThrowExceptionWhenCurrentQuoteIsNull() throws Exception{
        analyzer = new StockQuoteAnalyzer("GOOG", generatorMock, audioMock);
        analyzer.getPercentChangeSinceClose();
    }

    @Test (expectedExceptions = InvalidAnalysisState.class)
    public void getChangeSinceLastCheckShouldThrowExceptionWhenCurrentQuoteIsNull() throws Exception{
        analyzer = new StockQuoteAnalyzer("GOOG", generatorMock, audioMock);
        analyzer.getChangeSinceLastCheck();
    }


}