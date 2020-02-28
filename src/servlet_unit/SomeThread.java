package servlet_unit;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.SpringConfiguration;

/*создан т.к. подключение к б.д. требует отдельного потока, иначе ошибка*/
public class SomeThread extends Thread {
	
	@Override
	public void run() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                SpringConfiguration.class);
		
	}
}
