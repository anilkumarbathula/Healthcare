package novelhealthcare;

import java.util.List;



import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.dotridge.dao.HospitalDao;
import com.dotridge.dao.HospitalDaoImpl;
import com.dotridge.domain.Hospital;

public class HospitalDaoTest {
	
	private HospitalDao hospitalDao;
	@Before
	public void setUp(){
		hospitalDao=new HospitalDaoImpl();
	}
	@Test
	public void testGetAllHospitals(){
		List<Hospital> hosplist=hospitalDao.getAllHospitals();
		Assert.assertNotNull(hosplist);
		Assert.assertEquals(3, hosplist.size());
	}
	
	public void testClear(){
		hospitalDao=null;
	}

}
