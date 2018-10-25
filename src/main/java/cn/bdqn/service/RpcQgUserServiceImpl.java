package cn.bdqn.service;

import cn.bdqn.RpcQgUserService;
import cn.bdqn.mapper.QgUserMapper;
import cn.bdqn.pojo.QgUser;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 用户管理相关业务实现
 */
@Component
@Service(interfaceClass = RpcQgUserService.class)
public class RpcQgUserServiceImpl implements RpcQgUserService {
    @Resource
    private QgUserMapper qgUserMapper;
    @Override
    public QgUser getQgUserById(String s) throws Exception {
        return null;
    }

    @Override
    public QgUser getQgUserByWxUserId(String s) throws Exception {
        return null;
    }

    @Override
    public QgUser findByPhone(String s) throws Exception {
        return qgUserMapper.findByPhone(s);
    }

    @Override
    public QgUser login(String phone, String password) throws Exception {
        //通过手机号查找用户
        QgUser user =  this.findByPhone(phone);
        //判断用户是否存在以及密码是否正确
        if(null!=user &&user.getPassword().equals(password)){
            return  user;
        }
        return null;
    }

    @Override
    public QgUser getCurrentUser(String s) throws Exception {
        return null;
    }

    @Override
    public Integer createQgUser(String s, String s1) throws Exception {
        return 1;
    }
}
