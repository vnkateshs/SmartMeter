package com.cts.ai.iot.smartmeter.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cts.ai.iot.smartmeter.bean.VehicleInfoBean;
import com.cts.ai.iot.smartmeter.bean.VehicleInput;
import com.cts.ai.iot.smartmeter.bean.VenicleInfoResponse;
import com.cts.ai.iot.smartmeter.model.VehicleInfo;
import com.cts.ai.iot.smartmeter.repository.VehicleInfoRepository;

@Repository
public class VehicleInfoDaoImpl implements VehicleInfoDao {

	@Autowired
	VehicleInfoRepository vehicleInfoRepository;

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	@Override
	public ArrayList<VehicleInfo> getVehicleInfoByLocation(String location) {
		// TODO Auto-generated method stub

		ArrayList<VehicleInfo> vehicleInfo = vehicleInfoRepository.findByLocation(location);

		return vehicleInfo;
	}

	public double calculateFactor(double avgData)
	{
		double factorVal=0.0;
		if(avgData>=0.0 && avgData<=5.0)
		{
			factorVal=0.1;
		}
		else if(avgData>5.0 && avgData<=10.0)
		{
			factorVal=0.2;
		}else if(avgData>10.0 && avgData<=20.0)
		{
			factorVal=0.4;
		}else if(avgData>20.0)
		{
			factorVal=0.5;
		}
		
		return factorVal;
	}

