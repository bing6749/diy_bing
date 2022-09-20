package top.bing6749.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.bing6749.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author MaRui
* @description 针对表【user】的数据库操作Mapper
* @createDate 2022-06-13 16:15:48
* @Entity top.bing6749.domain.User
*/

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {

}




