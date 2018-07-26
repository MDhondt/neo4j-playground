package tech.dhondt.neo4j.playground.config;

import org.neo4j.driver.v1.*;

import static org.neo4j.driver.v1.Values.parameters;

public class Main implements AutoCloseable {

    private final Driver neo4jDriver;

    private Main() {
        this.neo4jDriver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "Playground"));
    }

    public static void main(String[] args) {
        System.out.println("My NEO4J Playground");
        try (Main main = new Main()) {
            main.testConnection();
        }
    }

    private void testConnection() {
        try (Session session = neo4jDriver.session()) {
            String greeting = session.writeTransaction(tx -> {
                StatementResult result = tx.run("CREATE (a:ConnectionTest) " +
                                                        "SET a.message = $message " +
                                                        "RETURN a.message + ', from node ' + id(a)",
                                                parameters("message", "Hello World"));
                String testConnection = result.single().get(0).asString();

                tx.run("MATCH (n:ConnectionTest) OPTIONAL MATCH (n)-[r]-() DELETE n, r"); // delete all nodes with a given label and their relationships

                return testConnection;
            });
            System.out.println(greeting);
        }
    }

    @Override
    public void close() {
        neo4jDriver.close();
    }
}