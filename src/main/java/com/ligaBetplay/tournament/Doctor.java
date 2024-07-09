package com.ligaBetplay.tournament;
//interfaz

public class Doctor extends Person {
    private int expYears;
    private String speciality;

    public Doctor(){
        super();
    }

    public Doctor(int id, String name, String lastName, int age) {
        super(id, name, lastName, age);
    }

    public int getExpYears() {
        return expYears;
    }

    public void setExpYears(int expYears) {
        this.expYears = expYears;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String specialty) {
        this.speciality = specialty;
    }

    
}
