package com.example.teacher.controller;

import com.example.teacher.model.Teacher;
import com.example.teacher.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Scanner;

@Controller
@RequestMapping(value = "/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/newTeacher")
    public String newTeacher() {
        Scanner scanner = new Scanner(System.in);
        Teacher teacher = new Teacher();
        teacher.setName(scanner.next());
        teacher.setSchool(scanner.next());
        teacher.setExperience(scanner.nextByte());
        teacherService.save(teacher);
        return "newTeacher";
    }

    @GetMapping("/getTeacher")
    public String getTeacher(Integer id) {
        Teacher teacher = teacherService.findById(id);

        return "getTeacher";
    }

    @GetMapping("/getAllTeachers")
    public String getAllTeachers() {
        List<Teacher> teachers = teacherService.findAll();

        return "getAllTeachers";
    }

    @GetMapping("/editTeacher")
    public String editTeacher(Integer id) {
        Scanner scanner = new Scanner(System.in);
        Teacher teacher = new Teacher();
        teacher.setId(id);
        teacher.setName(scanner.next());
        teacher.setSchool(scanner.next());
        teacher.setExperience(scanner.nextByte());
        teacherService.editTeacher(teacher);

        return "editTeachers";
    }

    @GetMapping("/deleteTeacher")
    public String deleteTeacher(Integer id) {
        teacherService.deleteById(id);

        return "deleteTeacher";
    }
}
