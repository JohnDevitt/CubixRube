
import java.util.ArrayList;

public class RubixCube {
	
	// Color Coding
	// 1 = White
	// 2 = Blue
	// 3 = Red
	// 4 = Yellow
	// 5 = Orange
	// 6 = Green

	// The Face of a side of a cube is represented in the array: Left-to-Right, Top-To-Bottom
	Face topFace;
	Face bottomFace;
	Layer topLayer;
	Layer midLayer;
	Layer bottomLayer;

	public RubixCube(Face topFace, Face bottomFace, Layer topLayer, Layer midLayer, Layer bottomLayer) {
		this.topFace = topFace;
		this.bottomFace = bottomFace;
		this.topLayer = topLayer;
		this.midLayer = midLayer;
		this.bottomLayer = bottomLayer;
	}

	public void rotateTopClockwise() {
		topLayer.rotateLayerClockwise();
		topFace.performClockwiseRotation();
	}

	public void rotateTopAntiClockwise() {
		topLayer.rotateLayerAntiClockwise();
		topFace.performAntiClockwiseRotation();
	}

	public void rotateBottomClockwise() {
		// Rotate the LIST clockwise to rotate this LAYER anticlockwise
		bottomLayer.rotateLayerAntiClockwise();
		bottomFace.performClockwiseRotation();
	}

	public void rotateBottomAntiClockwise() {
		// Rotate the LAYER clockwise to rotate this LIST anticlockwise
		bottomLayer.rotateLayerClockwise();
		bottomFace.performClockwiseRotation();
	}

	public void rotateRightClockwise() {
		transformCubeForLeftRightRotations();
		rotateTopClockwise();
		reverseTransformCubeForLeftRightRotations();
	}

	public void rotateRightAntiClockwise() {
		transformCubeForLeftRightRotations();
		rotateTopAntiClockwise();
		reverseTransformCubeForLeftRightRotations();
	}


	public void rotateLeftClockwise() {
		transformCubeForLeftRightRotations();
		rotateBottomClockwise();
		reverseTransformCubeForLeftRightRotations();
	}


	public void rotateLeftAntiClockwise() {
		transformCubeForLeftRightRotations();
		rotateBottomAntiClockwise();
		reverseTransformCubeForLeftRightRotations();
	}

	public void rotateFrontClockwise() {
		transformCubeForFrontBackRotations();
		rotateTopClockwise();
		reverseTransformCubeForFrontBackRotations();
	}

	public void rotateFrontAntiClockwise() {
		transformCubeForFrontBackRotations();
		rotateTopAntiClockwise();
		reverseTransformCubeForFrontBackRotations();
	}


	public void rotateBackClockwise() {
		transformCubeForFrontBackRotations();
		rotateBottomClockwise();
		reverseTransformCubeForFrontBackRotations();
	}


	public void rotateBackAntiClockwise() {
		transformCubeForFrontBackRotations();
		rotateBottomAntiClockwise();
		reverseTransformCubeForFrontBackRotations();
	}

