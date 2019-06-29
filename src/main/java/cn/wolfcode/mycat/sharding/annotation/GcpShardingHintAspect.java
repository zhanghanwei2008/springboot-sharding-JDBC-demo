package cn.wolfcode.mycat.sharding.annotation;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



import io.shardingsphere.api.HintManager;

/**
 * 强制主库路由注解 处理
 * @author hugx
 * @create 2019-05-08 16:14
 */
@Component
@Aspect
public class GcpShardingHintAspect {
    private static final Logger log= LoggerFactory.getLogger(GcpShardingHintAspect.class);

    @Pointcut(value = "@annotation(gcpShardingHint)")
    public void pointcut(GcpShardingHint gcpShardingHint) {
    }

    @Before("@annotation(cn.wolfcode.mycat.sharding.annotation.GcpShardingHint)")
    public void before(JoinPoint joinPoint) {
        HintManager hintManager = HintManager.getInstance();
        hintManager.setMasterRouteOnly();
        log.info("强制主库路由处理  --  注解式拦截 " );

    }




}
