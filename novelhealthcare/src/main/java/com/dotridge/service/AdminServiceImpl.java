package com.dotridge.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dotridge.bean.AdminBean;
import com.dotridge.dao.AdminDao;
import com.dotridge.domain.Admin;

@Service
public class AdminServiceImpl implements AdminService 
{
	@Autowired
	private AdminDao adminDao;

	public Admin mapBeanToDomain(AdminBean adminBean) 
	{
		Date date = new Date();
		
		Admin admin = new Admin();
		//admin.setHospital(hospitalService.getHospitalByName(adminBean.getHospitalName()));
		admin.setAdminId(adminBean.getAdminId());
		admin.setFirstName(adminBean.getFirstName());
		admin.setMiddleName(adminBean.getMiddleName());
		admin.setLastName(adminBean.getLastName());
		admin.setEmail(adminBean.getEmail());
		admin.setPassword(adminBean.getPassword());
		admin.setPhone(adminBean.getPhone());
		admin.setProfileDocuments(adminBean.getProfileDocuments());
		admin.setStatus(adminBean.isStatus());
		admin.setCreatedBy("Anil");
		admin.setCreatedDate(date);
		admin.setModifiedBy("Anil");
		admin.setModifiedDate(date);
		return admin;
	}

	public AdminBean mapDomainToBean(Admin admin) 
	{
		AdminBean adminBean = new AdminBean();
		adminBean.setHospitalName(admin.getHospital().getHospitalName());
		adminBean.setAdminId(admin.getAdminId());
		adminBean.setFirstName(admin.getFirstName());
		adminBean.setMiddleName(admin.getMiddleName());
		adminBean.setLastName(admin.getLastName());
		adminBean.setEmail(admin.getEmail());
		adminBean.setPassword(admin.getPassword());
		adminBean.setPhone(admin.getPhone());
		adminBean.setProfileDocuments(admin.getProfileDocuments());
		adminBean.setStatus(admin.isStatus());
		return adminBean;
	}

	public AdminBean createAdmin(AdminBean adminBean) 
	{
		Admin adminDomain = mapBeanToDomain(adminBean);
		AdminBean adminBean2 = mapDomainToBean(adminDao.createAdmin(adminDomain));
		return adminBean2;
	}

	public AdminBean updateAdmin(AdminBean adminBean) {
		// TODO Auto-generated method stub
		return null;
	}

	public AdminBean getAdminById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<AdminBean> getAdminByName(String adminName) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<AdminBean> getAdminByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<AdminBean> getAdminByAddress1(String address1) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<AdminBean> getAdminByPhone(long phoneNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<AdminBean> getAdminByStatus(Boolean status) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<AdminBean> getAllAdmins() 
	{
		List<Admin> adminsList = adminDao.getAllAdmins();
		List<AdminBean> adminBeansList = null;
		if(adminsList != null && !adminsList.isEmpty())
		{
			adminBeansList = new ArrayList<AdminBean>();
			for(Admin adminDomain : adminsList)
			{
				AdminBean adminBean = mapDomainToBean(adminDomain);
				adminBeansList.add(adminBean);
			}
			return adminBeansList;
		}
		else
			throw new RuntimeException("No Hospital Available");
	}

	public boolean deleteAdmin(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<AdminBean> getAllAdminsByPagining(int currentPage, int numberOfRecords) {
		// TODO Auto-generated method stub
		return null;
	}

}
