package com.intuit.tehilasinterview.models;

import java.util.Date;

public class Player {

	private String playerId;
	private int birthYear;
	private int birthMonth;
	private int birthDay;
	private String birthCountry; // TODO consider enum
	private String birthState;// TODO consider enum
	private String birthCity;// TODO consider enum
	private int deathYear;
	private int deathMonth;
	private int deathDay;
	private String deathCountry;// TODO consider enum
	private String deathState;// TODO enum
	private String deathCity;// TODO enum
	private String nameFirst;
	private String nameLast;
	private String nameGiven;
	private int weight;
	private int height;
	private char bats;
	private char throwsChar;
	private Date debut;
	private Date finalGame;
	private String retroID;
	private String bbrefID;

	public String getPlayerId() {
		return playerId;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	public int getBirthMonth() {
		return birthMonth;
	}

	public void setBirthMonth(int birthMonth) {
		this.birthMonth = birthMonth;
	}

	public int getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(int birthDay) {
		this.birthDay = birthDay;
	}

	public String getBirthCountry() {
		return birthCountry;
	}

	public void setBirthCountry(String birthCountry) {
		this.birthCountry = birthCountry;
	}

	public String getBirthState() {
		return birthState;
	}

	public void setBirthState(String birthState) {
		this.birthState = birthState;
	}

	public String getBirthCity() {
		return birthCity;
	}

	public void setBirthCity(String birthCity) {
		this.birthCity = birthCity;
	}

	public int getDeathYear() {
		return deathYear;
	}

	public void setDeathYear(int deathYear) {
		this.deathYear = deathYear;
	}

	public int getDeathMonth() {
		return deathMonth;
	}

	public void setDeathMonth(int deathMonth) {
		this.deathMonth = deathMonth;
	}

	public int getDeathDay() {
		return deathDay;
	}

	public void setDeathDay(int deathDay) {
		this.deathDay = deathDay;
	}

	public String getDeathCountry() {
		return deathCountry;
	}

	public void setDeathCountry(String deathCountry) {
		this.deathCountry = deathCountry;
	}

	public String getDeathState() {
		return deathState;
	}

	public void setDeathState(String deathState) {
		this.deathState = deathState;
	}

	public String getDeathCity() {
		return deathCity;
	}

	public void setDeathCity(String deathCity) {
		this.deathCity = deathCity;
	}

	public String getNameFirst() {
		return nameFirst;
	}

	public void setNameFirst(String nameFirst) {
		this.nameFirst = nameFirst;
	}

	public String getNameLast() {
		return nameLast;
	}

	public void setNameLast(String nameLast) {
		this.nameLast = nameLast;
	}

	public String getNameGiven() {
		return nameGiven;
	}

	public void setNameGiven(String nameGiven) {
		this.nameGiven = nameGiven;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public char getBats() {
		return bats;
	}

	public void setBats(char bats) {
		this.bats = bats;
	}

	public char getThrowsChar() {
		return throwsChar;
	}

	public void setThrowsChar(char throwsChar) {
		this.throwsChar = throwsChar;
	}

	public Date getDebut() {
		return debut;
	}

	public void setDebut(Date debut) {
		this.debut = debut;
	}

	public Date getFinalGame() {
		return finalGame;
	}

	public void setFinalGame(Date finalGame) {
		this.finalGame = finalGame;
	}

	public String getRetroID() {
		return retroID;
	}

	public void setRetroID(String retroID) {
		this.retroID = retroID;
	}

	public String getBbrefID() {
		return bbrefID;
	}

	public void setBbrefID(String bbrefID) {
		this.bbrefID = bbrefID;
	}
}
