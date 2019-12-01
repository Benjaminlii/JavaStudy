package main.java.com.park.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.park.entity.Check;
import com.park.service.CheckService;
import com.park.util.ResponseUtil;

/*
 * 订单控制层
 * 负责完成订单与取消订单
 * 根据电话号获取订单与用户部分信息
 */

@Controller
@RequestMapping("/check")
public class CheckController {
	@Autowired
	CheckService checkService;
	
	@RequestMapping(value="/findcheck")
	public void findcheck(HttpServletRequest request,HttpServletResponse response)throws IOException {
	
		JSONObject json=new JSONObject ();
		Check check=new Check();
		check.setParking_id(request.getParameter("parking_id"));
		check.setPhonenumber(request.getParameter("phonenumber"));
		List<Check> checks=checkService.findAllCheck(check);
		for(Check ch:checks) {
			//System.out.println("输出"+ch.getPhonenumber());
			json.put(String.valueOf(ch.getCheck_id()), ch);
		}
		try {
			ResponseUtil.write(response, json.toString());
		} catch (Exception e) {
 			e.printStackTrace();
		}
		
	}
	
	@RequestMapping("/findCheckstatus")
	public void findCheckstatus(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		JSONObject json=new JSONObject ();
		Check check=new Check();
		check.setParking_id(request.getParameter("parking_id"));
		check.setPhonenumber(request.getParameter("phonenumber"));
		check.setCheckstatus(request.getParameter("checkstatus"));
		List<Check> checks=checkService.findParkingStatus(check);
		for(Check ch:checks) {
			json.put(String.valueOf(ch.getCheck_id()), ch);
		}
		try {
			ResponseUtil.write(response, json.toString());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}


}
