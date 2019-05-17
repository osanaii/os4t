package com.os4t.modules.app.service;


import com.baomidou.mybatisplus.service.IService;
import com.os4t.modules.app.entity.UserEntity;
import com.os4t.modules.app.form.LoginForm;

/**
 * 用户
 *
 * @author  18256595192@163.com
 *
 */
public interface UserService extends IService<UserEntity> {

	UserEntity queryByMobile(String mobile);

	/**
	 * 用户登录
	 * @param form    登录表单
	 * @return        返回用户ID
	 */
	long login(LoginForm form);
}
