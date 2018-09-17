package tech.zhengshi.clazz.dto;

import tech.zhengshi.core.dt.IDAware;

import java.io.Serializable;

public class StudentClassDTO implements Serializable, IDAware {


    private static final long serialVersionUID = 1964508588449306512L;

    private Long id;

    //用户与班级关联基础属性
    private Long studentId;
    private Long classId;
    private Long gradeId;


    public StudentClassDTO() {
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
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
}
