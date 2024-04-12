package basic;

import java.io.IOException;

//demonstrat Exception Propagation

abstract class SuperClass{

    public SuperClass(){
    } 

    public void method1() throws Exception {
        System.out.println(" SuperClass");
    }

    public abstract void method2();
    }

    class ChildClass extends SuperClass {
    public void method1() throws IOException {
        System.out.println("ChildClass");
    }

    @Override
    public void method2() {

    }

    public static void main(String[] args) throws Exception {
        ChildClass childClass = new ChildClass();
        childClass.method1();
    }
}
