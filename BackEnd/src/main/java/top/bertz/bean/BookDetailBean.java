package top.bertz.bean;

import java.util.ArrayList;
import java.util.Map;

public class BookDetailBean {

    private long id;
    public String booktitle="asd";
    public String bookfee="213";
    public String image="sad";
    public String description="qwe";
//    public ArrayList<Properties> properties;

    public BookDetailBean(String booktitle,String bookfee,String image,String description){
        id=1;
        this.bookfee=bookfee;
        this.booktitle=booktitle;
        this.image=image;
        this.description=description;
    }

    public long getId() {
        return id;
    }
    //    public void setPropertie(String name,String value){
//        this.properties.add(new Properties(name,value));
//    }

}

//class Properties{
//    public String name;
//    public String value;
//
//    public Properties(String name, String value){
//        this.name=name;
//        this.value=value;
//    }
//}