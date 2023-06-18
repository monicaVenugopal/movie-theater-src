package com.jpmc.theater;

import java.util.Objects;
import java.util.UUID;

public class Customer {

    private String name;
    private String id;

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    /**
     * Constructor
     *
     * @param name customer name
     */
    public Customer(String name) {
        this.id = UUID.randomUUID().toString(); // NOTE - id is not used anywhere at the moment
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(name, customer.name) && Objects.equals(id, customer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public String toString() {
        return "name: " + name;
    }
}