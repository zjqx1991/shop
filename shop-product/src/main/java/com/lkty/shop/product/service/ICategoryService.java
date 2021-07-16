package com.lkty.shop.product.service;

import com.lkty.shop.common.po.product.po.Category;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 商品三级分类 服务类
 * </p>
 *
 * @author Raven
 * @since 2021-07-16
 */
public interface ICategoryService extends IService<Category> {

    /**
     * 获取品牌三级分类列表树
     */
    List<Category> fetchCategoryListTrees();
}
