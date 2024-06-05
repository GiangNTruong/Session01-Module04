package ra.crudemployee.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.crudemployee.model.Department;
import ra.crudemployee.service.DepartmentService;

import java.util.List;

@Controller
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;
    @GetMapping
    public String home(Model model){
        List<Department> list = departmentService.findAll();
        model.addAttribute("list",list);
        return "department/home";
    }

    @GetMapping("/add")
    public String addDepartment(Model model){
        Department de=new Department();
        model.addAttribute("de",de);
        return "department/add";
    }

    @PostMapping("/add")
    public String saveEmployee(@ModelAttribute Department department, Model model){
        Department de = departmentService.insertDepartment(department);
        if (de!=null){
            return "redirect:/department";
        }else {
            model.addAttribute("de",de);
            return "department/add";
        }
    }

    @GetMapping("/edit/{id}")
    public String editEmployee(Model model,@PathVariable Integer id){
        model.addAttribute("de",departmentService.getDepartmentById(id));
        return "department/edit";
    }

    @PostMapping("/update/{id}")
    public String updateEmployee(@ModelAttribute Department department,@PathVariable Integer id){
        department.setDepartId(id);
        departmentService.updateDepartment(department);
        return "redirect:/department";

    }

    @GetMapping("delete/{id}")
    public String deleteEmployee(@PathVariable Integer id){
        departmentService.deleteDepartment(id);
        return  "redirect:/department";
    }
}
