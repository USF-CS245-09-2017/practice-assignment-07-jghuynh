/**
 * A Node class to be used for ArrayList and LinkedList
 * @param <T> a Template type of data
 * @author Justine Huynh
 * 03/23/2019
 */
public class Node<T> {
    private T data;
    private Node next;

    /**
     * Constructs an object of type Node with data and the next node of type null
     * @param data the value to input into the first node
     */
    public Node(T data) {
        this.data = data;
        next = null;
    }

    /**
     * Accepts a Node as a parameter and sets that node to be the next node
     * (connects to the Node)
     * @param next the Node to connect to
     */
    public void setNextNode(Node next) {
        this.next = next;
    }

    /**
     * Gets/proceeds to the next node
     * @return the next node
     */
    public Node getNextNode() {
        return next;
    }

    /**
     * Sets the data at whatever node Object is in
     * @param data the value to put in the current node
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Gets the data at the current Node
     * @return the data/value at the current Node
     */
    public T getData() {
        return data;
    }

}
