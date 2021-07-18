package com.lkty.shop.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lkty.shop.common.code.LKTYCodeEnum;
import com.lkty.shop.common.exception.LKTYException;
import com.lkty.shop.common.po.product.po.Brand;
import com.lkty.shop.common.utils.LKTYObjectUtils;
import com.lkty.shop.product.mapper.IBrandMapper;
import com.lkty.shop.product.service.IBrandService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.netflix.loadbalancer.RetryRule;
import freemarker.ext.servlet.IncludePage;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p>
 * 品牌 服务实现类
 * </p>
 *
 * @author Raven
 * @since 2021-07-16
 */
@Service
public class BrandServiceImpl extends ServiceImpl<IBrandMapper, Brand> implements IBrandService {

    @Override
    public Boolean saveBrand(Brand brand) {
        if (LKTYObjectUtils.isBlank(brand) || !LKTYObjectUtils.isBlank(brand.getId())) {
            throw new LKTYException(LKTYCodeEnum.PARAM_FAIL);
        }
        return this.save(brand);
    }

    @Override
    public Boolean deleteBrandByBatchIds(List<String> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            throw new LKTYException(LKTYCodeEnum.PARAM_FAIL);
        }
        return this.removeByIds(ids);
    }

    @Override
    public Boolean updateBrand(Brand brand) {
        if (LKTYObjectUtils.isBlank(brand) || LKTYObjectUtils.isBlank(brand.getId())) {
            throw new LKTYException(LKTYCodeEnum.PARAM_FAIL);
        }
        return this.updateById(brand);
    }

    @Override
    public Brand fetchBrandInfoById(String id) {
        if (LKTYObjectUtils.isBlank(id)) {
            throw new LKTYException(LKTYCodeEnum.PARAM_FAIL);
        }
        return this.getById(id);
    }

    @Override
    public Page<Brand> fetchBrandList(int page, int step) {
        if (page <= 0 || step <= 0) {
            throw new LKTYException(LKTYCodeEnum.PARAM_FAIL);
        }
        QueryWrapper<Brand> wrapper = new QueryWrapper<>();
        Page<Brand> brandPage = new Page<>(page, step);
        return this.page(brandPage, null);
    }
}
