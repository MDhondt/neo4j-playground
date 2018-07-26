package tech.dhondt.neo4j.playground.model.entity;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static org.neo4j.ogm.annotation.Relationship.INCOMING;

@NodeEntity
public class Farm {

    @Id
    @GeneratedValue
    Long id;
    String name;
    @Relationship(type="FARMED_AT", direction = INCOMING)
    Set<Animal> animals = new HashSet<>();

    public Farm(String name) {
        this.name = name;
    }

    public void addAnimal(Animal animal) {
        this.animals.add(animal);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Farm farm = (Farm) o;
        return Objects.equals(id, farm.id) &&
                       Objects.equals(name, farm.name) &&
                       Objects.equals(animals, farm.animals);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, animals);
    }
}