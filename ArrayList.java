/**
 * Data is stored in an array which can grow as needed
 * @author Justine Huynh
 * 03/23/2019
 */
public class ArrayList<T> implements List<T> {

    private int INITIAL_SIZE = 10;
    private T[] array;
    private int head;
    private int tail;
    private int size;

    public ArrayList() {
        Object[] tempArray = (T[]) new Object[INITIAL_SIZE];
        array = (T[]) tempArray;
        head = 0;
        tail = 0;
        size = 0;
    }

    /**
     * Adds a given item to the end of the ArrayList; grows the ArrayList if it is full
     * @param item the item to be added
     */
    public void add(T item) {
        if (array[array.length - 1] != null)
        {
            grow_array();
        }
        array[size] = item;
        size++;
    }

    /**
     * Adds a given item to a specified position in the ArrayList; grows the array if needed
     * @param pos the specified position/index
     * @param item the item to be added
     */
    public void add(int pos, T item) {
        Assert.notFalse(pos >= 0 && pos < array.length);
        if (array[array.length - 1] != null) {
            grow_array();
        }
        T originalVal = array[0];
        T temp = array[0];
        for (int index = pos; index < size + 1; index ++) {
            if (index == pos) {
                originalVal = array[index];
//                array[index + 1] = array[index];
                array[index] = item;
            }
            else if (index > pos) {
                temp = array[index];
                array[index] = originalVal;
                originalVal = temp;
//                array[index + 1] = array[index];
            }
//            originalVal = array[index];
        }
        size ++;
    }

    /**
     * Gets the item at the specified position in the ArrayList
     * @param pos the specified position/index
     * @return the item at the position or null if not found
     */
    public T get(int pos){
        Assert.notFalse(pos >= 0 && pos < size);
        return array[pos];
//         for (int index = 0; index < size; index ++) {
//             if (index == pos) {
//                 return array[index];
//             }
//         }
//         return null;
    }

    /**
     * Removes an item from the specified position in the ArrayList
     * @param pos the specified position/index
     * @return the item from that position
     */
    public T remove(int pos){
//        System.out.println("Enter Remove Function. Removing item at position = " + pos);
//        Assert.notFalse(pos >= 0 && pos < size);
        if (pos < 0 || pos >= size) {
            try {
                throw new Exception("False!");
            }
            catch (Exception e) {
            }
            return null;
        }

        T value = array[pos];
//        System.out.println("Value = " + value);
        for (int index = pos; index < size; index ++) {
           array[index] = array[index + 1];
        }
        size --;
        return value;
    }

    /**
     * Gets the size (number of elements) of the ArrayList
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * Grows the array to twice its size
     */
    protected void grow_array() {
        Object[] tempArray = new Object[array.length * 2];
        T[] twiceArray = (T[]) tempArray;
        for (int index = 0; index < array.length; index ++)
        {
            twiceArray[index] = array[index];
        }
        array = twiceArray;
    }

    public static void main(String[] args) {
        ArrayList myAL = new ArrayList();

        myAL.add(3);
        myAL.add(5);
        myAL.add(10);
        myAL.add(2, 4);
        myAL.add(2);
        System.out.println("Before removing");
        for (int index = 0; index < myAL.size(); index ++) {
            System.out.println(myAL.get(index) + " ");
        }
        System.out.println("Size = " + myAL.size);
        myAL.remove(2);
        System.out.println("Tried removed element as position = " + 2);
        for (int index = 0; index < myAL.size(); index ++) {
            System.out.println(myAL.get(index) + " ");
        }
        System.out.println("Size = " + myAL.size);

    }

}
