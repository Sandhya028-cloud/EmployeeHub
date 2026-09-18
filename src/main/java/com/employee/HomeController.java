package com.employee;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/add-employee")
    public String addEmployeePage() {
      return "add-employee";
      }

    @GetMapping("/view-employees")
    public String viewEmployeesPage() {
      return "view-employees";
       }

    @GetMapping("/edit-employee")
    public String editEmployeePage() {
       return "edit-employee";
      }
}