package core;

public class LoopEx {
    void ForLoopEx(int time) {
        for (int i = 0; i < time; i++) {
            System.out.println(i);
        }
    }

    void WhileLoopEx(int time) {
        int i = 0;
        while (i < time) {
            System.out.println(i);
            i++;
        }
    }

    void DoLoopEx(int time) {
        int i = 0;
        do {
            System.out.println(i);
            i++;
        } while(i < time);
    }

    public static void main(String[] args) {
        new LoopEx().ForLoopEx(10);
        new LoopEx().WhileLoopEx(10);
        new LoopEx().DoLoopEx(10);
    }
}
