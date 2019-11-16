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

import io.renren.modules.sys.entity.SyenvironmentEntity;
import io.renren.modules.sys.service.SyenvironmentService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 高考环境
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:12
 */
@RestController
@RequestMapping("sys/syenvironment")
public class SyenvironmentController {
    @Autowired
    private SyenvironmentService syenvironmentService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:syenvironment:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = syenvironmentService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:syenvironment:info")
    public R info(@PathVariable("id") Integer id){
        SyenvironmentEntity syenvironment = syenvironmentService.getById(id);

        return R.ok().put("syenvironment", syenvironment);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:syenvironment:save")
    public R save(@RequestBody SyenvironmentEntity syenvironment){
        syenvironmentService.save(syenvironment);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:syenvironment:update")
    public R update(@RequestBody SyenvironmentEntity syenvironment){
        ValidatorUtils.validateEntity(syenvironment);
        syenvironmentService.updateById(syenvironment);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:syenvironment:delete")
    public R delete(@RequestBody Integer[] ids){
        syenvironmentService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
