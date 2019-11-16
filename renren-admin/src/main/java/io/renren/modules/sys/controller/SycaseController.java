package io.renren.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.sys.entity.SycaseEntity;
import io.renren.modules.sys.service.SycaseService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 论思案例
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:09
 */
@RestController
@RequestMapping("sys/sycase")
public class SycaseController {
    @Autowired
    private SycaseService sycaseService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:sycase:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sycaseService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{caseid}")
    @RequiresPermissions("sys:sycase:info")
    public R info(@PathVariable("caseid") Integer caseid){
        SycaseEntity sycase = sycaseService.getById(caseid);

        return R.ok().put("sycase", sycase);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:sycase:save")
    public R save(@RequestBody SycaseEntity sycase){
        sycaseService.save(sycase);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:sycase:update")
    public R update(@RequestBody SycaseEntity sycase){
        ValidatorUtils.validateEntity(sycase);
        sycaseService.updateById(sycase);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:sycase:delete")
    public R delete(@RequestBody Integer[] caseids){
        sycaseService.removeByIds(Arrays.asList(caseids));

        return R.ok();
    }

}
