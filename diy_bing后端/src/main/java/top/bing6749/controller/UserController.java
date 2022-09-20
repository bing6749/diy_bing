package top.bing6749.controller;
/*
 * @author  MaRui
 * @date  2022/6/17 19:23
 * @version 1.0
 */


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.bing6749.domain.User;
import top.bing6749.entity.MessageConstant;
import top.bing6749.entity.Result;
import top.bing6749.service.UserService;
import top.bing6749.utils.SHA256Util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * @author MaRui
 */
@RestController
@RequestMapping("/user")
@Log4j2
public class UserController {
    @Autowired
    public UserService userService;

//    public HttpSession session;

    @PostMapping("/login")
    public Result login(@RequestBody(required=false) User user,
                        @CookieValue(value = "token", required = false) String token, HttpServletRequest request) {

        HttpSession session = request.getSession();
        System.out.println(token);
        //用户使用用户名密码登录
        if (user != null) {
            log.info("用户使用用户名密码登录");
            User user1 = userService.findUserByUserNameAndPassword(user);
            if (user1 != null) {
                String userHashId = SHA256Util.encryptPassword(user.getUserPassword(), user.getUserName());
                session.setAttribute("userHashId", userHashId);
                log.info(userHashId);
                return new Result(true, MessageConstant.USER_LOGIN_SUCCESS, userHashId);
            }
            return new Result(false, MessageConstant.USER_LOGIN_FAIT);
        }
        //用户使用userHashId登录
        else if (token != null) {
            log.info("用户使用userHashId登录");
            String userHashIdBack = (String) session.getAttribute("userHashId");
            log.info(userHashIdBack);
            log.info(token);
            if (userHashIdBack.equals(token)) {
                //前端传入的token和后端存入的userHashId相同
                return new Result(true, MessageConstant.USER_LOGIN_SUCCESS);
            }
        }
        return new Result(false, MessageConstant.USER_LOGIN_FAIT);

    }

}
