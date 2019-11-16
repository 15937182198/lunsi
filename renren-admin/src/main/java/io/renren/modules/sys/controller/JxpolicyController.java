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

import io.renren.modules.sys.entity.JxpolicyEntity;
import io.renren.modules.sys.service.JxpolicyService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 论思四必方针
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:11
 */
@RestController
@RequestMapping("sys/jxpolicy")
public class JxpolicyController {
    @Autowired
    private JxpolicyService jxpolicyService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:jxpolicy:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = jxpolicyService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:jxpolicy:info")
    public R info(@PathVariable("id") Integer id){
        JxpolicyEntity jxpolicy = jxpolicyService.getById(id);

        return R.ok().put("jxpolicy", jxpolicy);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:jxpolicy:save")
    public R save(@RequestBody JxpolicyEntity jxpolicy){
        jxpolicyService.save(jxpolicy);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:jxpolicy:update")
    public R update(@RequestBody JxpolicyEntity jxpolicy){
        ValidatorUtils.validateEntity(jxpolicy);
        jxpolicyService.updateById(jxpolicy);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:jxpolicy:delete")
    public R delete(@RequestBody Integer[] ids){
        jxpolicyService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
