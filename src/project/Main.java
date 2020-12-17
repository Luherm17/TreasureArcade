package project;

import java.awt.Color;
import java.awt.event.KeyEvent;


import edu.princeton.cs.introcs.StdDraw;


public class Main {

	static int time = 0;
	static int time2 = 0;
	static int treasures = 0;
	static int points = 0;
	static int lives = 3;
	
	/**
	 * Check to see if a given key is pressed at the moment.  This method does not
	 *   wait for a key to be pressed, so if nothing is pressed, it returns
	 *   false right away.
	 *   
	 * The event constants are found at:
	 *   https://docs.oracle.com/javase/7/docs/api/java/awt/event/KeyEvent.html
	 * @param key the integer code of the key
	 * @return true if that key is down, false otherwise
	 */
	private static boolean checkFor(int key) {
		if (StdDraw.isKeyPressed(key)) {
			return true;
		}
		else {
			return false;
		}
	}

	public static void setupDrawing() {
		StdDraw.setCanvasSize(512, 512);
		StdDraw.setXscale(0,512);
		StdDraw.setYscale(0,512);		
	}

	public static double randomInRange(double start, double stop) {		
		double randoRange = Math.random()*(stop - start) + start;
		return randoRange;
	}


	public static void drawBubble(double x, double y, double size) {
		// Note the Pen color uses a "new color" with 4 parameters
		// TODO: You are welcome to change the color & transparency of clouds
		//                             red   green   blue   transparency (0-255)
		int bright = (int) randomInRange(100,255);        // 255 for white clouds. Lower numbers for grayer clouds
		int transparency = 100;  // 0-255; Higher numbers are "less transparent"
		StdDraw.setPenColor(new Color( bright/((int) randomInRange(1, 2)),    bright/((int) randomInRange(1, 3)),   bright/((int) randomInRange(1, 4)),   transparency));

		StdDraw.filledCircle(x, y, size/3); // Middle of cloud

	}


	public static double[][] createRandomBubbleLocations(int n) {
		double[][] array = new double[n][3];
		for (int i=0; i < array.length; i++) {
			array[i][0] = randomInRange(0, 550); // Sets x coord

			array[i][1] = randomInRange(-512, 0); // Sets y-coord

			array[i][2] = randomInRange(20, 50); // Sets size
		}
		return array;
	}


	public static void drawBubblesAt(double[][] bubbleLocations) {
		for (int i = 0; i < bubbleLocations.length; i++) {
			drawBubble(bubbleLocations[i][0], bubbleLocations[i][1], bubbleLocations[i][2]);
		}
	}

	public static void advanceBubbles(double[][] bubbleLocations) {
		for (int i=0; i < bubbleLocations.length; i++) {
			bubbleLocations[i][1]+= Math.random();
			if (bubbleLocations[i][1] > 550) {
				bubbleLocations[i][1] = -50;
			}
		}
	}

	public static void drawBoard() {

		StdDraw.setPenColor(Color.gray);
		StdDraw.filledRectangle(512, 512, 150, 100);
		StdDraw.setPenColor(Color.black);
		StdDraw.text(450, 500, "Score: " + points);
		StdDraw.text(450, 475, "Lives: " + lives);
		StdDraw.text(450, 450, "Treasures: " + treasures);
		StdDraw.text(450, 425, "Time: " + time/100 + "s");
	}
	
	
	public static void drawObstacle(double x, double y, double size) {
		// Note the Pen color uses a "new color" with 4 parameters
		// TODO: You are welcome to change the color & transparency of clouds
		//                             red   green   blue   transparency (0-255)
		int transparency = 200;  // 0-255; Higher numbers are "less transparent"
		StdDraw.setPenColor(new Color( 255,    0,   0,   transparency));

		StdDraw.filledSquare(x, y, size/5);
		StdDraw.filledCircle(x, y, size/4);
	}
	
	public static double[][] createRandomObstacleLocations(int n) {
		double[][] array = new double[n][3];
		for (int i=0; i < array.length; i++) {
			array[i][0] = randomInRange(50, 500); // Sets x coord

			array[i][1] = randomInRange(50, 500); // Sets y-coord

			array[i][2] = randomInRange(30, 50); // Sets size
		}
		return array;
	}
	
	public static void drawObstaclesAt(double[][] obstacleLocations) {
		for (int i = 0; i < obstacleLocations.length; i++) {
			drawObstacle(obstacleLocations[i][0], obstacleLocations[i][1], obstacleLocations[i][2]);
		}
	}
	
	public static void drawTreasure(double x, double y, double size) {
		// Note the Pen color uses a "new color" with 4 parameters
		// TODO: You are welcome to change the color & transparency of clouds
		//                             red   green   blue   transparency (0-255)
		int transparency = 200;  // 0-255; Higher numbers are "less transparent"
		StdDraw.setPenColor(new Color( 255,    215,   0,   transparency));

		StdDraw.filledRectangle(x, y, size/4, size/2);
		StdDraw.filledRectangle(x, y, size/2, size/4);
	}
	
