package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Lxl on 2019/3/20.
 */

@Entity
@Table(name = "user")
@JsonIgnoreProperties
public class User {

    // 主键id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    // 用户id
    @Column(name = "user_id", unique = true)
    private String userId;
    // 用户名称
    @Column(name = "username")
    private String username;
    // 用户密码
    @Column(name = "pwd", length = 100)
    private String pwd;

    private Boolean enable;
    // 移动电话
    @Column(name = "mobile_phone")
    private String mobilePhone;
    // 办公电话
    @Column(name = "office_phone")
    private String officePhone;
    // 邮箱
    @Column(name = "email")
    private String email;
    // 部门
    @Column(name = "deptId")
    private String deptId;
    // 工位
    @Column(name = "stationId")
    private String stationId;
    // 身份证号
    @Column(name = "certNumber")
    private String certNumber;
    @JoinTable(name ="user_role" ,joinColumns = @JoinColumn(name = "id"),inverseJoinColumns = @JoinColumn(name = "roleId"))
    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE},fetch =FetchType.EAGER)
    private Set<Role> roles =new LinkedHashSet<>();


     //User无参构造方法
    public User(){
        super();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getCertNumber() {
        return certNumber;
    }

    public void setCertNumber(String certNumber) {
        this.certNumber = certNumber;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
