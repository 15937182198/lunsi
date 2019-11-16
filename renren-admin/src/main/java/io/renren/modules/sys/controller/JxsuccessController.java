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

import io.renren.modules.sys.entity.JxsuccessEntity;
import io.renren.modules.sys.service.JxsuccessService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 论思创新
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:21
 */
@RestController
@RequestMapping("sys/jxsuccess")
public class JxsuccessController {
    @Autowired
    private JxsuccessService jxsuccessService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:jxsuccess:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = jxsuccessService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:jxsuccess:info")
    public R info(@PathVariable("id") Integer id){
        JxsuccessEntity jxsuccess = jxsuccessService.getById(id);

        return R.ok().put("jxsuccess", jxsuccess);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:jxsuccess:save")
    public R save(@RequestBody JxsuccessEntity jxsuccess){
        jxsuccessService.save(jxsuccess);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:jxsuccess:update")
    public R update(@RequestBody JxsuccessEntity jxsuccess){
        ValidatorUtils.validateEntity(jxsuccess);
        jxsuccessService.updateById(jxsuccess);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:jxsuccess:delete")
    public R delete(@RequestBody Integer[] ids){
        jxsuccessService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
