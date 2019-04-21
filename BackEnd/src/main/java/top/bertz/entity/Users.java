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


    public Users(String name,String password,String email){
        this.name=name;
        this.password=password;
        this.email=email;
    }

}
