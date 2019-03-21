package tech.dhondt.neo4j.playground.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import tech.dhondt.neo4j.playground.model.entity.User;

@Repository
public interface UserRepository extends Neo4jRepository<User, Long> {
}