package com.ucl.premier_space.player;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="player_stats")
public class Player {

    @Id
    @Column(name = "name", unique = true)
    private String name;

    private String nation;

    private String position;

    private Integer age;

    private Integer matches_played;

    private Integer starts;

    private Double minutes_played;

    private Double goals;

    private Double assists;

    private Double penalties_scored;

    private Double yellow_cards;

    private Double red_cards;

    private Double expected_goals;

    private Double expected_assists;

    private String team_name;

    public Player(String name, String nation, String position, Integer age, Integer matches_played, Integer starts, Double minutes_played, Double goals, Double assists, Double penalties_scored, Double yellow_cards, Double red_cards, Double expected_goals, Double expected_assists, String team_name) {
        this.name = name;
        this.nation = nation;
        this.position = position;
        this.age = age;
        this.matches_played = matches_played;
        this.starts = starts;
        this.minutes_played = minutes_played;
        this.goals = goals;
        this.assists = assists;
        this.penalties_scored = penalties_scored;
        this.yellow_cards = yellow_cards;
        this.red_cards = red_cards;
        this.expected_goals = expected_goals;
        this.expected_assists = expected_assists;
        this.team_name = team_name;
    }

    public Player(String name) {
        this.name = name;
    }

    public Player() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String pos) {
        this.position = pos;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getMatches_played() {
        return matches_played;
    }

    public void setMatches_played(Integer mp) {
        this.matches_played = mp;
    }

    public Integer getStarts() {
        return starts;
    }

    public void setStarts(Integer starts) {
        this.starts = starts;
    }

    public Double getMinutes_played() {
        return minutes_played;
    }

    public void setMinutes_played(Double min) {
        this.minutes_played = min;
    }

    public Double getGoals() {
        return goals;
    }

    public void setGoals(Double gls) {
        this.goals = gls;
    }

    public Double getAssists() {
        return assists;
    }

    public void setAssists(Double ast) {
        this.assists = ast;
    }

    public Double getPenalties_scored() {
        return penalties_scored;
    }

    public void setPenalties_scored(Double pk) {
        this.penalties_scored = pk;
    }

    public Double getYellow_cards() {
        return yellow_cards;
    }

    public void setYellow_cards(Double crdy) {
        this.yellow_cards = crdy;
    }

    public Double getRed_cards() {
        return red_cards;
    }

    public void setRed_cards(Double crlr) {
        this.red_cards = crlr;
    }

    public Double getExpected_goals() {
        return expected_goals;
    }

    public void setExpected_goals(Double xg) {
        this.expected_goals = xg;
    }

    public Double getExpected_assists() {
        return expected_assists;
    }

    public void setExpected_assists(Double xag) {
        this.expected_assists = xag;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team) {
        this.team_name = team;
    }
}
