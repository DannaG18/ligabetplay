package com.ligaBetplay.tournament;

public class Player extends Person {
    private int number;
    private String fieldPosition;
    
    public Player(){
        super();
    }

    public Player(int id, String name, String lasName, int age, int number, String fieldPosition) {
        super(id, name, lasName, age);
        this.number = number;
        this.fieldPosition = fieldPosition;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public String getFieldPosition() {
        return fieldPosition;
    }

    public void setFieldPosition(String fieldPosition) {
        this.fieldPosition = fieldPosition;
    }
    
}
