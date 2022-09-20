package top.bing6749.service;

import top.bing6749.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author MaRui
* @description 针对表【user】的数据库操作Service
* @createDate 2022-06-13 16:15:48
*/

public interface UserService extends IService<User> {


    User findUserByUserNameAndPassword(User user);
}
