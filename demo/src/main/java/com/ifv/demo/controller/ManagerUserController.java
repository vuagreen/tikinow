package com.ifv.demo.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ifv.demo.model.User;
import com.ifv.demo.service.ManagerUserService;

@RestController
@RequestMapping("/ManagerUesr")

public class ManagerUserController {
	
	@Autowired
	private ManagerUserService managerUserService;

	@PostMapping("")
	public Map<String, Object> create (@RequestBody User user){
		Map<String, Object> result = new HashMap<String, Object>();
		User u = managerUserService.Create(user);
		result.put("user", u);
		return result;
	};
	
	@GetMapping("/{id}")
	public Map<String, Object> select (@RequestParam  Long id){
		Map<String, Object> result = new HashMap<String, Object>();
		Optional<User> u = managerUserService.FindUserById(id);
		result.put("user", u);
		return result;
	};
	
	@PutMapping("")
	public Map<String, Object> edit (@RequestBody User user){
		Map<String, Object> result = new HashMap<String, Object>();
		User u = managerUserService.Create(user);
		result.put("user", u);
		return result;
	};
	
	@DeleteMapping("/{id}")
	public Map<String, Object> delete (@RequestParam Long id){
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			managerUserService.Delete(id);
			result.put("mesager", "Xóa người dùng thành công!");
		} catch (Exception e) {
			result.put("mesager", "Xóa người dùng thất bại!");
		}
		return result;
	};
}
