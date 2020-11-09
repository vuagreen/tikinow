package com.ifv.demo.controller;

import com.ifv.demo.model.User;
import com.ifv.demo.service.ManagerUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminAPI {

    @Autowired
    private ManagerUserService managerUserServ;

    @GetMapping("/")
    public String hello() {
        return "Hello Admin";
    }

    @PostMapping("/acount")
    public Map<String, Object> create (@RequestBody User user){
        Map<String, Object> result = new HashMap<String, Object>();
        User u = managerUserServ.Create(user);
        result.put("user", u);
        return result;
    };

    @GetMapping("/acount/id}")
    public Map<String, Object> select (@PathVariable("id")  Long id){
        Map<String, Object> result = new HashMap<String, Object>();
        Optional<User> u = managerUserServ.FindUserById(id);
        result.put("user", u);
        return result;
    };

    @PutMapping("/acount")
    public Map<String, Object> edit (@RequestBody User user){
        Map<String, Object> result = new HashMap<String, Object>();
        User u = managerUserServ.Create(user);
        result.put("user", u);
        return result;
    };

    @DeleteMapping("/acount/{id}")
    public Map<String, Object> delete (@PathVariable("id") Long id){
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            managerUserServ.Delete(id);
            result.put("mesager", "Xóa người dùng thành công!");
        } catch (Exception e) {
            result.put("mesager", "Xóa người dùng thất bại!");
        }
        return result;
    };
}
