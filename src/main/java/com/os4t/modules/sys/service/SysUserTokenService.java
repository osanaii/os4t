package com.os4t.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.os4t.common.utils.Result;
import com.os4t.modules.sys.entity.SysUserTokenEntity;

/**
 * 用户Token
 * 
 */
public interface SysUserTokenService extends IService<SysUserTokenEntity> {

	/**
	 * 生成token
	 * @param userId  用户ID
	 */
	Result createToken(long userId);

	/**
	 * 退出，修改token值
	 * @param userId  用户ID
	 */
	void logout(long userId);

}