	public void transformCubeForLeftRightRotations() {
		ArrayList<Integer> newTopLayer = new ArrayList<Integer>();
		ArrayList<Integer> newMidLayer = new ArrayList<Integer>();
		ArrayList<Integer> newBottomLayer = new ArrayList<Integer>();
		int[][] newTopFace = new int[3][3];
		int[][] newBottomFace = new int[3][3];

		//------------------------------------------------------------------//

		newTopLayer.add(topLayer.get(2));
		newTopLayer.add(midLayer.get(2));
		newTopLayer.add(bottomLayer.get(2));

		newMidLayer.add(topLayer.get(1));
		newMidLayer.add(midLayer.get(1));
		newMidLayer.add(bottomLayer.get(1));

		newBottomLayer.add(topLayer.get(0));
		newBottomLayer.add(midLayer.get(0));
		newBottomLayer.add(bottomLayer.get(0));

		//------------------------------------------------------------------//

		newTopLayer.add(bottomFace.get(0, 2));
		newTopLayer.add(bottomFace.get(1, 2));
		newTopLayer.add(bottomFace.get(2, 2));

		newMidLayer.add(bottomFace.get(0, 1));
		newMidLayer.add(bottomFace.get(1, 1));
		newMidLayer.add(bottomFace.get(2, 1));

		newBottomLayer.add(bottomFace.get(0, 0));
		newBottomLayer.add(bottomFace.get(1, 0));
		newBottomLayer.add(bottomFace.get(2, 0));

		//------------------------------------------------------------------//

		newTopLayer.add(bottomLayer.get(6));
		newTopLayer.add(midLayer.get(6));
		newTopLayer.add(topLayer.get(6));

		newMidLayer.add(bottomLayer.get(7));
		newMidLayer.add(midLayer.get(7));
		newMidLayer.add(topLayer.get(7));

		newBottomLayer.add(bottomLayer.get(8));
		newBottomLayer.add(midLayer.get(8));
		newBottomLayer.add(topLayer.get(8));

		//------------------------------------------------------------------//

		newTopLayer.add(topFace.get(0, 2));
		newTopLayer.add(topFace.get(1, 2));
		newTopLayer.add(topFace.get(2, 2));

		newMidLayer.add(topFace.get(0, 1));
		newMidLayer.add(topFace.get(1, 1));
		newMidLayer.add(topFace.get(2, 1));

		newBottomLayer.add(topFace.get(0, 0));
		newBottomLayer.add(topFace.get(1, 0));
		newBottomLayer.add(topFace.get(2, 0));

		//------------------------------------------------------------------//

		newTopFace[0][0] = topLayer.get(5);
		newTopFace[0][1] = midLayer.get(5);
		newTopFace[0][2] = bottomLayer.get(5);

		newTopFace[1][0] = topLayer.get(4);
		newTopFace[1][1] = midLayer.get(4);
		newTopFace[1][2] = bottomLayer.get(4);

		newTopFace[2][0] = topLayer.get(3);
		newTopFace[2][1] = midLayer.get(3);
		newTopFace[2][2] = bottomLayer.get(3);

		//------------------------------------------------------------------//

		newBottomFace[0][0] = topLayer.get(11);
		newBottomFace[0][1] = midLayer.get(11);
		newBottomFace[0][2] = bottomLayer.get(11);

		newBottomFace[1][0] = topLayer.get(10);
		newBottomFace[1][1] = midLayer.get(10);
		newBottomFace[1][2] = bottomLayer.get(10);

		newBottomFace[2][0] = topLayer.get(9);
		newBottomFace[2][1] = midLayer.get(9);
		newBottomFace[2][2] = bottomLayer.get(9);

		topLayer = new Layer(newTopLayer);
		midLayer = new Layer(newMidLayer);
		bottomLayer = new Layer(newBottomLayer);
		topFace = new Face(newTopFace);
		bottomFace = new Face(newBottomFace);
	}

	public void reverseTransformCubeForLeftRightRotations() {
		ArrayList<Integer> newTopLayer = new ArrayList<Integer>();
		ArrayList<Integer> newMidLayer = new ArrayList<Integer>();
		ArrayList<Integer> newBottomLayer = new ArrayList<Integer>();
		int[][] newTopFace = new int[3][3];
		int[][] newBottomFace = new int[3][3];

		newTopLayer.add(bottomLayer.get(0));
		newTopLayer.add(midLayer.get(0));
		newTopLayer.add(topLayer.get(0));

		newMidLayer.add(bottomLayer.get(1));
		newMidLayer.add(midLayer.get(1));
		newMidLayer.add(topLayer.get(1));

		newBottomLayer.add(bottomLayer.get(2));
		newBottomLayer.add(midLayer.get(2));
		newBottomLayer.add(topLayer.get(2));

		//------------------------------------------------------------------//

		newTopLayer.add(topFace.get(2, 0));
		newTopLayer.add(topFace.get(1, 0));
		newTopLayer.add(topFace.get(0, 0));

		newMidLayer.add(topFace.get(2, 1));
		newMidLayer.add(topFace.get(1, 1));
		newMidLayer.add(topFace.get(0, 1));

		newBottomLayer.add(topFace.get(2, 2));
		newBottomLayer.add(topFace.get(1, 2));
		newBottomLayer.add(topFace.get(0, 2));

		//------------------------------------------------------------------//

		newTopLayer.add(topLayer.get(8));
		newTopLayer.add(midLayer.get(8));
		newTopLayer.add(bottomLayer.get(8));

		newMidLayer.add(topLayer.get(7));
		newMidLayer.add(midLayer.get(7));
		newMidLayer.add(bottomLayer.get(7));

		newBottomLayer.add(topLayer.get(6));
		newBottomLayer.add(midLayer.get(6));
		newBottomLayer.add(bottomLayer.get(6));

		//------------------------------------------------------------------//

		newTopLayer.add(bottomFace.get(2, 0));
		newTopLayer.add(bottomFace.get(1, 0));
		newTopLayer.add(bottomFace.get(0, 0));

		newMidLayer.add(bottomFace.get(2, 1));
		newMidLayer.add(bottomFace.get(1, 1));
		newMidLayer.add(bottomFace.get(0, 1));

		newBottomLayer.add(bottomFace.get(2, 0));
		newBottomLayer.add(bottomFace.get(1, 0));
		newBottomLayer.add(bottomFace.get(0, 0));

		//------------------------------------------------------------------//

		newTopFace[0][0] = bottomLayer.get(9);
		newTopFace[0][1] = midLayer.get(9);
		newTopFace[0][2] = topLayer.get(9);

		newTopFace[1][0] = bottomLayer.get(10);
		newTopFace[1][1] = midLayer.get(10);
		newTopFace[1][2] = topLayer.get(10);

		newTopFace[2][0] = bottomLayer.get(11);
		newTopFace[2][1] = midLayer.get(11);
		newTopFace[2][2] = topLayer.get(11);

		//------------------------------------------------------------------//

		newBottomFace[0][0] = bottomLayer.get(3);
		newBottomFace[0][1] = midLayer.get(3);
		newBottomFace[0][2] = topLayer.get(3);

		newBottomFace[1][0] = bottomLayer.get(4);
		newBottomFace[1][1] = midLayer.get(4);
		newBottomFace[1][2] = topLayer.get(4);

		newBottomFace[2][0] = bottomLayer.get(5);
		newBottomFace[2][1] = midLayer.get(5);
		newBottomFace[2][2] = topLayer.get(5);

		//-----------------------------------------------------------------//

		topLayer = new Layer(newTopLayer);
		midLayer = new Layer(newMidLayer);
		bottomLayer = new Layer(newBottomLayer);
		topFace = new Face(newTopFace);
		bottomFace = new Face(newBottomFace);

	}

