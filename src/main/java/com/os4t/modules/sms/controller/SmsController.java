package com.os4t.modules.sms.controller;
import com.os4t.common.utils.Result;

import com.os4t.modules.sms.entity.Email;
import com.os4t.modules.sms.service.SmsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/sys/sms")
public class SmsController {
	
	@Autowired
	private SmsService smsService;


	@PostMapping("/send")
	@RequiresPermissions("sys:sms:send")
	public Result send(@RequestBody Email mail) {
		try {
			smsService.sendFreemarker(mail);
		} catch (Exception e) {
			e.printStackTrace();
			return  Result.error();
		}
		return  Result.ok();
	}
	
	@PostMapping("/list")
	@RequiresPermissions("sms:mail:list")
	public Result list(Email mail) {
		return smsService.listMail(mail);
	}
}
