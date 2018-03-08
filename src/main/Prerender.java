package main;

public class Prerender {
	char[][] prerender;
	
	public Prerender(Map map, Character character) {
		prerenderMap(map);
		prerenderCharacter(character);
	}
	
	public void prerenderMap(Map map) {
		this.prerender = new char[map.tiles.length][map.tiles[0].length];
		for (int i = 0; i < map.tiles.length; i++) {
			Tile[] tileRow = map.tiles[i];
			for (int j = 0; j < tileRow.length; j++) {
				Tile tile = tileRow[j];
				this.prerender[i][j] = Prerender.prerenderTile(tile);
			}
		}
	}
	
	public void prerenderCharacter(Character character) {
		this.prerender[character.coordinates.y][character.coordinates.x] = 'x';
	}
	
	

	private static char prerenderTile(Tile tile) {
		switch (tile.terrainType) {
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