	public void transformCubeForFrontBackRotations() {
		ArrayList<Integer> newTopLayer = new ArrayList<Integer>();
		ArrayList<Integer> newMidLayer = new ArrayList<Integer>();
		ArrayList<Integer> newBottomLayer = new ArrayList<Integer>();
		int[][] newTopFace = new int[3][3];
		int[][] newBottomFace = new int[3][3];

		newTopLayer.add(bottomFace.get(0, 0));
		newTopLayer.add(bottomFace.get(0, 1));
		newTopLayer.add(bottomFace.get(0, 2));

		newMidLayer.add(bottomFace.get(1, 0));
		newMidLayer.add(bottomFace.get(1, 1));
		newMidLayer.add(bottomFace.get(1, 2));

		newBottomLayer.add(bottomFace.get(2, 0));
		newBottomLayer.add(bottomFace.get(2, 1));
		newBottomLayer.add(bottomFace.get(2, 2));

		//------------------------------------------------------------------//

		newTopLayer.add(bottomLayer.get(3));
		newTopLayer.add(midLayer.get(3));
		newTopLayer.add(topLayer.get(3));

		newMidLayer.add(bottomLayer.get(4));
		newMidLayer.add(midLayer.get(4));
		newMidLayer.add(topLayer.get(4));

		newBottomLayer.add(bottomLayer.get(5));
		newBottomLayer.add(midLayer.get(5));
		newBottomLayer.add(topLayer.get(5));

		//------------------------------------------------------------------//

		newTopLayer.add(topFace.get(2, 2));
		newTopLayer.add(topFace.get(2, 1));
		newTopLayer.add(topFace.get(2, 0));

		newMidLayer.add(topFace.get(1, 2));
		newMidLayer.add(topFace.get(1, 1));
		newMidLayer.add(topFace.get(1, 0));

		newBottomLayer.add(topFace.get(0, 2));
		newBottomLayer.add(topFace.get(0, 1));
		newBottomLayer.add(topFace.get(0, 0));

		//------------------------------------------------------------------//

		newTopLayer.add(topLayer.get(11));
		newTopLayer.add(midLayer.get(11));
		newTopLayer.add(bottomLayer.get(11));

		newMidLayer.add(topLayer.get(10));
		newMidLayer.add(midLayer.get(10));
		newMidLayer.add(bottomLayer.get(10));

		newBottomLayer.add(topLayer.get(9));
		newBottomLayer.add(midLayer.get(9));
		newBottomLayer.add(bottomLayer.get(9));

		//------------------------------------------------------------------//

		newTopFace[0][0] = topLayer.get(0);
		newTopFace[0][1] = topLayer.get(1);
		newTopFace[0][2] = topLayer.get(2);

		newTopFace[1][0] = midLayer.get(0);
		newTopFace[1][1] = midLayer.get(1);
		newTopFace[1][2] = midLayer.get(2);

		newTopFace[2][0] = bottomLayer.get(0);
		newTopFace[2][1] = bottomLayer.get(1);
		newTopFace[2][2] = bottomLayer.get(2);

		//------------------------------------------------------------------//

		newBottomFace[0][0] = bottomLayer.get(8);
		newBottomFace[0][1] = bottomLayer.get(7);
		newBottomFace[0][2] = bottomLayer.get(6);

		newBottomFace[1][0] = midLayer.get(8);
		newBottomFace[1][1] = midLayer.get(7);
		newBottomFace[1][2] = midLayer.get(6);

		newBottomFace[2][0] = topLayer.get(8);
		newBottomFace[2][1] = topLayer.get(7);
		newBottomFace[2][2] = topLayer.get(6);

		//------------------------------------------------------------------//

		topLayer = new Layer(newTopLayer);
		midLayer = new Layer(newMidLayer);
		bottomLayer = new Layer(newBottomLayer);
		topFace = new Face(newTopFace);
		bottomFace = new Face(newBottomFace);
	}

