package com.lkty.shop.api.product;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lkty.shop.common.po.product.po.Brand;
import com.lkty.shop.common.po.product.po.Category;
import com.lkty.shop.common.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 商品品牌 前端控制器
 * </p>
 *
 * @author Raven
 * @since 2021-07-16
 */
@Api(value = "品牌表管理")
@RequestMapping("/product/brand")
public interface IBrandApi {

    @ApiOperation("保存品牌")
    @PostMapping("/save")
    R saveBrand(@RequestBody Brand brand);


    @ApiOperation("批量删除品牌")
    @PostMapping("/delete")
    R deleteBrandByBatchIds(@RequestBody List<String> ids);

    @ApiOperation("更新品牌")
    @PostMapping("/update")
    R updateBrand(@RequestBody Brand brand);

    @ApiOperation("获取品牌分类信息")
    @GetMapping("/info/{id}")
    R fetchBrandInfoById(@PathVariable("id") String id);

    @ApiOperation("获取品牌")
    @GetMapping("/list")
    R fetchBrandList(@RequestParam(name = "page", defaultValue = "1") int page,
                     @RequestParam(name = "size", defaultValue = "10") int step);
}
