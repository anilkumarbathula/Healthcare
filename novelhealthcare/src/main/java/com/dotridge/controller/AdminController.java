package com.dotridge.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dotridge.bean.AdminBean;
import com.dotridge.bean.HospitalBean;
import com.dotridge.service.AdminService;
import com.dotridge.service.HospitalService;
import com.dotridge.util.ServiceConstants;

@Controller
@RequestMapping(value="/adminManagement")
public class AdminController
{
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private HospitalService hospitalService;
	
	@RequestMapping(value="/getAllUsers")
	public String viewAllAdmins(Model model)
	{
		try
		{
			List<AdminBean> adminBeansList = adminService.getAllAdmins();
			System.out.println(adminBeansList);
			int uiListSize = adminBeansList.size();
			int recordsPerPage = Math.round((uiListSize / ServiceConstants.NUMBER_OF_RECORDS_PER_PAGE) + 1);
			List<Integer> pageBarList = new ArrayList<Integer>();
			for(int i = 0; i < recordsPerPage; i++)
			{
				pageBarList.add(i + 1);
			}
			System.out.println("recordsPerPage : " + recordsPerPage);
			System.out.println("pageBarList : " + pageBarList.size());
			model.addAttribute("pageBarList",pageBarList);
			model.addAttribute("uiAdminsList",adminBeansList);
			return "getUsersBoard";
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value="/getAdminRegForm")
	public String getHospitalRegistrationForm(Model model)
	{
		AdminBean adminBean = new AdminBean();
		List<HospitalBean> hospitalBeanList = hospitalService.getAllHospitals();
		Set<String> hospitalNameList = new HashSet<String>();
		for(HospitalBean hospitalBeans : hospitalBeanList)
		{
			hospitalNameList.add(hospitalBeans.getHospitalName());
		}
		model.addAttribute("hospitalNameList",hospitalNameList);
		model.addAttribute("adminBean",adminBean);
		return "addAdminFormDef";
	}
	
	@RequestMapping(value="/addAdmin", method=RequestMethod.POST)
	public String addAdmin(@ModelAttribute("adminBean") AdminBean adminBean, Model model)
	{
		System.out.println(adminBean.toString());
		AdminBean adminBean2 = adminService.createAdmin(adminBean);
		if(adminBean2.getAdminId() > 0)
		{
				List<AdminBean> uiAdminsList = adminService.getAllAdmins();
				model.addAttribute("uiAdminsList" ,uiAdminsList);
				//System.out.println(uiHospitalList);
				return "getUsersBoard";
		}
		else
		{
			System.out.println("Hospital Adding is failed");
			return "getUsersBoard";
		}	
	}
}
