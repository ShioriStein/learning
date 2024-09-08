package core.accessmod;

//core. accessmod. p1.DefaultClass1' is not public in 'core. accessmod. p1'. Cannot be accessed from outside package
//import core.accessmod.p1.DefaultClass1;

//core. accessmod. p2.DefaultClass2' is not public in 'core. accessmod. p2'. Cannot be accessed from outside package
//import core.accessmod.p2.DefaultClass2;

//class TestAccessModifierEx extends DefaultClass1 {}

import core.accessmod.p1.PublicClass1;
import core.accessmod.p2.PublicClass2;

class TestAccessModifierEx1 extends PublicClass1 {
    
}

class TestAccessModifierEx2 extends PublicClass2 {

}

public class AccessModifierEx {
    public static void main(String[] args) {
        TestAccessModifierEx2 obj2 = new TestAccessModifierEx2();
    }
}
