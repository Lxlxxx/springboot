package com.example.demo.service.impl;

import com.example.demo.dao.UserRepository;
import com.example.demo.entity.User;
import com.example.demo.service.IUserServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lxl on 2019/4/8.
 */
@Service
public class UserServiceimpl  implements IUserServcie  {

    @Autowired
    UserRepository userRepository;

    @Override
    public void saveUser() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <100; i++) {
                    User user =new User();
                    user.setUsername("Lxlamin1"+i);
                    user.setEmail("529412341@qq.com");
                    user.setPwd("123456");
                    user.setDeptId("软件研发部");
                    user.setStationId("java工程师");

                    userRepository.save(user);
                }
            }
        }).start();

    }

    @Override
    public void deleteUser(int id) {

    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public List<User> selectUser() {
        return null;
    }

    @Override
    public Page<User> getUserPage(Integer page, Integer size,final  User user) {


        Pageable pageable =new PageRequest(page,size, Sort.Direction.ASC,"id");
        Page<User> userPage =userRepository.findAll(new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list =new ArrayList<Predicate>();
                if (null !=user.getUsername() && !"".equals(user.getUsername())) {
                    list.add(criteriaBuilder.equal(root.get("username").as(String.class), user.getUsername()));
                }
                if (null !=user.getEmail() && !"".equals(user.getEmail())){
                    list.add(criteriaBuilder.equal(root.get("email").as(String.class),user.getEmail()));
                }
                if (null !=user.getDeptId() && !"".equals(user.getDeptId())){
                    list.add(criteriaBuilder.equal(root.get("deptid").as(String.class),user.getDeptId()));
                }
                Predicate[] p = new Predicate[list.size()];

                return criteriaBuilder.and(list.toArray(p));


            }
        },pageable);

        return userPage;
    }
}
