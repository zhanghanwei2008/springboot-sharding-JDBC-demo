package cn.wolfcode.mycat.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import cn.wolfcode.mycat.domain.UserAddressDO;
import cn.wolfcode.mycat.domain.UsersDO;
import cn.wolfcode.mycat.mapper.UserAddressMapper;
import cn.wolfcode.mycat.service.UsersService;
import io.shardingsphere.core.keygen.KeyGenerator;

/**
 * @author hugx
 * @create 2019-04-28 17:32
 */

@RestController
public class UsersController {
    private static  final Logger log= LoggerFactory.getLogger(UsersController.class);

    @Autowired
    private UserAddressMapper userAddressMapper;

    @Autowired
    private UsersService usersService;

    @Autowired
    private KeyGenerator keyGenerator;

    @PutMapping("/users")
    public String createUsersDO(@RequestBody UsersDO usersDO){
        usersDO.setCreateTime(new Date());
        usersDO.setLastUpdate(new Date());
//        usersDO.setUserID((Long) keyGenerator.generateKey());
        usersService.insert(usersDO);

        log.info("createUsersDO() --> 创建对象成功 ");
        return "创建对象成功";

    }
    @GetMapping("/users/{id}")
    public  UsersDO getUsers(@PathVariable int id)
    {
       UsersDO users=null;

        users= usersService.getUsersByID(id);
        log.info("getUsersDO() --> 成功获取对象。 ");
        return users;

    }

//    @PostMapping("/users")
//    public String updateUsersDO(@RequestBody UsersDO usersDO){
////        HintManager hintManager = HintManager.getInstance();
////        hintManager.setMasterRouteOnly();
//        usersDO.setLastUpdate(new Date());
//        usersService.update(usersDO);
//        log.info("updateUsersDO() --> 修改对象成功 ");
//        return "修改对象成功";
//    }

    @PostMapping("/users")
    public List<UsersDO> updateUsersDO(@RequestBody UsersDO usersDO){
//        HintManager hintManager = HintManager.getInstance();
//        hintManager.setMasterRouteOnly();
        usersDO.setLastUpdate(new Date());
        List<UsersDO> result= usersService.updateTwo(usersDO);
        log.info("updateUsersDO() --> 修改对象成功 ");
        return result;
    }

    @GetMapping("/users")
    public List<UsersDO> findAll(){
//        HintManager hintManager = HintManager.getInstance();
//        hintManager.setMasterRouteOnly();
        List<UsersDO> result=usersService.findAll();
        log.info("findAll 查询成功 , 返回对象数量："+result.size());
//        test();
        return result;
    }

    @GetMapping("/users2")
    public List<UsersDO> findAllTwo(){
        List<UsersDO> result=usersService.findAllTwo();
        log.info("findAllTwo 查询成功 , 返回对象数量："+result.size());
        return result;
    }

    @RequestMapping(value = "/query",method = RequestMethod.GET)
    public List<UserAddressDO> queryAll(){
        List<UserAddressDO> result=userAddressMapper.queryJoin();
        log.info("queryJoin 查询成功 , 返回对象数量："+result.size());
        return result;
    }
}
