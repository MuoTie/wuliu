package com.mba.service.impl;

import com.mba.entity.Menu;
import com.mba.mapper.MenuMapper;
import com.mba.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author z
 * @since 2023-03-30
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

}
