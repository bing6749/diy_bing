package top.bing6749.diy_bing;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.jsonwebtoken.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.bing6749.controller.ArticleController;
import top.bing6749.domain.ArticleAndTag;
import top.bing6749.domain.Product;
import top.bing6749.entity.PageResult;
import top.bing6749.entity.QueryPageBean;
import top.bing6749.entity.Result;
import top.bing6749.service.ProductService;
import top.bing6749.utils.JSON2Data;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@SpringBootTest
class DiyBingApplicationTests {

    @Autowired
    DataSource dataSource;
    @Autowired
    ProductService productService;
    @Autowired
    ArticleController articleController;
    @Test
    void contextLoads() {
    }
//    测试数据库连接
    @Test
    void testDb() throws SQLException {
        System.out.println(dataSource.getConnection());
    }
//    添加商品json数据进入数据库
    @Test
    void json2Data() throws SQLException, IOException {
        List<Product> products = JSON2Data.productList2Data();
        for (Product product : products) {
            productService.save(product);
        }
    }
//    测试article和tag的多表联结
    @Test
    void testAricleTag(){
        Result articles = articleController.findArticles(1);
        System.out.println(articles.getData());
    }
    private String signature="admin";
    @Test
    public void jwt(){
        JwtBuilder builder = Jwts.builder();
        String compact = builder.setHeaderParam("type", "JWT")
                .setHeaderParam("alg", "HS256")
                .claim("username", "admin")
                .claim("role", "admin")
                .setSubject("admin-test")
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .setId(UUID.randomUUID().toString())
                .signWith(SignatureAlgorithm.HS256, signature)
                .compact();
        System.out.println(compact);
    }
    @Test
    public void parseJwt(){
        String token = "eyJ0eXBlIjoiSldUIiwiYWxnIjoiSFMyNTYifQ.eyJ1c2VybmFtZSI6ImFkbWluIiwicm9sZSI6ImFkbWluIiwic3ViIjoiYWRtaW4tdGVzdCIsImV4cCI6MTY1NTU0MjE5NiwianRpIjoiODIyYzI5ZWYtNWU5ZC00MzVmLTlmMjQtOGE1YzdiMDIzYjQ2In0.yIdMkK-lzSObEJvzlaG-_6gQ_29FH5Y55mZXyFrNn1Q";
        JwtParser jwtParser = Jwts.parser();
        Jws<Claims> claimsJws = jwtParser.setSigningKey(signature).parseClaimsJws(token);
        Claims body = claimsJws.getBody();
        System.out.println(body.get("username"));
        System.out.println(body.get("role"));
        System.out.println(body.getId());
    }
    @Test
    public void findAllArticleTest(){
        PageResult cpu = articleController.findAllArticle(new QueryPageBean(2, 2, ""));
        for (Object row : cpu.getRows()) {
            System.out.println(row.toString());
        }
    }
//    @Test
//    public void

}
