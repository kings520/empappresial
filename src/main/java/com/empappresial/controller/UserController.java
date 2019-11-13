package com.empappresial.controller;


import com.empappresial.domain.Role;
import com.empappresial.domain.User;
import com.empappresial.service.RoleService;
import com.empappresial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("admin")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/listUsers")
    public String listUser(ModelMap modelMap){
        List<User> user = userService.findAll();
        modelMap.addAttribute("users",user);
        return "admin/listUser";
    }

    @GetMapping("/userForm")
    public String userForm(ModelMap modelMap){
        List<User> user = userService.findAll();
        List<Role> roles = roleService.findAll();

        modelMap.addAttribute("user",user);
        modelMap.addAttribute("role",roles);
        return "admin/addUser";
    }

    @PostMapping("/addUser")
    public String addEmployee(
            @RequestParam(value = "firstName") String firstName,
            @RequestParam(value = "surname") String surname,
            @RequestParam(value = "otherName") String otherName,
            @RequestParam(value = "phone") String phone,
            @RequestParam(value = "email") String email,
            @RequestParam(value = "salary") String salary,
            @RequestParam(value = "bank") String bank,
            @RequestParam(value = "accountName") String accountName,
            @RequestParam(value = "accountNumber") String accountNumber,
            @RequestParam(value = "username") String username,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "roleName") List<Role> roleName,
            @Valid User employee, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/addUser";
        }
        employee.setFirstName(firstName);
        employee.setSurname(surname);
        employee.setOtherName(otherName);
        employee.setPhone(phone);
        employee.setEmail(email);
        employee.setSalary(salary);
        employee.setBank(bank);
        employee.setAccountName(accountName);
        employee.setAccountNumber(accountNumber);
        employee.setUsername(username);
        employee.setPassword(password);
        employee.setRole(roleName);
        userService.createUser(employee);

        return "redirect:/admin/listUsers";
    }
}
