package cn.wolfcode.mycat.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

import cn.wolfcode.mycat.domain.GoodsDO;

@Mapper
public interface GoodsRepository {

    @Insert("insert into goodsDO(goodsId, goodsName, goodsType) value (#{goodsId},#{goodsName},#{goodsType})")
    int insert(GoodsDO goodsDO);

    @Update("update goodsDO set goodsName = #{goodsName} where goodsId = #{goodsId} ")
    int update(GoodsDO goodsDO);

    @Select("select * from goodsDO")
    List<GoodsDO> selectAll();

    @Delete("delete from goodsDO")
    int deleteAll();

    @Delete("delete from goodsDO where goodsId = #{goodsId} ")
    int deleteByGoodsId(Long goodsId);

    List<GoodsDO> findAllByGoodsIdBetween(Long goodsId1, Long goodsId2);

    List<GoodsDO> findAllByGoodsIdIn(List<Long> goodsIds);
}
