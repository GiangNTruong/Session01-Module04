package ra.crudemployee.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ra.crudemployee.model.Employee;
import ra.crudemployee.repository.EmployeeRepository;
import ra.crudemployee.service.EmployeeService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getProducts() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getProductById(Integer emId) {
        return employeeRepository.findById(emId).orElseThrow(()->new NoSuchElementException("Khong ton tai"+emId));
    }

    @Override
    public Employee insertProduct(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateProduct(Employee employee) {
        employeeRepository.findById(employee.getEmpId()).orElseThrow(()->new NoSuchElementException("Khong ton tai san pham nay trong database"));
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteProduct(Integer emId) {
        employeeRepository.deleteById(emId);
    }
}
