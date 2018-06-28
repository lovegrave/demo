package xin.lovegrave.community.demo.cache.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;


/**
 * Redis封装类
 * Created by a on 2018/3/19.
 *
 * @author wy
 */
@Service
public class RedisServiceImpl {

    /**
     * 日志对象
     */
    protected Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    private JedisPool jedisPool;

    public void set(String key,String value){
        Jedis jedis = jedisPool.getResource();
        jedis.select(4);
        jedis.setex(key,10,value);
    }


}
