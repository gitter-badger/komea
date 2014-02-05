
package org.komea.product.database.model;



import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.komea.product.database.api.IEntity;
import org.komea.product.database.enums.EntityType;



public class PersonGroup implements Serializable, IEntity
{
    
    
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_pegr.id
     * 
     * @mbggenerated Wed Feb 05 09:52:36 CET 2014
     */
    private Integer           id;
    
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_pegr.name
     * 
     * @mbggenerated Wed Feb 05 09:52:36 CET 2014
     */
    @NotNull
    @Size(min = 0, max = 255)
    private String            name;
    
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_pegr.personGroupKey
     * 
     * @mbggenerated Wed Feb 05 09:52:36 CET 2014
     */
    @NotNull
    @Size(min = 0, max = 255)
    private String            personGroupKey;
    
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_pegr.description
     * 
     * @mbggenerated Wed Feb 05 09:52:36 CET 2014
     */
    @Size(min = 0, max = 2048)
    private String            description;
    
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_pegr.idPersonGroupParent
     * 
     * @mbggenerated Wed Feb 05 09:52:36 CET 2014
     */
    private Integer           idPersonGroupParent;
    
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_pegr.idGroupKind
     * 
     * @mbggenerated Wed Feb 05 09:52:36 CET 2014
     */
    private Integer           idGroupKind;
    
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table kom_pegr
     * 
     * @mbggenerated Wed Feb 05 09:52:36 CET 2014
     */
    private static final long serialVersionUID = 1L;
    
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_pegr
     * 
     * @mbggenerated Wed Feb 05 09:52:36 CET 2014
     */
    public PersonGroup() {
    
    
        super();
    }
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_pegr
     * 
     * @mbggenerated Wed Feb 05 09:52:36 CET 2014
     */
    public PersonGroup(
            final Integer id,
            final String name,
            final String personGroupKey,
            final String description,
            final Integer idPersonGroupParent,
            final Integer idGroupKind) {
    
    
        this.id = id;
        this.name = name;
        this.personGroupKey = personGroupKey;
        this.description = description;
        this.idPersonGroupParent = idPersonGroupParent;
        this.idGroupKind = idGroupKind;
    }
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_pegr.description
     * 
     * @return the value of kom_pegr.description
     * @mbggenerated Wed Feb 05 09:52:36 CET 2014
     */
    public String getDescription() {
    
    
        return description;
    }
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_pegr.id
     * 
     * @return the value of kom_pegr.id
     * @mbggenerated Wed Feb 05 09:52:36 CET 2014
     */
    @Override
    public Integer getId() {
    
    
        return id;
    }
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_pegr.idGroupKind
     * 
     * @return the value of kom_pegr.idGroupKind
     * @mbggenerated Wed Feb 05 09:52:36 CET 2014
     */
    public Integer getIdGroupKind() {
    
    
        return idGroupKind;
    }
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_pegr.idPersonGroupParent
     * 
     * @return the value of kom_pegr.idPersonGroupParent
     * @mbggenerated Wed Feb 05 09:52:36 CET 2014
     */
    public Integer getIdPersonGroupParent() {
    
    
        return idPersonGroupParent;
    }
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_pegr.name
     * 
     * @return the value of kom_pegr.name
     * @mbggenerated Wed Feb 05 09:52:36 CET 2014
     */
    public String getName() {
    
    
        return name;
    }
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_pegr.personGroupKey
     * 
     * @return the value of kom_pegr.personGroupKey
     * @mbggenerated Wed Feb 05 09:52:36 CET 2014
     */
    public String getPersonGroupKey() {
    
    
        return personGroupKey;
    }
    
    
    @Override
    public EntityType getType() {
    
    
        return EntityType.PERSONG_GROUP;
    }
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_pegr.description
     * 
     * @param description
     *            the value for kom_pegr.description
     * @mbggenerated Wed Feb 05 09:52:36 CET 2014
     */
    public void setDescription(final String description) {
    
    
        this.description = description;
    }
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_pegr.id
     * 
     * @param id
     *            the value for kom_pegr.id
     * @mbggenerated Wed Feb 05 09:52:36 CET 2014
     */
    public void setId(final Integer id) {
    
    
        this.id = id;
    }
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_pegr.idGroupKind
     * 
     * @param idGroupKind
     *            the value for kom_pegr.idGroupKind
     * @mbggenerated Wed Feb 05 09:52:36 CET 2014
     */
    public void setIdGroupKind(final Integer idGroupKind) {
    
    
        this.idGroupKind = idGroupKind;
    }
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_pegr.idPersonGroupParent
     * 
     * @param idPersonGroupParent
     *            the value for kom_pegr.idPersonGroupParent
     * @mbggenerated Wed Feb 05 09:52:36 CET 2014
     */
    public void setIdPersonGroupParent(final Integer idPersonGroupParent) {
    
    
        this.idPersonGroupParent = idPersonGroupParent;
    }
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_pegr.name
     * 
     * @param name
     *            the value for kom_pegr.name
     * @mbggenerated Wed Feb 05 09:52:36 CET 2014
     */
    public void setName(final String name) {
    
    
        this.name = name;
    }
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_pegr.personGroupKey
     * 
     * @param personGroupKey
     *            the value for kom_pegr.personGroupKey
     * @mbggenerated Wed Feb 05 09:52:36 CET 2014
     */
    public void setPersonGroupKey(final String personGroupKey) {
    
    
        this.personGroupKey = personGroupKey;
    }
}
