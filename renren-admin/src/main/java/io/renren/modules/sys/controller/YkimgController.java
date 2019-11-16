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

import io.renren.modules.sys.entity.YkimgEntity;
import io.renren.modules.sys.service.YkimgService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 论思高考为艺考生定制专属课程
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:21
 */
@RestController
@RequestMapping("sys/ykimg")
public class YkimgController {
    @Autowired
    private YkimgService ykimgService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:ykimg:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = ykimgService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:ykimg:info")
    public R info(@PathVariable("id") Integer id){
        YkimgEntity ykimg = ykimgService.getById(id);

        return R.ok().put("ykimg", ykimg);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:ykimg:save")
    public R save(@RequestBody YkimgEntity ykimg){
        ykimgService.save(ykimg);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:ykimg:update")
    public R update(@RequestBody YkimgEntity ykimg){
        ValidatorUtils.validateEntity(ykimg);
        ykimgService.updateById(ykimg);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:ykimg:delete")
    public R delete(@RequestBody Integer[] ids){
        ykimgService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
