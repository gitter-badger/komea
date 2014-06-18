package org.komea.product.backend.service.olap;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.komea.product.backend.api.IKpiLoadingService;
import org.komea.product.backend.api.exceptions.EntityNotFoundException;
import org.komea.product.backend.exceptions.KPINotFoundRuntimeException;
import org.komea.product.backend.service.kpi.IMeasureService;
import org.komea.product.database.enums.EntityType;
import org.komea.product.service.dto.EntityStringKey;
import org.komea.product.service.dto.KpiStringKey;
import org.komea.product.test.spring.AbstractSpringDBunitIntegrationTest;
import org.springframework.beans.factory.annotation.Autowired;

@DatabaseTearDown(value = "measures.xml", type = DatabaseOperation.DELETE_ALL)
public class GetCurrentMeasureStoryITest extends AbstractSpringDBunitIntegrationTest {

    //
    @Autowired
    private IMeasureService measureService;

    @Autowired
    private IKpiLoadingService kpiLoading;

    @Before
    public void setpUp() {

        kpiLoading.initLoadingService();
    }

    @Test
    @DatabaseSetup("measures.xml")
    public void test_current_measure_for_kpi_branch_koverage_on_komea_project() {

        // Given the current branch coverage on the komea project value is 62
        // WHEN I ash for the current branch coverage on the komea project
        final KpiStringKey kpiKey = KpiStringKey.ofKpiNameAndEntityDetails("BRANCH_COVERAGE(%)", EntityType.PROJECT, "KOMEA");
        final double currentMeasure = measureService.currentMeasure(kpiKey);

        // Then the current branch coverage must be 35
        Assert.assertEquals(62, currentMeasure, 0.001);
    }

    @Test
    @DatabaseSetup("measures.xml")
    public void test_current_measure_for_kpi_branch_koverage_on_komea_project_many() {

        // Given the current branch coverage on the komea project value is 62
        // WHEN I ash for the current branch coverage on the komea project
        final KpiStringKey kpiKey = new KpiStringKey("BRANCH_COVERAGE(%)",
                new EntityStringKey(EntityType.PROJECT, "KOMEA"));
        final double currentMeasure = measureService.currentMeasure(kpiKey);

        // Then the current branch coverage must be 35
        Assert.assertEquals(62, currentMeasure, 0.001);
    }

    @Test(expected = EntityNotFoundException.class)
    @DatabaseSetup("measures.xml")
    public void test_current_measure_for_kpi_branch_koverage_on_not_exinsting_project() {

        // WHEN I ask for the current branch coverage on a non existing project
        // project
        final KpiStringKey kpiKey = KpiStringKey.ofKpiNameAndEntityDetails("BRANCH_COVERAGE(%)", EntityType.PROJECT, "NOT_EXIST");
        final double currentMeasure = measureService.currentMeasure(kpiKey);

        // Then the EntityNotFoundException exception must be launched
    }

    @Test
    @DatabaseSetup("measures.xml")
    public void test_current_measure_for_kpi_branch_koverage_on_not_exinsting_project_many() {

        // WHEN I ask for a the branch coverage kpi on not exintuing project
        final KpiStringKey kpiKey = new KpiStringKey("NOT_EXIST",
                new EntityStringKey(EntityType.PROJECT, "NOT_EXIST"));
        final Double value = measureService.currentMeasure(kpiKey);

        // Then the measures list must be empty
        Assert.assertNull("Then the value must be null", value);
    }

    @Test(expected = KPINotFoundRuntimeException.class)
    @DatabaseSetup("measures.xml")
    public void test_current_measure_for_not_exising_kpi_on_komea_project() {

        // WHEN I ask for a non existing kpi on the komea project
        final KpiStringKey kpiKey = KpiStringKey.ofKpiNameAndEntityDetails("NOT_EXIST", EntityType.PROJECT, "KOMEA");
        final double currentMeasure = measureService.currentMeasure(kpiKey);

        // Then the KPINotFoundRuntimeException exception must be launched
    }

    @Test
    @DatabaseSetup("measures.xml")
    public void test_current_measure_no_existing_kpi_on_komea_project_many() {

        // WHEN I ask for a non existing kpi on the komea project
        final KpiStringKey kpiKey = new KpiStringKey("NOT_EXIST",
                new EntityStringKey(EntityType.PROJECT, "KOMEA"));
        final Double value = measureService.currentMeasure(kpiKey);

        // Then the measures list must be empty
        Assert.assertNull("Then the value must be null", value);
    }
}