	@Override
	public VenicleInfoResponse getVehicleDetails(VehicleInput vehicleInput) {
		// TODO Auto-generated method stub
				// VehicleInfoBean vehicleInfo = vehicleInfoRepository.getScoreByVin(vin);
		double overAllFilter=0.0;
		
		
		double totalAvgAccident=0.0;
		double totalAvgClaim=0.0;
		double totalAvgSpeedings=0.0;
		
		double averageAccidentCount=0.0;
		double averageClaimsCount=0.0;
		double averageSpeedingsCount=0.0;
		VenicleInfoResponse VenicleInfoResponse=new VenicleInfoResponse();

		if(vehicleInput.getDateOfbirth()!=null)
		{
		ArrayList<VehicleInfoBean> getByAgeGroup=getData(vehicleInput,"age");
		for(VehicleInfoBean vehicleInfoBean:getByAgeGroup)
		{
			
			if(vehicleInfoBean.getAvgAccident()>0.0)
			{
				averageAccidentCount+=1.0;
			}
			
			totalAvgAccident+=vehicleInfoBean.getAvgAccident();
			
			if(vehicleInfoBean.getAvgClaims()>0.0)
			{
			averageClaimsCount+=1.0;
			}
			
			totalAvgClaim+=vehicleInfoBean.getAvgClaims();

			
			if(vehicleInfoBean.getAvgSpeedings()>0.0)
			{
			averageSpeedingsCount+=1.0;
			}
			
			totalAvgSpeedings+=vehicleInfoBean.getAvgSpeedings();

			if(VenicleInfoResponse.getAgeList()==null)
			{
				VenicleInfoResponse.setAgeList(new ArrayList<VehicleInfoBean>());
			}
			
			VenicleInfoResponse.getAgeList().add(vehicleInfoBean);
			
		}
		
		if(getByAgeGroup!=null && getByAgeGroup.size()>0)
		{
			
			double avgAccidentTot=0.0;
			if(averageAccidentCount>0.0)
			{
				avgAccidentTot=(totalAvgAccident/averageAccidentCount);
				avgAccidentTot=avgAccidentTot * calculateFactor(avgAccidentTot);
			}
			double avgClaimTot=0.0;
			if(averageClaimsCount>0.0)
			{
				avgClaimTot=(totalAvgClaim/averageClaimsCount);
				avgClaimTot=avgClaimTot*calculateFactor(avgClaimTot);
			}
			double avgSpeedingTot=0.0;
			if(averageSpeedingsCount>0.0)
			{
				avgSpeedingTot=(totalAvgSpeedings/averageSpeedingsCount);
				avgSpeedingTot=avgSpeedingTot*calculateFactor(avgSpeedingTot);

			}
			double ageAvgTotal=(avgAccidentTot+avgClaimTot+avgSpeedingTot)/100.00;
			VenicleInfoResponse.setAgeAvgTotal(ageAvgTotal);
		}
		
		}
		
		if(vehicleInput.getLocation()!=null)
		{
		
		totalAvgAccident=0.0;
		totalAvgClaim=0.0;
		totalAvgSpeedings=0.0;
		averageAccidentCount=0.0;
		averageClaimsCount=0.0;
		averageSpeedingsCount=0.0;
		ArrayList<VehicleInfoBean> getByLocation=getData(vehicleInput,"location");
		
		for(VehicleInfoBean vehicleInfoBean:getByLocation)
		{
			if(vehicleInfoBean.getAvgAccident()>0.0)
			{
				averageAccidentCount+=1.0;
			}
			
			totalAvgAccident+=vehicleInfoBean.getAvgAccident();
			
			if(vehicleInfoBean.getAvgClaims()>0.0)
			{
			averageClaimsCount+=1.0;
			}
			
			totalAvgClaim+=vehicleInfoBean.getAvgClaims();

			
			if(vehicleInfoBean.getAvgSpeedings()>0.0)
			{
			averageSpeedingsCount+=1.0;
			}
			
			totalAvgSpeedings+=vehicleInfoBean.getAvgSpeedings();
			
			if(VenicleInfoResponse.getLocationList()==null)
			{
				VenicleInfoResponse.setLocationList(new ArrayList<VehicleInfoBean>());
			}
			VenicleInfoResponse.getLocationList().add(vehicleInfoBean);
			
		}
		
		if(getByLocation!=null && getByLocation.size()>0)
		{

			double avgAccidentTot=0.0;
			if(averageAccidentCount>0.0)
			{
				avgAccidentTot=(totalAvgAccident/averageAccidentCount);
				avgAccidentTot=avgAccidentTot * calculateFactor(avgAccidentTot);
			}
			double avgClaimTot=0.0;
			if(averageClaimsCount>0.0)
			{
				avgClaimTot=(totalAvgClaim/averageClaimsCount);
				avgClaimTot=avgClaimTot*calculateFactor(avgClaimTot);
			}
			double avgSpeedingTot=0.0;
			if(averageSpeedingsCount>0.0)
			{
				avgSpeedingTot=(totalAvgSpeedings/averageSpeedingsCount);
				avgSpeedingTot=avgSpeedingTot*calculateFactor(avgSpeedingTot);

			}
			
			double ageAvgTotal=(avgAccidentTot+avgClaimTot+avgSpeedingTot)/100.00;
			
			VenicleInfoResponse.setLocationAvgTotal(ageAvgTotal);
		}
		
		}
		
		if(vehicleInput.getVehicleId()!=null)
		{
		totalAvgAccident=0.0;
		totalAvgClaim=0.0;
		totalAvgSpeedings=0.0;
		averageAccidentCount=0.0;
		averageClaimsCount=0.0;
		averageSpeedingsCount=0.0;
		String vehicleType=getVehicleType(vehicleInput.getVehicleId());
		vehicleInput.setVehicleId(vehicleType);
		System.out.println(vehicleInput.getVehicleId());
		ArrayList<VehicleInfoBean> getByVehicle=getData(vehicleInput,"vehicletype");
		
		for(VehicleInfoBean vehicleInfoBean:getByVehicle)
		{
			if(vehicleInfoBean.getAvgAccident()>0.0)
			{
				averageAccidentCount+=1.0;
			}
			
			totalAvgAccident+=vehicleInfoBean.getAvgAccident();
			
			if(vehicleInfoBean.getAvgClaims()>0.0)
			{
			averageClaimsCount+=1.0;
			}
			
			totalAvgClaim+=vehicleInfoBean.getAvgClaims();

			
			if(vehicleInfoBean.getAvgSpeedings()>0.0)
			{
			averageSpeedingsCount+=1.0;
			}
			
			totalAvgSpeedings+=vehicleInfoBean.getAvgSpeedings();
			
			if(VenicleInfoResponse.getVehicleList()==null)
			{
				VenicleInfoResponse.setVehicleList(new ArrayList<VehicleInfoBean>());
			}
			
			VenicleInfoResponse.getVehicleList().add(vehicleInfoBean);
			
		}
		
		if(getByVehicle!=null && getByVehicle.size()>0)
		{
			double avgAccidentTot=0.0;
			if(averageAccidentCount>0.0)
			{
				avgAccidentTot=(totalAvgAccident/averageAccidentCount);
				avgAccidentTot=avgAccidentTot * calculateFactor(avgAccidentTot);
			}
			double avgClaimTot=0.0;
			if(averageClaimsCount>0.0)
			{
				avgClaimTot=(totalAvgClaim/averageClaimsCount);
				avgClaimTot=avgClaimTot*calculateFactor(avgClaimTot);
			}
			double avgSpeedingTot=0.0;
			if(averageSpeedingsCount>0.0)
			{
				avgSpeedingTot=(totalAvgSpeedings/averageSpeedingsCount);
				avgSpeedingTot=avgSpeedingTot*calculateFactor(avgSpeedingTot);

			}
			
			double ageAvgTotal=(avgAccidentTot+avgClaimTot+avgSpeedingTot)/100.00;
			
			VenicleInfoResponse.setVehicleAvgTotal(ageAvgTotal);
		}
		
		}
		
		overAllFilter=0.0;
		if(VenicleInfoResponse.getAgeAvgTotal()>0.0)
		{
			overAllFilter+=1.0;
		}
		
		if(VenicleInfoResponse.getLocationAvgTotal()>0.0)
		{
			overAllFilter+=1.0;
		}
		
		if(VenicleInfoResponse.getVehicleAvgTotal()>0.0)
		{
			overAllFilter+=1.0;
		}
		
		if(overAllFilter>0.0)
		{
			double overAlltotal= (VenicleInfoResponse.getAgeAvgTotal()+VenicleInfoResponse.getLocationAvgTotal()+VenicleInfoResponse.getVehicleAvgTotal())/overAllFilter;
			
			VenicleInfoResponse.setTotal(overAlltotal);
		}
		
		
		return VenicleInfoResponse;
	}
	
