package top.bertz.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TestSequence")
    //@GeneratedValue(strategy=GenerationType.IDENTITY) // MYSQL时可以这样使用自增
    @SequenceGenerator(name = "TestSequence", sequenceName = "SEQ_Test", allocationSize=-700)
    @Column(name = "id", nullable = false)
    private Long id;
    private String booktitle;
    private double bookfee;
    private double discount;
    private int number;
    private String description;
    private String auther;
    private String image;

    @CreatedDate
    private Timestamp createtime;

    @LastModifiedDate
    private Timestamp updatetime;

    @ManyToMany(mappedBy = "books")
    @JsonIgnoreProperties("books")
    private Set<Carts> carts = new HashSet<Carts>();

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "category_id")
    @JsonIgnoreProperties("books")
    private Category category;

//    @ManyToMany(mappedBy = "books")
//    @JsonIgnoreProperties("books")
//            private Orders O
    Book() {
    }


    public Book(String booktitle, double bookfee, String description) {
        this.booktitle = booktitle;
        this.bookfee = bookfee;
        this.description = description;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public double getBookfee() {
        return bookfee;
    }

    public void setBookfee(double bookfee) {
        this.bookfee = bookfee;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public Timestamp getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Timestamp updatetime) {
        this.updatetime = updatetime;
    }

    public Set<Carts> getCarts() {
        return carts;
    }

    public void setCarts(Set<Carts> carts) {
        this.carts = carts;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getAuther() {
        return auther;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
