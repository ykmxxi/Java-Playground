package chap9.child;

import chap9.parent.Parent;

public class Child extends Parent {

    public String value = "child";

    @Override
    public void hello() {
        super.hello();
        System.out.println("Child.hello");
    }

    public void superCall() {
        System.out.println("this value = " + value); // this 생략 가능
        System.out.println("super value = " + super.value);

        hello();
    }

    public void call() {
        publicValue = 1;
        protectedValue = 1;
        // defaultValue = 1;
        // privateValue = 1;

        publicMethod();
        protectedMethod();
        // defaultMethod();
        // privateMethod();

        printParent();
    }

}
