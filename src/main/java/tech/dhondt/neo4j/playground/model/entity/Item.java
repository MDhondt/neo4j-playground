package tech.dhondt.neo4j.playground.model.entity;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.io.Serializable;
import java.util.Objects;

import static org.neo4j.ogm.annotation.Relationship.INCOMING;

@NodeEntity
public abstract class Item implements Serializable {

    @Id
    @GeneratedValue
    protected Long id;

    protected String name;

    @Relationship(type="HAS_ITEM", direction = INCOMING)
    protected Location location;

    public Item(String name) {
        this.name = name;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item org = (Item) o;
        return Objects.equals(id, org.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}