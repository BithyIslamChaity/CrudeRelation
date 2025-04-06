package org.isdb62.StudentCrudRelation.controller;

import java.util.List;

import org.isdb62.StudentCrudRelation.dao.ClassTeacher;
import org.isdb62.StudentCrudRelation.dao.ClassTeacherProjection;
import org.isdb62.StudentCrudRelation.dto.StudentClassDTO;
import org.isdb62.StudentCrudRelation.model.StudentClass;
import org.isdb62.StudentCrudRelation.service.StudentClassService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/class")
public class StudentClassController {
   private final StudentClassService studentClassService;

   public StudentClassController(StudentClassService studentClassService) {
      this.studentClassService = studentClassService;
   }
   @PostMapping
  public ResponseEntity<?> saveStudentClass(@RequestBody StudentClassDTO classDTO){
   StudentClass saved= studentClassService.saveStudentClass(classDTO);
   return new ResponseEntity<>(saved, HttpStatus.CREATED);
   }
   @GetMapping("/{id}")
   public StudentClass gStudentClass(@PathVariable Integer id){
    StudentClass byID = studentClassService.getStudentClass(id);
    return byID;
   }
   @DeleteMapping("/{id}")
   public ResponseEntity<?> deleteStudentClass(@PathVariable Integer id){
    studentClassService.deleteStudentClass(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }
   @GetMapping
public List<StudentClass> getAllStudentClass(){
    return studentClassService.getAllStudentClass();
   }
   @PutMapping("/{id}")
   public StudentClass updateStudentClass(@PathVariable Integer id, @RequestBody StudentClassDTO classDTO){
      StudentClass updated = studentClassService.updateStudentClass(id, classDTO);
      return updated;
   }

   @GetMapping("/getClassTeacher")
   public List<ClassTeacherProjection> getAllClassTeacher(){
       return studentClassService.getAllClassTeacher();
   }
   
}
