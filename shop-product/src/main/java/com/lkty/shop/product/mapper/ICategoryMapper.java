package com.lkty.shop.product.mapper;

import com.lkty.shop.common.po.product.po.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 商品三级分类 Mapper 接口
 * </p>
 *
 * @author Raven
 * @since 2021-07-16
 */
@Mapper
public interface ICategoryMapper extends BaseMapper<Category> {

}
