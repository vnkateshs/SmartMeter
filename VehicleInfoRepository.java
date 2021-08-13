package com.cts.ai.iot.smartmeter.repository;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cts.ai.iot.smartmeter.bean.VehicleInfoBean;
import com.cts.ai.iot.smartmeter.bean.VehicleInput;
import com.cts.ai.iot.smartmeter.model.VehicleInfo;

@Transactional
@Repository
public interface VehicleInfoRepository extends CrudRepository<VehicleInfo, Long> {
	
	ArrayList<VehicleInfo> findByLocation	(String location);

	@Query("select new com.cts.ai.iot.smartmeter.bean.VehicleInput(v.vehicletype) from VehicleInfo v where v.vehicleid=:vehicleid and rownum<2")
	VehicleInput getVehicleType(String vehicleid);
	
	


}

