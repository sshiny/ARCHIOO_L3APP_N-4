package archioo;

public abstract class Operation {
	
	protected char operator;
	protected float left;
	protected float right;
	protected abstract float calculate();
	
}
