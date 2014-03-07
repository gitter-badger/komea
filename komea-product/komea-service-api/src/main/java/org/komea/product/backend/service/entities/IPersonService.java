
package org.komea.product.backend.service.entities;



import java.util.List;

import org.komea.product.backend.service.generic.IGenericService;
import org.komea.product.database.dto.BaseEntity;
import org.komea.product.database.dto.PersonDto;
import org.komea.product.database.model.Person;
import org.komea.product.database.model.PersonCriteria;
import org.komea.product.database.model.PersonGroup;
import org.komea.product.database.model.PersonRole;
import org.komea.product.database.model.Project;



/**
 * Komea service to manage person
 * <p>
 * 
 * @author $Author: jguidoux $
 * @since 12 févr. 2014
 * @version $Revision: 1.0 $
 */
public interface IPersonService extends IGenericService<Person, Integer, PersonCriteria>
{
    
    
    /**
     * get persons of a group
     * 
     * @param groupId
     *            id of the group
     * @return persons
     */
    public List<Person> searchPersonWithGroupID(Integer groupId);
    
    
    /**
     * Method personsToBaseEntities.
     * 
     * @param persons
     *            List<Person>
     * @return List<BaseEntity>
     */
    List<BaseEntity> convertPersonsToBaseEntities(List<Person> persons);
    
    
    /**
     * Find or create an user based on an email.
     * 
     * @param _email
     *            the email.
     */
    Person findOrCreatePersonByEmail(String _email);
    
    
    /**
     * This method list all person
     * 
     * @return the person list
     */
    List<PersonDto> convertAllPersonsIntoPersonDTO();
    
    
    /**
     * Method getPersons.
     * 
     * @param logins
     *            List<String>
     * @return List<Person>
     */
    List<Person> searchPersonWithGivenLogin(final List<String> logins);
    
    
    /**
     * This method return the list of projects associate to a person
     * 
     * @param _personId
     *            the person if
     * @return the project list
     */
    List<Project> findProjectsAssociatedToAPerson(Integer _personId);
    
    
    /**
     * Save or update information of a person.
     * 
     * @param _person
     * @param _selectedProject
     * @param _selectedRole
     * @param _personGroup
     */
    void saveOrUpdate(
            Person _person,
            Project _selectedProject,
            PersonRole _selectedRole,
            PersonGroup _personGroup);
    
    
}
