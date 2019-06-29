package cn.wolfcode.mycat.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

import cn.wolfcode.mycat.domain.StoreDO;

/**
 * @author hgx61
 * @create 2019-04-28 9:47
 */

@Mapper
public interface StoreMapper {

    @Insert("insert into store(storeID, storeName, storeAddress, createTime, lastUpdate) value (#{storeID},#{storeName},#{storeAddress},#{createTime},#{lastUpdate})")
    int insert(StoreDO storeDO);

    @Update("update store set storeName = #{storeName} where storeID = #{storeID} ")
    int update(StoreDO storeDO);

    @Select("select * from store")
    List<StoreDO> selectAll();
}
