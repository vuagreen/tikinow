/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifv.demo.DAO;

import Dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.Query;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author admin
 */
public class ManagerUserDAO {
    @Autowired
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<UserDto> GetAllUser(String username, String full_name, String address, String gender, LocalDate birth_date) {
        StringBuilder sql = new StringBuilder();
        sql.append(" Select id, username, full_name, birth_date, address,gender, phone_number, email ");
        sql.append(" From tikinow tk ");
        sql.append(" Where 1=1 ");
        if(username != null){
            sql.append("    AND     LOWER(tk.username) like :username ");
        }
        if(full_name != null){
            sql.append("    AND     LOWER(tk.full_name) like :full_name ");
        }
        if(address != null){
            sql.append("    AND     LOWER(k.address) like :address ");
        }
        if(gender != null){
            sql.append("    AND     LOWER(tk.gender) like :gender ");
        }
        if(birth_date != null){
            sql.append("    AND tk.birth_date = :birth_date ");
        }
        Query query = entityManager.createNativeQuery(sql.toString(), "userManager");

        if (username != null) {
            query.setParameter("username", "%" + username.toLowerCase() + "%");
        }
        if (full_name != null) {
            query.setParameter("full_name", "%" + full_name.toLowerCase() + "%");
        }
        if (address != null) {
            query.setParameter("address", "%" + address.toLowerCase() + "%");
        }
        if (gender != null) {
            query.setParameter("gender", "%" + gender.toLowerCase() + "%");
        }
        if (gender != null) {
            query.setParameter("birth_date", birth_date);
        }
        return query.getResultList();
    }
}