	public static double[][] createRandomTreasureLocations(int n) {
		double[][] array = new double[n][3];
		for (int i=0; i < array.length; i++) {
			array[i][0] = randomInRange(50, 500); // Sets x coord

			array[i][1] = randomInRange(50, 500); // Sets y-coord

			array[i][2] = randomInRange(10, 20); // Sets size
		}
		return array;
	}
	
	public static void drawTreasuresAt(double[][] treasureLocations) {
		for (int i = 0; i < treasureLocations.length; i++) {
			drawTreasure(treasureLocations[i][0], treasureLocations[i][1], treasureLocations[i][2]);
		}
	}
	
	public static void endScreen() {
		
		StdDraw.setPenColor(Color.gray);
		StdDraw.filledRectangle(512, 512, 150, 100);
		StdDraw.setPenColor(Color.black);
//		if(lives == 2) {
//			StdDraw.text(450, 500, "Score: " + ((points/100)-5));
//		} if(lives == 1) {
//			StdDraw.text(450, 500, "Score: " + ((points/100)-10));
//		} if(lives == 0) {
//			StdDraw.text(450, 500, "Score: " + ((points/100)-15));
//		} else if (lives == 3) {
		StdDraw.text(450, 500, "Score: " + points);
//		}
		StdDraw.text(450, 475, "Lives: " + lives);
		StdDraw.text(450, 450, "Treasures: " + treasures);
		StdDraw.text(450, 425, "Time: " + time/100 + "s");
		
		StdDraw.setPenColor(Color.red);
		StdDraw.filledRectangle(256, 256, 50, 50);
		StdDraw.setPenColor(Color.white);
		StdDraw.text(256, 256, "You lost!");
	}


	public static void main(String[] args) {
		

		setupDrawing();

		StdDraw.enableDoubleBuffering();

		double px = 256;  // x location of the demo point
		double py = 25.6;  // y location of the demo point

		//
		// This song will play in the background allowing your other work
		//   to proceed. 
		// If annoyed, comment this out
		// If you want more, change playOnce() to playAlways()
		//
		BackgroundSong sbsp = new BackgroundSong("videoplayback.wav");
		sbsp.playOnce();

		double[][] bubbleLocations = createRandomBubbleLocations(75);
		
		double randomX = randomInRange(50, 450);
		double randomY = randomInRange(50, 450);
		double randomX1 = randomInRange(50, 450);
		double randomY1 = randomInRange(50, 450);
		double randomX2 = randomInRange(50, 450);
		double randomY2 = randomInRange(50, 450);
		
		double randoX = randomInRange(50, 450);
		double randoY = randomInRange(50, 450);
		double randoX1 = randomInRange(50, 450);
		double randoY1 = randomInRange(50, 450);
		double randoX2 = randomInRange(50, 450);
		double randoY2 = randomInRange(50, 450);
		
	

		while (true) {
			
			if(lives == 0) {
				endScreen();
				StdDraw.show();
				break;
			}
			
			StdDraw.clear();

			StdDraw.picture(256, 256, "images/underwater.jpg",512*1.2,512*1.2);
			
			
			drawTreasure(randomX,randomY,15);
			drawTreasure(randomX1,randomY1,15);
			drawTreasure(randomX2,randomY2,15);
			
			drawObstacle(randoX,randoY,35);
			drawObstacle(randoX1,randoY1,35);
			drawObstacle(randoX2,randoY2,35);
			

			//
			// Should we move?
			//
			if (checkFor(KeyEvent.VK_A)) {
				if(px > 15.36) {
					px = px - 1.536;
				}
			}
			if (checkFor(KeyEvent.VK_D)) {
				if(px < 496.64) {
					px = px + 1.536;
				}
			}
			py+=1.536;
			if(py >= 527.36) {

				py = -15.36;
			}
			
			
			//
			// The pirate
			//
			StdDraw.setPenColor(Color.BLACK);
			StdDraw.filledCircle(px, py, 15.36);	


			drawBubblesAt(bubbleLocations);

			advanceBubbles(bubbleLocations);

			drawBoard();

			StdDraw.show();  
			StdDraw.pause(10);   // 1/100 of a second
			time+=2.95;
			time2+=3;
			if(px <= randomX+15 && px >= randomX-15 && py <= randomY+15 && py >= randomY-15) {
				points+=20;
				treasures++;
			} else if(px <= randomX1+15 && px >= randomX1-15 && py <= randomY1+15 && py >= randomY1-15) {
				points+=20;
				treasures++;
			} else if(px <= randomX2+15 && px >= randomX2-15 && py <= randomY2+15 && py >= randomY2-15) {
				points+=20;
				treasures++;
			} else if(px <= randoX+15 && px >= randoX-15 && py <= randoY+15 && py >= randoY-15) {
				points-=30;
				px = 256;
				py = 25.6;
				lives-=1;
			} else if(px <= randoX1+15 && px >= randoX1-15 && py <= randoY1+15 && py >= randoY1-15) {
				points-=30;
				px = 256;
				py = 25.6;
				lives-=1;
			} else if(px <= randoX2+15 && px >= randoX2-15 && py <= randoY2+15 && py >= randoY2-15) {
				points-=30;
				px = 256;
				py = 25.6;
				lives-=1;
			}

		}

	}

}
