package main.java.com.park.controller;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.park.entity.CarSpace;
import com.park.entity.Check;
import com.park.service.CarspaceService;
import com.park.service.CheckService;
import main.java.com.park.serviceImpl.SocketServiceImp;
import com.park.util.ResponseUtil;




/*
 * 车位控制层
 * 负责预约  停车  取车 操作
 * 查询车位一系列信息
 */

@Controller
@RequestMapping("/carspace")
public class CarspaceController {
	
	@Autowired 
	CarspaceService carspaceService;
	
	@Autowired
	CheckService checkService;
	
	//预定车位,便产生一条状态为0的订单信息
	@RequestMapping(value = "/bookCarspace")//预定车位,便产生一条状态为0的订单信息
	public String bookCarspace(HttpServletRequest request,HttpServletResponse response) throws IOException{
		JSONObject json=new JSONObject ();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		String  start_time= sdf.format(now);
		CarSpace cp=new CarSpace();
		cp.setSpace_status(1);
		cp.setParking_id(request.getParameter("parking_id"));
		cp.setSpace_location(request.getParameter("space_location"));
		cp.setPhonenumber(request.getParameter("phonenumber"));
		cp.setStart_time(start_time);
 		boolean result1=carspaceService.reserveCarspace(cp);//修改车位状态
 		
 		//添加订单
 		Check ck=new Check();
 		ck.setCheckstatus("0");//预定
 		ck.setCheck_start_time(start_time);
 		ck.setParking_id(request.getParameter("parking_id"));
 		ck.setPhonenumber(request.getParameter("phonenumber"));
 		ck.setSpace_location(request.getParameter("space_location"));
 		boolean result2=checkService.addCheck(ck);
 		//json.put("result", result1&result2);
		try {
			String result3=com.park.util.Translate.Send("1*");// 给总控端发送请求
			System.out.println( String.valueOf(result1&result2));
			//SocketTest.Send("1*");
			ResponseUtil.write(response,"true");
			return "success";
		} catch (Exception e) {
 			e.printStackTrace();
		}
		return "failure";
	
	}
	
	
	//停车
	@RequestMapping(value="/parkCarspace")
	public void parkCarspace(HttpServletRequest request,HttpServletResponse response) throws IOException {
		JSONObject json=new JSONObject();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		String  start_time= sdf.format(now);
		CarSpace cp=new CarSpace();
		cp.setSpace_status(2);
		cp.setParking_id(request.getParameter("parking_id"));
		cp.setSpace_location(request.getParameter("space_location"));
		cp.setPhonenumber(request.getParameter("phonenumber"));
		cp.setStart_time(start_time);
		String result=carspaceService.parkCarspace(cp);
		Check check=new Check();
		check.setCheckstatus("1");
		check.setCheck_start_time(start_time);
		check.setParking_id(request.getParameter("parking_id"));
		check.setPhonenumber(request.getParameter("phonenumber"));
		check.setSpace_location(request.getParameter("space_location"));
		//boolean result2=checkService.updateCheck1(check);
		System.out.println("得到了"+request.getParameter("space_location"));
		System.out.println(".."+request.getParameter("phonenumber"));
		System.out.println(result);

		json.put("result", result);
		
		try {
			String result3=com.park.util.Translate.Send("2*");// 给总控端发送请求
			System.out.println("结果"+result3);
			System.out.println(".."+result3.equals("success"));
			ResponseUtil.write(response,result);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	//取车操作
	@RequestMapping(value="/takeCarspace")
	public void takeCarspace(HttpServletRequest request,HttpServletResponse response)throws Exception {
		JSONObject json=new JSONObject();
		CarSpace car=new CarSpace();
		car.setParking_id(request.getParameter("parking_id"));
		car.setSpace_location(request.getParameter("space_location"));
		car.setPhonenumber(request.getParameter("phonenumber"));
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now=new Date();
		String over_time=sdf.format(now);
		car.setSpace_status(0);
		boolean result=carspaceService.takeCarspace(car);
		Check check=new Check();
		check.setCheckstatus("2");
		check.setParking_id(request.getParameter("parking_id"));
		check.setSpace_location(request.getParameter("space_location"));
		check.setPhonenumber(request.getParameter("phonenumber"));
		check.setCheck_over_time(over_time);
		System.out.println(request.getParameter("parking_id"));
		System.out.println(request.getParameter("phonenumber"));
		boolean result2=checkService.updateCheck2(check);
		//json.put("result", result&result2);
		System.out.println("result"+result);
		json.put("parking_id",check.getParking_id());
		json.put("space_location", check.getSpace_location());
		json.put("phonenumber",check.getPhonenumber());
		json.put("checkmoney", 21);
		json.put("start_time", "2017-10-29 22:10:04");
		json.put("over_time", check.getCheck_over_time());
		
		ResponseUtil.write(response, json.toString());
		}
	
	
	@RequestMapping(value = "/checkCarspace")//查看车位是否可以预约
	public void checkCarspace(HttpServletRequest request,HttpServletResponse response) throws IOException{
		JSONObject json=new JSONObject ();
		CarSpace cp=new CarSpace();
		cp.setParking_id(request.getParameter("parking_id"));
		cp.setSpace_location(request.getParameter("space_location"));
 		int result=carspaceService.checkCarspace(cp);//修改车位状态
 		json.put("result", result);
		try {
			ResponseUtil.write(response, json.toString());
		} catch (Exception e) {
 			e.printStackTrace();
		}

	} 
	
	

}
