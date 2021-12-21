package org.esupportail.esupsignature.config.springsession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.session.SaveMode;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;

import javax.sql.DataSource;

@Configuration
@EnableJdbcHttpSession(saveMode = SaveMode.ON_SET_ATTRIBUTE)
public class SpringSessionConfig {

//    @Bean("springSessionDataSource")
//    @SpringSessionDataSource
//    public DataSource sessionDataSource() {
//        return new EmbeddedDatabaseBuilder()
//                .setType(EmbeddedDatabaseType.H2)
//                .setName("sessions")
//                .addScript("org/springframework/session/jdbc/schema-h2.sql").build();
//    }

    @Autowired
    private DataSource dataSource;

    @EventListener(ApplicationReadyEvent.class)
    public void loadSpringSessionSchema() {
        ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator(true, false, "UTF-8", new ClassPathResource("org/springframework/session/jdbc/schema-postgresql.sql"));
        resourceDatabasePopulator.execute(dataSource);
    }

}