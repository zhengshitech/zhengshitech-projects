package tech.zhengshi.clazz.domain;

import tech.zhengshi.core.base.domain.BaseDomain;

/**
 * @author H
 */
public class StudentClassDomain extends BaseDomain {

    private Long studentId;
    private Long classId;
    private Long gradeId;

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
