package com.example.teacher.service;

import com.example.teacher.model.Teacher;
import com.example.teacher.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;

    public void save(Teacher teacher) {
        teacher = teacherRepository.save(teacher);
    }

    public Teacher findById(Integer id) {
        return teacherRepository.findById(id).get();
    }

    public List<Teacher> findAll() {
        return (List<Teacher>) teacherRepository.findAll();
    }

    public void editTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public void deleteById(Integer id) {
        teacherRepository.deleteById(id);
    }
}
