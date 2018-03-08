package main;

import java.io.File;
import java.io.IOException;
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
		character.setCoordinates(20, 10);
		
		Scanner reader = new Scanner(System.in);  
		
		char c = 's';
		while(c != 'q') {
			if(c=='w')character.moveUp();
			if(c=='a')character.moveLeft();
			if(c=='s')character.moveDown();
			if(c=='d')character.moveRight();
			Prerender prerender = new Prerender(map, character);
			Renderer.renderPrerender(prerender);
			System.out.println("Enter a command: ");
			c = reader.next().charAt(0); 
			Main.clearScreen();
		}
		reader.close();
		

	}
	public static void clearScreen() {  
		for (int i = 0; i < 50; ++i) System.out.println();
	}

}
