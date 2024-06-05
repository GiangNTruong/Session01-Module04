package ra.crudemployee.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ra.crudemployee.model.Department;
import ra.crudemployee.model.Employee;
import ra.crudemployee.service.DepartmentService;
import ra.crudemployee.service.EmployeeService;
import ra.crudemployee.service.UploadFile;

import java.util.List;

@Controller
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final DepartmentService departmentService;
    private final EmployeeService employeeService;
    private final UploadFile uploadFile;

    @GetMapping
    public String home(Model model){
        List<Employee> list = employeeService.getProducts();
        model.addAttribute("list",list);
        return "employee/home";
    }

    @GetMapping("/add")
    public String addEmployee(Model model){
        List<Department> listDepartment = departmentService.findAll();
        Employee em=new Employee();
        model.addAttribute("listDe",listDepartment);
        model.addAttribute("em",em);
        return "employee/add";
    }

    @PostMapping("/add")
    public String saveEmployee(@ModelAttribute Employee employee, @RequestParam MultipartFile imageFile, Model model){
        if(imageFile!=null && !imageFile.isEmpty()){
            String imageUrl = uploadFile.uploadToLocal(imageFile);
            employee.setAvatar(imageUrl);
        }
        Employee e = employeeService.insertProduct(employee);
        if (e!=null){
            return "redirect:/employee";
        }else {
            List<Department> listDepartment = departmentService.findAll();
            model.addAttribute("listDe",listDepartment);
            model.addAttribute("em",e);
            return "employee/add";
        }
    }

    @GetMapping("/edit/{id}")
    public String editEmployee(Model model,@PathVariable Integer id){
        List<Department> listDepartment = departmentService.findAll();
        model.addAttribute("listDe",listDepartment);
        model.addAttribute("em",employeeService.getProductById(id));
        return "employee/edit";
    }

    @PostMapping("/update/{id}")
    public String updateEmployee(@ModelAttribute Employee employee,@PathVariable Integer id, Model model){
            employee.setEmpId(id);
        List<Department> listDepartment = departmentService.findAll();
        model.addAttribute("listDe",listDepartment);
            employeeService.updateProduct(employee);
        return "redirect:/employee";

    }

    @GetMapping("delete/{id}")
    public String deleteEmployee(@PathVariable Integer id){
        employeeService.deleteProduct(id);
        return  "redirect:/employee";
    }
}
