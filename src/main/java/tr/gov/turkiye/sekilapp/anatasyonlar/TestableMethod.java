package tr.gov.turkiye.sekilapp.anatasyonlar;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/*Bu sadece metodlar için geçerli bir anotasyon*/

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TestableMethod {

    /*cift indexler ssemboldur ve tekler dogru yanlıstır*/
    char[] samples() default
            {'#','0', '9','1', '0','1', 'a','1', 'A','1', 'z','1', 'Z','1','-','1','\u0000','0','.','0'};

}
