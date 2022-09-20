package top.bing6749.controller;
/*
 * @author  MaRui
 * @date  2022/6/13 17:35
 * @version 1.0
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.bing6749.domain.CPUProductCountDistribution;
import top.bing6749.domain.GPUProducatCountDistribution;
import top.bing6749.domain.Product;
import top.bing6749.entity.MessageConstant;
import top.bing6749.entity.Result;
import top.bing6749.service.ProductService;

import java.util.List;

/**
 * @author MaRui
 */
//@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    public ProductService productService;

//    查找CPU商品列表
    @GetMapping("/findCPUProduct")
    public Result findCPUProduct(){
        List<Product> list = null;
        try {
            list = productService.findCPUProduct();
            return new Result(true, MessageConstant.QUERY_PRODUCT_SUCCESS,list);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_PRODUCT_FAIT);
        }
    }

//    查找GPU商品列表
    @GetMapping("/findGPUProduct")
    public Result findGPUProduct(){
        List<Product> list = null;
        try {
            list = productService.findGPUProduct();
            System.out.println(list);
            return new Result(true, MessageConstant.QUERY_PRODUCT_SUCCESS,list);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_PRODUCT_FAIT);
        }
    }
    @GetMapping("/findCPUProductCount")
    public Result findCPUProductCount(){
        CPUProductCountDistribution cpuProductCountDistribution = productService.findCPUProductCount();
        try {
            return new Result(true,MessageConstant.QUERY_CPUCOUNT_SUCCESS,cpuProductCountDistribution);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(false,MessageConstant.QUERY_CPUCOUNT_FAIT);

    }
    @GetMapping("/findGPUProductCount")
    public Result findGPUProductCount(){
        GPUProducatCountDistribution gpuProducatCountDistribution = productService.findGPUProductCount();
        try {
            return new Result(true,MessageConstant.QUERY_GPUCOUNT_SUCCESS,gpuProducatCountDistribution);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(false,MessageConstant.QUERY_GPUCOUNT_FAIT);

    }
}
