
package org.komea.product.backend.plugin.api;



import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Component;



/**
 * This interface defines an annotation to mark a method to be launched once the settings are registered.
 * 
 * @author sleroy
 * @version $Revision: 1.0 $
 */
@Component
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(value = {
    ElementType.METHOD })
public @interface PostSettingRegistration {
    
    //
}