package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.JxtrusteeshipDao;
import io.renren.modules.sys.entity.JxtrusteeshipEntity;
import io.renren.modules.sys.service.JxtrusteeshipService;


@Service("jxtrusteeshipService")
public class JxtrusteeshipServiceImpl extends ServiceImpl<JxtrusteeshipDao, JxtrusteeshipEntity> implements JxtrusteeshipService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<JxtrusteeshipEntity> page = this.page(
                new Query<JxtrusteeshipEntity>().getPage(params),
                new QueryWrapper<JxtrusteeshipEntity>()
        );

        return new PageUtils(page);
    }

}
