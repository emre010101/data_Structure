package week5;

public class EmptyQueueException extends RuntimeException {
	
	public EmptyQueueException() {
		super("There are no elements in the Queue");
	}
}
