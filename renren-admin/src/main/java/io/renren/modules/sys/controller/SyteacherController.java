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

import io.renren.modules.sys.entity.SyteacherEntity;
import io.renren.modules.sys.service.SyteacherService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 高考团队老师
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:09
 */
@RestController
@RequestMapping("sys/syteacher")
public class SyteacherController {
    @Autowired
    private SyteacherService syteacherService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:syteacher:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = syteacherService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{teacherid}")
    @RequiresPermissions("sys:syteacher:info")
    public R info(@PathVariable("teacherid") Integer teacherid){
        SyteacherEntity syteacher = syteacherService.getById(teacherid);

        return R.ok().put("syteacher", syteacher);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:syteacher:save")
    public R save(@RequestBody SyteacherEntity syteacher){
        syteacherService.save(syteacher);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:syteacher:update")
    public R update(@RequestBody SyteacherEntity syteacher){
        ValidatorUtils.validateEntity(syteacher);
        syteacherService.updateById(syteacher);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:syteacher:delete")
    public R delete(@RequestBody Integer[] teacherids){
        syteacherService.removeByIds(Arrays.asList(teacherids));

        return R.ok();
    }

}
