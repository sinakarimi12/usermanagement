package com.kia.usermanegment.controller;

import com.kia.usermanegment.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public abstract class StudentController {

    private static Map<Long, Student> studentRepo = new HashMap<>();


    static {
        Student classOne = new Student();
        classOne.setId(1L);
        classOne.setFirstName("kia");
        classOne.setLastName("Ansary");
        classOne.setAge(18);
        classOne.setNationalCode("2742253122");
        classOne.setSex("Man");
        studentRepo.put(classOne.getId(), classOne);

        Student classTwo = new Student();
        classTwo.setId(2L);
        classTwo.setFirstName("Sina");
        classTwo.setLastName("karimi");
        classTwo.setNationalCode("2742263152");
        classTwo.setAge(18);
        classTwo.setSex("Man");
        studentRepo.put(classTwo.getId(), classTwo);
    }


    @RequestMapping(value = "/getAllStudents/{id}")
    public ResponseEntity<Object> getStudentList(@PathVariable("id")Long id, @RequestBody Student student){
        List<Student> studentsList = new ArrayList<>();
        List<Integer> students =studentsList.stream()
                .filter(p->p.getAge()>25)
                .map(p->p.getAge())
                .collect(Collectors.toList());

        String value = String.valueOf(students);
        student.setId(id);
        studentRepo.put( id,student);
        return new ResponseEntity<>(studentRepo.values(), HttpStatus.OK);
    }


    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public ResponseEntity<Object> creatStudent(@RequestBody Student student) {
        studentRepo.put(student.getId(), student);
        return new ResponseEntity<>("Student successfully created", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/students")
    public ResponseEntity<Object> getStudent() {
        return new ResponseEntity<>(studentRepo.values(), HttpStatus.OK);
    }


    @RequestMapping(value = "/student/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateStudent(@PathVariable("id") Long id, @RequestBody Student student) {
        studentRepo.remove(id);
        student.setId(id);
        studentRepo.put(id, student);
        return new ResponseEntity<>("Student updated successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteStudent(@PathVariable("id") Long id) {
        studentRepo.remove(id);
        return new ResponseEntity<>("Student deleted successfully", HttpStatus.OK);
    }
}


