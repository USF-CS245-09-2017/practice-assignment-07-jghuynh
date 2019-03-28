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
        Assert.notFalse(pos >= 0 && pos < size);
        if (array[INITIAL_SIZE - 1] != null) {
            grow_array();
        }
        for (int index = 0; index < size; index ++) {
            if (index == pos) {
                array[index + 1] = array[index];
                array[index] = item;
                size ++;
            }
            else if (index > pos) {
                array[index] = array[index - 1];
            }
        }
    }

    /**
     * Gets the item at the specified position in the ArrayList
     * @param pos the specified position/index
     * @return the item at the position or null if not found
     */
    public T get(int pos){
        Assert.notFalse(pos >= 0 && pos < size);
        for (int index = 0; index < size; index ++) {
            if (index == pos) {
                return array[index];
            }
        }
        return null;
    }

    /**
     * Removes an item from the specified position in the ArrayList
     * @param pos the specified position/index
     * @return the item from that position
     */
    public T remove(int pos){
        Assert.notFalse(pos >= 0 && pos < size);
        T value = array[head];
        for (int index = 0; index < size; index ++) {
            if (index == pos) {
                size --;
                value = array[pos];
                array[index] = array[index + 1];
            }
            else if (index > pos) {
                if (index == size - 1) {
                    array[index] = null;
                }
                else
                {
                    array[index] = array[index + 1];
                }
            }
        }
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
        myAL.remove(0);
        for (int index = 0; index < myAL.size(); index ++) {
            System.out.println(myAL.get(index) + " ");
        }

    }

}
