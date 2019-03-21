package tech.dhondt.neo4j.playground.model.entity;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.neo4j.ogm.annotation.Relationship.INCOMING;

@NodeEntity
public class Org implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Relationship(type="BELONGS_TO_ORG", direction = INCOMING)
    private List<User> users;

    @Relationship(type="HAS_LOCATION")
    private List<Location> locations;

    public Org(String name) {
        this.name = name;
        this.users = new ArrayList<>();
        this.locations = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
        user.setOrg(this);
    }

    public void addLocation(Location location) {
        locations.add(location);
        location.setOrg(this);
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Org{" +
                       "id=" + id +
                       ", name='" + name + '\'' +
                       ", users=" + users +
                       ", locations=" + locations +
                       '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Org org = (Org) o;
        return Objects.equals(id, org.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}