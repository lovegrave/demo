package xin.lovegrave.community.demo.service;

import xin.lovegrave.community.demo.pojo.TUser;

public interface UserService {

    TUser findByUserId(Integer id);

    void save(TUser user);
}
