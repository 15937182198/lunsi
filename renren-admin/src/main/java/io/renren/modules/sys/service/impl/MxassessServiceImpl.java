package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.MxassessDao;
import io.renren.modules.sys.entity.MxassessEntity;
import io.renren.modules.sys.service.MxassessService;


@Service("mxassessService")
public class MxassessServiceImpl extends ServiceImpl<MxassessDao, MxassessEntity> implements MxassessService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MxassessEntity> page = this.page(
                new Query<MxassessEntity>().getPage(params),
                new QueryWrapper<MxassessEntity>()
        );

        return new PageUtils(page);
    }

}
