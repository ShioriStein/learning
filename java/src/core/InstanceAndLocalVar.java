package core;

public class InstanceAndLocalVar {
    public String instanceVariable;
    public int instanceIntVariable;

    public void classMethod() {
        String localVariable;
        int instanceIntVariable;
    }

    InstanceAndLocalVar() {

    }

    public static void main(String[] args) {
        InstanceAndLocalVar instanceAndLocalVar = new InstanceAndLocalVar();
    }
}
