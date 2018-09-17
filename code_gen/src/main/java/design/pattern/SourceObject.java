package design.pattern;

public class SourceObject implements SourceInterface {
    @Override
    public void doSth() {
        System.out.println("SourceObject：正在吃饭");
    }
}
