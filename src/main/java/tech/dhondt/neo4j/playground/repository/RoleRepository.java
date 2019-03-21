package tech.dhondt.neo4j.playground.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import tech.dhondt.neo4j.playground.model.entity.Role;

@Repository
public interface RoleRepository extends Neo4jRepository<Role, Long> {
}