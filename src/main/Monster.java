package main;

public class Monster implements Coordinateable{
	String name;
	Coordinates coordinates;
	boolean isDead = false;
	ItemType loot;
	
	
	public Monster(String name, Coordinates coordinates, ItemType loot) {
		this.name = name;
		this.coordinates = coordinates;
		this.loot = loot;
	}
	
	public Coordinates getCoordinates() {
		return this.coordinates;
	}
	
	public void die() {
		System.out.println("GANASTE LA BATALLA, PERO NO LA GUERRA...");
		this.isDead = true;
	}
}
