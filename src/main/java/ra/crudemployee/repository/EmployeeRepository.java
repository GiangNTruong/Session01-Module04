package ra.crudemployee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.crudemployee.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
