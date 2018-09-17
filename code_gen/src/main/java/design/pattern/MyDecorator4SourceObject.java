package design.pattern;

public class MyDecorator4SourceObject implements SourceInterface {
    private SourceInterface sourceObject;

    public MyDecorator4SourceObject(SourceInterface sourceObject) {
        this.sourceObject = sourceObject;
    }


    @Override
    public void doSth() {
        System.out.println("第一步：饭前洗手");
        this.sourceObject.doSth();
        System.out.println("第三步：饭后洗碗");
    }
}
