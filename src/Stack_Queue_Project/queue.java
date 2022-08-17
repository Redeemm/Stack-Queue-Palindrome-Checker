package Stack_Queue_Project;

import java.util.Arrays;

public class queue {

	private int front;
	private int rear;
	private final char[] queueArray;
	private int currentQueueSize;

	// Constructor
	queue(int maxSize) {
		queueArray = new char[maxSize];
		front = -1; // (maxSize + 1) - 1
		rear = -1;  // (maxSize + 1) - 1
		currentQueueSize = 0;
	}

	// Pushes a character to the 'rear' of the queue array
	public void enqueue(char character){
		if(isFull()) {
			System.out.println("Queue is full. No elements can be added.");
		}
		else {
			rear = (rear + 1) % queueArray.length;
			queueArray[rear] = character;
			currentQueueSize++;
		}
		if(front == -1)
			front++;
	}

	// Moves the character to 'front' position, assigns to variable and
	// decrements the available size of the array;
	public char dequeue() {
		char dequeuedCharacter = '\0';

		if(isEmpty())
			System.out.println("The queue is empty. Cannot remove anymore elements.");

		else {
			dequeuedCharacter = queueArray[front];
			queueArray[front] = '\0';
			front = (front + 1) % queueArray.length;
			--currentQueueSize;
		}
		return dequeuedCharacter;
	}

	// Checks to see if the array is empty
	public boolean isEmpty() {
		return currentQueueSize == 0;
	}

	// Checks to see if the array is full
	public boolean isFull() {
		return currentQueueSize == queueArray.length;
	}

	// Clear the 'queue' of all array contents
	public void clearArray() {
		//queueArray = null;
		Arrays.fill(queueArray, '\0');
	}

	@Override
	public String toString() {
		return "queue [front=" + front + ", rear=" + rear + ", queueArray=" + Arrays.toString(queueArray)
				+ ", currentQueueSize=" + currentQueueSize + "]";
	}
} // end class
