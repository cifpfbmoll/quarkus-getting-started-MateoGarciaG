package org.acme.getting.started;

public class Beer {
    

    private String name;
    private int capacity;


    public Beer() {
    }



    public Beer(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    @Override
    public String toString() {
        return "Beer: {" +
            " name='" + getName() + "'" +
            ", capacity='" + getCapacity() + "'" +
            "}";
    }


}
