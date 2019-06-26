package com.example.demo.service.impl;

import com.example.demo.dao.TargetRepository;
import com.example.demo.entity.Address;
import com.example.demo.entity.Target;
import com.example.demo.service.ITargerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * Created by as on 2019/3/13.
 */
@Service
public class TargerServiceimpl implements ITargerService {

    @Autowired(required=false)
    TargetRepository targetRepository;

    @Override
    public Target findByTid(int id){
        return targetRepository.findById(id);
    }

    @Override
    public void deleteTarget(int id) {

         targetRepository.deleteById(id);
    }

    @Override
    public Target saveTarget(Target target) {
            String str ="张三";
            target =new Target();
            Address address =new Address();
            //   address.setAddress_id(1);
            address.setAname("李四");
            target.setTage(12);
            target.setTname(str);
            target.setAddress(address);

        return targetRepository.save(target);

    }

    @Override
    public void save() {

        Target target1 =new Target("李明",13,new Address("1113","旺旺"));
        Target target2 =new Target("李明",13,new Address("1113","旺旺"));
        Target target3 =new Target("李明",13,new Address("1113","旺旺"));
        targetRepository.saveAll(Arrays.asList(target1,target2,target3));

    }

    @Override
    public Target finByTname(String Tname) {
        return targetRepository.findByTname(Tname);
    }
}
