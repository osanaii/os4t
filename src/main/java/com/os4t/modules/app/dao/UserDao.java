package com.os4t.modules.app.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.os4t.modules.app.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户
 *
 * @author  18256595192@163.com
 *
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {

}
