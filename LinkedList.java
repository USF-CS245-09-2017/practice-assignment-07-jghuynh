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
//        System.out.println("In the non-specific add method! LinkedList Size = " + size + "\t adding " + item);
        if (head == null) {
//            System.out.println("Head is null");
            Node<T> newNode = new Node(item);
//            System.out.println("Just created a new node");
            head = newNode;
//            System.out.println("Just pointed head to a new node");
//            System.out.println("LinkedList Size = " + size);
        }
        else {
//            System.out.println("Head is not null");
            Node<T> previous = head;
//            System.out.println("Just set previous node to head");
            if (size == 0) {
                previous.setData(item);
//                System.out.println("Just set head to item");
//                System.out.println("LinkedListSize = " + size);
            }
            else if (size == 1) {
//                System.out.println("If size is 1");
                Node<T> newNode = new Node(item);
                previous.setNextNode(newNode);
            }
            else
            {
//                System.out.println("If size is not 0 nor 1");
                for (int index = 0; index < size - 1; index ++) {
                    previous = previous.getNextNode(); // advance to penultimate node
//                    System.out.println("Previous = " + previous.getData());
                    if (index == size - 2)
                    {
                        Node<T> newNode = new Node(item);
                        previous.setNextNode(newNode);
//                        System.out.println("New Node = " + newNode.getData());
//                        System.out.println("Last node is " + newNode.getData());
                    }

                }


            }
        }
        size ++;
//        System.out.println("LinkedList Size After Adding = " + size);
//        System.out.println("End Add method");
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
//            System.out.println("Just increased size");
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
//            System.out.println("Done with advancing previous node to end");
            size ++;
//            System.out.println("Just increased size");
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


    /**
     * Removes the element from a given position
     * @param pos the given position
     * @return the element to be removed
     */
    public T remove(int pos) {
//        System.out.println("In the REmove method, removing pos = " + pos);
//        System.out.println("Current: LinkeList size = " + size + "\t Pos = " + pos);
        Assert.notFalse(pos >=0 && pos < size);
        if (pos < 0 || pos >= size) {
            return null;
        }
//        System.out.println("Position is legal");
        if (pos == 0) {
//            System.out.println("If position = 0");
            Node<T> current = head;
            head = current.getNextNode(); // advance head forward
//            System.out.println("Just pointed head to the next node");
            size --;
//            System.out.println("LinkedList Size: " + size);
            return current.getData();
        }
        Node<T>  previous = head;
        Node<T> current = previous.getNextNode();
        System.out.println("Current = " + current.getData());
        if (pos > 1)
        {
//            System.out.println("Enter if position: if pos <= 1");
            for (int index = 0; index < pos - 1; index ++) {
                previous = previous.getNextNode();
//                System.out.println("Previous node = " + previous.getData());
                current = previous.getNextNode();
//                System.out.println("Current Node = " + current.getData());
            }
            previous.setNextNode(current.getNextNode());
        }
        else { // if pos == 1
            current = current.getNextNode();
            System.out.println("Current = " + current.getData());
//            System.out.println("Current = " + current.getData());
//            Node<T> newNode = current.getNextNode();
            previous.setNextNode(current);
//            System.out.println("Previous = " + previous.getData());
        }
        size --;
//        System.out.println("After Removal: LinkedList Size = " + size);
//        System.out.println("Returning: " + current.getData());
        return current.getData();
    }

    /**
     * Gets the size/number of elements in the LinkedList
     * @return the size/number of elements
     */
    public int size() {
        return size;
    }

    public static void main (String[] args) {
        LinkedList myLL = new LinkedList();
        myLL.add(4);
        myLL.add(1);
        myLL.add(22);
        myLL.add(3);
        myLL.add(2, 50);
        // 4, 1, 50, 22, 3
        System.out.println("Array Before Removal");
        for (int index = 0; index < myLL.size; index ++) {
            System.out.print(myLL.get(index) + " ");
        }
        myLL.remove(0);
        myLL.remove(5);
        myLL.remove(1);

        myLL.add(2, 4);
//        Node<T> current = new Node();
        System.out.println();
        System.out.println("Array After Removing Index");
        for (int index = 0; index < myLL.size; index ++) {
            System.out.print(myLL.get(index) + " ");
        }
    }



}
