package com.jxw.heihei1.controller;

import com.jxw.heihei1.domian.User;
import com.jxw.heihei1.reposity.UserReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UserControl {
    @Autowired
    private UserReposity userReposity;

    /**
     * 查询所有用户
     * @param model
     * @return
     */
    @GetMapping   //不写就是直接映射users; 同时是get请求
    public ModelAndView list(Model model ){
        System.out.println("用户列表");
        model.addAttribute("userList",userReposity.findAll());
        model.addAttribute("title","用户管理");
        return new ModelAndView("users/list","userModel",model);
    }
    /**
     * 查看用户
     * @param id,model
     * @return
     */
    @GetMapping("{id}")        //不写就是直接映射users; 同时是get请求
    public ModelAndView view(@PathVariable("id") Long id , Model model){
        User user = userReposity.findOne(id);
        model.addAttribute("user",user);
        model.addAttribute("title","查看用户");
        return new ModelAndView("users/view","userModel",model);
    }
    /**
     * 获取创建用户的表单页面
     * @param model
     * @return
     */
    @RequestMapping("/tian")
    public ModelAndView createFrom( Model model){
        model.addAttribute("user",new User(null,null,null)); //使用带参的构造方法
        model.addAttribute("title","创建用户");
        return new ModelAndView("users/form","userModel",model);
    }
    @PostMapping
    public String saveOrUpdate(User user,Model model){
        user = userReposity.save(user);
        return "redirect:/users";
    }
    /**
     * 删除用户
     * @param id,model
     * @return
     */
    @GetMapping("/delete/{id}")        //不写就是直接映射users; 同时是get请求
    public String delete(@PathVariable("id") Long id , Model model){
        userReposity.delete(id);
        return "redirect:/users";
    }
    /**
     * 修改用户
     * @param id,model
     * @return
     */
    @GetMapping("/modify/{id}")        //不写就是直接映射users; 同时是get请求
    public ModelAndView modify(@PathVariable("id") Long id , Model model){

        User user = userReposity.findOne(id);
        model.addAttribute("user",user);
        model.addAttribute("title","修改用户");
        return new ModelAndView("users/form","userModel",model);
    }
}
