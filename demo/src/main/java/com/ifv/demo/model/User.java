package com.ifv.demo.model;

import Dto.UserDto;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@SuppressWarnings("serial")
@SqlResultSetMappings( {
		@SqlResultSetMapping (
				name="userManager",
				classes = {
						@ConstructorResult (
								targetClass = UserDto.class,
								columns = {
										@ColumnResult(name="id", type = long.class),
										@ColumnResult(name="username", type = String.class),
										@ColumnResult(name="full_name", type = String.class),
										@ColumnResult(name="address", type = String.class),
										@ColumnResult(name="gender", type = String.class),
										@ColumnResult(name="email", type = String.class),
										@ColumnResult(name="phone_number", type = String.class),
										@ColumnResult(name="birth_day", type = LocalDate.class),
								}
						)}
		),
} )

@Entity
@Data
public class User {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @Size(min = 6)
    private String username;

    @Column(nullable = false)
    @Size(min = 8)
    private String password;

    @Column(nullable = false)
    @Size(min = 10)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String idCard;

    private String address;

    @Column(unique = true, nullable = false)
    @Email
    private String email;

    private String gender;

    private LocalDate birthDay;

    private String avatar;

    @Pattern(regexp = "^(ROLE_USER|ROLE_ADMIN)$")
    private String role ;

    private String phoneNumber;

    private boolean confirmStatus = false;

	public User() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isConfirmStatus() {
		return confirmStatus;
	}

	public void setConfirmStatus(boolean confirmStatus) {
		this.confirmStatus = confirmStatus;
	}
    
    
}
