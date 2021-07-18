package com.lkty.shop.product.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lkty.shop.common.po.product.po.Brand;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 品牌 服务类
 * </p>
 *
 * @author Raven
 * @since 2021-07-16
 */
public interface IBrandService extends IService<Brand> {

    Boolean saveBrand(Brand brand);

    Boolean deleteBrandByBatchIds(List<String> ids);

    Boolean updateBrand(Brand brand);

    Brand fetchBrandInfoById(String id);

    Page<Brand> fetchBrandList(int page, int step);

}
