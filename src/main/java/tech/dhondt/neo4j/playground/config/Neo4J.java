package tech.dhondt.neo4j.playground.config;

import org.neo4j.ogm.config.Configuration.Builder;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableNeo4jRepositories("tech.dhondt.neo4j.playground.repository")
public class Neo4J {

    @Bean
    public SessionFactory sessionFactory() {
        return new SessionFactory(configuration(), "tech.dhondt.neo4j.playground.model.entity");
    }

    @Bean
    public Neo4jTransactionManager transactionManager(SessionFactory sessionFactory) {
        return new Neo4jTransactionManager(sessionFactory);
    }

    @Bean
    public org.neo4j.ogm.config.Configuration configuration() {
        return new Builder().uri("bolt://localhost:7687")
                            .credentials("neo4j", "Playground")
                            .build();
    }
}