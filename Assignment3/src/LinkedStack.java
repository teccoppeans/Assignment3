
public class LinkedStack<T> implements LinkedStackInterface<T>{

	Node<T> first;
	
	public LinkedStack() {
		first = null;
	}
	
	public LinkedStack(T object) {
		first = new Node<T>(object);
	}
	
	@Override
	public void push(T object) {
		// TODO Auto-generated method stub
		Node<T> temp = new Node<T>(object);
		temp.setNext(first);
		first = temp;
	}

	@Override
	public void pop() throws StackUnderflowException {
		// TODO Auto-generated method stub
		if (!isEmpty())
			first = first.getNext();
		else 
			throw new StackUnderflowException();
	}

	@Override
	public T top() throws StackUnderflowException {
		// TODO Auto-generated method stub
		if (!isEmpty())
			return first.getValue();
		else
			throw new StackUnderflowException();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (first == null)
			return true;
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		first = null;
	}

}
