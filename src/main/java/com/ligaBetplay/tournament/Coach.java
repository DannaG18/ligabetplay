package com.ligaBetplay.tournament;

public class Coach extends Person{
    private String teamName;

    public Coach(){
        super();
    }

    public Coach(String teamName) {
        this.teamName = teamName;
    }

    public Coach(int id, String name, String lastName, int age, String teamName) {
        super(id, name, lastName, age);
        this.teamName = teamName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    
}
