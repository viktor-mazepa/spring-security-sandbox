package com.mazasoft.springcourse.models;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    @NotEmpty(message = "User Name could not be null")
    @Size(min = 2, max = 100, message = "User Name should be greater than 2 characters and less than 100")
    private String userName;

    @Column(name = "year_of_birth")
    @NotNull
    @Min(value = 1900, message = "Year of birth should be greater than 1900")
    private int yearOfBirth;

    @Column(name = "password")
    @NotEmpty
    @Size(min = 2, max = 100, message = "Password should be greater than 4 characters")
    private String password;

    @Column(name = "role")
    private String role;

    public Person() {
    }

    public Person(String userName, int yearOfBirth, String role) {
        this.userName = userName;
        this.yearOfBirth = yearOfBirth;
        this.role=role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Person{" +
                "userName='" + userName + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", role='" + role + '\'' +
                '}';
    }
}
