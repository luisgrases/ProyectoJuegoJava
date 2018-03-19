package main;

public class Prerenderer {
	char[][] prerender;
	Character character;
	Map map;
	Coordinates currentCharacterCoordinates;
	char currentCharacterTile;
	
	public Prerenderer(Map map, Character character) {
		this.map = map;
		this.character = character;
	}
	
	public void load() {
		prerenderMap();
		prerenderCharacter();
	}
	
	public void update() {
		this.prerenderCharacter();
	}
	
	private void prerenderMap() {
		this.prerender = new char[this.map.tiles.length][this.map.tiles[0].length];
		for (int i = 0; i < this.map.tiles.length; i++) {
			Tile[] tileRow = this.map.tiles[i];
			for (int j = 0; j < tileRow.length; j++) {
				Tile tile = tileRow[j];
				this.prerender[i][j] = tile.mapToChar();
			}
		}
	}

	private void prerenderCharacter() {
		if(this.currentCharacterCoordinates != null) this.prerender[currentCharacterCoordinates.y][currentCharacterCoordinates.x] = currentCharacterTile; 
		currentCharacterCoordinates = new Coordinates(this.character.coordinates.x, this.character.coordinates.y);
		currentCharacterTile = this.prerender[this.character.coordinates.y][this.character.coordinates.x];
		this.prerender[this.character.coordinates.y][this.character.coordinates.x] = 'X';
	}

}
