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

import io.renren.modules.sys.entity.HeadEntity;
import io.renren.modules.sys.service.HeadService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 论思页面头部信息
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:05
 */
@RestController
@RequestMapping("sys/head")
public class HeadController {
    @Autowired
    private HeadService headService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:head:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = headService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:head:info")
    public R info(@PathVariable("id") Integer id){
        HeadEntity head = headService.getById(id);

        return R.ok().put("head", head);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:head:save")
    public R save(@RequestBody HeadEntity head){
        headService.save(head);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:head:update")
    public R update(@RequestBody HeadEntity head){
        ValidatorUtils.validateEntity(head);
        headService.updateById(head);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:head:delete")
    public R delete(@RequestBody Integer[] ids){
        headService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