	private String getVehicleType(String vehicleId) {
		// TODO Auto-generated method stub
		String vehicleType="";
		VehicleInput vehicleInfo = vehicleInfoRepository.getVehicleType(vehicleId);
		if(vehicleInfo!=null)
		{
			vehicleType=vehicleInfo.getVehicleId();
		}
		return vehicleType;
	}

	public ArrayList<VehicleInfoBean> getData(VehicleInput vehicleInput,String type)
	{
		boolean filter = false;
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		StringBuilder appendQuery = new StringBuilder();
		appendQuery.append("where 1=1");

		if (type.equals("location") && vehicleInput.getLocation() != null) {
			appendQuery.append(" and location='" + vehicleInput.getLocation() +"'");
		}
		
		
		if (type.equals("vehicletype") && vehicleInput.getVehicleId() != null) {
			appendQuery.append(" and lower(vehicletype)='" + vehicleInput.getVehicleId().toLowerCase()+"'");
		}

		if (type.equals("age") && vehicleInput.getDateOfbirth() != null) {
			String ageGroup=getAgeGroup(vehicleInput.getDateOfbirth());
			appendQuery.append(" and "+ageGroup);
		}

		
		// group by
		if(type.equals("vehicletype"))
		{
			appendQuery.append(" group by lower("+type+")");
		}else {
			appendQuery.append(" group by "+type);
			}

		ArrayList<VehicleInfoBean> vehicleInfo = (ArrayList<VehicleInfoBean>) em.createQuery("select new com.cts.ai.iot.smartmeter.bean.VehicleInfoBean(Avg(accidents) ,Avg(claims) ,Avg(speeding), cast("+type+" as text)) from VehicleInfo v "+appendQuery.toString())
				.getResultList();

		em.getTransaction().commit();
		em.close();
return vehicleInfo;
	}

