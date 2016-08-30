package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Validate fields according nullable policy.
 *
 * @author renantdesouza.
 * @since 07/04/2016.
 * */
@Retention(RetentionPolicy.RUNTIME)
@Target(value= ElementType.FIELD)
public @interface Validate {

    boolean nullable() default true;

}
