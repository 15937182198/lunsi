package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.GycultureDao;
import io.renren.modules.sys.entity.GycultureEntity;
import io.renren.modules.sys.service.GycultureService;


@Service("gycultureService")
public class GycultureServiceImpl extends ServiceImpl<GycultureDao, GycultureEntity> implements GycultureService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GycultureEntity> page = this.page(
                new Query<GycultureEntity>().getPage(params),
                new QueryWrapper<GycultureEntity>()
        );

        return new PageUtils(page);
    }

}
