package cn.wolfcode.mycat.domain;

import java.util.Date;


import lombok.Getter;
import lombok.Setter;

/**
 * @author hugx
 * @create 2019-04-28 17:19
 */

@Setter@Getter
public class UsersDO {
    /*用户ID */
    private Long userID;

    /*用户名 */
    private String userName;

    /*手机号码 */
    private String phoneNum;

    /*年龄 */
    private Integer age;

    /*所属会员类型 */
    private Integer ddID;

    /*注册时间 */
    private Date createTime;

    /*最后更新时间 */
    private Date lastUpdate;
}
