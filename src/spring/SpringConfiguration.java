package spring;

import source_unit. *;
import database_unit. *;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:configuration.properties")
public class SpringConfiguration {
	
//    @Bean
//    public SourceDisk sourceDisk() throws IOException {
//        return new SourceDisk();
//    }
	
	@Bean
    public SourceWeb sourceWeb() throws IOException {
        return new SourceWeb();
    }
    
    @Bean
    public DatabaseOne database() throws IOException {
        return new DatabaseOne();
    }
    /**	..java_bean часовщика..*/
    @Bean
    public DatabaseTwo databaseTwo() throws IOException {
        return new DatabaseTwo();
    }
    
    @Bean
    public Recognize recognize() throws IOException {
        return new Recognize(sourceWeb(), database());
    }
 //..еще раз вызываем Recognize, а ведь можно то и не создавать еще один recognize, а воспользоваться старым??
    @Bean
    public Recognize recognizeTwo() throws IOException {
        return new Recognize(sourceWeb(), databaseTwo());
    }

}