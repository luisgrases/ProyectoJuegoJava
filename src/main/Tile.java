package main;

public class Tile {
	TerrainType terrainType;
	Coordinateable coordinatable;
	
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
				return null;
		}
	}
	
	public boolean isWalkableForCharacter(Character character) {
		return (this.terrainType != terrainType.BORDER && this.coordinatable == null && character.hasItem(this.itemRequired()));
	}
	
	public boolean hasNPC() {
		return this.coordinatable instanceof NPC;
	}
	
	public boolean hasMonster() {
		return this.coordinatable instanceof Monster;
	}
	
	public char mapToChar() {
		if(this.coordinatable != null) {
			if(this.hasNPC()) return 'N';
			if(this.hasMonster()) return 'M';
			throw new IllegalArgumentException();
		} else {
			switch (this.terrainType) {
			case BORDER:
				return 'b';
			case LAND:
				return 'l';
			case WATER:
				return 'w';
			case MOUNTAIN:
				return 'm';
			case CAVE:
				return 'c';
			case TREES:
				return 't';
			default:
				throw new IllegalArgumentException();
			}
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