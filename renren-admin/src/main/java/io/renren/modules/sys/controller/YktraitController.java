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

import io.renren.modules.sys.entity.YktraitEntity;
import io.renren.modules.sys.service.YktraitService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 只讲必考点,不讲无关知识
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:21
 */
@RestController
@RequestMapping("sys/yktrait")
public class YktraitController {
    @Autowired
    private YktraitService yktraitService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:yktrait:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = yktraitService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:yktrait:info")
    public R info(@PathVariable("id") Integer id){
        YktraitEntity yktrait = yktraitService.getById(id);

        return R.ok().put("yktrait", yktrait);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:yktrait:save")
    public R save(@RequestBody YktraitEntity yktrait){
        yktraitService.save(yktrait);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:yktrait:update")
    public R update(@RequestBody YktraitEntity yktrait){
        ValidatorUtils.validateEntity(yktrait);
        yktraitService.updateById(yktrait);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:yktrait:delete")
    public R delete(@RequestBody Integer[] ids){
        yktraitService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
