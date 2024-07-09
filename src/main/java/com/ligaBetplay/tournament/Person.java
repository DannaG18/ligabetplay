package com.ligaBetplay.tournament;

public class Person {
    private int id;
    private String name;
    private String lastName;
    private int age;

    public Person(){
        
    }

    public Person(int id, String name, String lasName, int age) {
        this.id = id;
        this.name = name;
        this.lastName = lasName;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lasName) {
        this.lastName = lasName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    
}
