package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.YktextbookDao;
import io.renren.modules.sys.entity.YktextbookEntity;
import io.renren.modules.sys.service.YktextbookService;


@Service("yktextbookService")
public class YktextbookServiceImpl extends ServiceImpl<YktextbookDao, YktextbookEntity> implements YktextbookService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<YktextbookEntity> page = this.page(
                new Query<YktextbookEntity>().getPage(params),
                new QueryWrapper<YktextbookEntity>()
        );

        return new PageUtils(page);
    }

}
