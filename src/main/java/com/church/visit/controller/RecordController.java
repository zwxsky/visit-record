package com.church.visit.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.church.visit.model.RecordCond;
import com.church.visit.model.RecordModel;
import com.church.visit.service.RecordService;

@Controller
@RequestMapping("/record")
public class RecordController extends BaseController {
	
	@Autowired
	private  RecordService recordService;
	
	/**
	 * 根据条件获取记录列表
	 * @param request
	 * @param response
	 * @param cond
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public List<RecordModel> getList(HttpServletRequest request,HttpServletResponse response,
			RecordCond cond){
		return recordService.queryByCond(cond);
	}
	
	/**
	 * 根据id 查详情
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	@ResponseBody
	public RecordModel getModel(HttpServletRequest request,HttpServletResponse response,
			@PathVariable Long id){
		
		return recordService.queryModel(id);
	}
	
	/**
	 * 更新探访记录
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	@ResponseBody
	public Map<String, Object> getModel(HttpServletRequest request,HttpServletResponse response,
			@RequestBody RecordModel recordModel){
		
//		recordService.updateModel(recordModel);
		return ajaxResult(recordService.updateModel(recordModel)==1?true:false, null);
	}
	
}
