package com.li.controller;

import com.li.domain.User;
import com.li.services.IUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
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

    @RequestMapping("/testValidated")
    public String testValidated(@Validated User user, BindingResult result,Model model) {
        //获取错误信息
        if (result.hasErrors()) {
            List<ObjectError> allErrors = result.getAllErrors();

            //输出错误信息
            for (ObjectError allError : allErrors) {
                System.out.println(allError);
            }

            //将错误信息传到页面
            model.addAttribute("errors", allErrors);
            return "error";
        }

        return "success";
    }

    @RequestMapping("/testValid")
    public String testValid(@Valid User user, BindingResult result, Model model) {
        System.out.println(user);
        //获取错误信息
        if (result.hasErrors()) {
            List<ObjectError> allErrors = result.getAllErrors();

            //输出错误信息
            for (ObjectError allError : allErrors) {
                System.out.println(allError);
            }

            //将错误信息传到页面
            model.addAttribute("errors", allErrors);
            return "error";
        }

        return "success";
    }


    @RequestMapping("/testInterceptor1")
    public String testInterceptor1() {
        System.out.println("执行了testInterceptor1");
        return "success";
    }

    @RequestMapping("/testInterceptor2")
    public String testInterceptor2() {
        System.out.println("执行了testInterceptor2");
        return "success";
    }

}
