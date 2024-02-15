package spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.ebtity.Student;
import spring.repo.StudentRepo;
import spring.service.StudentService;

import java.util.List;

@Controller
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class MainController {
    private final StudentService studentService;
    @GetMapping
    public String findAll (Model model){
        List<Student> students = studentService.findAll();
        model.addAttribute("allStudents",students);
        return "main-page";
    }

    @GetMapping("/new")
    public String create(Model model){
        model.addAttribute("newStudent",new Student());
        return "new-student";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("newStudent")Student student){
        studentService.save(student);
        return "redirect: /api/students";
    }

    @GetMapping("/update/{studentId}")
    public String editStudentsForm(@PathVariable("studentId")Long studentId,Model model){
        Student student = studentService.findById(studentId);
        model.addAttribute("student",student);
        return "edit-student";
    }

    @PostMapping("/edit/{studentId}")
    public String update(@ModelAttribute("student") Student newStudent,
                         @PathVariable Long studentId){
        studentService.updateById(studentId, newStudent);
        return "redirect:/api/students";
    }

    @GetMapping ("/delete/{studentId}")
    public String deleteCompanyById(@PathVariable("studentId") Long studentId) {
        studentService.deleteById(studentId);
        return "redirect:/api/students";
    }
}
