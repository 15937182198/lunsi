package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.HeadDao;
import io.renren.modules.sys.entity.HeadEntity;
import io.renren.modules.sys.service.HeadService;


@Service("headService")
public class HeadServiceImpl extends ServiceImpl<HeadDao, HeadEntity> implements HeadService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<HeadEntity> page = this.page(
                new Query<HeadEntity>().getPage(params),
                new QueryWrapper<HeadEntity>()
        );

        return new PageUtils(page);
    }

}
