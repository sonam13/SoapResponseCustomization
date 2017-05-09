package com.tcs.soapResponseCustomization.Controller;

import java.io.File;
import java.io.IOException;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.tcs.soapResponseCustomization.Request.Request;
import com.tcs.soapResponseCustomization.Service.SoapResponseCustomizationService;

@Controller
public class SoapResponseCustomizationController {
	@Autowired 
	SoapResponseCustomizationService service;
	@RequestMapping(value = "/soapResponseCustomization", method = RequestMethod.POST)
	public @ResponseBody String getClientes(@RequestBody Request request) {
     String msg=null;
     try
     {
		String filePath=request.getServicePath();
		new File(filePath+ File.separator+"pojoResponse").mkdirs();
		service.generateCustomResponse(request.getServiceResponse(),request);
		msg= "Response Customized Successfully";
     }
     catch(Exception e)
     {
    	 e.printStackTrace();
    	 msg="Exception occurred while customizing response";
     }
	 return msg;
	}
}
