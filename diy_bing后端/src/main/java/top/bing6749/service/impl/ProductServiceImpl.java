package top.bing6749.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import top.bing6749.domain.CPUProductCountDistribution;
import top.bing6749.domain.GPUProducatCountDistribution;
import top.bing6749.domain.Product;
import top.bing6749.service.ProductService;
import top.bing6749.mapper.ProductMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author MaRui
* @description 针对表【product】的数据库操作Service实现
* @createDate 2022-06-13 16:15:48
*/
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product>
    implements ProductService{
    @Autowired
    private  ProductMapper productMapper;

    @Override
    public List<Product> findCPUProduct() {
        QueryWrapper<Product> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("brandId",21014).or().eq("brandId",23834);
        return productMapper.selectList(objectQueryWrapper);
    }

    @Override
    public List<Product> findGPUProduct() {
        QueryWrapper<Product> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("brandId",79649).or().eq("brandId",21103);
        return productMapper.selectList(objectQueryWrapper);
    }

    @Override
    public CPUProductCountDistribution findCPUProductCount() {
        //AMD
        QueryWrapper<Product> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("brandId",21014);
        Integer count = productMapper.selectCount(objectQueryWrapper);
        //intel
        QueryWrapper<Product> objectQueryWrapper1 = new QueryWrapper<>();
        objectQueryWrapper1.eq("brandId",23834);
        Integer count2 = productMapper.selectCount(objectQueryWrapper1);
        CPUProductCountDistribution cpuProductCountDistribution = new CPUProductCountDistribution();
        cpuProductCountDistribution.setIntel(count2);
        cpuProductCountDistribution.setAMD(count);

        return cpuProductCountDistribution;
    }

    @Override
    public GPUProducatCountDistribution findGPUProductCount() {
        //AMD
        QueryWrapper<Product> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("brandId",79649);
        Integer count = productMapper.selectCount(objectQueryWrapper);
        //intel
        QueryWrapper<Product> objectQueryWrapper1 = new QueryWrapper<>();
        objectQueryWrapper1.eq("brandId",21103);
        Integer count2 = productMapper.selectCount(objectQueryWrapper1);
        GPUProducatCountDistribution gpuProducatCountDistribution = new GPUProducatCountDistribution();
        gpuProducatCountDistribution.setAMD(count2);
        gpuProducatCountDistribution.setNvidia(count);
        return gpuProducatCountDistribution;
    }
}




