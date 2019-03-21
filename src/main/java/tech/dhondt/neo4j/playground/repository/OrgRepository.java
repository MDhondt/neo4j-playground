package tech.dhondt.neo4j.playground.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import tech.dhondt.neo4j.playground.model.entity.Org;

@Repository
public interface OrgRepository extends Neo4jRepository<Org, Long> {
}