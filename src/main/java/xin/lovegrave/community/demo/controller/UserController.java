package xin.lovegrave.community.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.lovegrave.community.demo.cache.ehcache.EhCacheServiceImpl;
import xin.lovegrave.community.demo.cache.redis.RedisServiceImpl;
import xin.lovegrave.community.demo.pojo.TUser;
import xin.lovegrave.community.demo.service.UserService;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RedisServiceImpl redisService;
    @Autowired
    private EhCacheServiceImpl ehCacheService;

    @RequestMapping("/test")
    public TUser findUserById(Integer id){
        return userService.findByUserId(id);
    }

    @PostMapping("/save")
    public void save(@RequestBody TUser user){
       userService.save(user);
    }

    @RequestMapping("/ehSave")
    public void ehSave(){
        ehCacheService.save("users","huang","lei");
    }

    @RequestMapping("/get")
    public Object get(){
        return ehCacheService.getValue("users","huang");
    }

    @RequestMapping("/set")
    public void set(String key,String value){
        redisService.set(key,value);
    }

}
