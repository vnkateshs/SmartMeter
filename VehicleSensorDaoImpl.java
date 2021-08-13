package com.cts.ai.iot.smartmeter.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cts.ai.iot.smartmeter.bean.VehicleInfoBean;
import com.cts.ai.iot.smartmeter.bean.VehicleSensorData;
import com.cts.ai.iot.smartmeter.model.VehicleInfo;
import com.cts.ai.iot.smartmeter.model.VehicleSensor;

@Repository
public class VehicleSensorDaoImpl implements VehicleSensorDao {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	
	@Override
	public ArrayList<VehicleSensor> getVehicleSensorDetails(String vehicleId, String driverId) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		StringBuilder appendQuery = new StringBuilder();
		appendQuery.append("where 1=1");

			appendQuery.append(" and driverId='" + driverId +"'");
		
		
			appendQuery.append(" and vehicleId='" + vehicleId+"'");


		@SuppressWarnings("unchecked")
		ArrayList<VehicleSensor> vehicleInfo = (ArrayList<VehicleSensor>) em.createQuery("From VehicleSensor v "+appendQuery.toString())
				.getResultList();

		em.getTransaction().commit();
		em.close();
return vehicleInfo;
	}

}
