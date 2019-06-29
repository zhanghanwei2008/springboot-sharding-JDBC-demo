package cn.wolfcode.mycat.sharding.strategy;

import java.util.Collection;

import cn.wolfcode.mycat.controller.StoreController;
import io.shardingsphere.api.algorithm.sharding.ListShardingValue;
import io.shardingsphere.api.algorithm.sharding.ShardingValue;
import io.shardingsphere.api.algorithm.sharding.hint.HintShardingAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
<!-- 强制路由分片策略-->
<bean id="demoUserHintStrategy" class="shard.strategy.DemoUserHintStrategy"/>
 <!-- 强制路由例子使用-->
 <sharding:hint-strategy id="shardingDemoUserHintStrategy" algorithm-ref="demoUserHintStrategy"/>
 DemoUserHintStrategy 的Java 如下，强制分片要实现HintShardingAlgorithm接口。 /**
 * DemoUserHint强制路由分片策略,其实可以共用，只是例子

 */
@Slf4j
public class DemoUserHintStrategy implements HintShardingAlgorithm {
    private static final Logger log= LoggerFactory.getLogger(DemoUserHintStrategy.class);
    public DemoUserHintStrategy() {
        log.info("DemoUserHintStrategy  初始化 ***************");
    }

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, ShardingValue shardingValue) {
        //availableTargetNames 这个参数是所有的dataSource的集合，shardingValue是HintManager传过来的分片信息
        log.info("DemoUserHintStrategy_availableTargetNames={}", availableTargetNames);
        log.info("DemoUserHintStrategy_shardingValue={}", shardingValue);
        ListShardingValue listShardingValue = (ListShardingValue) shardingValue;
        Collection shardingValueList = listShardingValue.getValues();
        //因为调用的时候分片是直接传的 DataSource的名称，所以直接返回就可以了，如果传其它值则要加业务逻辑进行分片筛选
        //返回结果只能是availableTargetNames 里边所包含的
        return shardingValueList;
    }



}
