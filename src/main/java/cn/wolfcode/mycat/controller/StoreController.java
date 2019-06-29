package cn.wolfcode.mycat.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

import cn.wolfcode.mycat.domain.StoreDO;
import cn.wolfcode.mycat.mapper.StoreMapper;

/**
 * @author hugx
 * @create 2019-04-28 9:51
 */

@RestController
public class StoreController {
    private static final Logger  log= LoggerFactory.getLogger(StoreController.class);

    @Autowired
    private StoreMapper storeMapper;


   @PutMapping("/store")
    public String create(@RequestBody StoreDO storeDO) {
        storeDO.setCreateTime(new Date());
        storeDO.setLastUpdate(new Date());
        storeMapper.insert(storeDO);
        log.info("创建成功");
        return "创建成功";
    }

    @PostMapping("/store")
    public String save(@RequestBody StoreDO storeDO) {
        storeDO.setLastUpdate(new Date());
        storeMapper.update(storeDO);
        log.info("修改成功");
        return "修改成功";
    }

    @GetMapping("/store")
    public List<StoreDO> list() {
         List<StoreDO> result= storeMapper.selectAll();
         log.info("查询成功 , 返回对象数量："+result.size());
         return result;
    }
}
