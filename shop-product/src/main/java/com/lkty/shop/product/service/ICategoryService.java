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
     * 保存品牌分类
     */
    Category saveCategory(Category category);

    /**
     * 批量删除品牌分类
     * @param ids 分类id
     */
    Boolean deleteCategoryByBatchIds(List<String> ids);

    /**
     * 更新品牌分类
     */
    Boolean updateCategory(Category category);

    /**
     * 获取品牌分类信息
     */
    Category fetchCategoryInfoById(String id);

    /**
     * 获取品牌三级分类列表树
     */
    List<Category> fetchCategoryListTrees();

}
