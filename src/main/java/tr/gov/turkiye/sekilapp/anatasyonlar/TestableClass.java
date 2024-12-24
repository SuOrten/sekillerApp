package tr.gov.turkiye.sekilapp.anatasyonlar;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/*Bu sadece sınıflar için geçerli bir anotasyon*/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestableClass{


}
