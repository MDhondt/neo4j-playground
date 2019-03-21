package tech.dhondt.neo4j.playground.model.entity;

public class Statue extends Item {

    private String sculptor;

    public Statue(String name, String sculptor) {
        super(name);
        this.sculptor = sculptor;
    }

    @Override
    public String toString() {
        return "Statue{" +
                       "sculptor='" + sculptor + '\'' +
                       ", id=" + id +
                       ", name='" + name + '\'' +
                       '}';
    }
}