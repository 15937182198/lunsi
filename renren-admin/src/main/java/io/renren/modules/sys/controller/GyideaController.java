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

import io.renren.modules.sys.entity.GyideaEntity;
import io.renren.modules.sys.service.GyideaService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 教学理念
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:21
 */
@RestController
@RequestMapping("sys/gyidea")
public class GyideaController {
    @Autowired
    private GyideaService gyideaService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:gyidea:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = gyideaService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:gyidea:info")
    public R info(@PathVariable("id") Integer id){
        GyideaEntity gyidea = gyideaService.getById(id);

        return R.ok().put("gyidea", gyidea);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:gyidea:save")
    public R save(@RequestBody GyideaEntity gyidea){
        gyideaService.save(gyidea);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:gyidea:update")
    public R update(@RequestBody GyideaEntity gyidea){
        ValidatorUtils.validateEntity(gyidea);
        gyideaService.updateById(gyidea);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:gyidea:delete")
    public R delete(@RequestBody Integer[] ids){
        gyideaService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
