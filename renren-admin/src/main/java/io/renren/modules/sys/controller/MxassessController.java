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

import io.renren.modules.sys.entity.MxassessEntity;
import io.renren.modules.sys.service.MxassessService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 学霸四大评估体系
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:09
 */
@RestController
@RequestMapping("sys/mxassess")
public class MxassessController {
    @Autowired
    private MxassessService mxassessService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:mxassess:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = mxassessService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:mxassess:info")
    public R info(@PathVariable("id") Integer id){
        MxassessEntity mxassess = mxassessService.getById(id);

        return R.ok().put("mxassess", mxassess);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:mxassess:save")
    public R save(@RequestBody MxassessEntity mxassess){
        mxassessService.save(mxassess);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:mxassess:update")
    public R update(@RequestBody MxassessEntity mxassess){
        ValidatorUtils.validateEntity(mxassess);
        mxassessService.updateById(mxassess);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:mxassess:delete")
    public R delete(@RequestBody Integer[] ids){
        mxassessService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
