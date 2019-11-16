package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.HomeslideshowDao;
import io.renren.modules.sys.entity.HomeslideshowEntity;
import io.renren.modules.sys.service.HomeslideshowService;


@Service("homeslideshowService")
public class HomeslideshowServiceImpl extends ServiceImpl<HomeslideshowDao, HomeslideshowEntity> implements HomeslideshowService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<HomeslideshowEntity> page = this.page(
                new Query<HomeslideshowEntity>().getPage(params),
                new QueryWrapper<HomeslideshowEntity>()
        );

        return new PageUtils(page);
    }

}
