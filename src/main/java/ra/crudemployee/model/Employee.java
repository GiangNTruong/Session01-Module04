package ra.crudemployee.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer EmpId;
    private String fullName;
    private String Gender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
	private String position;
    private Double salary;
    private String avatar;
    @ManyToOne
    @JoinColumn(name = "departId",referencedColumnName = "departId")
    private Department department;
}
