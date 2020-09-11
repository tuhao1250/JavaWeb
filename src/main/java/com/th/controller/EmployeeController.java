package com.th.controller;

import com.th.bean.Employee;
import com.th.common.AppContextUtil;
import com.th.common.interceptor.WebLogAspect;
import com.th.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

@Controller
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @RequestMapping("/employee")
    @ResponseBody
    public Employee getEmployee(@RequestParam("id")Integer id, HttpServletRequest request){
        ServletContext servletContext = request.getServletContext();
        WebLogAspect bean = AppContextUtil.getBean(WebLogAspect.class);
        System.out.println(bean);
        Employee employeeById = employeeService.getEmployeeById(id);
        return employeeById;
    }
}
