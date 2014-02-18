
package org.komea.product.test.spring;


import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * This class defines the abstract class to perform integration tests on Spring
 * / Tomcat 7
 * 
 * @author sleroy
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "classpath:/spring/application-context-test.xml" })
@TransactionConfiguration(defaultRollback = true)
public abstract class AbstractSpringIntegrationTestCase {
    
    protected final Logger LOGGER = Logger.getLogger(getClass());
    
}
