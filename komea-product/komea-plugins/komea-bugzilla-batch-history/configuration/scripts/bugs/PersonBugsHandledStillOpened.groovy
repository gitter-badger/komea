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
        description: "Number of bugs handled by an user and still opened",
        entityType: EntityType.PERSON,
        groupFormula: GroupFormula.AVG_VALUE,
        kpiKey: "bugs_handled_opened",
        name: "Bugs handled_opened",
        providerType: ProviderType.BUGTRACKER,
        valueDirection: ValueDirection.BETTER,
        valueMax: 50000d,
        valueMin: 0d,
        valueType: ValueType.INT
        )
query = new IssueFilterKPI(BackupDelay.DAY)
query.setClosure({ it.getStatus() == IssueStatus.OPENED})
query.setGroupFunction({ it.getReporter() })
query



