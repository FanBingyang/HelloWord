package service.impl;

import mapper.BaseDictMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.BaseDict;
import pojo.User;
import service.BaseDictService;

import java.util.List;

@Service
public class BaseDictServiceImpl implements BaseDictService {

    @Autowired
    private BaseDictMapper baseDictMapper;

    @Override
    public List<BaseDict> selectVetMajor() {
        return baseDictMapper.selectVetMajor();
    }

    @Override
    public List<BaseDict> selectPetKind() {
        return baseDictMapper.selectPetKind();
    }

    @Override
    public Boolean getUser(User user) {
        User u = baseDictMapper.getUser(user);
        if (u != null && u.getPassword().equals(user.getPassword()))
            return true;
        return false;
    }
}
