package io.renren.modules.sys.dao;

import io.renren.modules.sys.entity.SyintroEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import javax.annotation.Resource;

/**
 * 论思简介
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:09
 */
@Mapper
@Resource
public interface SyintroDao extends BaseMapper<SyintroEntity> {


    @Update("update tb_syintro set introContent=#{introcontent},imgAddress=#{imgaddress},updateTime=#{updatetime} where introId=#{introid}")
    public int updateById1(SyintroEntity syintroEntity);
}
