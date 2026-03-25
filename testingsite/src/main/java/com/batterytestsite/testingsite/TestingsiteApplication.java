package com.batterytestsite.testingsite;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.ServletContext;

@SpringBootApplication
@RestController
public class TestingsiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestingsiteApplication.class, args);
	}

@Autowired
ServletContext request;
@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
 @ResponseBody
 public String uploadFile(@RequestParam("file") MultipartFile file) {


  File uploadLocation = new File("testingsite/fileUploadFolder/wpiData.wpilog");

try (FileOutputStream fos = new FileOutputStream("testingsite/fileUploadFolder/wpiData.wpilog")) {
   fos.write(file.getBytes());
   fos.close();
} catch (Exception e) {

   //Shows errors.
 e.printStackTrace();

 return "Failure";
 }

 return "Success";
 }
   

}
