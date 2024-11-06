package com.example.demo.repository;

import com.example.demo.model.Employee;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class EmployeeRepository {
    private final JdbcTemplate jdbcTemplate;

    public EmployeeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Employee> findAll() {
        return jdbcTemplate.query("SELECT * FROM employee", new BeanPropertyRowMapper<>(Employee.class));
    }

    public int save(Employee employee) {
        return jdbcTemplate.update("INSERT INTO employee (name, department) VALUES (?, ?)",
                employee.getName(), employee.getDepartment());
    }

    public int update(Employee employee) {
        return jdbcTemplate.update("UPDATE employee SET name=?, department=? WHERE id=?",
                employee.getName(), employee.getDepartment(), employee.getId());
    }

    public int deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM employee WHERE id=?", id);
    }
}