	private String getAgeGroup(String dateOfbirth) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	      Date birthDate = null;
		try {
			birthDate = sdf.parse(dateOfbirth);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}     
	      int getYear = calculateAge(birthDate);
	      
	      System.out.println("getYear" +getYear);
	      
	      String getAgeGroup=getAgeGroupByAge(getYear);
	      
	      System.out.println("getAgeGroup" +getAgeGroup);
	      
		return getAgeGroup;
	}

	private String getAgeGroupByAge(int getYear) {
		// TODO Auto-generated method stub
		String ageRange="";
		if(getYear>=0 && getYear<=10 )
		{
			ageRange="age>0 and age<=10";
		}
		else if(getYear>10 && getYear<=20 )
		{
			ageRange="age>10 and age<=20";
	
		}else if(getYear>20 && getYear<=30 )
		{
			ageRange="age>20 and age<=30";

			
		}else if(getYear>30 && getYear<=40 )
		{
			ageRange="age>30 and age<=40";

			
		}else if(getYear>40 && getYear<=50 )
		{
			ageRange="age>40 and age<=50";

			
		}else if(getYear>60 && getYear<=70 )
		{
			ageRange="age>60 and age<=70";

		}else if(getYear>70 && getYear<=80 )
		{
			ageRange="age>70 and age<=80";

		}else if(getYear>90 && getYear<=100 )
		{
			ageRange="age>90 and age<=100";

		}else if(getYear>100 )
		{
			ageRange="age>100";
			
		}
		
		return ageRange;
	}

	private int calculateAge(Date birthDate) {
		// TODO Auto-generated method stub
		  int years = 0;
	      int months = 0;
	      int days = 0;
	 
	      //create calendar object for birth day
	      Calendar birthDay = Calendar.getInstance();
	      birthDay.setTimeInMillis(birthDate.getTime());
	 
	      //create calendar object for current day
	      long currentTime = System.currentTimeMillis();
	      Calendar now = Calendar.getInstance();
	      now.setTimeInMillis(currentTime);
	 
	      //Get difference between years
	      years = now.get(Calendar.YEAR) - birthDay.get(Calendar.YEAR);
	      int currMonth = now.get(Calendar.MONTH) + 1;
	      int birthMonth = birthDay.get(Calendar.MONTH) + 1;
	 
	      //Get difference between months
	      months = currMonth - birthMonth;
	 
	      //if month difference is in negative then reduce years by one 
	      //and calculate the number of months.
	      if (months < 0)
	      {
	         years--;
	         months = 12 - birthMonth + currMonth;
	         if (now.get(Calendar.DATE) < birthDay.get(Calendar.DATE))
	            months--;
	      } else if (months == 0 && now.get(Calendar.DATE) < birthDay.get(Calendar.DATE))
	      {
	         years--;
	         months = 11;
	      }
	 
	      //Calculate the days
	      if (now.get(Calendar.DATE) > birthDay.get(Calendar.DATE))
	         days = now.get(Calendar.DATE) - birthDay.get(Calendar.DATE);
	      else if (now.get(Calendar.DATE) < birthDay.get(Calendar.DATE))
	      {
	         int today = now.get(Calendar.DAY_OF_MONTH);
	         now.add(Calendar.MONTH, -1);
	         days = now.getActualMaximum(Calendar.DAY_OF_MONTH) - birthDay.get(Calendar.DAY_OF_MONTH) + today;
	      } 
	      else
	      {
	         if (months == 12)
	         {
	            years++;
	         }
	      }
	      //Create new Age object 
	      return  years;
	}

}
