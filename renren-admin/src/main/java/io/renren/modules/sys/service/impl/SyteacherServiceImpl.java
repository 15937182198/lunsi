package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.SyteacherDao;
import io.renren.modules.sys.entity.SyteacherEntity;
import io.renren.modules.sys.service.SyteacherService;


@Service("syteacherService")
public class SyteacherServiceImpl extends ServiceImpl<SyteacherDao, SyteacherEntity> implements SyteacherService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SyteacherEntity> page = this.page(
                new Query<SyteacherEntity>().getPage(params),
                new QueryWrapper<SyteacherEntity>()
        );

        return new PageUtils(page);
    }

}
