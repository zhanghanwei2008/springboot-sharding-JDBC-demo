package cn.wolfcode.mycat.sharding.search;

import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.PreciseShardingAlgorithm;

import java.util.Collection;

class UsersPreciseShardingAlgorithm implements PreciseShardingAlgorithm {
    public void UsersPreciseShardingAlgorithm() {
    }


    @Override
    public String doSharding(Collection collection, PreciseShardingValue preciseShardingValue) {
        return null;
    }
}
