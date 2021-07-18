package com.lkty.shop.api.third.oss;


import com.lkty.shop.common.po.product.po.Category;
import com.lkty.shop.common.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * OSS 前端控制器
 * </p>
 *
 * @author Raven
 * @since 2021-07-16
 */
@Api(value = "OSS管理")
@RequestMapping("/third/oss")
public interface IThirdOssApi {

    @ApiOperation("获取OSS签名")
    @GetMapping("/policy")
    R fetchPolicy();
}
