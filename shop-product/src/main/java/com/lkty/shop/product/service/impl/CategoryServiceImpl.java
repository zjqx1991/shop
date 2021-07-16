package com.lkty.shop.product.service.impl;

import com.lkty.shop.common.po.product.po.Category;
import com.lkty.shop.product.mapper.ICategoryMapper;
import com.lkty.shop.product.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品三级分类 服务实现类
 * </p>
 *
 * @author Raven
 * @since 2021-07-16
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<ICategoryMapper, Category> implements ICategoryService {

}
