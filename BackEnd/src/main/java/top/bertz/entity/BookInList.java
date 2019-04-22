package top.bertz.entity;

import java.sql.Timestamp;

public class BookInList {
    private Long id;
    private String booktitle;
    private double bookfee;
    private double discount;
    private int number;
    private int type;
    private Timestamp createtime;
    private Timestamp updatetime;

    public BookInList(){}


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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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
}
