package cn.wolfcode.mycat.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * @author hugx
 * @create 2019-05-06 20:47
 */

//@Entity
//@Table(name="goods")
//@Data
@Setter
@Getter
public class GoodsDO {
//    @Id
    private Long goodsId;

    private String goodsName;

    private Long goodsType;
}
