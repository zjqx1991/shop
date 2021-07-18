package com.lkty.shop.api.product;


import com.lkty.shop.common.po.product.po.Category;
import com.lkty.shop.common.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 商品三级分类 前端控制器
 * </p>
 *
 * @author Raven
 * @since 2021-07-16
 */
@Api(value = "品牌分类表管理")
@RequestMapping("/product/category")
public interface ICategoryApi {


    @ApiOperation("保存品牌分类")
    @PostMapping("/save")
    R saveCategory(@RequestBody Category category);

    @ApiOperation("批量删除品牌分类")
    @PostMapping("/delete")
    R deleteCategoryByBatchIds(@RequestBody List<String> ids);

    @ApiOperation("更新品牌分类")
    @PostMapping("/update")
    R updateCategory(@RequestBody Category category);

    @ApiOperation("获取品牌分类信息")
    @GetMapping("/info/{id}")
    R fetchCategoryInfoById(@PathVariable("id") String id);


    @ApiOperation("获取品牌三级分类列表树")
    @GetMapping("/trees")
    R fetchCategoryListTrees();


}
