package service.impl;

import mapper.IllMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Ill;
import service.IllService;

import java.util.List;

@Service
public class IllServiceImpl implements IllService {

    @Autowired
    private IllMapper illMapper;

    @Override
    public void insertIll(Ill ill) {
        illMapper.insertIll(ill);
    }

    @Override
    public List<Ill> selectIll(Ill ill) {
        return illMapper.selectIll(ill);
    }
}
