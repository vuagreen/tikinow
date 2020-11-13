/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifv.demo.service.impl;

import Dto.UserDto;
import com.ifv.demo.DAO.ManagerUserDAO;
import com.ifv.demo.service.ManagerUserService;

import java.time.LocalDate;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

import com.ifv.demo.model.User;
import com.ifv.demo.repository.UserRepository;

public class ManagerUserServiceImpl implements ManagerUserService{

	@Autowired
	private UserRepository userRepo;
    @Autowired
    private ManagerUserDAO managerUserDAO;
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

    @Override
    public Map<String, Object> GetAllUser(String username, String full_name, String address,
                                    String gender, LocalDate birth_date) {
        Map<String, Object> mapResult = new HashMap<>();
        try {
            List<UserDto> result = managerUserDAO.GetAllUser(username, full_name, address, gender, birth_date);
            mapResult.put("result", result);
            mapResult.put("status", true);
        }catch (Exception e){
            e.printStackTrace();
            mapResult.put("result", null);
            mapResult.put("status", false);
        }
        return mapResult;
    }
}
