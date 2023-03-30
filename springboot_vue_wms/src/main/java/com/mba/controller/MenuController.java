package com.mba.controller;


import com.mba.common.Result;
import com.mba.entity.Menu;

import com.mba.service.IMenuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author z
 * @since 2023-03-30
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Resource
    private  IMenuService menuService;

    @GetMapping("/list")
    public Result list(@RequestParam String roleId){
        List list = menuService.lambdaQuery().like(Menu::getMenuright, roleId).list();
        return Result.suc(list);
    }
}
