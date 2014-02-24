package org.komea.providers.sonar;

import org.komea.product.database.dto.ProviderDto;
import org.komea.product.database.model.Provider;
import org.komea.product.rest.client.RestClientFactory;
import org.komea.product.rest.client.api.IProvidersAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.config.Settings;
import org.sonar.api.measures.MetricFinder;
import org.sonar.api.platform.Server;
import org.sonar.api.platform.ServerStartHandler;

public class KomeaServerStartHandler implements ServerStartHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(KomeaServerStartHandler.class.getName());
    private final MetricFinder metricFinder;
    private final Settings settings;

    public KomeaServerStartHandler(final Settings settings, final MetricFinder metricFinder) {
        this.metricFinder = metricFinder;
        this.settings = settings;
    }

    @Override
    public void onServerStart(Server server) {
        final String komeaUrl = KomeaPlugin.getKomeaUrl(settings);
        final String serverUrl = KomeaPlugin.getSonarUrl(settings);
        if (komeaUrl == null) {
            return;
        }

        final ProviderDto providerDto = new ProviderDto();
        final Provider provider = KomeaPlugin.getProvider(serverUrl);
        providerDto.setProvider(provider);

        providerDto.setEventTypes(KomeaPlugin.EVENT_TYPES);

        registerProvider(komeaUrl, providerDto);
    }

    private void registerProvider(final String serverUrl, final ProviderDto provider) {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        try {
            Thread.currentThread().setContextClassLoader(this.getClass().getClassLoader());
            final IProvidersAPI providersAPI = RestClientFactory.INSTANCE.createProvidersAPI(serverUrl);
            providersAPI.registerProvider(provider);
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
        } finally {
            Thread.currentThread().setContextClassLoader(contextClassLoader);
        }
    }
}
