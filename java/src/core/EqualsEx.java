package core;

public class EqualsEx {
    public static void main(String[] args) {
        String str1 = "someText";
        String str2;
        String str3 = new String("someText");
        str2 = "someText";

        //equals method
        System.out.println(str1.equals(str2));
        System.out.println(str1.equals(str3));

        //==
        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
    }
}
