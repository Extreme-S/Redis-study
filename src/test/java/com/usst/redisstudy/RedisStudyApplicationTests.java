package com.usst.redisstudy;

import com.usst.redisstudy.model.UserDO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class RedisStudyApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 增
     */
    @Test
    void testStringSet() {
        //ValueOperations valueOperations = redisTemplate.opsForValue();
//        redisTemplate.opsForValue().set("name", "lyw yyds");

        stringRedisTemplate.opsForValue().set("user-service:user:1", "str lyw");
    }

    /**
     * 删
     */
    @Test
    void testStringDel() {
        stringRedisTemplate.delete("user-service:user:1");
    }

    /**
     * 改
     */
    @Test
    void testStringUpd() {
        stringRedisTemplate.opsForValue().set("user-service:user:1", "罗英伟 yyds");
    }

    /**
     * 查
     */
    @Test
    void testStringGet() {
        //ValueOperations valueOperations = redisTemplate.opsForValue();
//        String str1 = (String) redisTemplate.opsForValue().get("name");
//        System.out.println(str1);

        String str2 = stringRedisTemplate.opsForValue().get("user-service:user:1");
        System.out.println(str2);
    }

    /**
     * 序列化测试
     */
    @Test
    public void testSeria() {
        UserDO userDO = new UserDO();
        userDO.setId(1);
        userDO.setName("lyw yyds");
        userDO.setPwd("123456");

//        redisTemplate.opsForValue().set("user:1", userDO);
//        redisTemplate.opsForValue().set("user-service:user:3",userDO);

    }

}
