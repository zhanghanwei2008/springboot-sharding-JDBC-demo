package cn.wolfcode.mycat.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * @author hugx
 * @create 2019-04-28 9:45
 */
@Setter@Getter
public class StoreDO {

    private Long storeID;
    private String storeName;
    private String storeAddress;
    private Date createTime;
    private Date lastUpdate;



}
