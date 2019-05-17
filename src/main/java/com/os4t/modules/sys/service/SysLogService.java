package com.os4t.modules.sys.service;


import com.baomidou.mybatisplus.service.IService;
import com.os4t.common.utils.PageUtils;
import com.os4t.modules.sys.entity.SysLogEntity;

import java.util.Map;


/**
 * 系统日志
 * 
 */
public interface SysLogService extends IService<SysLogEntity> {

    PageUtils queryPage(Map<String, Object> params);

}
