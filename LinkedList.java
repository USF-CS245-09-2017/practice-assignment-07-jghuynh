//import org.w3c.dom.Node;

public class LinkedList<T> implements List<T>{

    private Node<T> head = null;
    private int size;

    /**
     * Constructs an object of type LinkedList that has a dummy head and next node both as null
     */
    public LinkedList(){
        head = new Node<T>(null);
        head.setNextNode(null);
        // head = head.getNext();

    }

    /**
     * Adds an item value to the end of the LinkedList
     * @param item the value to add
     */
    public void add (T item) {
        if (head == null) {
            Node<T> newNode = new Node(item);
            head = newNode;
            size ++;
        }
        else {
            Node<T> previous = head;
            for (int index = 0; index < size - 1; index ++) {
                previous = previous.getNextNode(); // advance to penultimate node
                Node<T> newNode = new Node(item);
                previous.setNextNode(newNode);
                size ++;
            }
        }
    }

    public void add(int pos, T data)
    {
        Assert.notFalse(pos <= size && pos >= 0);
        size++;
        if (pos == 0) {
            Node newNode = new Node(data);
            newNode.setNextNode(head);
            head = newNode;
        }
        else {
            Node previous = head;
            for (int index = 0; index < pos - 1; index ++)
            {
                previous = previous.getNextNode();
                Node newNode = new Node(data);
                newNode.setNextNode(previous.getNextNode()); // set newNode in front of previous
                previous.setNextNode(newNode); // advance previous node to newNode
            }
        }



    }

    public T get(int pos) {
        Assert.notFalse(pos > 0 && pos < size);
        Node current = head;
        for (int index = 0; index < pos; index ++) {
             current = current.getNextNode();
        }
         return (T) current.getData();
    }

    public T remove(int pos) {
        Assert.notFalse(pos >=0 && pos < size) {
            if (pos == 0) {
                Node<T> current = head;
                head = current.getNextNode(); // advance head forward
                return current.getData();
            }
            Node<T>  previous = head;
            Node<T> current = previous.getNextNode();
            for (int index = 0; index < pos - 1; index ++) {
                previous = previous.getNextNode();
                current = previous.getNextNode();
                size --;
            }
            return current.getData();
        }
    }

    public int size() {
        return size;
    }


}
