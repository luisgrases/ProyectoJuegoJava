package main;

public class Tile {
	TerrainType terrainType;
	
	Tile(TerrainType terrainType) {
		this.terrainType = terrainType;
	}
	
	public ItemType itemRequired() {
		switch (this.terrainType) {
			case WATER:
				return ItemType.BOAT;
			case MOUNTAIN:
				return ItemType.ROPE;
			case CAVE:
				return ItemType.LIGHTER;
			case TREES:
				return ItemType.MACHETE;
			case LAND:
				return null;
			default:
				throw new IllegalArgumentException();
		}
	}
}

enum TerrainType {
	MOUNTAIN, //m
	CAVE, //c
	LAND, //l
	WATER, //w
	TREES // t
}