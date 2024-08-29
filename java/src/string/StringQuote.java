package string;

public class StringQuote {
    public static void main(String[] args) {
        //  character literals (single quotes) being used which is why concatenation wouldn't occur
        // the corresponding ASCII values of each character would be added and the result of that sum would be printed.
        // The ASCII values of ‘b’, ‘i’, ‘t’ are:
        //‘b’ = 98
        //‘i’ = 105
        //‘t’ = 116
        System.out.println('b' + 'i' + 't');
    }
}
