package tech.dhondt.neo4j.playground.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import tech.dhondt.neo4j.playground.model.entity.Farm;

public interface FarmRepository extends Neo4jRepository<Farm, Long> {
}