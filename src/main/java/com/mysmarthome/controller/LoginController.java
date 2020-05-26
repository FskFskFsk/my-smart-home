package com.mysmarthome.controller;

import com.mysmarthome.dao.EmployeeDao;
import com.mysmarthome.entities.ActiveUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    ActiveUser activeUser;
    @Autowired
    EmployeeDao employeeDao;
    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){
        int activeUserId=employeeDao.getActiveUserId(username);
        String activeUserPassword=employeeDao.getActiveUserPassword(username);

        //System.out.println(activeUserId);
        //System.out.println(username+" "+password);
        //System.out.println(activeUserPassword);
        if(activeUserId>10){
            if(activeUserPassword.equals(password)){
                session.setAttribute("loginUser",username);
                activeUser.setId(activeUserId);

                return "redirect:/device.html";
            }else{
                map.put("msg","用户名密码错误");
                return  "login";
            }
        }else{
            if("admin".equals(username)&&activeUserPassword.equals(password)){

                session.setAttribute("loginUser",username);

                activeUser.setId(activeUserId);

                return "redirect:/main.html";
            }else{
                map.put("msg","用户名密码错误");
                return  "login";
            }
        }

    }
}
