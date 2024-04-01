package com.example.nocash.model;

import javax.persistence.*;

@Entity
@TableGenerator(name = "tableGeneratorUser", table = "id_generator", pkColumnName = "entity",
        valueColumnName = "next_id", pkColumnValue = "User", allocationSize = 1)
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tableGeneratorUser")

    @Column(name = "id")
    int id;

    @Column(name = "username")
    String username;

    @Column(name = "password")
    String password; // encoded password

    @Column(name = "phone_number")
    String phoneNumber;

    @Column(name = "email")
    String email;

    @Column(name = "name")
    String name;

    @Column(name = "identify_code")
    String identifyCode;

    @Column(name = "date_of_birth")
    String dateOfBirth; // stored date as string

    @Column(name = "role")
    String role;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    User parent;

    @Column(name = "money")
    Double money;

    @Column(name = "enabled")
    Boolean enabled;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public User(String username, String password, String phoneNumber, String email, String name, String identifyCode, String dateOfBirth, String role) {
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.name = name;
        this.identifyCode = identifyCode;
        this.dateOfBirth = dateOfBirth;
        this.role = role;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean active) {
        this.enabled = active;
    }

    public User parent(){return parent;}

    public String getParent(){
        try {
            return parent.getName();
        } catch (Exception e) {
            return "";
        }
    }

    public int parentId() {
        try {
            return parent.getId();
        } catch (Exception e) {
            return 0;
        }
    }

    public void setParent(User parent) {
        this.parent = parent;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String password(){
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentifyCode() {
        return identifyCode;
    }

    public void setIdentifyCode(String identifyCode) {
        this.identifyCode = identifyCode;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
