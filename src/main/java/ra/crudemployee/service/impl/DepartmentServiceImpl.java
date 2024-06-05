package ra.crudemployee.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ra.crudemployee.model.Department;
import ra.crudemployee.model.Employee;
import ra.crudemployee.repository.DepartmentRepository;
import ra.crudemployee.service.DepartmentService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Integer deId) {
        return departmentRepository.findById(deId).orElseThrow(()->new NoSuchElementException("Khong ton tai"+deId));
    }

    @Override
    public Department insertDepartment(Department department) {
       return departmentRepository.save(department);
    }

    @Override
    public Department updateDepartment(Department department) {
        departmentRepository.findById(department.getDepartId()).orElseThrow(()->new NoSuchElementException("Khong ton tai phong ban nay trong database"));
        return departmentRepository.save(department);
    }

    @Override
    public void deleteDepartment(Integer deId) {
        departmentRepository.deleteById(deId);
    }


}
