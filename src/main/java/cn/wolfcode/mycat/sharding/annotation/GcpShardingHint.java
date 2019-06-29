package cn.wolfcode.mycat.sharding.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 强制主库路由注解
 *
 * @author hgx61
 * @create 2019-05-02 11:19
 */


@Retention(RetentionPolicy.RUNTIME)
@Target(value={ElementType.METHOD,ElementType.TYPE})
public @interface GcpShardingHint {
}
