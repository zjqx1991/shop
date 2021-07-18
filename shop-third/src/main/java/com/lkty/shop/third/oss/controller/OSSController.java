package com.lkty.shop.third.oss.controller;


import com.lkty.shop.api.third.oss.IThirdOssApi;
import com.lkty.shop.common.utils.R;
import com.lkty.shop.third.oss.service.IOSSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class OSSController implements IThirdOssApi {

    @Autowired
    private IOSSService ossService;

    @Override
    public R fetchPolicy() {
        Map<String, String> map = ossService.fetchPolicy();
        return R.ok().put(R.DATA_KEY, map);
    }
}
