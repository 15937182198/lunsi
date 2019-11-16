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

import io.renren.modules.sys.entity.JxenvironmentEntity;
import io.renren.modules.sys.service.JxenvironmentService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 高考集训页面环境展示
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:11
 */
@RestController
@RequestMapping("sys/jxenvironment")
public class JxenvironmentController {
    @Autowired
    private JxenvironmentService jxenvironmentService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:jxenvironment:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = jxenvironmentService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:jxenvironment:info")
    public R info(@PathVariable("id") Integer id){
        JxenvironmentEntity jxenvironment = jxenvironmentService.getById(id);

        return R.ok().put("jxenvironment", jxenvironment);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:jxenvironment:save")
    public R save(@RequestBody JxenvironmentEntity jxenvironment){
        jxenvironmentService.save(jxenvironment);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:jxenvironment:update")
    public R update(@RequestBody JxenvironmentEntity jxenvironment){
        ValidatorUtils.validateEntity(jxenvironment);
        jxenvironmentService.updateById(jxenvironment);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:jxenvironment:delete")
    public R delete(@RequestBody Integer[] ids){
        jxenvironmentService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
