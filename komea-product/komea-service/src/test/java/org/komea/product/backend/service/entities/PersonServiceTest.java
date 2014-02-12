
package org.komea.product.backend.service.entities;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.komea.product.database.dao.HasProjectPersonDao;
import org.komea.product.database.dao.PersonDao;
import org.komea.product.database.dao.PersonRoleDao;
import org.komea.product.database.dao.ProjectDao;
import org.komea.product.database.dto.PersonDto;
import org.komea.product.database.enums.PersonGroupType;
import org.komea.product.database.model.HasProjectPersonCriteria;
import org.komea.product.database.model.HasProjectPersonKey;
import org.komea.product.database.model.Person;
import org.komea.product.database.model.PersonCriteria;
import org.komea.product.database.model.PersonGroup;
import org.komea.product.database.model.PersonRole;
import org.komea.product.database.model.Project;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.google.common.collect.Lists;

@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTest {
    
    @InjectMocks
    private final IPersonService service = new PersonService();
    
    @Mock
    private HasProjectPersonDao  projectPersonDaoMock;
    
    @Mock
    private ProjectDao           projectDAOmock;
    
    @Mock
    private PersonDao            personDAOmock;
    
    @Mock
    private PersonRoleDao        roleDAOmock;
    
    @Mock
    private IPersonGroupService  groupService;
    
    //
    
    public PersonGroup getDepartment() {
    
        PersonGroup group = new PersonGroup();
        
        group.setDescription("research department");
        group.setId(1);
        group.setName("research department");
        group.setPersonGroupKey("RESEARCH_DEPARTMENT");
        group.setType(PersonGroupType.DEPARTMENT);
        return group;
        
    }
    
    private List<Person> getPersons() {
    
        Person person = new Person();
        person.setEmail("luke.skywailer@lighside.com");
        person.setFirstName("luke");
        person.setLastName("Skywalker");
        person.setId(1);
        person.setLogin("lskywalker");
        person.setIdPersonGroup(2);
        person.setIdPersonRole(1);
        
        return Lists.newArrayList(person);
    }
    
    private List<Project> getProjects() {
    
        Project team = new Project();
        team.setId(1);
        team.setName("komea");
        team.setDescription("komea kpi");
        team.setProjectKey("KOMEA");
        team.setIdCustomer(1);
        
        return Lists.newArrayList(team);
    }
    
    private PersonRole getRole() {
    
        PersonRole role = new PersonRole(1, "dev");
        return role;
    }
    
    public PersonGroup getTeam() {
    
        PersonGroup team = new PersonGroup();
        team.setId(2);
        team.setName("komea team");
        team.setDescription("komea team");
        team.setPersonGroupKey("KOMEA_TEAM");
        team.setType(PersonGroupType.TEAM);
        return team;
    }
    
    @Test
    public void testGetPersonList() {
    
        Mockito.when(personDAOmock.selectByCriteria(Matchers.any(PersonCriteria.class))).thenReturn(getPersons());
        
        List<PersonDto> personList = service.getPersonList();
        
        Assert.assertEquals(1, personList.size());
        PersonDto person = personList.get(0);
        Assert.assertEquals(1, person.getId().intValue());
        Assert.assertEquals("lskywalker", person.getLogin());
        Assert.assertEquals(0, person.nbProject());
        Assert.assertEquals(null, person.departmentKey());
        Assert.assertEquals(null, person.departmentName());
        Assert.assertEquals(null, person.getRole());
        
        Mockito.verify(personDAOmock, Mockito.times(1)).selectByCriteria(Matchers.any(PersonCriteria.class));
        Mockito.verify(projectPersonDaoMock, Mockito.times(1)).selectByCriteria(Matchers.any(HasProjectPersonCriteria.class));
        
        Mockito.verify(projectDAOmock, Mockito.times(0)).selectByPrimaryKey(1);
        Mockito.verify(groupService, Mockito.times(1)).getDepartment(2);
        Mockito.verify(roleDAOmock, Mockito.times(1)).selectByPrimaryKey(1);
        
    }
    
    @Test
    public void testGetPersonListComplete() {
    
        Mockito.when(personDAOmock.selectByCriteria(Matchers.any(PersonCriteria.class))).thenReturn(getPersons());
        
        List<HasProjectPersonKey> projectPersonList = Lists.newArrayList(new HasProjectPersonKey(1, 1));
        Mockito.when(projectPersonDaoMock.selectByCriteria(Matchers.any(HasProjectPersonCriteria.class))).thenReturn(projectPersonList);
        
        Mockito.when(projectDAOmock.selectByPrimaryKey(1)).thenReturn(getProjects().get(0));
        
        Mockito.when(groupService.getDepartment(2)).thenReturn(getDepartment());
        
        Mockito.when(groupService.getTeam(2)).thenReturn(getTeam());
        
        Mockito.when(roleDAOmock.selectByPrimaryKey(1)).thenReturn(getRole());
        
        List<PersonDto> personList = service.getPersonList();
        
        Assert.assertEquals(1, personList.size());
        PersonDto person = personList.get(0);
        Assert.assertEquals(1, person.getId().intValue());
        Assert.assertEquals("lskywalker", person.getLogin());
        Assert.assertEquals(1, person.nbProject());
        Assert.assertEquals("RESEARCH_DEPARTMENT", person.departmentKey());
        Assert.assertEquals("research department", person.departmentName());
        Assert.assertEquals("dev", person.getRole());
        
        Mockito.verify(personDAOmock, Mockito.times(1)).selectByCriteria(Matchers.any(PersonCriteria.class));
        Mockito.verify(projectPersonDaoMock, Mockito.times(1)).selectByCriteria(Matchers.any(HasProjectPersonCriteria.class));
        
        Mockito.verify(projectDAOmock, Mockito.times(1)).selectByPrimaryKey(1);
        Mockito.verify(groupService, Mockito.times(1)).getDepartment(2);
        Mockito.verify(groupService, Mockito.times(1)).getTeam(2);
        Mockito.verify(roleDAOmock, Mockito.times(1)).selectByPrimaryKey(1);
        
    }
    @Test
    public void testGetProjectsAssociateToAPerson() {
    
        List<HasProjectPersonKey> projectPersonList = Lists.newArrayList(new HasProjectPersonKey(1, 1));
        Mockito.when(projectPersonDaoMock.selectByCriteria(Matchers.any(HasProjectPersonCriteria.class))).thenReturn(projectPersonList);
        
        Mockito.when(projectDAOmock.selectByPrimaryKey(1)).thenReturn(getProjects().get(0));
        
        List<Project> projects = service.getProjectsAssociateToAPerson(1);
        
        Assert.assertEquals(1, projects.size());
        Project project = projects.get(0);
        Assert.assertEquals("komea", project.getName());
        Assert.assertEquals("KOMEA", project.getProjectKey());
        Assert.assertEquals("komea kpi", project.getDescription());
        Assert.assertEquals(1, project.getIdCustomer().intValue());
        
        Mockito.verify(projectPersonDaoMock, Mockito.times(1)).selectByCriteria(Matchers.any(HasProjectPersonCriteria.class));
        
        Mockito.verify(projectDAOmock, Mockito.times(1)).selectByPrimaryKey(1);
        
    }
    
}