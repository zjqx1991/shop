package com.lkty.shop.product.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lkty.shop.api.product.IBrandApi;
import com.lkty.shop.common.po.product.po.Brand;
import com.lkty.shop.common.utils.R;
import com.lkty.shop.product.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 品牌 前端控制器
 * </p>
 *
 * @author Raven
 * @since 2021-07-16
 */
@RestController
public class BrandController implements IBrandApi {

    @Autowired
    private IBrandService brandService;

    @Override
    public R saveBrand(@RequestBody Brand brand) {
        Boolean save = this.brandService.saveBrand(brand);
        return R.ok().put(R.DATA_KEY, save);
    }

    @Override
    public R deleteBrandByBatchIds(@RequestBody List<String> ids) {
        Boolean delete = this.brandService.deleteBrandByBatchIds(ids);
        return R.ok().put(R.DATA_KEY, delete);
    }

    @Override
    public R updateBrand(@RequestBody Brand brand) {
        Boolean update = this.brandService.updateBrand(brand);
        return R.ok().put(R.DATA_KEY, update);
    }

    @Override
    public R fetchBrandInfoById(@PathVariable("id") String id) {
        Brand brand = this.brandService.fetchBrandInfoById(id);
        return R.ok().put(R.DATA_KEY, brand);
    }

    @Override
    public R fetchBrandList(@RequestParam(name = "page", defaultValue = "1") int page,
                            @RequestParam(name = "size", defaultValue = "10") int step) {
        Page<Brand> pageList = this.brandService.fetchBrandList(page, step);
        return R.ok().put(R.DATA_KEY, pageList);
    }
}
