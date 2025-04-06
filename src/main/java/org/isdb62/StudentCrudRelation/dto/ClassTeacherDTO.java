package org.isdb62.StudentCrudRelation.dto;

public class ClassTeacherDTO {
	private String className;
	private String teacherName;

	public ClassTeacherDTO(String className, String teacherName) {
		this.className = className;
		this.teacherName = teacherName;
	}

	public String getClassName() {
		return className;
	}

	public String getTeacherName() {
		return teacherName;
	}

}
