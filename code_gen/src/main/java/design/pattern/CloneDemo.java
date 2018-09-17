package design.pattern;

import java.io.*;

/**
 * @author H
 */
public class CloneDemo implements Cloneable,Serializable {

    private static final long serialVersionUID = -1421932922500644496L;

    private Integer aInt;
    private String aString;
    private User user;

    public CloneDemo(Integer aInt, String aString, User user) {
        this.aInt = aInt;
        this.aString = aString;
        this.user = user;
    }

    public Integer getaInt() {
        return aInt;
    }

    public void setaInt(Integer aInt) {
        this.aInt = aInt;
    }

    public String getaString() {
        return aString;
    }

    public void setaString(String aString) {
        this.aString = aString;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



    public CloneDemo shallowClone() throws CloneNotSupportedException {
        return (CloneDemo) super.clone();
    }


    public CloneDemo deepClone() throws CloneNotSupportedException, IOException, ClassNotFoundException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(this);

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        Object o = ois.readObject();
        return (CloneDemo) o;
    }
}
