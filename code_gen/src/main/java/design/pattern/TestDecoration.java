package design.pattern;

/**
 * @author H
 */
public class TestDecoration {
    public static void main(String[] args) {

        SourceObject sourceObject = new SourceObject();
        SourceInterface sourceInterface = sourceObject;
        sourceInterface.doSth();
        System.out.println("-------------------------------------");
        MyDecorator4SourceObject myDecorator4SourceObject = new MyDecorator4SourceObject(sourceInterface);
        myDecorator4SourceObject.doSth();

    }
}
