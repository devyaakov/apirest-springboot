package com.example.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Employee;
import com.example.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
    EmployeeRepository employeeRepository;
    
    public ArrayList<Employee> getAll(){
        return (ArrayList<Employee>) employeeRepository.findAll();
    }

    public Employee create(Employee employee){
        return employeeRepository.save(employee);
    }

    public Optional<Employee> getById(int id){
        return employeeRepository.findById(id);
    }

    public boolean delete(int id) {
        try{
            employeeRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }	
}
