package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;


public class Main {
	private static final Charset ENCODING = StandardCharsets.UTF_8;

	public static void main(String[] args) throws IOException {
		Map map = MapSerializer.deserializeMap("/src/maps/map.txt");
		Character character = new Character("Luis Ignacio", new Coordinates(20,10));
		NPC npc1 = new NPC("Johnny", new Coordinates(19,11));
		Monster monster1 = new Monster("Dragon", new Coordinates(17,12));
		NPC[] npcs = new NPC[]{npc1};
		Monster[] monsters = new Monster[]{monster1};
		
		Prerender prerender = new Prerender(map, character, npcs, monsters);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String c = "start";
		while(true) {
			
			if(c.equals("w"))character.moveUp();
			if(c.equals("a"))character.moveLeft();
			if(c.equals("s"))character.moveDown();
			if(c.equals("d"))character.moveRight();
			prerender.update();
			Renderer.renderPrerender(prerender);
			
			System.out.println("Enter a command: ");
			c = reader.readLine();
			
			Main.clearScreen();
			
			
		}

	}
	public static void clearScreen() {  
		for (int i = 0; i < 50; ++i) System.out.println();
	}

}
