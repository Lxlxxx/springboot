package com.example.demo.entity;

        import org.hibernate.annotations.GenericGenerator;

        import javax.persistence.*;
        import java.io.Serializable;


/**
 * 导出文件实体
 */

@Entity
public class RootDetails implements Serializable {

    /**
     * "姓名","年龄","性别","职业","薪水","职位"
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;  //主键id
    @Column(name = "Name" ,length = 32)
    private String Name ;   //姓名
    @Column(name = "Age",length = 2)
    private String Age;  //年龄
    @Column(name = "Sex",length = 2)
    private  String Sex;// 性别
    @Column(name = "Profession" ,length = 6)
    private String Profession;// 职业
    @Column(name = "Pay",length = 256)
    private int  Pay;//薪水
    @Column(name = "Zw",length = 8)


    private String Zw;//职位

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getProfession() {
        return Profession;
    }

    public void setProfession(String profession) {
        Profession = profession;
    }

    public int getPay() {
        return Pay;
    }

    public void setPay(int pay) {
        Pay = pay;
    }

    public String getZw() {
        return Zw;
    }

    public void setZw(String zw) {
        Zw = zw;
    }

    @Override
    public String toString() {
        return "RootDetails{" +
                "Id='" + Id + '\'' +
                ", Name='" + Name + '\'' +
                ", Age='" + Age + '\'' +
                ", Sex='" + Sex + '\'' +
                ", Profession='" + Profession + '\'' +
                ", Pay='" + Pay + '\'' +
                ", Zw='" + Zw + '\'' +
                '}';
    }
}

