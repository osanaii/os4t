package com.os4t.modules.job.controller;

import com.os4t.common.utils.Result;
import com.os4t.modules.job.service.ScheduleJobService;
import com.os4t.common.annotation.SysLog;
import com.os4t.common.utils.PageUtils;
import com.os4t.common.validator.ValidatorUtils;
import com.os4t.modules.job.entity.ScheduleJobEntity;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 定时任务
 *
 * @author  18256595192@163.com
 *
 */
@RestController
@RequestMapping("/sys/schedule")
public class ScheduleJobController {
	@Autowired
	private ScheduleJobService scheduleJobService;
	
	/**
	 * 定时任务列表
	 */
	@GetMapping("/list")
	@RequiresPermissions("sys:schedule:list")
	public Result list(@RequestParam Map<String, Object> params){
		PageUtils page = scheduleJobService.queryPage(params);

		return Result.ok().put("page", page);
	}
	
	/**
	 * 定时任务信息
	 */
	@GetMapping("/info/{jobId}")
	@RequiresPermissions("sys:schedule:info")
	public Result info(@PathVariable("jobId") Long jobId){
		ScheduleJobEntity schedule = scheduleJobService.selectById(jobId);
		
		return Result.ok().put("schedule", schedule);
	}
	
	/**
	 * 保存定时任务
	 */
	@SysLog("保存定时任务")
	@PostMapping("/save")
	@RequiresPermissions("sys:schedule:save")
	public Result save(@RequestBody ScheduleJobEntity scheduleJob){
		ValidatorUtils.validateEntity(scheduleJob);
		
		scheduleJobService.save(scheduleJob);
		
		return Result.ok();
	}
	
	/**
	 * 修改定时任务
	 */
	@SysLog("修改定时任务")
	@PostMapping("/update")
	@RequiresPermissions("sys:schedule:update")
	public Result update(@RequestBody ScheduleJobEntity scheduleJob){
		ValidatorUtils.validateEntity(scheduleJob);
				
		scheduleJobService.update(scheduleJob);
		
		return Result.ok();
	}
	
	/**
	 * 删除定时任务
	 */
	@SysLog("删除定时任务")
	@PostMapping("/delete")
	@RequiresPermissions("sys:schedule:delete")
	public Result delete(@RequestBody Long[] jobIds){
		scheduleJobService.deleteBatch(jobIds);
		
		return Result.ok();
	}
	
	/**
	 * 立即执行任务
	 */
	@SysLog("立即执行任务")
	@PostMapping("/run")
	@RequiresPermissions("sys:schedule:run")
	public Result run(@RequestBody Long[] jobIds){
		scheduleJobService.run(jobIds);
		
		return Result.ok();
	}
	
	/**
	 * 暂停定时任务
	 */
	@SysLog("暂停定时任务")
	@PostMapping("/pause")
	@RequiresPermissions("sys:schedule:pause")
	public Result pause(@RequestBody Long[] jobIds){
		scheduleJobService.pause(jobIds);
		
		return Result.ok();
	}
	
	/**
	 * 恢复定时任务
	 */
	@SysLog("恢复定时任务")
	@PostMapping("/resume")
	@RequiresPermissions("sys:schedule:resume")
	public Result resume(@RequestBody Long[] jobIds){
		scheduleJobService.resume(jobIds);
		
		return Result.ok();
	}

}
