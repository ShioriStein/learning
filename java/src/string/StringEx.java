package string;

public class StringEx {
    static String defaultString;
    public static void main(String[] args) {
        /* By default new String will result in empty String */
        /* This string won't stay in string pool*/
        String newString = new String();
        /* You can assign value to declare String variable */
        String assignString = "";
        String assignNewString = new String("");

        System.out.println(defaultString);
        System.out.println(newString);
        System.out.println(assignString);
        System.out.println(newString == assignString);
        System.out.println(assignString.equals(newString));
    }
}
