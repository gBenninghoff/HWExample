//Gabe Benninghoff
//Chapter 4 #25
//I did not copy code from other people or sources other than our CIS-221 textbook. 
//I did not use any "AI" software to help write code

import javax.management.RuntimeErrorException;

import support.LLNode;

public class circularQueue<T> {
    protected LLNode<T> rear; // the rear reference
    protected int numElements = 0; // instantiate the number of elements
    protected LLNode<T> temp; // a temp LLNode to be used in both Enqueue in Dequeue
    protected T element; // Used in dequeu to keep track of value of dequeue

    public circularQueue() { // base constructor
        rear = null;
    }

    public void enqueue(T element) {
        LLNode<T> newNode = new LLNode<T>(element); // setting up a new node to be inserted
        if (rear == null) { // if there is nothing in the queue then the node will reference itself as it
                            // needs to be a circle
            rear = newNode;
            newNode.setLink(newNode);
        } else { // if there is something inside of the queue then insert this new node at the
                 // front and point it towards the last inserted node
            temp = rear.getLink(); // holds the link reference
            rear.setLink(newNode); // sets the last node to reference the new node as first
            newNode.setLink(temp); // set the new node to the last added node
        }
        numElements++; // increment for size
    }

    public T dequeue() {
        numElements--; // decided to decriment at the beginning because of all the return statements
        if (isEmpty()) {
            throw new RuntimeException("Dequeue attempted on an empty queue."); // I cannot do QueueUnderlow
            // Exceptions for some reason
        }
        if (rear.getLink() == rear) { // this is if there is just the one node
            element = rear.getInfo();
            rear = null;
            return element;
        }

        temp = rear.getLink(); // get the first node
        element = rear.getInfo(); // preserve the data to be printed later
        while (true) {
            if (temp.getLink() == rear) { // if the temparary node points to the rear node then break out
                break;
            }
            temp = temp.getLink(); // otherwise advance one in queue
        }
        temp.setLink(rear.getLink()); // set the second to last node's pointer to the first node
        rear = temp; // set the rear pointer to the second to last node
        return element; // return info saved previously
    }

    public boolean isFull() {
        return false;
    }

    public boolean isEmpty() {
        return (rear == null);
    }

    public int size() {
        return numElements;
    }

}
