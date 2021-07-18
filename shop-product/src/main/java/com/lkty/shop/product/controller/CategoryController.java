package com.lkty.shop.product.controller;


import com.lkty.shop.api.product.ICategoryApi;
import com.lkty.shop.common.po.product.po.Category;
import com.lkty.shop.common.utils.R;
import com.lkty.shop.product.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;
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
     * 保存品牌分类
     */
    @Override
    public R saveCategory(@RequestBody Category category) {
        Category ct = this.categoryService.saveCategory(category);
        return R.ok().put(R.DATA_KEY, ct);
    }

    /**
     * 批量删除品牌分类
     * @param ids 分类id
     */
    @Override
    public R deleteCategoryByBatchIds(@RequestBody List<String> ids) {
        Boolean batchIds = this.categoryService.deleteCategoryByBatchIds(ids);
        return R.ok().put(R.DATA_KEY, batchIds);
    }

    @Override
    public R updateCategory(@RequestBody Category category) {
        Boolean isUpdate = this.categoryService.updateCategory(category);
        return R.ok().put(R.DATA_KEY, isUpdate);
    }

    @Override
    public R fetchCategoryInfoById(@PathVariable("id") String id) {
        Category category = this.categoryService.fetchCategoryInfoById(id);
        return R.ok().put(R.DATA_KEY, category);
    }

    /**
     * 获取品牌三级分类列表树
     */
    @Override
    public R fetchCategoryListTrees() {
        List<Category> categoryList = this.categoryService.fetchCategoryListTrees();
        return R.ok().put(R.DATA_KEY, categoryList);
    }

}
