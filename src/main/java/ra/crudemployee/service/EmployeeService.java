package ra.crudemployee.service;

import ra.crudemployee.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getProducts();
    Employee getProductById(Integer emId);
    Employee insertProduct(Employee employee);
    Employee updateProduct(Employee employee);
    void deleteProduct(Integer emId);
}
