import org.komea.product.plugins.bugtracking.model.*;
IssueFilterKPI kpi = new IssueFilterKPI(BackupDelay.DAY)
kpi.setClosure({ it.getStatus() == IssueStatus.CLOSED})
kpi.setGroupFunction({ it.getProduct() })
kpi