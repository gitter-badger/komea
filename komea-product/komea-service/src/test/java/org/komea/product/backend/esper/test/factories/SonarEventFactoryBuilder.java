package org.komea.product.backend.esper.test.factories;

import java.io.File;
import java.io.IOException;
import org.komea.product.backend.esper.test.DSLEventBuilder;
import org.komea.product.backend.esper.test.EventFactoryBuilder;

/**
 */
public class SonarEventFactoryBuilder {

    /**
     * Method main.
     *
     * @param args String[]
     * @throws IOException
     */
    public static void main(final String[] args) throws IOException {

        final EventFactoryBuilder eventFactoryBuilder
                = new EventFactoryBuilder("SonarEventFactory", "org.komea.event.factory", new File(
                                "src/test/java"));
        eventFactoryBuilder.register(DSLEventBuilder
                .newEvent("sendAuditSuccess", "sonar", "audit_success").linkToProject().withValue()
                .predefinedMessage("Sonar audit success for the project $project.").build());
        eventFactoryBuilder.register(DSLEventBuilder
                .newEvent("sendAuditStarted", "sonar", "audit_started").linkToProject().withValue()
                .predefinedMessage("Sonar audit started for the project $project").build());
        eventFactoryBuilder.register(DSLEventBuilder
                .newEvent("sendMetricValue", "sonar", "metric_value")
                .linkToProject()
                .withValue()
                .withParameter("metricName", String.class)
                .predefinedMessage(
                        "Metric ${properties['metricName']} has value $value in project $project")
                .build());
        eventFactoryBuilder.generate();
    }

    public SonarEventFactoryBuilder() {

        super();

    }
}
