package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.DAO.EmployeeRepository;
import com.luv2code.springboot.cruddemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {

        employeeRepository = theEmployeeRepository;
    }


    @Override
    public List<Employee> findAll() {

        return employeeRepository.findAll();
    }

    @Override
    public Employee findByID(int theId) {
        Optional<Employee>  result = employeeRepository.findById(theId);
       Employee theEmployee=null;
        if (result.isPresent()){
            theEmployee=result.get();
       }else {
            throw new RuntimeException("Did not find employee id -"+theId);
        }
        return theEmployee;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployeeById(int theId) {
        employeeRepository.deleteById(theId);

    }

}
