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

import io.renren.modules.sys.entity.JxtrusteeshipEntity;
import io.renren.modules.sys.service.JxtrusteeshipService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 那些高考适合托管集训
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:21
 */
@RestController
@RequestMapping("sys/jxtrusteeship")
public class JxtrusteeshipController {
    @Autowired
    private JxtrusteeshipService jxtrusteeshipService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:jxtrusteeship:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = jxtrusteeshipService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:jxtrusteeship:info")
    public R info(@PathVariable("id") Integer id){
        JxtrusteeshipEntity jxtrusteeship = jxtrusteeshipService.getById(id);

        return R.ok().put("jxtrusteeship", jxtrusteeship);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:jxtrusteeship:save")
    public R save(@RequestBody JxtrusteeshipEntity jxtrusteeship){
        jxtrusteeshipService.save(jxtrusteeship);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:jxtrusteeship:update")
    public R update(@RequestBody JxtrusteeshipEntity jxtrusteeship){
        ValidatorUtils.validateEntity(jxtrusteeship);
        jxtrusteeshipService.updateById(jxtrusteeship);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:jxtrusteeship:delete")
    public R delete(@RequestBody Integer[] ids){
        jxtrusteeshipService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
