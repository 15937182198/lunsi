package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.JxpolicyDao;
import io.renren.modules.sys.entity.JxpolicyEntity;
import io.renren.modules.sys.service.JxpolicyService;


@Service("jxpolicyService")
public class JxpolicyServiceImpl extends ServiceImpl<JxpolicyDao, JxpolicyEntity> implements JxpolicyService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<JxpolicyEntity> page = this.page(
                new Query<JxpolicyEntity>().getPage(params),
                new QueryWrapper<JxpolicyEntity>()
        );

        return new PageUtils(page);
    }

}
