package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.*;

/**
 * Created by Lxl on 2019/3/20.
 */
@Entity
@Table(name = "role")
@JsonIgnoreProperties
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer roleId;
    private  String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> list =new LinkedHashSet<>();

    @JoinTable(name = "role_power" ,joinColumns = @JoinColumn(name = "roleId"),inverseJoinColumns =@JoinColumn(name = "id") )
    @ManyToMany(cascade =CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Power> powers =new ArrayList<>();


    //Role无参构造方法
    public Role(){
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Set<User> getList() {
        return list;
    }

    public void setList(Set<User> list) {
        this.list = list;
    }

    public List<Power> getPowers() {
        return powers;
    }

    public void setPowers(List<Power> powers) {
        this.powers = powers;
    }

    public Role(String name, Set<User> list, List<Power> powers) {
        this.name = name;
        this.list = list;
        this.powers = powers;
    }

    
}
