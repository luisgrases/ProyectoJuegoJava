package main;

public class Renderer {
	public static void renderPrerender(Prerenderer prerenderer) {
		int topBound = prerenderer.character.coordinates.y - 7;
		int bottomBound = prerenderer.character.coordinates.y + 7;
		for (int i = topBound; i < bottomBound; i++) {
			int leftBound = prerenderer.character.coordinates.x - 10;
			int rightBound = prerenderer.character.coordinates.x + 10;
		    for (int j = leftBound; j < rightBound; j++) {
		        System.out.print(prerenderer.prerender[i][j] + " ");
		    }
		    System.out.println();
		}
	}
	
	
}
