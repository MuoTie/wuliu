package com.mba.mapper;

import com.mba.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

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

}
