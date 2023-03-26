package com.mba.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class User {
    private Integer id;
    private String no;
    private String name;
    private String password;
    private Integer age;
    private Integer sex;
    private String phone;
    private Integer role_id;
    @TableField("isvalid")
    private String isValid;
}
