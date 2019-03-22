public class LinkedList<T> implements List<T>{

    public static boolean not_false(boolean condition) {
        if (!condition) {
            try {
                throw new Exception("Error!");
            }
            catch (Exception e) {
                System.err.println("Your condition is false!");
            }
        }
        return true;
    }

    public void add (T item) {
        if (head == null)
    }

    public void add(int pos, T data)
    {



    }

    public T get(int pos) {

    }

}
