package top.bing6749.utils;
/*
 * @author  MaRui
 * @date  2022/6/13 15:28
 * @version 1.0
 */


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.ResourceUtils;
import top.bing6749.domain.Product;

import java.io.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author MaRui
 */
public class JSON2Data {
    private static String readerMethod(File file) throws IOException {
        FileReader fileReader = new FileReader(file);
        Reader reader = new InputStreamReader(new FileInputStream(file), "Utf-8");
        int ch = 0;
        StringBuffer sb = new StringBuffer();
        while ((ch = reader.read()) != -1) {
            sb.append((char) ch);
        }
        fileReader.close();
        reader.close();
        String jsonStr = sb.toString();
        System.out.println(jsonStr);
        return jsonStr;
    }
    public static List<Product> productList2Data() throws IOException {
        List<Product> products = new ArrayList<Product>();
        String productJsonList = readerMethod( ResourceUtils.getFile("classpath:productListGPU.json"));
        products = JSON.parseArray(productJsonList, Product.class);
        return products;
    }

    public static void main(String[] args) throws IOException {
        productList2Data();
    }

}
