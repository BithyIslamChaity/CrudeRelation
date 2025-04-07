package org.isdb62.StudentCrudRelation.dao;

import lombok.Getter;

@Getter
public class ClassTeacher {
    private String className;
	private String classTeacherName;
    private Integer roomNumber;
    private String email;

    public ClassTeacher(String className, String classTeacherName, Integer roomNumber, String email) {
        this.className = className;
        this.classTeacherName = classTeacherName;
        this.roomNumber = roomNumber;
        this.email = email;
    }
}
