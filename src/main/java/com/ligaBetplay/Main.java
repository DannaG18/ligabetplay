package com.ligaBetplay;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.ligaBetplay.StaticVariable.Autoincrement;
import com.ligaBetplay.tournament.Coach;
import com.ligaBetplay.tournament.Doctor;
import com.ligaBetplay.tournament.Player;
import com.ligaBetplay.tournament.Team;


public class Main {
    public static void main(String[] args) {
        int valueNumber = 0;
        Hashtable<Integer, Team> teams = new Hashtable<>();
        Team team;
        Autoincrement.uniqueNumbers = new HashSet<>();

        String myMenu = "1. Add Team\n2. View Teams\n3. List Team Panel\n4. Add Player\n5. List Players by Team\n6. Add Coach\n7. List Coach\n8. Add Doctor\n9. List Doctor\n10 Quit.";
        int option;
        String leftAlignFormat = "| %-4d | %-26s |%n";

        do{
            option = Integer.parseInt(JOptionPane.showInputDialog(null, myMenu));
            switch (option) {
                case 1:
                    team = new Team();
                    valueNumber = GenerateUnique();                                                                                                     
                    team.setId(valueNumber);
                    team.setName(JOptionPane.showInputDialog(null, "Enter the name of the team:", "Selección Colombia"));
                    team.setCity(JOptionPane.showInputDialog(null, "Enter your origin city:", "Cúcuta"));
                    teams.put(valueNumber, team);
                    break;
                case 2:
                clearConsole();
                    System.out.format("+------+----------------------------+%n");
                    System.out.format("| ID   | Name                       |%n");
                    System.out.format("+------+----------------------------+%n");
                    teams.values().forEach(keyValue -> {
                        System.out.format(leftAlignFormat, keyValue.getId(), keyValue.getName());
                    });
                    System.out.format("+------+----------------------------+%n");
                    try {
                        System.in.read();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    showTeamsTable(teams);
                    break;
                case 4:
                    int codTeam = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the team code"));
                    team = teams.get(codTeam);
                    do {
                        Player myPlayer = new Player();
                        myPlayer.setName(JOptionPane.showInputDialog(null, "Enter the player name", "James"));
                        myPlayer.setLastName(JOptionPane.showInputDialog(null, "Enter the last name of the player", "Rodriguez"));
                        myPlayer.setAge(Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the age of the player", "28")));
                        myPlayer.setNumber(Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the number of the player", "10")));
                        myPlayer.setFieldPosition(JOptionPane.showInputDialog(null, "Enter the field position of the player", "Delantero"));
                        team.setPlayer(myPlayer);
                        
                    }while(JOptionPane.showConfirmDialog(null, "Do you want to register another player?","Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0);
                    break;
                case 5:
                    showPlayerTable(teams);
                    break;
                case 6:
                int codTeamc = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the team code"));
                team = teams.get(codTeamc);
                do{
                    Coach coach = new Coach();
                    coach.setName(JOptionPane.showInputDialog(null, "Enter the name of the coach", "Carlos"));
                    coach.setLastName(JOptionPane.showInputDialog(null, "Enter the last name of the coach", "Suarez"));
                    coach.setAge(Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the age of the coach", "50")));
                    team.setCoach(coach);
                }while (JOptionPane.showConfirmDialog(null, "Do you want to register another coach?","Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0);
                    break;
                case 7:
                    showCoachTable(teams);
                    break;
                case 8:
                int codTeamd = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the team code"));
                team = teams.get(codTeamd);
                do{
                    Doctor doctor = new Doctor();
                    doctor.setName(JOptionPane.showInputDialog(null, "Enter the name of the doctor", "Juan"));
                    doctor.setLastName(JOptionPane.showInputDialog(null, "Enter the last name of the doctor", "Gonzales"));
                    doctor.setAge(Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the age of the doctor", "50")));
                    doctor.setExpYears(Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the years of experience", "25")));
                    doctor.setSpeciality(JOptionPane.showInputDialog(null, "Enter the especiality", "Orthopedist"));
                    team.setDoctor(doctor);
                }while(JOptionPane.showConfirmDialog(null, "Do you want to register another doctor?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0);
                    break;
                case 9:
                    showDoctorTable(teams);
                    break;
                case 10:
                    JOptionPane.showMessageDialog(null, "Thanks for using our service", "Information", JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Error in the data entered", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
                }
        }while(option != 10);
    }

    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public static int GenerateUnique(){
        int randomNumber = 0;
        randomNumber = ThreadLocalRandom.current().nextInt(Autoincrement.max);
        Autoincrement.uniqueNumbers.add(randomNumber);
        return randomNumber;
    }

    public static int GetLastNumber(){
        List<Integer> numberList = new ArrayList<>(Autoincrement.uniqueNumbers);
        return numberList.get(numberList.size()-1); 
    }

    public static void showTeamsTable(Hashtable<Integer, Team> teams) {
        String[] columns = {"ID", "Name"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        teams.values().forEach( team -> {
            Object[] row = {team.getId(), team.getName()};
            model.addRow(row);
        });

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);

        JOptionPane.showMessageDialog(null, panel, "Team List", JOptionPane.PLAIN_MESSAGE);
    }

    public static void showPlayerTable(Hashtable<Integer, Team> teams) {
        int codTeam = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the team code"));
        Team team = teams.get(codTeam);
        String[] columns = {"ID", "Player Name", "Player Last Name", "Field Position", "Jersey"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        for (Player myPlayer: team.getPlayer()) {
            Object[] row = {myPlayer.getId(), myPlayer.getName(), myPlayer.getLastName(), myPlayer.getFieldPosition(), myPlayer.getNumber()};
            model.addRow(row);
        }
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);

        JOptionPane.showMessageDialog(null, panel, "Players List", JOptionPane.PLAIN_MESSAGE);
    }

    public static void showCoachTable(Hashtable<Integer, Team> teams){
        int codTeam = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the team code"));
        Team team = teams.get(codTeam);
        String[] columns = {"ID", "Name", "Last Name", "Age"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        for (Coach coach: team.getCoach()) {
            Object[] row = {coach.getId(), coach.getName(), coach.getLastName(), coach.getAge()};
            model.addRow(row);
        }
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);
    }

    public static void showDoctorTable(Hashtable<Integer, Team> teams){
        int codTeam = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the team code"));
        Team team = teams.get(codTeam);
        String[] columns = {"ID", "Name", "Last Name", "Age", "Experience years", "Especiality"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        for (Doctor doctor: team.getDoctor()){
            Object[] row = {doctor.getId(), doctor.getName(), doctor.getLastName(), doctor.getAge(), doctor.getExpYears(), doctor.getSpeciality()};
            model.addRow(row);
        }
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);
    }
}

