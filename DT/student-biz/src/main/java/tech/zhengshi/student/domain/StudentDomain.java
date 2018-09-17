package tech.zhengshi.student.domain;

import tech.zhengshi.core.base.domain.BaseDomain;

/**
 * @author H
 */
public class StudentDomain extends BaseDomain {

    private String userName;
    private Integer userAge;
    private String phone;
    private String idnumber;


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

    @Override
    public String toString() {
        return "User{" +
                "id=" + getId() +
                ", userName='" + userName + '\'' +
                ", userAge='" + userAge + '\'' +
                ", phone='" + phone + '\'' +
                ", idnumber='" + idnumber + '\'' +
                '}';
    }
}
