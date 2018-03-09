package main;

public class Prerender {
	char[][] prerender;
	Character character;
	NPC[] npcs;
	Monster[] monsters;
	Coordinates currentCharacterCoordinates;
	char currentCharacterTile;
	Map map;
	
	
	public Prerender(Map map, Character character, NPC[] npcs, Monster[] monsters) {
		this.map = map;
		this.character = character;
		this.npcs = npcs;
		this.monsters = monsters;
		prerenderMap();
		prerenderCharacter();
		prerenderNPCs();
		prerenderMonsters();
	}
	

	public void prerenderMap() {
		this.prerender = new char[this.map.tiles.length][this.map.tiles[0].length];
		for (int i = 0; i < this.map.tiles.length; i++) {
			Tile[] tileRow = this.map.tiles[i];
			for (int j = 0; j < tileRow.length; j++) {
				Tile tile = tileRow[j];
				this.prerender[i][j] = Prerender.prerenderTile(tile);
			}
		}
	}
	
	
	public void update() {
		this.prerenderCharacter();
	}
	

	
	public void prerenderCharacter() {
		if(this.currentCharacterCoordinates != null) this.prerender[currentCharacterCoordinates.y][currentCharacterCoordinates.x] = currentCharacterTile; 
		currentCharacterCoordinates = new Coordinates(this.character.coordinates.x, this.character.coordinates.y);
		currentCharacterTile = this.prerender[this.character.coordinates.y][this.character.coordinates.x];
		this.prerender[this.character.coordinates.y][this.character.coordinates.x] = 'X';
	}
	
	public void prerenderNPCs() { 
		for(NPC npc: this.npcs) {
			this.prerender[npc.coordinates.y][npc.coordinates.x] = 'N';
		}
	}
	
	public void prerenderMonsters() { 
		for(Monster monster: this.monsters) {
			this.prerender[monster.coordinates.y][monster.coordinates.x] = 'M';
		}
	}
	
	

	private static char prerenderTile(Tile tile) {
		switch (tile.terrainType) {
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
