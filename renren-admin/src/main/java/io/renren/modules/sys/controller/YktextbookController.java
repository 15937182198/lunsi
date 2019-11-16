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

import io.renren.modules.sys.entity.YktextbookEntity;
import io.renren.modules.sys.service.YktextbookService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 艺考文化课权威教材
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:21
 */
@RestController
@RequestMapping("sys/yktextbook")
public class YktextbookController {
    @Autowired
    private YktextbookService yktextbookService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:yktextbook:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = yktextbookService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:yktextbook:info")
    public R info(@PathVariable("id") Integer id){
        YktextbookEntity yktextbook = yktextbookService.getById(id);

        return R.ok().put("yktextbook", yktextbook);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:yktextbook:save")
    public R save(@RequestBody YktextbookEntity yktextbook){
        yktextbookService.save(yktextbook);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:yktextbook:update")
    public R update(@RequestBody YktextbookEntity yktextbook){
        ValidatorUtils.validateEntity(yktextbook);
        yktextbookService.updateById(yktextbook);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:yktextbook:delete")
    public R delete(@RequestBody Integer[] ids){
        yktextbookService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
