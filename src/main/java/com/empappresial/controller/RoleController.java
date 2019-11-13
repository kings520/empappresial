package com.empappresial.controller;


import com.empappresial.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class RoleController {

    @Autowired
    private RoleService roleService;
    public RoleController() {
    }

    @GetMapping("/manageRole")
    public String loadAllRole(Model model){
        //Iterable<Role> all = roleService.getAllRole();
        model.addAttribute("role",roleService.findAll());
        return "admin/list_role";
    }
//    @GetMapping("/loadRoleForm")
//    public String loadRoleForm(Model model){
//        model.addAttribute("role", new Role());
//        return "admin/roleForm";
//    }
//    @PostMapping("/addRole")
//    public String addRolghhe(@ModelAttribute Role role, BindingResult result){
//        if(result.hasErrors()){
//            return "admin/roleForm";
//        }
//        roleService.save(role);
//        return "redirect:/admin/manageRole";
//    }
//    @GetMapping("/editRole/{id}")
//    public String editEmployee(@PathVariable Long id, Model model) {
//        model.addAttribute("role", roleService.findById(id));
//        return "/admin/manageRole";
//    }
//
//    @PostMapping("/updateRole/{id}")
//    public String updateEmployee(@PathVariable("id") long id, @Valid Role role, BindingResult result) {
//        if (result.hasErrors()) {
//            role.setId(id);
//            return "/admin/manageRole";
//        }
//        roleService.save(role);
//        return "redirect:/admin/manageRole";
//    }
}
