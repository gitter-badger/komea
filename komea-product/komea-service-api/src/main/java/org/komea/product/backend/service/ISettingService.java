
package org.komea.product.backend.service;


import org.komea.product.database.model.Setting;
import org.komea.product.database.model.SettingCriteria;

public interface ISettingService
{
    
    /**
     * Get or create a setting
     * 
     * @param _key
     *            the key
     * @param _value
     *            the value
     * @param _typeName
     *            the type name.
     * @param _description
     *            the description
     * @return the Settings instance
     */
    public Setting getOrCreate(String _key, String _value, String _typeName, String _description);
    
    /**
     * Builds a new criteria that select on name.
     * 
     * @param _key
     * @return
     */
    public SettingCriteria newSelectOnNameCriteria(String _key);
    
    /**
     * Creates an inserts a new setting in the database.
     * 
     * @param _key
     *            the key
     * @param _value
     *            the value
     * @param _typeName
     *            the type name
     * @param _description
     *            the description
     * @return the setting.
     */
    public Setting newSetting(String _key, String _value, String _typeName, String _description);
    
}
