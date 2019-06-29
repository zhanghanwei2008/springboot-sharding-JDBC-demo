package cn.wolfcode.mycat.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

import cn.wolfcode.mycat.domain.UsersDO;

/**
 * @author hgx61
 * @create 2019-04-28 17:27
 */

@Mapper
public interface UsersMapper {

    @Insert("insert into users(userID, userName, phoneNum, age, ddID,createTime,lastUpdate) value (#{userID},#{userName},#{phoneNum},#{age},#{ddID},#{createTime},#{lastUpdate})")
    int insert(UsersDO usersDO);

    @Update("update users set userName = #{userName} where userID = #{userID} ")
    int update(UsersDO usersDO);

    @Select("select * from users")
    List<UsersDO> findAll();
    @Select ("select  * from users where userID=#{userID}")
    UsersDO getUsersByID(int userID);
}
