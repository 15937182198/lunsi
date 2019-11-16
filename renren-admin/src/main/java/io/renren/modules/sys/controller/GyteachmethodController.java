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

import io.renren.modules.sys.entity.GyteachmethodEntity;
import io.renren.modules.sys.service.GyteachmethodService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 论思教学法
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:11
 */
@RestController
@RequestMapping("sys/gyteachmethod")
public class GyteachmethodController {
    @Autowired
    private GyteachmethodService gyteachmethodService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:gyteachmethod:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = gyteachmethodService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:gyteachmethod:info")
    public R info(@PathVariable("id") Integer id){
        GyteachmethodEntity gyteachmethod = gyteachmethodService.getById(id);

        return R.ok().put("gyteachmethod", gyteachmethod);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:gyteachmethod:save")
    public R save(@RequestBody GyteachmethodEntity gyteachmethod){
        gyteachmethodService.save(gyteachmethod);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:gyteachmethod:update")
    public R update(@RequestBody GyteachmethodEntity gyteachmethod){
        ValidatorUtils.validateEntity(gyteachmethod);
        gyteachmethodService.updateById(gyteachmethod);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:gyteachmethod:delete")
    public R delete(@RequestBody Integer[] ids){
        gyteachmethodService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
