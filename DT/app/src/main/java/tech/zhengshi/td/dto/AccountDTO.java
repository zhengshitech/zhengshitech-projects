package tech.zhengshi.td.dto;

import java.io.Serializable;

public class AccountDTO implements Serializable {

    private static final long serialVersionUID = 4416787081186305889L;

    private Long id;

    //用户基础属性
    private String userName;
    private Integer userAge;
    private String phone;
    private String idnumber;


    //用户班级属性
    private Long studentId;
    private Long classId;
    private Long gradeId;
    private String className;
    private Integer type;
    private Integer studentMaxNumber;
    private String location;

    public AccountDTO() {
    }


    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public Long getId() {
        return id;
    }

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


    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStudentMaxNumber() {
        return studentMaxNumber;
    }

    public void setStudentMaxNumber(Integer studentMaxNumber) {
        this.studentMaxNumber = studentMaxNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


}
