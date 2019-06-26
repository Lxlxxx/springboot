package com.example.demo.service.impl;

import com.example.demo.dao.AddressRepository;
import com.example.demo.entity.Address;
import com.example.demo.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by as on 2019/3/14.
 */
@Service
public class AddressServiceimpl implements IAddressService {

    @Autowired(required=true)
    private AddressRepository addressRepository;

    @Override
    public Address saveAddress(Address address) {

        address =new Address();
        address.setAname("李明");
        address.setPhone("112233");
        address.setZipcode("529412341@qq.com");

        return  addressRepository.save(address);
    }


}
