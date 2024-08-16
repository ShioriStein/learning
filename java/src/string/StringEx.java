package string;

public class StringEx {
    static String defaultString;
    public static void main(String[] args) {
        /* By default new String will result in empty String */
        String newString = new String();
        /* You can assign value to declare String variable */
        String assignString = "";

        System.out.println(defaultString);
        System.out.println(newString);
        System.out.println(assignString);
    }
}
