package io.renren.modules.sys.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import io.renren.common.utils.FilesUploadUtils;
import io.renren.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.sys.entity.SyintroEntity;
import io.renren.modules.sys.service.SyintroService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;


/**
 * 论思简介
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:09
 */
@RestController
@RequestMapping("sys/syintro")
public class SyintroController {
    @Autowired
    private SyintroService syintroService;

    @Resource
    private FilesUploadUtils filesUploadUtils;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:syintro:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = syintroService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{introid}")
    @RequiresPermissions("sys:syintro:info")
    public R info(@PathVariable("introid") Integer introid){
        SyintroEntity syintro = syintroService.getById(introid);

        return R.ok().put("syintro", syintro);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:syintro:save")
    public R save(@RequestBody SyintroEntity syintroEntity) throws IOException {
        System.out.println(syintroEntity);
        syintroEntity.setAddtime(new Date());
//        syintroEntity.setImgaddress(filesUploadUtils.upload(imgaddress).get(0));
        syintroService.save(syintroEntity);
        return R.ok();
    }

    /**
     * 上传图片
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("syIntroFileUpload")
    @RequiresPermissions("sys:syintro:save")
    public R syIntroFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        List<String> upload = filesUploadUtils.upload(file);
        return R.ok().put("imgaddress",upload.get(0));
    }

    @PostMapping("syIntroFileDelete")
    @RequiresPermissions("sys:syintro:delete")
    public R syIntroFileDelete(@RequestParam String imgaddress){
        System.out.println("开始删除图片");
        System.out.println(imgaddress);
        filesUploadUtils.deleteImg(imgaddress);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:syintro:update")
    public R update(@RequestBody SyintroEntity syintroEntity){
        ValidatorUtils.validateEntity(syintroEntity);
        System.out.println(syintroEntity);
        syintroEntity.setUpdatetime(new Date());
        syintroService.updateById1(syintroEntity);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:syintro:delete")
    public R delete(@RequestBody Integer[] introids){
        for (Integer introid : introids) {
            SyintroEntity byId = syintroService.getById(introid);
            System.out.println("删除");
            filesUploadUtils.deleteImg(byId.getImgaddress());
        }
        syintroService.removeByIds(Arrays.asList(introids));
        return R.ok();
    }

}
