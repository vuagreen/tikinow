/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifv.demo.service.impl;

import com.ifv.demo.service.ManagerUserService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ifv.demo.model.User;
import com.ifv.demo.repository.UserRepository;

public class ManagerUserServiceImpl implements ManagerUserService{

	@Autowired
	private UserRepository userRepo;
	
    @Override
    public User Edit(User u) {
    	User user = userRepo.save(u);
        return user;
    }

    @Override
    public void Delete(Long id) {
    	userRepo.deleteById(id);
    }

    @Override
    public User Create(User u) {
    	User user = userRepo.save(u);
        return user;
    }

	@Override
	public Optional<User> FindUserById(Long id) {
		Optional<User> user = userRepo.findById(id);
		return user;
	}
}
