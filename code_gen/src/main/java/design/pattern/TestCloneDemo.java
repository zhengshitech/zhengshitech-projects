package design.pattern;

import java.io.IOException;

public class TestCloneDemo {
    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {

        CloneDemo cloneDemo = new CloneDemo(22,"Tom",new User("Jack",111));


        CloneDemo shallowObject = cloneDemo.shallowClone();
        System.out.println(shallowObject);

        CloneDemo deepObject = cloneDemo.deepClone();
        System.out.println(deepObject);


    }
}
