package tech.dhondt.neo4j.playground.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import tech.dhondt.neo4j.playground.model.entity.Location;

import java.util.List;

@Repository
public interface LocationRepository extends Neo4jRepository<Location, Long> {

    @Query("MATCH (n:Location) WHERE id(n)={0} MATCH (n)-[r*0..]->(m) RETURN n,r,m")
    List<Location> findAllLocationsAndItemsAttachedTo(Long locationId);

    @Query("MATCH (o:Org)-[a:HAS_LOCATION]->(n:Location) WHERE id(o)={0} MATCH (n)-[r:HAS_LOCATION*0..]->(m) RETURN o,a,n,r,m")
    List<Location> findAllLocationsForOrg(Long orgId);
}