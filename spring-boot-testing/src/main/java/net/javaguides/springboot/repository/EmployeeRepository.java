package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository //not required -- SimpleJpaRepository (internally annotated with @Repository) implements JpaRepository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
