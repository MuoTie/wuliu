package com.mba.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mba.common.QueryPageParam;
import com.mba.entity.User;
import com.mba.service.IUserService;
import io.swagger.models.Swagger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author z
 * @since 2023-03-26
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @GetMapping("/list")
    public List<User> List(){
        return userService.list();
    }

    //新增
    @PostMapping("/save")
    public boolean save(@RequestBody User user){
        return userService.save(user);
    }
    //修改
    @PostMapping("/mod")
    public boolean mod(@RequestBody User user){
        return userService.updateById(user);
    }
    //新增或修改
    @PostMapping("/saveOrMod")
    public boolean saveOrMod(@RequestBody User user){
        return userService.saveOrUpdate(user);
    }
    //删除
    @GetMapping("/delete")
    public boolean delete(Integer id){
        return userService.removeById(id);
    }
    //查询
    @PostMapping("/listP")
    public List<User> listP(@RequestBody User user){
        LambdaQueryWrapper<User> lambdaQueryWrapper =new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(User::getName,user.getName());

        return userService.list(lambdaQueryWrapper);
    }

    @PostMapping("/listPage")
    public List<User> listPage(@RequestBody QueryPageParam query){

        HashMap param = query.getParam();
        String name = (String)param.get("name");


        Page page = new Page();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());

        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(User::getName,name);

        IPage result = userService.page(page, lambdaQueryWrapper);
        System.out.println("Total="+ result.getTotal());
        return result.getRecords();
    }

    @PostMapping("/listPageC")
    public List<User> listPageC(@RequestBody QueryPageParam query){

        HashMap param = query.getParam();
        String name = (String)param.get("name");

        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(User::getName,name);

        Page page = new Page();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());

//        IPage result = userService.pageC(page);
        IPage result = userService.pageCC(page,lambdaQueryWrapper);
        System.out.println("Total="+ result.getTotal());
        return result.getRecords();
    }
}
