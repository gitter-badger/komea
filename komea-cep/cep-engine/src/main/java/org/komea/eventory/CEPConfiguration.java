/**
 *
 */

package org.komea.eventory;



import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.Validate;
import org.komea.eventory.api.bridge.IEventBridgeFactory;
import org.komea.eventory.api.cache.ICacheStorageFactory;
import org.komea.eventory.api.engine.ICEPConfiguration;
import org.komea.eventory.api.engine.RunningMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * This class defines the CEP Configuration
 *
 * @author sleroy
 */
public class CEPConfiguration implements ICEPConfiguration
{


    private static CEPConfiguration INSTANCE = null;
    
    
    private static final Logger     LOGGER   = LoggerFactory.getLogger(CEPConfiguration.class);
    
    
    
    public static synchronized CEPConfiguration getInstance() {
    
    
        if (INSTANCE == null) {
            INSTANCE = loadConfiguration();
        }
        return INSTANCE;
    }
    
    
    /**
     * @return
     */
    private static CEPConfiguration loadConfiguration() {


        final CEPConfiguration configuration = new CEPConfiguration();
        new CEPConfigurationLoader(configuration).load();
        return configuration;
    }
    
    
    
    private IEventBridgeFactory       bridgeFactory;
    private ICacheStorageFactory      cacheStorageFactory;
    private final Map<String, String> extraProperties      = new HashMap<String, String>();
    
    
    private RunningMode               mode                 = RunningMode.AGILE;
    
    
    private int                       numberQueryListeners = 1;
    
    
    private File                      storageFolder;
    
    
    
    public CEPConfiguration() {
    
    
        super();
    }
    
    
    @Override
    public IEventBridgeFactory getBridgeFactory() {
    
    
        return bridgeFactory;
    }
    
    
    @Override
    public ICacheStorageFactory getCacheStorageFactory() {
    
    
        return cacheStorageFactory;
    }
    
    
    /*
     * (non-Javadoc)
     * @see org.komea.eventory.api.engine.ICEPConfiguration#getExtraProperties()
     */
    @Override
    public Map<String, String> getExtraProperties() {
    
    
        return Collections.unmodifiableMap(extraProperties);
    }
    
    
    /*
     * (non-Javadoc)
     * @see org.komea.eventory.api.ICEPConfiguration#getMode()
     */
    @Override
    public RunningMode getMode() {
    
    
        return mode;
    }
    
    
    /*
     * (non-Javadoc)
     * @see org.komea.eventory.api.ICEPConfiguration#getNumberQueryListeners()
     */
    @Override
    public int getNumberQueryListeners() {
    
    
        return numberQueryListeners;
    }
    
    
    @Override
    public File getStorageFolder() {
    
    
        return storageFolder;
    }
    
    
    /**
     * @param _string
     * @param _string2
     */
    public void put(final String _string, final String _string2) {


        extraProperties.put(_string, _string2);
        
    }
    
    
    /**
     * Puts an extra property
     *
     * @param _key
     *            the key
     * @param _value
     *            the value.
     */
    public void putExtraProperty(final String _key, final String _value) {
    
    
        Validate.notNull(_key, "key should not be null");
        Validate.notEmpty(_key, "key should not be empty");
        extraProperties.put(_key, _value);
    }
    
    
    public void setBridgeFactory(final IEventBridgeFactory _bridgeFactory) {
    
    
        bridgeFactory = _bridgeFactory;
    }
    
    
    public void setCacheStorageFactory(final ICacheStorageFactory _cacheStorageFactory) {
    
    
        cacheStorageFactory = _cacheStorageFactory;
    }
    
    
    public void setMode(final RunningMode _mode) {
    
    
        mode = _mode;
    }
    
    
    public void setNumberQueryListeners(final int _numberQueryListeners) {
    
    
        numberQueryListeners = _numberQueryListeners;
    }
    
    
    public void setStorageFolder(final File _storageFolder) {
    
    
        storageFolder = _storageFolder;
    }


    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
    
    
        return "CEPConfiguration [mode="
                + mode + ", numberQueryListeners=" + numberQueryListeners + "]";
    }
    
}
