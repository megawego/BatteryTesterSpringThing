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
import com.batterytestsite.testingsite.WPILogHandler;

@SpringBootApplication
@RestController
public class TestingsiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestingsiteApplication.class, args);
	}
   WPILogHandler LogHandler;
@Autowired
ServletContext request;
 public Integer logCount=0;
@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
 @ResponseBody
 public String uploadFile(@RequestParam("file") MultipartFile file) {
  String logName="wpiData"+logCount.toString();
  String uploadLocation = "testingsite/fileUploadFolder/"+logName+".wpilog";
  File uploadedFile=new File(uploadLocation);
  logCount+=1;
try {
   FileOutputStream fos = new FileOutputStream(uploadedFile);
   fos.write(file.getBytes());
   fos.close();
   LogHandler=new WPILogHandler(uploadLocation);
   if(LogHandler.IsLogValid()){
   return Long.toString(LogHandler.getStartingTimestamp());
   } else {
      return "Invalid File";
   }
} catch (Exception e) {

   //Shows errors.
 e.printStackTrace();

 return "Failure";
 }
 }
   

}
