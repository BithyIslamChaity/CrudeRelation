package org.isdb62.StudentCrudRelation.service;

import java.lang.foreign.Linker.Option;
import java.util.List;
import java.util.Optional;

import org.isdb62.StudentCrudRelation.dao.ClassTeacher;
import org.isdb62.StudentCrudRelation.dao.ClassTeacherProjection;
import org.isdb62.StudentCrudRelation.dto.StudentClassDTO;
import org.isdb62.StudentCrudRelation.model.StudentClass;
import org.isdb62.StudentCrudRelation.model.Teacher;
import org.isdb62.StudentCrudRelation.repository.StudentClassRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class StudentClassService {
  
    private final StudentClassRepository studentClassRepository;
    private final TeacherService teacherService;

    public StudentClassService(StudentClassRepository studentClassRepository,
    TeacherService teacherService) {
        this.studentClassRepository = studentClassRepository;
        this.teacherService = teacherService;
    }

    public StudentClass saveStudentClass(StudentClassDTO classDTO) {
      Integer teacherId = classDTO.getClassTeacherId();
      Teacher teacher = teacherService.getTeacher(teacherId);
      if(teacher == null){
          throw new RuntimeException("Teacher not found");
      }
     StudentClass studentClass = new StudentClass();
        studentClass.setName(classDTO.getName());
        studentClass.setRoomNumber(classDTO.getRoomNumber());
        studentClass.setClassTeacher(teacher);

        return studentClassRepository.save(studentClass);
    }
    public StudentClass getStudentClass(Integer id) {
        return studentClassRepository.findById(id).orElse(null);
    }

    public void deleteStudentClass(Integer id) {
       studentClassRepository.deleteById(id);
    }

    public List<StudentClass> getAllStudentClass() {
        return studentClassRepository.findAll();
    }

    public StudentClass updateStudentClass(Integer id, StudentClassDTO classDTO) {
      Optional<StudentClass> sclassById = studentClassRepository.findById(id);
      if(sclassById.isPresent()){
        StudentClass aClass = new StudentClass();
        if(classDTO.getName() != null){
            aClass.setName(classDTO.getName());
        }
        if(classDTO.getRoomNumber() != null){
            aClass.setRoomNumber(classDTO.getRoomNumber());
        }
        if(classDTO.getClassTeacherId() != null){
            Integer teacherId = classDTO.getClassTeacherId();
            Teacher teacher = teacherService.getTeacher(teacherId);
            if(teacher == null){
                throw new RuntimeException("Teacher not found");
            }
            aClass.setClassTeacher(teacher);
        }
        return studentClassRepository.save(aClass);
      }
      else{
        throw new IllegalArgumentException("Class not found");
        }
}

    public List<ClassTeacherProjection> getAllClassTeacher() {
        return studentClassRepository.getAllClassTeacher();

    }
}
           
