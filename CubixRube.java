
import java.util.ArrayList;

public class CubixRube {
	
	public static void main(String[] args) {

		/*

		int[][] topFace = new int[3][3];
		int[][] bottomFace = new int[3][3];

		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				topFace[i][j] = 1;
				bottomFace[i][j] = 6;
			}		
		}

		Face tFace = new Face(topFace);
		Face bFace = new Face(bottomFace);

		ArrayList<Integer> topLayer = new ArrayList<Integer>();
		ArrayList<Integer> midLayer = new ArrayList<Integer>();
		ArrayList<Integer> bottomLayer = new ArrayList<Integer>();

		for(int i = 2; i < 6; i++) {
			for(int j = 0; j < 3; j++) {
				topLayer.add(i);
				midLayer.add(i);
				bottomLayer.add(i);
			}
		}

		Layer tLayer = new Layer(topLayer);
		Layer mLayer = new Layer(midLayer);
		Layer bLayer = new Layer(bottomLayer);

		RubixCube cube = new RubixCube(tFace, bFace, tLayer, mLayer, bLayer);
		

		cube.rotateBackClockwise();
		cube.print();

		*/

		CubeBuilder cubeBuilder = new CubeBuilder();
		RubixCube cube = cubeBuilder.buildCube();

		cube.print();
	}
}