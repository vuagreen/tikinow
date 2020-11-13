package com.ifv.demo.controller;

import com.ifv.demo.model.User;
import com.ifv.demo.service.ManagerUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/admin")
public class AdminAPI {

    @Autowired
    private ManagerUserService managerUserServices;

    @GetMapping("/")
    public String hello() {
        return "Hello Admin";
    }

    @PostMapping("/acount")
    public Map<String, Object> create (@RequestBody User user){
        Map<String, Object> result = new HashMap<String, Object>();
        User u = managerUserServices.Create(user);
        result.put("user", u);
        return result;
    };

    @GetMapping("/acount/id}")
    public Map<String, Object> select (@PathVariable("id")  Long id){
        Map<String, Object> result = new HashMap<String, Object>();
        Optional<User> u = managerUserServices.FindUserById(id);
        result.put("user", u);
        return result;
    };

    @GetMapping("/acount")
    public Map<String, Object> getAll (
            @RequestParam (required = false) String username,
            @RequestParam (required = false) String full_name,
            @RequestParam (required = false) String address,
            @RequestParam (required = false) String gender,
            @RequestParam (required = false) LocalDate birth_day
    ){

        return  managerUserServices.GetAllUser(username, full_name, address, gender, birth_day);
    };

    @PutMapping("/acount")
    public Map<String, Object> Edit (@RequestBody User user){
        Map<String, Object> result = new HashMap<String, Object>();
        User u = managerUserServices.Create(user);
        result.put("user", u);
        return result;
    };

    @DeleteMapping("/acount/{id}")
    public Map<String, Object> delete (@PathVariable("id") Long id){
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            managerUserServices.Delete(id);
            result.put("mesager", "Xóa người dùng thành công!");
        } catch (Exception e) {
            result.put("mesager", "Xóa người dùng thất bại!");
        }
        return result;
    };
}
