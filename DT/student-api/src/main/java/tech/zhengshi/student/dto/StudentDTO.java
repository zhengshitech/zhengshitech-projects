package tech.zhengshi.student.dto;

import tech.zhengshi.core.dt.IDAware;

import java.io.Serializable;

public class StudentDTO implements Serializable, IDAware {

    private static final long serialVersionUID = 4416787081186305889L;

    private Long id;

    //用户基础属性
    private String userName;
    private Integer userAge;
    private String phone;
    private String idnumber;


    public StudentDTO() {
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

}
