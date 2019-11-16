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

import io.renren.modules.sys.entity.MxsystemEntity;
import io.renren.modules.sys.service.MxsystemService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 学霸四大管理体系
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:09
 */
@RestController
@RequestMapping("sys/mxsystem")
public class MxsystemController {
    @Autowired
    private MxsystemService mxsystemService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:mxsystem:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = mxsystemService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:mxsystem:info")
    public R info(@PathVariable("id") Integer id){
        MxsystemEntity mxsystem = mxsystemService.getById(id);

        return R.ok().put("mxsystem", mxsystem);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:mxsystem:save")
    public R save(@RequestBody MxsystemEntity mxsystem){
        mxsystemService.save(mxsystem);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:mxsystem:update")
    public R update(@RequestBody MxsystemEntity mxsystem){
        ValidatorUtils.validateEntity(mxsystem);
        mxsystemService.updateById(mxsystem);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:mxsystem:delete")
    public R delete(@RequestBody Integer[] ids){
        mxsystemService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
