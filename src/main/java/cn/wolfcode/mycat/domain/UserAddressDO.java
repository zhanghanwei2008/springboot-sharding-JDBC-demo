package cn.wolfcode.mycat.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * @author hugx
 * @create 2019-04-28 17:23
 */

@Getter@Setter
public class UserAddressDO {
    /*'地址ID */
    private Long addressID;

    /*收货人 */
    private String receiver;

    /*地址详细 */
    private String addressDetail;

    /*用户ID */
    private Long userID;

    /*创建时间 */
    private Date createTime;

    /*最后更新时间 */
    private Date lastUpdate;
}
