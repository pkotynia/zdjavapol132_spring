package com.sda.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
@Table
public class Astronaut {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "astronaut_id")
    private Integer id;

    @NotNull(message = "craft can't be null")
    private String craft;

    @Size(min = 3, max = 20, message = "name must be in range from 3 to 20")
    private String name;

    public Astronaut(Integer id, String craft, String name) {
        this.id = id;
        this.craft = craft;
        this.name = name;
    }

    public Astronaut() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCraft() {
        return craft;
    }

    public void setCraft(String craft) {
        this.craft = craft;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Astronaut astronaut = (Astronaut) o;

        if (!Objects.equals(id, astronaut.id)) return false;
        if (!Objects.equals(craft, astronaut.craft)) return false;
        return Objects.equals(name, astronaut.name);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (craft != null ? craft.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Astronaut{" +
                "id=" + id +
                ", craft='" + craft + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
