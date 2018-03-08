package main;

public class Renderer {
	public static void renderPrerender(Prerender prerender) {
		for (int i = 0; i < prerender.prerender.length; i++) {
		    for (int j = 0; j < prerender.prerender[i].length; j++) {
		        System.out.print(prerender.prerender[i][j] + " ");
		    }
		    System.out.println();
		}
	}
	
}
