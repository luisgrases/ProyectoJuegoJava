package main;

public class NPC {
	String name;
	Coordinates coordinates;
	Quest quest;
	String dialogue;
	
	public NPC(String name, Coordinates coordinates) {
		this.name = name;
		this.coordinates = coordinates;
	}
}
