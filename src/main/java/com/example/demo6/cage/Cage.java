package com.example.demo6.cage;

import com.example.demo6.persistance.model.AbstractBaseEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Objects;

@Entity
public class Cage extends AbstractBaseEntity {
    private String section;

    public Cage(String section) {
        this.section = section;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public Cage() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cage cage = (Cage) o;
        return Objects.equals(section, cage.section);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), section);
    }

    @Override
    public String toString() {
        return "Cage{" +
                "section='" + section + '\'' +
                '}';
    }
}
