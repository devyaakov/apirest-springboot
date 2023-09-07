package com.example.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Employee;
import com.example.services.EmployeeService;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {
	@Autowired
    EmployeeService employeeService;

    @GetMapping()
    public ArrayList<Employee> obtenerUsuarios(){
        return employeeService.getAll();
    }

    @PostMapping()
    public Employee guardarUsuario(@RequestBody Employee usuario){
        return this.employeeService.create(usuario);
    }

    @GetMapping( path = "/{id}")
    public Optional<Employee> obtenerUsuarioPorId(@PathVariable("id") int id) {
        return this.employeeService.getById(id);
    }

    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") int id){
        boolean ok = this.employeeService.delete(id);
        if (ok){
            return "Se eliminó el usuario con id " + id;
        }else{
            return "No pudo eliminar el usuario con id" + id;
        }
    }
}
