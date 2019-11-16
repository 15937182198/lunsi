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

import io.renren.modules.sys.entity.MxcaseEntity;
import io.renren.modules.sys.service.MxcaseService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 学霸逆袭案例
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:09
 */
@RestController
@RequestMapping("sys/mxcase")
public class MxcaseController {
    @Autowired
    private MxcaseService mxcaseService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:mxcase:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = mxcaseService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:mxcase:info")
    public R info(@PathVariable("id") Integer id){
        MxcaseEntity mxcase = mxcaseService.getById(id);

        return R.ok().put("mxcase", mxcase);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:mxcase:save")
    public R save(@RequestBody MxcaseEntity mxcase){
        mxcaseService.save(mxcase);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:mxcase:update")
    public R update(@RequestBody MxcaseEntity mxcase){
        ValidatorUtils.validateEntity(mxcase);
        mxcaseService.updateById(mxcase);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:mxcase:delete")
    public R delete(@RequestBody Integer[] ids){
        mxcaseService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
