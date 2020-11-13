/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifv.demo.service;
import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;
import com.ifv.demo.model.User;

public interface ManagerUserService {
    public User Create (User u);
    public User Edit (User u);
    public void Delete (Long id);
    public Optional<User> FindUserById(Long id);
    public Map<String, Object> GetAllUser(String username, String full_name, String address, String gender, LocalDate birth_date);
}
