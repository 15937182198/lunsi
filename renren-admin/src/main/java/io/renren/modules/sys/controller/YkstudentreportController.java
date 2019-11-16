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

import io.renren.modules.sys.entity.YkstudentreportEntity;
import io.renren.modules.sys.service.YkstudentreportService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * ,艺考生高考成绩展示
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:09
 */
@RestController
@RequestMapping("sys/ykstudentreport")
public class YkstudentreportController {
    @Autowired
    private YkstudentreportService ykstudentreportService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:ykstudentreport:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = ykstudentreportService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:ykstudentreport:info")
    public R info(@PathVariable("id") Integer id){
        YkstudentreportEntity ykstudentreport = ykstudentreportService.getById(id);

        return R.ok().put("ykstudentreport", ykstudentreport);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:ykstudentreport:save")
    public R save(@RequestBody YkstudentreportEntity ykstudentreport){
        ykstudentreportService.save(ykstudentreport);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:ykstudentreport:update")
    public R update(@RequestBody YkstudentreportEntity ykstudentreport){
        ValidatorUtils.validateEntity(ykstudentreport);
        ykstudentreportService.updateById(ykstudentreport);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:ykstudentreport:delete")
    public R delete(@RequestBody Integer[] ids){
        ykstudentreportService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
