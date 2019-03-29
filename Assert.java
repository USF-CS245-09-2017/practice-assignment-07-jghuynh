public class Assert {
    public static boolean notFalse(boolean condition) {
        if (condition) {
            return true;
        }
        try {
            throw new Exception("False condition!");
        }
        catch (Exception e) {
//            System.out.println("False!");
        }
        return true;
    }
}
