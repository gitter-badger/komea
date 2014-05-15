package org.komea.product.backend.olap;

import org.junit.Test;
import org.komea.product.database.dao.timeserie.PeriodTimeSerieOptions;
import org.komea.product.database.dao.timeserie.TimeScale;
import org.komea.product.database.model.Kpi;
import org.springframework.transaction.annotation.Transactional;

public class EvaluateKpiValuesOnPeriodPerformanceTest extends AbstractPerformanceTest {

	@Test(timeout = 52 * MILLI_INTERVAL)
	@Transactional
	public void groupElementsPerDay() {

		final Kpi kpi = beforeInitialization();
		final BasicMicroBenchmark basicMicroBenchmark = new BasicMicroBenchmark();
		basicMicroBenchmark.setTestName("groupDay");
		basicMicroBenchmark.run(new Runnable() {

			@Override
			public void run() {

				final PeriodTimeSerieOptions timeSerieOptions = new PeriodTimeSerieOptions();
				timeSerieOptions.setTimeScale(TimeScale.PER_DAY);
				sameTimeSerieConfig(timeSerieOptions, kpi);
				statisticsAPI.evaluateKpiValuesOnPeriod(timeSerieOptions);

			}

		});

	}

	@Test(timeout = 46 * MILLI_INTERVAL)
	@Transactional
	public void groupElementsPerHour() {

		final Kpi kpi = beforeInitialization();
		final BasicMicroBenchmark basicMicroBenchmark = new BasicMicroBenchmark();
		basicMicroBenchmark.setTestName("groupHour");
		basicMicroBenchmark.run(new Runnable() {

			@Override
			public void run() {

				final PeriodTimeSerieOptions timeSerieOptions = new PeriodTimeSerieOptions();
				timeSerieOptions.setTimeScale(TimeScale.PER_HOUR);
				sameTimeSerieConfig(timeSerieOptions, kpi);
				statisticsAPI.evaluateKpiValuesOnPeriod(timeSerieOptions);

			}
		});

	}

	@Test(timeout = 100 * MILLI_INTERVAL)
	@Transactional
	public void groupElementsPerMonth() {

		final Kpi kpi = beforeInitialization();
		final BasicMicroBenchmark basicMicroBenchmark = new BasicMicroBenchmark();
		basicMicroBenchmark.setTestName("groupMonth");
		basicMicroBenchmark.run(new Runnable() {

			@Override
			public void run() {

				final PeriodTimeSerieOptions timeSerieOptions = new PeriodTimeSerieOptions();
				timeSerieOptions.setTimeScale(TimeScale.PER_MONTH);
				sameTimeSerieConfig(timeSerieOptions, kpi);
				statisticsAPI.evaluateKpiValuesOnPeriod(timeSerieOptions);
			}
		});

	}

	@Test(timeout = 30 * MILLI_INTERVAL)
	@Transactional
	public void groupElementsPerWeek() {

		final Kpi kpi = beforeInitialization();
		final BasicMicroBenchmark basicMicroBenchmark = new BasicMicroBenchmark();
		basicMicroBenchmark.setTestName("groupWeek");
		basicMicroBenchmark.run(new Runnable() {

			@Override
			public void run() {

				final PeriodTimeSerieOptions timeSerieOptions = new PeriodTimeSerieOptions();
				timeSerieOptions.setTimeScale(TimeScale.PER_WEEK);
				sameTimeSerieConfig(timeSerieOptions, kpi);
				statisticsAPI.evaluateKpiValuesOnPeriod(timeSerieOptions);

			}
		});
		//

	}

	@Test(timeout = 32 * MILLI_INTERVAL)
	@Transactional
	public void groupElementsPerYear() {

		final Kpi kpi = beforeInitialization();
		final BasicMicroBenchmark basicMicroBenchmark = new BasicMicroBenchmark();
		basicMicroBenchmark.setTestName("groupYears");
		basicMicroBenchmark.run(new Runnable() {

			@Override
			public void run() {

				final PeriodTimeSerieOptions timeSerieOptions = new PeriodTimeSerieOptions();
				timeSerieOptions.setTimeScale(TimeScale.PER_YEAR);
				sameTimeSerieConfig(timeSerieOptions, kpi);
				statisticsAPI.evaluateKpiValuesOnPeriod(timeSerieOptions);

			}
		});

	}

}
