package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.MxsystemDao;
import io.renren.modules.sys.entity.MxsystemEntity;
import io.renren.modules.sys.service.MxsystemService;


@Service("mxsystemService")
public class MxsystemServiceImpl extends ServiceImpl<MxsystemDao, MxsystemEntity> implements MxsystemService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MxsystemEntity> page = this.page(
                new Query<MxsystemEntity>().getPage(params),
                new QueryWrapper<MxsystemEntity>()
        );

        return new PageUtils(page);
    }

}
