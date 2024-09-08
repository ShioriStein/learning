package exception;

import java.io.IOException;

public class CheckedException {
    void m() throws IOException {
        throw new java.io.IOException("device error"); // checked exception
    }

    void n() throws IOException {
        m();
    }

    void p() {
        try {
            n();
        } catch (Exception e) {
            System.out.println("exception handeled");
        }
    }

    public static void main(String[] args) {
        CheckedException ce = new CheckedException();
        ce.p();
        System.out.println("Main done");
    }
}
