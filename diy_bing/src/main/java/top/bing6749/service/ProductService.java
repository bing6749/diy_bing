package top.bing6749.service;

import top.bing6749.domain.CPUProductCountDistribution;
import top.bing6749.domain.GPUProducatCountDistribution;
import top.bing6749.domain.Product;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author MaRui
* @description 针对表【product】的数据库操作Service
* @createDate 2022-06-13 16:15:48
*/
public interface ProductService extends IService<Product> {
    public List<Product> findCPUProduct();

    public List<Product> findGPUProduct();

    CPUProductCountDistribution findCPUProductCount();

    GPUProducatCountDistribution findGPUProductCount();
}
