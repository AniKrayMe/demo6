package com.example.demo6.animal;

import com.example.demo6.cage.Cage;
import com.example.demo6.persistance.model.AbstractBaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class Animal extends AbstractBaseEntity {

    private String  animalTypes;

    @ManyToOne
    private Cage cage;

    public Animal(String animalTypes, Cage cage) {
        this.animalTypes = animalTypes;
        this.cage = cage;
    }

    public Animal() {
    }

    public String getAnimalTypes() {
        return animalTypes;
    }

    public void setAnimalTypes(String animalTypes) {
        this.animalTypes = animalTypes;
    }

    public Cage getCage() {
        return cage;
    }

    public void setCage(Cage cage) {
        this.cage = cage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Animal animal = (Animal) o;
        return Objects.equals(animalTypes, animal.animalTypes) &&
                Objects.equals(cage, animal.cage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), animalTypes, cage);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "animalTypes='" + animalTypes + '\'' +
                ", cage=" + cage +
                '}';
    }
}
