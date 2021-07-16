package com.lkty.shop.api.product;


import com.lkty.shop.common.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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


    @ApiOperation("获取品牌三级分类列表树")
    @GetMapping("/trees")
    R fetchCategoryListTrees();

}
