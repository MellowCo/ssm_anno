package com.li.controller;

import com.li.domain.User;
import com.li.services.IUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @Program: ssm_anno
 * @ClassName: UserController
 * @Description:
 * @Author: li
 * @Create: 2019-08-06 15:36
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserServices services;

    //添加user
    @RequestMapping("/add")
    public String add(User user, Model model) {
        services.insertUser(user);

        List<User> all = services.findAll();
        model.addAttribute("list", all);

        return "success";
    }

    @RequestMapping("/fileUpload")
    public String upload(HttpServletRequest request,String name,MultipartFile file) throws IOException {
        String path = request.getSession().getServletContext().getRealPath("/upload");
        System.out.println(name);

        String filename = file.getOriginalFilename();
        filename = UUID.randomUUID().toString().replaceAll("-", "") + "_" + filename;

        file.transferTo(new File(path, filename));


        // return new ModelAndView("success", "msg", "文件上传成功");

        return "success";

    }

}
