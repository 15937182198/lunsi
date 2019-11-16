package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.YksystemDao;
import io.renren.modules.sys.entity.YksystemEntity;
import io.renren.modules.sys.service.YksystemService;


@Service("yksystemService")
public class YksystemServiceImpl extends ServiceImpl<YksystemDao, YksystemEntity> implements YksystemService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<YksystemEntity> page = this.page(
                new Query<YksystemEntity>().getPage(params),
                new QueryWrapper<YksystemEntity>()
        );

        return new PageUtils(page);
    }

}
