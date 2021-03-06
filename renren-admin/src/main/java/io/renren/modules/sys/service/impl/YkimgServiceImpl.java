package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.YkimgDao;
import io.renren.modules.sys.entity.YkimgEntity;
import io.renren.modules.sys.service.YkimgService;


@Service("ykimgService")
public class YkimgServiceImpl extends ServiceImpl<YkimgDao, YkimgEntity> implements YkimgService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<YkimgEntity> page = this.page(
                new Query<YkimgEntity>().getPage(params),
                new QueryWrapper<YkimgEntity>()
        );

        return new PageUtils(page);
    }

}
