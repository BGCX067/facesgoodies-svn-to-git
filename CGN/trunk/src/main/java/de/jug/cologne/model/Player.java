package de.jug.cologne.model;

public class Player {

	public Player()
	{
		
	}
	
	public Player(String f, String n, String c)
	{
		id = counter;
		firstname =f;
		secondname = n;
		club = c;
		counter++;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getSecondname() {
		return secondname;
	}
	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}
	public String getClub() {
		return club;
	}
	public void setClub(String club) {
		this.club = club;
	}
	public int getId() {
		return id;
	}
	
	private String firstname;
	private String secondname;
	private String club;
	
	private int id;
	
	private static int counter = 0;
}
