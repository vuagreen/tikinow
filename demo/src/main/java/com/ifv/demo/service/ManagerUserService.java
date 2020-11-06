/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifv.demo.service;
import java.util.Optional;

import com.ifv.demo.model.User;

public interface ManagerUserService {
    public User Create (User u);
    public User Edit (User u);
    public void Delete (Long id);
    public Optional<User> FindUserById(Long id);
}
