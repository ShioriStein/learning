package string;

public class StringEx {
    static String defaultString;

    public static void stringBufferBuilderSpeed() {
        long time1;
        long time2;

        String string = "";
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder();

        time1 = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            string += i;
        }
        time2 = System.currentTimeMillis();
        System.out.println("String" + (time2 - time1));

        time1 = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            stringBuffer.append(i);
        }
        time2 = System.currentTimeMillis();
        System.out.println("StringBuffer" + (time2 - time1));

        time1 = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            stringBuilder.append(i);
        }
        time2 = System.currentTimeMillis();
        System.out.println("stringBuilder" + (time2 - time1));
    }
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

        stringBufferBuilderSpeed();
    }
}
