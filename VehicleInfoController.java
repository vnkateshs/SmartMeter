package com.cts.ai.iot.smartmeter.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cts.ai.iot.smartmeter.bean.VehicleInput;
import com.cts.ai.iot.smartmeter.bean.VenicleInfoResponse;
import com.cts.ai.iot.smartmeter.model.VehicleInfo;
import com.cts.ai.iot.smartmeter.service.VehicleInfoService;

@CrossOrigin(origins = "*")
@RestController
public class VehicleInfoController {

	@Autowired
	VehicleInfoService vehicleInfoService;

	private static Logger logger = LoggerFactory.getLogger(VehicleInfoController.class);

//http://localhost:8080/vehicleInfo?location=Chickago	
	@RequestMapping(value = { "/vehicleInfo" }, method = RequestMethod.GET)
	public ArrayList<VehicleInfo> getVehicleInfoByLocation(@RequestParam String location) {

		logger.info("getVehicleInfoByLocation entered...");

		// Return some HTML
		ArrayList<VehicleInfo> vehicleInfo = vehicleInfoService.getVehicleInfoByLocation(location);

		return vehicleInfo;
	}

		@RequestMapping(value = { "/home" }, method = RequestMethod.GET)
	public ModelAndView getAllURL() {

		logger.info("getVehicleInfoByLocation entered...");

		// Return some HTML
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("home");
	    return modelAndView;

	}
	
	@RequestMapping(value = { "/getVehicleInfo" }, method = RequestMethod.POST)
	public VehicleInput getScoreByVin1(@RequestBody VehicleInput vehicleInput) {

		logger.info("getVehicleInfoByLocation entered...");
String resetInput=vehicleInput.getVehicleId();		
		// Return some HTML
		VenicleInfoResponse vehicleInfo =vehicleInfoService.getVehicleDetails(vehicleInput);
		//VehicleInfoBean vehicleInfo = vehicleInfoService.getScoreByVin(vin);
		//System.out.println(vehicleInfo.get(0));
		
		DecimalFormat df = new DecimalFormat("#.##");      
		double total = Double.valueOf(df.format(vehicleInfo.getTotal()));
		
		vehicleInput.setFactor(total);
		vehicleInput.setVehicleId(resetInput);
		return vehicleInput;
	}
	
	@RequestMapping(value = { "/registration" }, method = RequestMethod.GET)
public ModelAndView registration() {

	logger.info("getVehicleInfoByLocation entered...");

	// Return some HTML
	ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("registration");
    return modelAndView;

}
}
