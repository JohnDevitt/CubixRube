
import java.util.ArrayList;

public class Layer {
	
	ArrayList<Integer> layer;

	public Layer(ArrayList<Integer> layer) {
		this.layer = layer;
	}

	public void rotateLayerClockwise() {
		for(int i = 0; i < 3; i++) {
			layer.add(layer.size() - 1, layer.remove(0));
		}
	}

	public void rotateLayerAntiClockwise() {
		for(int i = 0; i < 3; i++) {
			layer.add(0, layer.remove(layer.size() - 1));
		}
	}

	public int get(int index) {
		return layer.get(index);
	}

	public void print() {

		for(int i = 9; i < 12; i++) {
			System.out.print("| " + layer.get(i) + " ");
		}

		for(int i = 0; i < 9; i++) {
			System.out.print("| " + layer.get(i) + " ");
		}

		System.out.println("|");

		System.out.println("|---|---|---|---|---|---|---|---|---|---|---|---|");
	}

}