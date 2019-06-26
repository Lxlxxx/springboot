package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Created by as on 2019/3/13.
 */
@Entity()
@Table(name = "target")
public class Target implements Serializable {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    @Column(name="tname",length = 20)
    private  String tname;
    @Column(name="tage",length = 20)
    private  int tage;
    @OneToOne(cascade = {CascadeType.ALL})
  //  @JoinColumn(name="address_id",referencedColumnName = "id")
    @JoinColumn(name = "address_id",referencedColumnName = "id")
    private Address address;

    public Target( String tname, int tage, Address address) {

        this.tname = tname;
        this.tage = tage;
        this.address = address;
    }

    public Target(String tname,int tage) {
        this.tage=tage;
        this.tname = tname;
    }


    public  Target(){
        super();

    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public int getTage() {
        return tage;
    }

    public void setTage(int tage) {
        this.tage = tage;
    }

    @Override
    public String toString() {
        return "Target{" +
                "tname='" + tname + '\'' +
                ", tage=" + tage +
                '}';
    }
}
