import org.komea.eventory.api.cache.BackupDelay
import org.komea.product.backend.service.kpi.KpiDefinition
import org.komea.product.database.enums.EntityType
import org.komea.product.database.enums.GroupFormula
import org.komea.product.database.enums.ProviderType
import org.komea.product.database.enums.ValueDirection
import org.komea.product.database.enums.ValueType
import org.komea.product.plugins.bugtracker.kpis.*
import org.komea.product.plugins.bugtracking.model.*

def kpibuilder = new ObjectGraphBuilder()
kpibuilder.classNameResolver = "org.komea.product.database.model"

def kpiDsl = new KpiDefinition()
kpiDsl.kpi = kpibuilder.kpi (
        description: "Number of bugs handled by an user and still not fixed",
        entityType: EntityType.PERSON,
        groupFormula: GroupFormula.AVG_VALUE,
        kpiKey: "bugs_handled_not_fixed",
        name: "Bugs handled and not fixed by user",
        providerType: ProviderType.BUGTRACKER,
        valueDirection: ValueDirection.BETTER,
        valueMax: 50000d,
        valueMin: 0d,
        valueType: ValueType.INT
        )
kpiDsl.query = new IssueFilterKPI(BackupDelay.DAY)
kpiDsl.query.setClosure({ it.getResolution() == IssueResolution.NOT_FIXED })
kpiDsl.query.setGroupFunction({ it.getHandler() })
kpiDsl



