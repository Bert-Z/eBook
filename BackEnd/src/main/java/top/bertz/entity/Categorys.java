package top.bertz.entity;

import javax.persistence.*;

@Entity
public class Categorys {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",nullable = false)
    private Integer id;
    private String category1;
    private String category2;

}
