package main;

public class Renderer {
	public static void renderPrerender(Prerender prerender) {
		int topBound = prerender.character.coordinates.y - 7;
		int bottomBound = prerender.character.coordinates.y + 7;
		for (int i = topBound; i < bottomBound; i++) {
			int leftBound = prerender.character.coordinates.x - 10;
			int rightBound = prerender.character.coordinates.x + 10;
		    for (int j = leftBound; j < rightBound; j++) {
		        System.out.print(prerender.prerender[i][j] + " ");
		    }
		    System.out.println();
		}
	}
	
	
}
