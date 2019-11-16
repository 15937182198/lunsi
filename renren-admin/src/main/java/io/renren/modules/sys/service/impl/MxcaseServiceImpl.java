package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.MxcaseDao;
import io.renren.modules.sys.entity.MxcaseEntity;
import io.renren.modules.sys.service.MxcaseService;


@Service("mxcaseService")
public class MxcaseServiceImpl extends ServiceImpl<MxcaseDao, MxcaseEntity> implements MxcaseService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MxcaseEntity> page = this.page(
                new Query<MxcaseEntity>().getPage(params),
                new QueryWrapper<MxcaseEntity>()
        );

        return new PageUtils(page);
    }

}
