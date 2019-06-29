package cn.wolfcode.mycat.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import cn.wolfcode.mycat.domain.GoodsDO;
import cn.wolfcode.mycat.mapper.GoodsRepository;
import io.shardingsphere.core.keygen.KeyGenerator;


@RestController
public class GoodsController {

    @Autowired
    private KeyGenerator keyGenerator;

    @Autowired
    private GoodsRepository goodsRepository;

    @GetMapping("save")
    public String save(){
        for(int i= 1 ; i <= 40 ; i ++){
            GoodsDO goods = new GoodsDO();
            goods.setGoodsId((long) i);
            goods.setGoodsName( "shangpin" + i);
            goods.setGoodsType((long) (i+1));
            goodsRepository.insert(goods);
        }
        return "success";
    }

    @GetMapping("select")
    public String select(){
        return goodsRepository.selectAll().toString();
    }

    @GetMapping("delete")
    public void delete(){
//         goodsRepository.deleteAll();
        deleteById(1L);
    }

    public String deleteById(Long goodsId){
        goodsRepository.deleteByGoodsId(goodsId);
        return "删除  goodsId："+goodsId+"  成功";
    }

    @GetMapping("/query1")
    public Object query1(){
        return goodsRepository.findAllByGoodsIdBetween(10L, 30L);
    }

    @GetMapping("/query2")
    public Object query2(){
        List<Long> goodsIds = new ArrayList<>();
        goodsIds.add(10L);
        goodsIds.add(15L);
        goodsIds.add(20L);
        goodsIds.add(25L);
        return goodsRepository.findAllByGoodsIdIn(goodsIds);
    }
}
