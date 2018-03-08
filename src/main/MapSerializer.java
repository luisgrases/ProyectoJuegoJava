package main;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MapSerializer {

	public static Map deserializeMap(String filePath) throws IOException {
		String[] rows = FileReader.readTextFile(filePath);
		Tile[][] tiles = new Tile[rows.length][rows[0].length()];
		for(int i = 0; i < rows.length; i++) { tiles[i] = deserializeMapRow(rows[i]);}
		return new Map(tiles);
	}
	
	
	private static Tile[] deserializeMapRow(String row) {
		Tile[] tileRow = new Tile[row.length()];
		for(int i = 0; i < row.length(); i++) {
			Tile tile = MapSerializer.deserializeTile(row.charAt(i));
			tileRow[i] = tile;
		}
		return tileRow;
	}
	
	private static Tile deserializeTile(char c) {
		return new Tile(MapSerializer.terrainMapper(c));
	}
	
	private static TerrainType terrainMapper(char c) {
		switch(c) {
			case 'm':  return TerrainType.MOUNTAIN;
			case 'w':  return TerrainType.WATER;
			case 'c':  return TerrainType.CAVE;
			case 't':  return TerrainType.TREES;
			case 'l':  return TerrainType.LAND;
			default: throw new IllegalArgumentException();
		}
	}

}
