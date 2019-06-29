package cn.wolfcode.mycat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.shardingsphere.core.keygen.DefaultKeyGenerator;
import io.shardingsphere.core.keygen.KeyGenerator;

@SpringBootApplication
//@EnableApolloConfig
public class MycatApplication {

    public static void main(String[] args) {
        SpringApplication.run(MycatApplication.class, args);
    }

    @Bean
     public KeyGenerator keyGenerator(){
        return new DefaultKeyGenerator();
    }


}
