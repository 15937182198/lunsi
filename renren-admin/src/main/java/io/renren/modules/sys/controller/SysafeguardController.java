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

import io.renren.modules.sys.entity.SysafeguardEntity;
import io.renren.modules.sys.service.SysafeguardService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 此表是八大保障
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:12
 */
@RestController
@RequestMapping("sys/sysafeguard")
public class SysafeguardController {
    @Autowired
    private SysafeguardService sysafeguardService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:sysafeguard:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysafeguardService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:sysafeguard:info")
    public R info(@PathVariable("id") Integer id){
        SysafeguardEntity sysafeguard = sysafeguardService.getById(id);

        return R.ok().put("sysafeguard", sysafeguard);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:sysafeguard:save")
    public R save(@RequestBody SysafeguardEntity sysafeguard){
        sysafeguardService.save(sysafeguard);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:sysafeguard:update")
    public R update(@RequestBody SysafeguardEntity sysafeguard){
        ValidatorUtils.validateEntity(sysafeguard);
        sysafeguardService.updateById(sysafeguard);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:sysafeguard:delete")
    public R delete(@RequestBody Integer[] ids){
        sysafeguardService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
