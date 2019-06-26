package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by as on 2019/3/14.
 */
@Entity
@Table(name = "address")
public class Address implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    @Column(name = "phone",length = 20)
    private  String phone;
    @Column(name = "zipcode",length = 30)
    private String zipcode;
    @Column(name = "aname",length = 30)
    private String aname;

    @OneToOne(mappedBy = "address",cascade = CascadeType.ALL,optional=false)
    private  Target target;


    public Address(){
        super();
    }

    public Address(String phone, String aname) {
        this.aname=aname;
        this.phone = phone;
    }

    public Address(Integer id, String phone, String zipcode, String aname) {
        this.id = id;
        this.phone = phone;
        this.zipcode = zipcode;
        this.aname = aname;

    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", aname='" + aname + '\'' +
                '}';
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }


}
