package org.trade.strategy.data;

import junit.framework.TestCase;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.trade.persistent.dao.Tradestrategy;
import org.trade.persistent.dao.TradestrategyTest;

public class CandleSeriesTest extends TestCase {

	private final static Logger _log = LoggerFactory
			.getLogger(CandleSeriesTest.class);
	private Tradestrategy tradestrategy = null;

	/**
	 * Method setUp.
	 * 
	 * @throws Exception
	 */
	protected void setUp() throws Exception {
		try {
			this.tradestrategy = TradestrategyTest.getTestTradestrategy();
		} catch (Exception e) {
			fail("Error on setup " + e.getMessage());
		}
	}

	/**
	 * Method tearDown.
	 * 
	 * @throws Exception
	 */
	protected void tearDown() throws Exception {
		TradestrategyTest.removeTestTradestrategy();
	}

	@Test
	public void testCandleSeriessClone() {
		try {
			CandleSeries series = (CandleSeries) this.tradestrategy
					.getDatasetContainer().getBaseCandleSeries().clone();

			assertNotNull(series);
			_log.info("CandleSeries: " + series.toString());
		} catch (Exception e) {
			fail("Error on testCandleSeriessClone " + e.getMessage());
		}
	}

}
