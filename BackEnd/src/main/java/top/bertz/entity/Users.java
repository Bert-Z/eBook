package top.bertz.entity;

import javax.persistence.*;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",nullable = false)
    private Long id;
    @Column(name="name",nullable = false)
    private String name;
    @Column(name="password",nullable = false)
    private String password;
    @Column(name="email",nullable = false)
    private String email;
    private String nickname;
    private int genxder;
    private String phonenumber;
    private String receiptplace;


    Users(){}

    public Users(String name,String password,String email){
        this.name=name;
        this.password=password;
        this.email=email;
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
        return genxder;
    }

    public void setGenxder(int genxder) {
        this.genxder = genxder;
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
}
