package top.bertz.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "email", nullable = false)
    private String email;
    private boolean isforbidden;
    private boolean isadmin;
    private String nickname;
    private int gender;
    private String phonenumber;
    private String receiptplace;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("user")
    private List<Carts> usercarts = new ArrayList<Carts>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("user")
    private List<Orders> userorders = new ArrayList<Orders>();


    User() {
    }

    public User(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getGenxder() {
        return gender;
    }

    public void setGenxder(int gender) {
        this.gender = gender;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getReceiptplace() {
        return receiptplace;
    }

    public void setReceiptplace(String receiptplace) {
        this.receiptplace = receiptplace;
    }

    public List<Carts> getUsercarts() {
        return usercarts;
    }

    public void setUsercarts(List<Carts> usercarts) {
        this.usercarts = usercarts;
    }

    public List<Orders> getUserorders() {
        return userorders;
    }

    public void setUserorders(List<Orders> userorders) {
        this.userorders = userorders;
    }

    public boolean getIsforbidden() {
        return isforbidden;
    }

    public void setIsforbidden(boolean isforbidden) {
        this.isforbidden = isforbidden;
    }

    public boolean isIsadmin() {
        return isadmin;
    }

    public void setIsadmin(boolean isadmin) {
        this.isadmin = isadmin;
    }

}
