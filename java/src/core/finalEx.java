package core;

public class finalEx {
    final String s = "test";
    final String empty;
    String notFinalText = "test";

    @Override
    public String toString() {
        return "finalEx{" +
                "s='" + s + '\'' +
                ", empty='" + empty + '\'' +
                ", notFinalText='" + notFinalText + '\'' +
                '}';
    }

    finalEx() {
        this.empty = "snv";
    }

    finalEx(String initempty) {
        this.empty = initempty;
    }

    public void doSomePrint(final String test) {
        System.out.println(test);
    }
    public static void main(String[] args) {
        final finalEx finalEx = new finalEx("testneh");
        finalEx.notFinalText = "sadasda"; //biến final nhưng vẫn có thể thay đổi nội dung của nó
        System.out.println(finalEx.toString());
        finalEx.doSomePrint("testneh");

        //finalEx = new finalEx(); //Lỗi

    }
}
