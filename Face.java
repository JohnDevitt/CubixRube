
public class Face{
	
	int[][] face;

	public Face(int[][] face) {
		this.face = face;
	}

	public void performClockwiseRotation() {
			
			int[][] transformedFace = new int[3][3];

			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					transformedFace[i][j] = face[j][2 - j];
				}
			}
			
			face = transformedFace;
	}

	public void performAntiClockwiseRotation() {

		int[][] transformedFace = new int[3][3];

		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				transformedFace[i][j] = face[2 - j][i];
			}
		}

		face = transformedFace;
	}

	public int get(int i, int j) {
		return face[i][j];
	}


	public void print() {
		System.out.print("            ");
		System.out.println("|---|---|---|");
		for(int i = 0; i < 3; i++) {
			System.out.print("            ");
			System.out.print("| ");
			for(int j = 0; j < 3; j++) {
				System.out.print(face[i][j] + " | ");
			}
			System.out.println();
			System.out.print("            ");
			System.out.println("|---|---|---|");
		}
	}

}