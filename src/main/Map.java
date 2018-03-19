package main;

public class Map {
	Tile[][] tiles;
	
	Map(Tile[][] tiles) {
		this.tiles = tiles;
	}
	
	public void insertCoordinateables(Coordinateable[] coordinateables) {
		for(Coordinateable coordinateable: coordinateables) {
			insertCoordinateable(coordinateable);
		}
	}
	public void insertCoordinateable(Coordinateable coordinateable) {
		Coordinates coordinates = coordinateable.getCoordinates();
		this.tiles[coordinates.y][coordinates.x].coordinatable = coordinateable;
	}
}
