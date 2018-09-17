package tech.zhengshi.core.dt;

/**
 * @author H
 */
public class IDUtil {


    public static Long getID() {
        return System.nanoTime();
    }

    public static String getTrasanctionID() {
        return "TRX-" + getID();
    }

}
