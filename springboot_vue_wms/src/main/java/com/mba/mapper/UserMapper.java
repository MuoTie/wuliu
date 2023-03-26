package com.mba.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mba.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author z
 * @since 2023-03-26
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    IPage<User> pageC(Page page);

    IPage pageCC(Page page, @Param(Constants.WRAPPER)Wrapper wrapper);
}
