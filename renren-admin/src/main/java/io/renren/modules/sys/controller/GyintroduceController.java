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

import io.renren.modules.sys.entity.GyintroduceEntity;
import io.renren.modules.sys.service.GyintroduceService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 论思介绍
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:12
 */
@RestController
@RequestMapping("sys/gyintroduce")
public class GyintroduceController {
    @Autowired
    private GyintroduceService gyintroduceService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:gyintroduce:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = gyintroduceService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:gyintroduce:info")
    public R info(@PathVariable("id") Integer id){
        GyintroduceEntity gyintroduce = gyintroduceService.getById(id);

        return R.ok().put("gyintroduce", gyintroduce);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:gyintroduce:save")
    public R save(@RequestBody GyintroduceEntity gyintroduce){
        gyintroduceService.save(gyintroduce);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:gyintroduce:update")
    public R update(@RequestBody GyintroduceEntity gyintroduce){
        ValidatorUtils.validateEntity(gyintroduce);
        gyintroduceService.updateById(gyintroduce);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:gyintroduce:delete")
    public R delete(@RequestBody Integer[] ids){
        gyintroduceService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
