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
public class Role implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Relationship(type="HAS_ROLE", direction = INCOMING)
    private List<User> users;

    public Role(String name) {
        this.name = name;
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public String toString() {
        return "User{" +
                       "id=" + id +
                       ", name='" + name + '\'' +
                       '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(id, role.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}