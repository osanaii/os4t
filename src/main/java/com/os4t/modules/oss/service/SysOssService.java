package com.os4t.modules.oss.service;

import com.baomidou.mybatisplus.service.IService;
import com.os4t.common.utils.PageUtils;
import com.os4t.modules.oss.entity.SysOssEntity;

import java.util.Map;

/**
 * 文件上传
 *
 * @author  18256595192@163.com
 *
 */
public interface SysOssService extends IService<SysOssEntity> {

	PageUtils queryPage(Map<String, Object> params);
}
