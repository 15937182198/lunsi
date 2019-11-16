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

import io.renren.modules.sys.entity.HomeslideshowEntity;
import io.renren.modules.sys.service.HomeslideshowService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 轮播图
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:09
 */
@RestController
@RequestMapping("sys/homeslideshow")
public class HomeslideshowController {
    @Autowired
    private HomeslideshowService homeslideshowService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:homeslideshow:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = homeslideshowService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:homeslideshow:info")
    public R info(@PathVariable("id") Integer id){
        HomeslideshowEntity homeslideshow = homeslideshowService.getById(id);

        return R.ok().put("homeslideshow", homeslideshow);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:homeslideshow:save")
    public R save(@RequestBody HomeslideshowEntity homeslideshow){
        homeslideshowService.save(homeslideshow);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:homeslideshow:update")
    public R update(@RequestBody HomeslideshowEntity homeslideshow){
        ValidatorUtils.validateEntity(homeslideshow);
        homeslideshowService.updateById(homeslideshow);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:homeslideshow:delete")
    public R delete(@RequestBody Integer[] ids){
        homeslideshowService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
