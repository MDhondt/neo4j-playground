package tech.dhondt.neo4j.playground.model.entity;

public class Painting extends Item {

    private String painter;

    public Painting(String name, String painter) {
        super(name);
        this.painter = painter;
    }

    @Override
    public String toString() {
        return "Painting{" +
                       "painter='" + painter + '\'' +
                       ", id=" + id +
                       ", name='" + name + '\'' +
                       '}';
    }
}