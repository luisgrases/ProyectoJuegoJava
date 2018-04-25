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
		Character character = new Character("Luis Ignacio", new Coordinates(14,10), map);
		NPC npc1 = new NPC("Johnny", new Coordinates(12,11), "Hola aventurero!");
		Monster monster1 = new Monster("Dragon", new Coordinates(11,12), ItemType.DRAGON_HEAD);
		Quest npc1Quest = new Quest("Cruza el bosque y mata al dragon del otro lado, luego traeme su cabeza.", new Item(ItemType.MACHETE), ItemType.DRAGON_HEAD, "Gracias! Esta cabeza de dragón me sera un buen adorno para mi árbol de navidad.");
		npc1.quest = npc1Quest;
		
		
		Coordinateable[] coordinateables = new Coordinateable[] {monster1, npc1};
		map.insertCoordinateables(coordinateables);
		
		Prerenderer prerenderer = new Prerenderer(map, character);
		prerenderer.load();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String c = "start";
		while(true) {
			
			if(c.equals("w"))character.moveUp();
			if(c.equals("a"))character.moveLeft();
			if(c.equals("s"))character.moveDown();
			if(c.equals("d"))character.moveRight();
			
			prerenderer.update();
			Renderer.renderPrerender(prerenderer);
			
			System.out.println("Enter a command: ");
			c = reader.readLine();
			
			Main.clearScreen();
			
			
		}

	}
	public static void clearScreen() {  
		for (int i = 0; i < 50; ++i) System.out.println();
	}

}
