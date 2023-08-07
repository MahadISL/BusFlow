package com.project.BusFlow.model;


import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Entity
@Table(name = "User_table")
public class User {

    @Id
    @SequenceGenerator(name = "seqGen", initialValue = 20001, allocationSize = 1, sequenceName = "seqGen")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGen")
    @Column(name = "Id", unique = true)
    private long id;

    @Column(name = "Name")
    private String name;

    @Column(unique = true, name = "Email")
    private String email;

    @Column(name = "Password")
    private String password;

    @Column(name = "Age")
    private int age;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Token> tokenList;


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}
