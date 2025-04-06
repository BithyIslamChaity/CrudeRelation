package org.isdb62.StudentCrudRelation.repository;

import java.util.List;

import org.isdb62.StudentCrudRelation.dao.ClassTeacher;
import org.isdb62.StudentCrudRelation.dao.ClassTeacherProjection;
import org.isdb62.StudentCrudRelation.dao.ClassTeacherRecord;
import org.isdb62.StudentCrudRelation.model.StudentClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentClassRepository extends JpaRepository<StudentClass, Integer> {

	@Query("SELECT sc.name AS className, sc.classTeacher.name AS teacherName FROM StudentClass sc")
	List<ClassTeacherProjection> getAllClassTeacher();

	@Query("SELECT new org.isdb62.StudentCrudRelation.dto.ClassTeacherDTO(sc.name,  sc.classTeacher.name) FROM StudentClass sc")
	List<ClassTeacher> fetchAllClassTeacherDTOs();

	@Query("SELECT new org.isdb62.StudentCrudRelation.dao.ClassTeacherRecord(sc.name,  sc.classTeacher.name) FROM StudentClass sc")
	List<ClassTeacherRecord> fetchAllClassTeacherRecords();

}
