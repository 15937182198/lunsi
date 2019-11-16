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

import io.renren.modules.sys.entity.GymeaningEntity;
import io.renren.modules.sys.service.GymeaningService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 论思教学意义
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:11
 */
@RestController
@RequestMapping("sys/gymeaning")
public class GymeaningController {
    @Autowired
    private GymeaningService gymeaningService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:gymeaning:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = gymeaningService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:gymeaning:info")
    public R info(@PathVariable("id") Integer id){
        GymeaningEntity gymeaning = gymeaningService.getById(id);

        return R.ok().put("gymeaning", gymeaning);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:gymeaning:save")
    public R save(@RequestBody GymeaningEntity gymeaning){
        gymeaningService.save(gymeaning);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:gymeaning:update")
    public R update(@RequestBody GymeaningEntity gymeaning){
        ValidatorUtils.validateEntity(gymeaning);
        gymeaningService.updateById(gymeaning);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:gymeaning:delete")
    public R delete(@RequestBody Integer[] ids){
        gymeaningService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
