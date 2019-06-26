package com.example.demo.service;

import com.example.demo.entity.RootDetails;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public interface IRootService {

    boolean export(List<Map<String,Object> >datalist , String colNames,
                   String mapkey, HttpServletRequest request,
                   HttpServletResponse response);

    void insertRootDetails();


//    RootDetails getRootDeatails(String name);
}
