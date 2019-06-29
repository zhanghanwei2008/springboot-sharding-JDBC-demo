package cn.wolfcode.mycat.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import cn.wolfcode.mycat.domain.UsersDO;
import cn.wolfcode.mycat.mapper.UsersMapper;
import cn.wolfcode.mycat.sharding.annotation.GcpShardingHint;

/**
 * @author hugx
 * @create 2019-05-08 15:18
 */
@Service
public class UsersService {
    private static final Logger log= LoggerFactory.getLogger(UsersService.class);

    @Autowired
    private UsersMapper usersMapper;

    @Transactional
    public   int insert(UsersDO usersDO){
       int result= usersMapper.insert(usersDO);
       log.info("insert () of UsersService  result= "+result);
       return  result;
    }

    @Transactional
    public int update(UsersDO usersDO){
        int result= usersMapper.update(usersDO);
        log.info("update () of UsersService  result= "+result);
        return  result;
    }

    @GcpShardingHint
    public  List<UsersDO> findAll(){
        List<UsersDO> result= usersMapper.findAll();
        log.info("findAll () of UsersService  result= "+result.toString());
        return  result;
    }

    public  List<UsersDO> findAllTwo(){
        List<UsersDO> result= usersMapper.findAll();
        log.info("findAllTwo () of UsersService  result= "+result.toString());
        return  result;
    }

    @Transactional
    public List<UsersDO>  updateTwo(UsersDO usersDO){
        int flag= usersMapper.update(usersDO);
        log.info("updateTwo () of UsersService  flag= "+flag);

        List<UsersDO> result= usersMapper.findAll();
        log.info("updateTwo  call findAll () of UsersService  result= "+result.toString());
        return  result;
    }
    @Transactional
     public UsersDO getUsersByID(int id)
    {
        UsersDO users=usersMapper.getUsersByID(id);
        return  users;
    }

}
