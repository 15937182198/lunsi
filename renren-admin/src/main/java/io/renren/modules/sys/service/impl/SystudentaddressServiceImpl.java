package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.SystudentaddressDao;
import io.renren.modules.sys.entity.SystudentaddressEntity;
import io.renren.modules.sys.service.SystudentaddressService;


@Service("systudentaddressService")
public class SystudentaddressServiceImpl extends ServiceImpl<SystudentaddressDao, SystudentaddressEntity> implements SystudentaddressService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SystudentaddressEntity> page = this.page(
                new Query<SystudentaddressEntity>().getPage(params),
                new QueryWrapper<SystudentaddressEntity>()
        );

        return new PageUtils(page);
    }

}
