
public interface Stack {
    public void    push();
	public Object  pop() throws StackEmptyException;
	public Object  top();
	public boolean isEmpty();
	public int size();
}
