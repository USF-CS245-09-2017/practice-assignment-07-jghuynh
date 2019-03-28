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
        System.out.println("In the non-specific add method!");
        if (head == null) {
            System.out.println("Head is null");
            Node<T> newNode = new Node(item);
            head = newNode;
            size ++;
            System.out.println("LinkedList Size = " + size);
        }
        else {
            System.out.println("Head is not null");
            Node<T> previous = head;
            if (size == 0) {
                previous.setData(item);
            }
            else
            {
                for (int index = 0; index < size - 1; index ++) {
                    previous = previous.getNextNode(); // advance to penultimate node
                    Node<T> newNode = new Node(item);
                    previous.setNextNode(newNode);
                    size ++;
                    System.out.println("LinkedList Size = " + size);
                }
            }
        }
    }

    /**
     * Adds data to a specified position in the LinkedList
     * @param pos the specified position
     * @param data the value to add
     */
    public void add(int pos, T data)
    {
        Assert.notFalse(pos <= size && pos >= 0);
        if (pos == 0) {
            Node newNode = new Node(data);
            newNode.setNextNode(head);
            head = newNode;
            size ++;
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
            size ++;
        }



    }

    /**
     * Gets the data at a particular node position
     * @param pos the particular position
     * @return the data at that position
     */
    public T get(int pos) {
        Assert.notFalse(pos > 0 && pos < size);
        Node current = head;
        for (int index = 0; index < pos; index ++) {
             current = current.getNextNode();
        }
         return (T) current.getData();
    }

//    /**
//     * Grows the array to twice its size
//     */
//    protected void grow_array() {
//        Object[] tempArray = new Object[array.length * 2];
//        T[] twiceArray = (T[]) tempArray;
//        for (int index = 0; index < array.length; index ++)
//        {
//            twiceArray[index] = array[index];
//        }
//        array = twiceArray;
//    }


    public T remove(int pos) {
        System.out.println("LinkeList size = " + size);
        Assert.notFalse(pos >=0 && pos < size);
        if (pos == 0) {
            Node<T> current = head;
            head = current.getNextNode(); // advance head forward
            size --;
            return current.getData();
        }
        Node<T>  previous = head;
        Node<T> current = previous.getNextNode();
        for (int index = 0; index < pos - 1; index ++) {
            previous = previous.getNextNode();
            current = previous.getNextNode();
        }
        size --;
        return current.getData();
    }

    public int size() {
        return size;
    }

    public static void main (String[] args) {
        LinkedList myLL = new LinkedList();
        myLL.add(4);
        myLL.add(1);
        myLL.remove(3);
//        Node<T> current = new Node();
        for (int index = 0; index < myLL.size; index ++) {
            System.out.print(myLL.get(index) + " ");
        }
    }



}
