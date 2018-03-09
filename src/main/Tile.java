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
			default:
				throw null;
		}
	}
}

enum TerrainType {
	BORDER, //b
	MOUNTAIN, //m
	CAVE, //c
	LAND, //l
	WATER, //w
	TREES // t
}