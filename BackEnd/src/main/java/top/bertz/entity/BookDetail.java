package top.bertz.entity;


import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
public class BookDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",nullable = false)
    private Long id;
    private String booktitle;
    private double bookfee;
    private double discount;
    private int number;
    private int type;
    private String description;


    public BookDetail(String booktitle, double bookfee, String description) {
        this.booktitle = booktitle;
        this.bookfee = bookfee;
        this.description = description;
    }



}
