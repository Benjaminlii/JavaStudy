package main.java.com.park.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.park.entity.CarSpace;
import com.park.service.ParkingInfoService;
import com.park.util.ResponseUtil;
import com.park.vo.ParkingInformation;


/*
 * 停车场控制层
 * 实现查询每个停车场的具体信息
 */
@Controller
@RequestMapping("/parkinglot")
public class ParkingInfoController {
	
	@Autowired
	ParkingInfoService parkingService;
	
	@RequestMapping(value = "/searchParkByName")//根据坐标信息搜索附近停车场的信息***加上分页
	public void searchParkByName(HttpServletRequest request,HttpServletResponse response ){
	String parking_name = request.getParameter("parking_name");
	System.out.println("]]"+parking_name);
	JSONObject json = new JSONObject();
	//String parking_id=request.getParameter("parking_id");
	//int emptyCarspace=parkingService.getEmptyCarSpace(parking_id);
	//json.put(parking_id, emptyCarspace);
	List<ParkingInformation> pl = parkingService.searchParkByName(parking_name);
	for (ParkingInformation p : pl) {
		json.put(p.getParking_id(), p);
		System.out.println("没进入循环");
		System.out.println("+++"+p.getParking_name());
		}
	try {
		ResponseUtil.write(response, json.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/searchAllStatus")
	public void searchAllStatus(HttpServletRequest request,HttpServletResponse response ) {
		JSONObject json = new JSONObject();
		String parking_id=request.getParameter("parking_id");
		List<CarSpace> carspaces=parkingService.getAllCarspace(parking_id);
		for(CarSpace carspace:carspaces) {
			json.put(carspace.getSpace_location(), carspace.getSpace_status());
		}
		try {
			ResponseUtil.write(response, json.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

}
