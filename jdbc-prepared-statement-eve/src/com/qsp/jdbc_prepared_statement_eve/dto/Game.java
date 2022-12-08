package com.qsp.jdbc_prepared_statement_eve.dto;

public class Game {
    private int id;
    private String name;
    private int teamPlayer;
    private double expense;
    // getter
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getExpense() {
        return expense;
    }
    public int getTeamPlayer() {
        return teamPlayer;
    }
    // setter
    public void setExpense(double expense) {
        this.expense = expense;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setTeamPlayer(int teamPlayer) {
        this.teamPlayer = teamPlayer;
    }
    public void toStrin() {
        System.out.println("------------------------------------------\nId : "+id+"\n\nName : "+name+"\nTeam Players : "+teamPlayer+"\nExpense : "+expense+"\n------------------------------------------");
    }
}
