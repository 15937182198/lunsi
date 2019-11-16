package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.YkstudentreportDao;
import io.renren.modules.sys.entity.YkstudentreportEntity;
import io.renren.modules.sys.service.YkstudentreportService;


@Service("ykstudentreportService")
public class YkstudentreportServiceImpl extends ServiceImpl<YkstudentreportDao, YkstudentreportEntity> implements YkstudentreportService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<YkstudentreportEntity> page = this.page(
                new Query<YkstudentreportEntity>().getPage(params),
                new QueryWrapper<YkstudentreportEntity>()
        );

        return new PageUtils(page);
    }

}
