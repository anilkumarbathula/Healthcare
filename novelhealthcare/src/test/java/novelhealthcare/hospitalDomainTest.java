package novelhealthcare;

import java.util.Date;
import java.util.List;

import com.dotridge.dao.HospitalDao;
import com.dotridge.dao.HospitalDaoImpl;
import com.dotridge.domain.Hospital;

public class hospitalDomainTest 
{
	public static void main(String[] args) 
	{
		createHospital();
		//updateHospital();
		//getHospitalById();
		//getHospitalByName();
		//getAllHospitals();
		//getAllHospitalsByPagining();
		//deleteHospital();
	}

	private static void createHospital() 
	{
		Date date = new Date();
		
		Hospital hospital = new Hospital();
		hospital.setHospitalName("Prime");
		hospital.setAddress1("Kukatpally");
		hospital.setAddress2("Phase 2");
		hospital.setCity("Hyderabad");
		hospital.setState("Telangana");
		hospital.setZipCode(500024);
		hospital.setEmail("prime@gmail.com");
		hospital.setPhone(8563258963L);
		hospital.setFax(040-88899966L);
		hospital.setStatus(true);
		hospital.setCreatedBy("Yugandhar");
		hospital.setCreatedDate(date);
		hospital.setModifiedBy("Yugandhar");
		hospital.setModifiedDate(date);
		
		HospitalDao hospitalDao = new HospitalDaoImpl();
		Hospital hospitalDomain2 = hospitalDao.createHospital(hospital);
		System.out.println(hospitalDomain2);
	}
	
	private static void updateHospital(Hospital hospital)
	{
		HospitalDao hospitalDao = new HospitalDaoImpl();
		Hospital hospital1 = hospitalDao.updateHospital(hospital);
		System.out.println(hospital1);
	}
	
	private static void getHospitalById() 
	{
		HospitalDao hospitalDao = new HospitalDaoImpl();
		Hospital hospital = hospitalDao.getHospitalById(1);
		System.out.println(hospital);
	}
	
	private static void getHospitalByName() 
	{
		HospitalDao hospitalDao = new HospitalDaoImpl();
		List<Hospital> hospitals = hospitalDao.getHospitalByName("KIMS");
		for(Hospital h1 : hospitals)
		{
			System.out.print(h1.getHospitalName() + ", ");
			System.out.print(h1.getAddress1() + ", ");
			System.out.print(h1.getCity() + ", ");
			System.out.print(h1.getState() + ", ");
			System.out.print(h1.isStatus() + ", ");
			System.out.print(h1.getCreatedBy() + ", ");
			System.out.print(h1.getCreatedDate() + ", ");
			System.out.print(h1.getModifiedBy() + ", ");
			System.out.println(h1.getModifiedDate());
		}
	}
	
	private static void getAllHospitals() 
	{
		HospitalDao hospitalDao = new HospitalDaoImpl();
		List<Hospital> hospitals = hospitalDao.getAllHospitals();
		for(Hospital h1 : hospitals)
		{
			System.out.print(h1.getHospitalName() + ", ");
			System.out.print(h1.getAddress1() + ", ");
			System.out.print(h1.getEmail() + ", ");
			System.out.println(h1.getPhone() + ", ");
			System.out.print(h1.getCity() + ", ");
			System.out.print(h1.getState() + ", ");
			System.out.print(h1.isStatus() + ", ");
			System.out.print(h1.getCreatedBy() + ", ");
			System.out.print(h1.getCreatedDate() + ", ");
			System.out.print(h1.getModifiedBy() + ", ");
			System.out.println(h1.getModifiedDate());
		}
	}
	
	private static void getAllHospitalsByPagining() 
	{
		HospitalDao hospitalDao = new HospitalDaoImpl();
		List<Hospital> hospitals = hospitalDao.getAllHospitalsByPagining(2, 1);
		for(Hospital h1 : hospitals)
		{
			System.out.print(h1.getHospitalName() + ", ");
			System.out.print(h1.getAddress1() + ", ");
			System.out.print(h1.getEmail() + ", ");
			System.out.println(h1.getPhone() + ", ");
			System.out.print(h1.getCity() + ", ");
			System.out.print(h1.getState() + ", ");
			System.out.print(h1.isStatus() + ", ");
			System.out.print(h1.getCreatedBy() + ", ");
			System.out.print(h1.getCreatedDate() + ", ");
			System.out.print(h1.getModifiedBy() + ", ");
			System.out.println(h1.getModifiedDate());
		}
	}
	
	private static void deleteHospital() 
	{
		HospitalDao hospitalDao = new HospitalDaoImpl();
		boolean value = hospitalDao.deleteHospital(2);
		if(value = true)
		{
			System.out.println("One row deleted successfully");
		}
		else
			System.out.println("deletion failed or record not found with the specified Id");
	}
}
