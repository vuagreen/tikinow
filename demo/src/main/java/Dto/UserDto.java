package Dto;

import java.time.LocalDate;

public class UserDto {
    private long id;
    private String username;
    private String full_name;
    private String address;
    private String gender;
    private String email;
    private String phone_number;
    private LocalDate birth_date;

    public UserDto() {
    }

    public UserDto(long id, String username, String full_name, String address, String gender, String email, String phone_number, LocalDate birth_date) {
        this.id = id;
        this.username = username;
        this.full_name = full_name;
        this.address = address;
        this.gender = gender;
        this.email = email;
        this.phone_number = phone_number;
        this.birth_date = birth_date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public LocalDate getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(LocalDate birth_date) {
        this.birth_date = birth_date;
    }
}
