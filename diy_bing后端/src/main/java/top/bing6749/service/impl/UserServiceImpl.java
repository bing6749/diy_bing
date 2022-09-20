package top.bing6749.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import top.bing6749.domain.User;
import top.bing6749.service.UserService;
import top.bing6749.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author MaRui
* @description 针对表【user】的数据库操作Service实现
* @createDate 2022-06-13 16:15:48
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Autowired
    public UserMapper userMapper;


    @Override
    public User findUserByUserNameAndPassword(User user) {
        QueryWrapper<User> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("user_name",user.getUserName())
                          .eq("user_password",user.getUserPassword());
        return userMapper.selectOne(objectQueryWrapper);
    }
}




