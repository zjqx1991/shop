package com.lkty.shop.product.service.impl;

import com.lkty.shop.common.code.LKTYCodeEnum;
import com.lkty.shop.common.exception.LKTYException;
import com.lkty.shop.common.po.product.po.Category;
import com.lkty.shop.common.utils.LKTYObjectUtils;
import com.lkty.shop.product.mapper.ICategoryMapper;
import com.lkty.shop.product.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 商品三级分类 服务实现类
 * </p>
 *
 * @author Raven
 * @since 2021-07-16
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<ICategoryMapper, Category> implements ICategoryService {


    /**
     * 保存品牌分类
     */
    @Override
    public Category saveCategory(Category category) {
        if (LKTYObjectUtils.isBlank(category) || !LKTYObjectUtils.isBlank(category.getId())) {
            throw new LKTYException(LKTYCodeEnum.PARAM_FAIL);
        }
        boolean save = this.save(category);
        if (!save) {
            throw new LKTYException(LKTYCodeEnum.PRODUCT_CATEGORY_SAVE_FAIL);
        }
        return category;
    }

    /**
     * 批量删除品牌分类
     *
     * @param ids 分类id
     */
    @Override
    public Boolean deleteCategoryByBatchIds(List<String> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            throw new LKTYException(LKTYCodeEnum.PARAM_FAIL);
        }
        return this.removeByIds(ids);
    }

    /**
     * 更新品牌分类
     */
    @Override
    public Boolean updateCategory(Category category) {
        if (LKTYObjectUtils.isBlank(category) || LKTYObjectUtils.isBlank(category.getId())) {
            throw new LKTYException(LKTYCodeEnum.PARAM_FAIL);
        }
        return this.updateById(category);
    }

    /**
     * 更新品牌分类
     */
    @Override
    public Category fetchCategoryInfoById(String id) {
        if (LKTYObjectUtils.isBlank(id)) {
            throw new LKTYException(LKTYCodeEnum.PARAM_FAIL);
        }
        return this.getById(id);
    }

    /**
     * 获取品牌三级分类列表树
     */
    @Override
    public List<Category> fetchCategoryListTrees() {
        // 1、查出所有分类
        List<Category> listAll = this.list();

        // 2、组装成父子的树形结构
        // 2.1、一级分类
        List<Category> menus = listAll.stream().filter(sub -> {
            return "0".equals(sub.getParentCid());
        }).map(sub -> {
            sub.setChildren(this.getCategory(sub, listAll));
            return sub;
        }).sorted((menu1, menu2) -> {
            return (LKTYObjectUtils.isBlank(menu1.getSort()) ? 0 : menu1.getSort()) - (LKTYObjectUtils.isBlank(menu2.getSort()) ? 0 : menu2.getSort());
        }).collect(Collectors.toList());
        return menus;
    }


    /**
     * @param root
     * @param list
     * @return
     */
    private List<Category> getCategory(Category root, List<Category> list) {
        List<Category> childrenList = list.stream().filter(item -> {
            return root.getId().equals(item.getParentCid());
        }).map(sub -> {
            sub.setChildren(getCategory(sub, list));
            return sub;
        }).sorted((menu1, menu2) -> {
            return (LKTYObjectUtils.isBlank(menu1.getSort()) ? 0 : menu1.getSort()) - (LKTYObjectUtils.isBlank(menu2.getSort()) ? 0 : menu2.getSort());
        }).collect(Collectors.toList());
        return childrenList;
    }
}
