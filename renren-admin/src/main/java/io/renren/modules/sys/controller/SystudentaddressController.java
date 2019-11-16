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

import io.renren.modules.sys.entity.SystudentaddressEntity;
import io.renren.modules.sys.service.SystudentaddressService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 地址信息
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:12
 */
@RestController
@RequestMapping("sys/systudentaddress")
public class SystudentaddressController {
    @Autowired
    private SystudentaddressService systudentaddressService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:systudentaddress:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = systudentaddressService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:systudentaddress:info")
    public R info(@PathVariable("id") Integer id){
        SystudentaddressEntity systudentaddress = systudentaddressService.getById(id);

        return R.ok().put("systudentaddress", systudentaddress);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:systudentaddress:save")
    public R save(@RequestBody SystudentaddressEntity systudentaddress){
        systudentaddressService.save(systudentaddress);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:systudentaddress:update")
    public R update(@RequestBody SystudentaddressEntity systudentaddress){
        ValidatorUtils.validateEntity(systudentaddress);
        systudentaddressService.updateById(systudentaddress);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:systudentaddress:delete")
    public R delete(@RequestBody Integer[] ids){
        systudentaddressService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
