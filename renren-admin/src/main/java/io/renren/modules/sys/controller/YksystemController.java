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

import io.renren.modules.sys.entity.YksystemEntity;
import io.renren.modules.sys.service.YksystemService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 艺考生文化课集训高效管理体系
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:09
 */
@RestController
@RequestMapping("sys/yksystem")
public class YksystemController {
    @Autowired
    private YksystemService yksystemService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:yksystem:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = yksystemService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:yksystem:info")
    public R info(@PathVariable("id") Integer id){
        YksystemEntity yksystem = yksystemService.getById(id);

        return R.ok().put("yksystem", yksystem);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:yksystem:save")
    public R save(@RequestBody YksystemEntity yksystem){
        yksystemService.save(yksystem);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:yksystem:update")
    public R update(@RequestBody YksystemEntity yksystem){
        ValidatorUtils.validateEntity(yksystem);
        yksystemService.updateById(yksystem);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:yksystem:delete")
    public R delete(@RequestBody Integer[] ids){
        yksystemService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
