package com.os4t.modules.sms.service.impl;

import java.util.HashMap;
import java.util.Map;


import com.os4t.common.utils.Result;
import com.os4t.modules.sms.entity.Email;
import com.os4t.modules.sms.service.SmsService;
import com.os4t.modules.sms.utils.SmsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.thymeleaf.context.Context;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.internet.MimeMessage;

@Service("smsService")
public class SmsServiceImpl implements SmsService {
	private static final Logger logger = LoggerFactory.getLogger(SmsServiceImpl.class);

	@Autowired
	private JavaMailSender mailSender;//执行者
	@Autowired
	public Configuration configuration;//freemarker
	@Autowired
	private SpringTemplateEngine templateEngine;//thymeleaf
	@Value("${spring.mail.username}")
	public String USER_NAME;//发送者
	@Value("${server.servlet.context-path}")
	public String PATH;//发送者
	
	
	@Autowired
    private RedisTemplate<String, String> redisTemplate;
	
	static {
		 System.setProperty("mail.mime.splitlongparameters","false");
	}

	@Override
	public void send(Email mail) throws Exception {
		logger.info("发送邮件：{}",mail.getContent());
		SmsUtil mailUtil = new SmsUtil();
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(USER_NAME);
		message.setTo(mail.getEmail());
		message.setSubject(mail.getSubject());
		message.setText(mail.getContent());
		mailUtil.start(mailSender, message);
	}

	@Override
	public void sendHtml(Email mail) throws Exception {

	}

	@Override
	public void sendFreemarker(Email mail) throws Exception {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setFrom(USER_NAME);
		helper.setTo(mail.getEmail());
		helper.setSubject(mail.getSubject());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("mail", mail);
		model.put("path", PATH);
		model.put("cName", "zcl");
		model.put("product","保理委贷");
		Template template = configuration.getTemplate(mail.getTemplate()+".ftl");
		String text = FreeMarkerTemplateUtils.processTemplateIntoString(
				template, model);
		helper.setText(text, true);
		mailSender.send(message);
		mail.setContent(text);
	}

	@Override
	public void sendThymeleaf(Email mail) throws Exception {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setFrom(USER_NAME);
		helper.setTo(mail.getEmail());
		helper.setSubject(mail.getSubject());
		Context context = new Context();
		context.setVariable("email", mail);
		String text = templateEngine.process(mail.getTemplate(), context);
		helper.setText(text, true);
		mailSender.send(message);
	}

	@Override
	public void sendQueue(Email mail) throws Exception {
	}
	@Override
	public void sendRedisQueue(Email mail) throws Exception {
		redisTemplate.convertAndSend("mail",mail);
	}

	@Override
	public Result listMail(Email mail) {
		return Result.ok();
	}
}
