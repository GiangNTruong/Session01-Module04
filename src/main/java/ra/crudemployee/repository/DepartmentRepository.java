package ra.crudemployee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.crudemployee.model.Department;
@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {
}
