package com.example.demov1;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;


class Employee
{
    private int id;
    private String name;


    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
}


@RestController
public class MainController
{
    private ArrayList<Employee> employees;

    public MainController()
    {
        this.employees = new ArrayList<>(
                Arrays.asList(
                        new Employee(101, "sample1"),
                        new Employee(102, "sample2"),
                        new Employee(103, "sample3")
                )
        );
    }


    @GetMapping("/hello") // hello?id=1
    public String hello(@RequestParam int id)
    {
        return "hello "+id;
    }

    // getAllEmployees /employees // java obj -> json
    @GetMapping("/employees")
    public ArrayList<Employee> getAllEmployees()
    {
        return employees;
    }

    // 1
    @PostMapping("/save") // /sve ?id = 101 & name = sample
    public Employee save(@RequestParam int id,@RequestParam String name)
    {
        Employee employee = new Employee(id,name);
        employees.add(employee);
        return employee;
    }

    @PostMapping("save1")
    public Employee save1(@RequestBody Employee employee)
    {
        employees.add(employee);
        return employee;
    }

    @PostMapping("/update/{id}")
    public Employee update( @PathVariable int id, @RequestBody Employee newEmployee)
    {
        Employee exEmployee = employees.stream()
                .filter( (f) ->  f.getId() == id) //-> prod.getId())
                .findFirst().get();

        exEmployee.setName(newEmployee.getName());

        return exEmployee;
    }


    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id)
    {
        Employee employee = employees.stream()
                .filter(f-> f.getId() == id)
                .findFirst()
                .get();

        employees.remove(employee);

        return "deleted successfully...";
    }

}