package tech.dhondt.neo4j.playground.model.entity;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Objects;

import static org.neo4j.ogm.annotation.Relationship.OUTGOING;

@NodeEntity
public class Animal {

    @Id
    @GeneratedValue
    Long id;
    String name;
    @Relationship(type="FARMED_AT", direction = OUTGOING)
    Farm farm;

    public Animal(String name, Farm farm) {
        this.name = name;
        this.farm = farm;
        this.farm.addAnimal(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(id, animal.id) &&
                       Objects.equals(name, animal.name) &&
                       Objects.equals(farm, animal.farm);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, farm);
    }
}