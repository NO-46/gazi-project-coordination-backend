package com.example.authservice.controller;

import com.example.authservice.model.Student;
import com.example.authservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@RestController
@Transactional
@RequestMapping("/api/v1/student-management")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /*@PostMapping("/upload-students")
    public ResponseEntity<String> uploadStudents(@RequestParam("file") MultipartFile file) {
        try {
            // Read the excel file and convert it to a list of Student objects
            List<Student> students = ExcelHelper.readStudentsFromExcel(file.getInputStream());

            // Iterate through the list of students and save them to the database
            for (Student student : students) {
                // Encode the password before saving
                student.setPassword(passwordEncoder.encode(student.getPassword()));

                // Set the default role as ROLE_STUDENT
                Role studentRole = roleRepository.findByName(ERole.ROLE_STUDENT)
                        .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                student.setRoles(Collections.singleton(studentRole));

                // Save the student to the database
                userRepository.save(student);
            }

            return ResponseEntity.ok("Students have been successfully uploaded");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while reading the file");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    } */

}
