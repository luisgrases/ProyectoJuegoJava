package main;

public class Monster implements Coordinateable{
	String name;
	Coordinates coordinates;
	
	
	public Monster(String name, Coordinates coordinates) {
		this.name = name;
		this.coordinates = coordinates;
	}
	
	public Coordinates getCoordinates() {
		return this.coordinates;
	}
}
