package archioo;

public class Sum extends Operation {
	
	public Sum(float left, float right) {
		this.operator = '+';
		this.left = left;
		this.right = right;
	}

	@Override
	public float calculate() {
		return this.left + this.right;
	}
	
}
