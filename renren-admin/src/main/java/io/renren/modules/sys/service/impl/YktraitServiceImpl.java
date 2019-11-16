package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.YktraitDao;
import io.renren.modules.sys.entity.YktraitEntity;
import io.renren.modules.sys.service.YktraitService;


@Service("yktraitService")
public class YktraitServiceImpl extends ServiceImpl<YktraitDao, YktraitEntity> implements YktraitService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<YktraitEntity> page = this.page(
                new Query<YktraitEntity>().getPage(params),
                new QueryWrapper<YktraitEntity>()
        );

        return new PageUtils(page);
    }

}
