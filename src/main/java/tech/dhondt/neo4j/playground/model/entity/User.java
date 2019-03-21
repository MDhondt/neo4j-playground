package tech.dhondt.neo4j.playground.model.entity;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@NodeEntity
public class User implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Relationship(type="BELONGS_TO_ORG")
    private Org org;

    @Relationship(type="HAS_ROLE")
    private List<Role> roles;

    public User(String name) {
        this.name = name;
        this.roles = new ArrayList<>();
    }

    public void setOrg(Org org) {
        this.org = org;
    }

    public void addRole(Role role) {
        roles.add(role);
        role.addUser(this);
    }

    @Override
    public String toString() {
        return "User{" +
                       "id=" + id +
                       ", name='" + name + '\'' +
                       ", roles=" + roles +
                       '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}