	public void reverseTransformCubeForFrontBackRotations() {
		ArrayList<Integer> newTopLayer = new ArrayList<Integer>();
		ArrayList<Integer> newMidLayer = new ArrayList<Integer>();
		ArrayList<Integer> newBottomLayer = new ArrayList<Integer>();
		int[][] newTopFace = new int[3][3];
		int[][] newBottomFace = new int[3][3];

		newTopLayer.add(topFace.get(0, 0));
		newTopLayer.add(topFace.get(0, 1));
		newTopLayer.add(topFace.get(0, 2));

		newMidLayer.add(topFace.get(1, 0));
		newMidLayer.add(topFace.get(1, 1));
		newMidLayer.add(topFace.get(1, 2));

		newBottomLayer.add(topFace.get(2, 0));
		newBottomLayer.add(topFace.get(2, 1));
		newBottomLayer.add(topFace.get(2, 2));

		//------------------------------------------------------------------//

		newTopLayer.add(topLayer.get(5));
		newTopLayer.add(midLayer.get(5));
		newTopLayer.add(bottomLayer.get(5));

		newMidLayer.add(topLayer.get(4));
		newMidLayer.add(midLayer.get(4));
		newMidLayer.add(bottomLayer.get(4));

		newBottomLayer.add(topLayer.get(3));
		newBottomLayer.add(midLayer.get(3));
		newBottomLayer.add(bottomLayer.get(3));

		//------------------------------------------------------------------//

		newTopLayer.add(bottomFace.get(0, 0));
		newTopLayer.add(bottomFace.get(0, 1));
		newTopLayer.add(bottomFace.get(0, 2));

		newMidLayer.add(bottomFace.get(1, 0));
		newMidLayer.add(bottomFace.get(1, 1));
		newMidLayer.add(bottomFace.get(1, 2));

		newBottomLayer.add(bottomFace.get(2, 0));
		newBottomLayer.add(bottomFace.get(2, 1));
		newBottomLayer.add(bottomFace.get(2, 2));

		//------------------------------------------------------------------//

		newTopLayer.add(bottomLayer.get(9));
		newTopLayer.add(midLayer.get(9));
		newTopLayer.add(topLayer.get(9));

		newMidLayer.add(bottomLayer.get(10));
		newMidLayer.add(midLayer.get(10));
		newMidLayer.add(topLayer.get(10));

		newBottomLayer.add(bottomLayer.get(11));
		newBottomLayer.add(midLayer.get(11));
		newBottomLayer.add(topLayer.get(11));

		//------------------------------------------------------------------//

		newTopFace[0][0] = bottomLayer.get(8);
		newTopFace[0][1] = bottomLayer.get(7);
		newTopFace[0][2] = bottomLayer.get(6);

		newTopFace[1][0] = midLayer.get(8);
		newTopFace[1][1] = midLayer.get(7);
		newTopFace[1][2] = midLayer.get(6);

		newTopFace[2][0] = topLayer.get(8);
		newTopFace[2][1] = topLayer.get(7);
		newTopFace[2][2] = topLayer.get(6);

		//------------------------------------------------------------------//

		newBottomFace[0][0] = topLayer.get(0);
		newBottomFace[0][1] = topLayer.get(1);
		newBottomFace[0][2] = topLayer.get(2);

		newBottomFace[1][0] = midLayer.get(0);
		newBottomFace[1][1] = midLayer.get(1);
		newBottomFace[1][2] = midLayer.get(2);

		newBottomFace[2][0] = bottomLayer.get(0);
		newBottomFace[2][1] = bottomLayer.get(1);
		newBottomFace[2][2] = bottomLayer.get(2);

		//------------------------------------------------------------------//

		topLayer = new Layer(newTopLayer);
		midLayer = new Layer(newMidLayer);
		bottomLayer = new Layer(newBottomLayer);
		topFace = new Face(newTopFace);
		bottomFace = new Face(newBottomFace);
	}

	public void print() {
		System.out.println();
		topFace.print();
		topLayer.print();
		midLayer.print();
		bottomLayer.print();
		bottomFace.print();
		System.out.println();
	}
}