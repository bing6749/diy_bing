package top.bing6749.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.bing6749.domain.Tag;
import top.bing6749.service.TagService;
import top.bing6749.mapper.TagMapper;
import org.springframework.stereotype.Service;

/**
* @author MaRui
* @description 针对表【tag】的数据库操作Service实现
* @createDate 2022-06-13 16:15:48
*/
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag>
    implements TagService{

}




