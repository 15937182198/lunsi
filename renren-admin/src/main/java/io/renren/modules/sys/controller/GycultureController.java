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

import io.renren.modules.sys.entity.GycultureEntity;
import io.renren.modules.sys.service.GycultureService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 论思文化
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:12
 */
@RestController
@RequestMapping("sys/gyculture")
public class GycultureController {
    @Autowired
    private GycultureService gycultureService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:gyculture:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = gycultureService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:gyculture:info")
    public R info(@PathVariable("id") Integer id){
        GycultureEntity gyculture = gycultureService.getById(id);

        return R.ok().put("gyculture", gyculture);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:gyculture:save")
    public R save(@RequestBody GycultureEntity gyculture){
        gycultureService.save(gyculture);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:gyculture:update")
    public R update(@RequestBody GycultureEntity gyculture){
        ValidatorUtils.validateEntity(gyculture);
        gycultureService.updateById(gyculture);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:gyculture:delete")
    public R delete(@RequestBody Integer[] ids){
        gycultureService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
