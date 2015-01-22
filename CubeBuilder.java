
import java.util.Scanner;
import java.util.ArrayList;

public class CubeBuilder {
	
	private Scanner scanner = new Scanner(System.in);

	public RubixCube buildCube() {

		int[][] topFace = new int[3][3];
		ArrayList<Integer> topLayer = new ArrayList<Integer>();
		ArrayList<Integer> midLayer = new ArrayList<Integer>();
		ArrayList<Integer> bottomLayer = new ArrayList<Integer>();
		int[][] bottomFace = new int[3][3];

		System.out.println("Looking at the top face of the cube, input the colours from left to right, top to bottom using the following colour scheme");
		printColourCodingMessage();

		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				topFace[i][j] = scanner.nextInt();
			}
		}

		System.out.println("Looking at the top layer of the cube, input the colours from left to right, all the way around the 4 faces of the cube");
		printColourCodingMessage();

		for(int i = 0; i < 12; i++) {
			topLayer.add(scanner.nextInt());
		}

		System.out.println("Looking at the middle layer of the cube, input the colours from left to right, all the way around the 4 faces of the cube");
		printColourCodingMessage();

		for(int i = 0; i < 12; i++) {
			midLayer.add(scanner.nextInt());
		}

		System.out.println("Looking at the bottom layer of the cube, input the colours from left to right, all the way around the 4 faces of the cube");
		printColourCodingMessage();

		for(int i = 0; i < 12; i++) {
			bottomLayer.add(scanner.nextInt());
		}

		System.out.println("Looking at the bottom face of the cube, input the colours from left to right, top to bottom using the following colour scheme");
		printColourCodingMessage();

		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				bottomFace[i][j] = scanner.nextInt();
			}
		}

		return new RubixCube(new Face(topFace), new Face(bottomFace), new Layer(topLayer), new Layer(midLayer), new Layer(bottomLayer));

	}

	public void printColourCodingMessage() {
		System.out.println("Press enter after entering each colour");
		System.out.println("1 = White");
		System.out.println("2 = Blue");
		System.out.println("3 = Red");
		System.out.println("4 = Yellow");
		System.out.println("5 = Orange");
		System.out.println("6 = Green");
	}

}