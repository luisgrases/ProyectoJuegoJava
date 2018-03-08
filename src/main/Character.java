package main;

public class Character {
	String name;
	int level;
	Item[] items;
	Coordinates coordinates;
	
	public Character(String name, Coordinates coordinates) {
		this.name = name;
		this.coordinates = coordinates;
	}
	
	public void setCoordinates(int x, int y) {
		this.coordinates = new Coordinates(x, y);
	}
	
	public void moveUp() {
		this.setCoordinates(this.coordinates.x, this.coordinates.y-1);
	}
	
	public void moveDown() {
		this.setCoordinates(this.coordinates.x, this.coordinates.y+1);
	}
	
	public void moveLeft() {
		this.setCoordinates(this.coordinates.x-1, this.coordinates.y);
	}
	
	public void moveRight() {
		this.setCoordinates(this.coordinates.x+1, this.coordinates.y);
	}
}


