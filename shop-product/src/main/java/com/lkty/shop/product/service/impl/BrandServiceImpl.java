package com.lkty.shop.product.service.impl;

import com.lkty.shop.common.po.product.po.Brand;
import com.lkty.shop.product.mapper.IBrandMapper;
import com.lkty.shop.product.service.IBrandService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
