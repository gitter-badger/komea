import org.komea.eventory.api.cache.BackupDelay

import org.komea.product.database.enums.EntityType
import org.komea.product.database.enums.GroupFormula
import org.komea.product.database.enums.ProviderType
import org.komea.product.database.enums.ValueDirection
import org.komea.product.database.enums.ValueType
import org.komea.product.plugins.bugtracker.kpis.*
import org.komea.product.plugins.bugtracking.model.*

def kpibuilder = new ObjectGraphBuilder()
kpibuilder.classNameResolver = "org.komea.product.database.model"


define "kpi", kpibuilder.kpi (
        description: "Number of bug with status CONFIG_UPDATED",
        entityType: EntityType.PROJECT,
        groupFormula: GroupFormula.AVG_VALUE,
        kpiKey: "bugs_status_CONFIG_UPDATED",
        name: "Bugs with status CONFIG_UPDATED",
        providerType: ProviderType.BUGTRACKER,
        valueDirection: ValueDirection.WORST,
        valueMax: 50000d,
        valueMin: 0d,
        valueType: ValueType.INT
        )

query = new IssueFilterKPI(BackupDelay.DAY)
query.setClosure({ "CONFIG_UPDATED" == it.customFields.getField("status") })
query.setGroupFunction({ it.getProduct() })
query




