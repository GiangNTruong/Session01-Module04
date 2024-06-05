package ra.crudemployee.service;

import ra.crudemployee.model.Department;
import ra.crudemployee.model.Employee;

import java.util.List;

public interface DepartmentService {
    List<Department> findAll();
    Department getDepartmentById(Integer deId);
    Department insertDepartment(Department department);
    Department updateDepartment(Department department);
    void deleteDepartment(Integer deId);
}
