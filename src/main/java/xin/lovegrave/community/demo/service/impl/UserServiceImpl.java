package xin.lovegrave.community.demo.service.impl;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import xin.lovegrave.community.demo.mapper.TUserMapper;
import xin.lovegrave.community.demo.pojo.TUser;
import xin.lovegrave.community.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TUserMapper userMapper;


    @Override
    @Cacheable(value = "users",key = "#id")
    public TUser findByUserId(Integer id){
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    @CachePut(value = "users",key = "#user.userId")
    public void save(TUser user) {
        userMapper.insert(user);
    }
}
