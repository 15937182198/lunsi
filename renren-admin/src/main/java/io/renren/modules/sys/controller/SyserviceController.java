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

import io.renren.modules.sys.entity.SyserviceEntity;
import io.renren.modules.sys.service.SyserviceService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 高考一站式服务
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:12
 */
@RestController
@RequestMapping("sys/syservice")
public class SyserviceController {
    @Autowired
    private SyserviceService syserviceService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:syservice:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = syserviceService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{serviceid}")
    @RequiresPermissions("sys:syservice:info")
    public R info(@PathVariable("serviceid") Integer serviceid){
        SyserviceEntity syservice = syserviceService.getById(serviceid);

        return R.ok().put("syservice", syservice);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:syservice:save")
    public R save(@RequestBody SyserviceEntity syservice){
        syserviceService.save(syservice);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:syservice:update")
    public R update(@RequestBody SyserviceEntity syservice){
        ValidatorUtils.validateEntity(syservice);
        syserviceService.updateById(syservice);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:syservice:delete")
    public R delete(@RequestBody Integer[] serviceids){
        syserviceService.removeByIds(Arrays.asList(serviceids));

        return R.ok();
    }

}
