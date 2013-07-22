
public interface LinkedStackInterface<T> {

	public void push(T object);
	public void pop() throws StackUnderflowException;
	public T top() throws StackUnderflowException;
	public boolean isEmpty();
	public void clear();
}
