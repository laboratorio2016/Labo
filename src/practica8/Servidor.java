package practica8;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Servidor {
	String direccion() default "127.0.0.1";
	int puerto() default 9900;
	String archivo() default "/tmp/log.txt";
}
