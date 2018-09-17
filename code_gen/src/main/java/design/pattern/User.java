package design.pattern;

import java.io.Serializable;

/**
 * @author H
 */
public class User implements Serializable {

    private static final long serialVersionUID = -6223728105647178285L;

    private String name;
    private Integer id;


    public User(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
