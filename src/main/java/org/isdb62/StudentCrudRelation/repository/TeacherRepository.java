package org.isdb62.StudentCrudRelation.repository;

import org.isdb62.StudentCrudRelation.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

}
