package com.mysmarthome.controller;

import com.mysmarthome.dao.*;
import com.mysmarthome.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    @Autowired
    TemperatureDao temperatureDao;

    @Autowired
    HumidityDao humidityDao;

    @Autowired
    AirControlDao airControlDao;

    @Autowired
    DoorDao doorDao;

    @Autowired
    LightDao lightDao;


    //查询所有用户返回列表页面
    @GetMapping("/emps")
    public String  list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        System.out.println("所有用户:"+employees);
        //放在请求域中
        model.addAttribute("emps",employees);

        return "emp/list";
    }

    //来到用户添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model){

        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);

        return "emp/add";
    }

    //用户添加
    @PostMapping("/emp")
    public String addEmp(Employee employee){

        System.out.println("保存的员工信息："+employee);

        employeeDao.save(employee);

        temperatureDao.Init();
        humidityDao.Init();
        airControlDao.Init();
        doorDao.Init();
        lightDao.Init();




        return "redirect:/emps";
    }

    //来到修改页面，查出当前用户，在页面回显
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model){
        Employee employee = employeeDao.get(id);

        //System.out.println(employee);

        model.addAttribute("emp",employee);

        //页面要显示所有的职业列表
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        //回到修改页面(add是一个修改添加二合一的页面);
        return "emp/add";
    }

    //用户修改；需要提交用户id；
    @PutMapping("/emp")
    public String updateEmployee(Employee employee){
        System.out.println("修改的员工数据："+employee);

        System.out.println(employee);

        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //用户删除
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        airControlDao.delete(id);
        temperatureDao.delete(id);
        humidityDao.delete(id);
        doorDao.delete(id);
        lightDao.delete(id);

        return "redirect:/emps";
    }



}
