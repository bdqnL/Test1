package cn.bdqn.service;

import cn.bdqn.RpcQgTokenService;
import cn.bdqn.common.EmptyUtils;
import cn.bdqn.common.MD5;
import cn.bdqn.pojo.QgUser;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Token管理接口相关实现
 */
@Component
@Service(interfaceClass = RpcQgTokenService.class)
public class RpcQgTokenServiceImpl implements RpcQgTokenService {
    private String tokenPrefix = "token:";//统一添加token前缀标示
    /**
     * 生成Token的具体格式：用户的手机号MD5加密-用户的ID-当前时间
     * @param qgUser
     * @return
     */
    @Override
    public String generateToken(QgUser qgUser) {
        StringBuilder sb = new StringBuilder();
        sb.append(tokenPrefix);
        String phone = qgUser.getPhone();
        if (EmptyUtils.isEmpty(phone)) {
            phone = qgUser.getWxUserId();
        }
        sb.append(MD5.getMd5(phone,32));
        sb.append("-").append(qgUser.getId()).append("-");
        sb.append(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        return sb.toString();
    }
}
