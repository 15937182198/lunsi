package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.SyintroDao;
import io.renren.modules.sys.entity.SyintroEntity;
import io.renren.modules.sys.service.SyintroService;

import javax.annotation.Resource;


@Service("syintroService")
public class SyintroServiceImpl extends ServiceImpl<SyintroDao, SyintroEntity> implements SyintroService {

    @Resource
    private SyintroDao syintroDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SyintroEntity> page = this.page(
                new Query<SyintroEntity>().getPage(params),
                new QueryWrapper<SyintroEntity>()
        );

        return new PageUtils(page);
    }

    public boolean updateById1(SyintroEntity entity) {
        System.out.println("自定义修改方法执行");
        return syintroDao.updateById1(entity)!=0;
    }
}
