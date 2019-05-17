package com.os4t.modules.sms.service;


import com.os4t.common.utils.Result;
import com.os4t.modules.sms.entity.Email;

public interface SmsService {
	 /**
	  * 纯文本
	  * @param mail
	  * @throws Exception  void
	  *
	  */
	 public void send(Email mail) throws Exception;
	 /**
	  * 富文本
	  * @param mail
	  * @throws Exception  void
	  *
	  */
	 public void sendHtml(Email mail) throws Exception;
	 /**
	  * 模版发送 freemarker
	  * @param mail
	  * @throws Exception  void
	  *
	  */
	 public void sendFreemarker(Email mail) throws Exception;
	 /**
	  * 模版发送 thymeleaf(弃用、需要配合模板)
	  * @param mail
	  * @throws Exception  void
	  *
	  */
	 public void sendThymeleaf(Email mail) throws Exception;
	 /**
	  * 队列
	  * @param mail
	  * @throws Exception  void
	  *
	  */
	 public void sendQueue(Email mail) throws Exception;
	 /**
	  * Redis 队列
	  * @param mail
	  * @throws Exception  void
	  *
	  */
	 public void sendRedisQueue(Email mail) throws Exception;
	 
	 
	 public Result listMail(Email mail);
}
