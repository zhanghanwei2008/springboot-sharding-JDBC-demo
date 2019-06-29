package cn.wolfcode.mycat.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

import cn.wolfcode.mycat.domain.UserAddressDO;

/**
 * @author hgx61
 * @create 2019-04-28 17:27
 */
@Mapper
public interface UserAddressMapper {

    @Select("select * from user_address")
    List<UserAddressDO> findAll();

    @Select("select * from user_address ua INNER JOIN users us ON ua.userID = us.userID")
    List<UserAddressDO> queryJoin();
}
