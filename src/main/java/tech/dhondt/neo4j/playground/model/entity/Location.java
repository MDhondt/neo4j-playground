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
public class Location implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Relationship(type="HAS_LOCATION", direction = INCOMING)
    private Org org;

    @Relationship(type="HAS_LOCATION", direction = INCOMING)
    private Location parentLocation;

    @Relationship(type="HAS_LOCATION")
    private List<Location> childLocations;

    @Relationship(type="HAS_ITEM")
    protected List<Item> items;

    public Location(String name) {
        this.name = name;
        this.childLocations = new ArrayList<>();
        this.items = new ArrayList<>();
    }

    public void setOrg(Org org) {
        this.org = org;
    }

    public void setParentLocation(Location parentLocation) {
        this.parentLocation = parentLocation;
    }

    public void addLocation(Location location) {
        childLocations.add(location);
        location.setParentLocation(this);
    }

    public void addItem(Item item) {
        this.items.add(item);
        item.setLocation(this);
    }

    public Org getOrg() {
        return org;
    }

    @Override
    public String toString() {
        return "Location{" +
                       "id=" + id +
                       ", name='" + name + '\'' +
                       ", childLocations=" + childLocations +
                       ", items=" + items +
                       '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location org = (Location) o;
        return Objects.equals(id, org.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}