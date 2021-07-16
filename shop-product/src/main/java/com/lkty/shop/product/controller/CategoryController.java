package com.lkty.shop.product.controller;


import com.lkty.shop.api.product.ICategoryApi;
import com.lkty.shop.common.po.product.po.Category;
import com.lkty.shop.common.utils.R;
import com.lkty.shop.product.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 商品三级分类 前端控制器
 * </p>
 *
 * @author Raven
 * @since 2021-07-16
 */
@RestController
public class CategoryController implements ICategoryApi {

    @Autowired
    private ICategoryService categoryService;

    /**
     * 获取品牌三级分类列表树
     */
    @Override
    public R fetchCategoryListTrees() {
        List<Category> categoryList = this.categoryService.fetchCategoryListTrees();
        return R.ok().put(R.DATA_KEY, categoryList);
    }
}
