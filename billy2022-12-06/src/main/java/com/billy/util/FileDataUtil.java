package com.billy.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileDataUtil {
   
   //Ȯ���� �� 3���� �����ϰ� �ϰڴٰ� �����Ѱ���. 
   //����ϴ� Ȯ���� ���Ǹ� �� ��.(���� �ǽ������� ������� �ʰڽ��ϴ�~)
   private ArrayList<String> extNameArray = new ArrayList<String>() 
   {
      {
         add("gif");
         add("jpg");
         add("png");
      }
   };   //<-- ���� �ڵ忡���� Ȱ�������ʴ´�. ���� ������, �������� �ʴ´�. ���� �̸� ��������!!! 
   
   //÷������ ���ε� ��� ���������� ������ servlet-context.xml
   @Resource(name="uploadPath")
   private String uploadPath;
   
   public String getUploadPath() {
      return uploadPath;
   }

   public void setUploadPath(String uploadPath) {
      this.uploadPath = uploadPath;
   }

   /**
    * �Խù� �󼼺��⿡�� ÷������ �ٿ�ε� �޼��� ����(����)
    */
   @RequestMapping(value="/download", method=RequestMethod.GET)
   @ResponseBody  //� �����͸� body�� �����Ͽ� �����ϰ����Ҷ� ��. view ���������ʰ� �ٷ� Ŭ���̾�Ʈ��û���� ����/
   public FileSystemResource fileDownload(@RequestParam("filename") String fileName, HttpServletResponse response) {
      File file = new File(uploadPath + "/" + fileName);
      response.setContentType("application/download; utf-8");
      response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
      return new FileSystemResource(file);
   }
   
   /**
    * ���� ���ε� �޼���(����)
    * @throws IOException 
    */
   public String[] fileUpload(MultipartFile[] file) throws IOException {
      String[] files = new String[file.length];
      for(int i = 0 ; i < file.length ; i++) {
        if(file[i].getOriginalFilename()!="") {   //���� file��ü�� �����Ѵٸ�
           String originalName = file[i].getOriginalFilename();//Ȯ���ڸ� ������������ ��ü ���ϸ��� ������
            UUID uid = UUID.randomUUID();//�������� ���ϱ�(�������ϸ����� ������ �ٸ��� �����ϱ� ����)
            String saveName = uid.toString() + "." + originalName.split("\\.")[1];//�ѱ� ���ϸ� ó�� ������...  
            //String[] files = new String[] {saveName};//����ȯ files[0]�� ���ϸ��� ����.
            byte[] fileData = file[i].getBytes();
            File target = new File(uploadPath, saveName);
            FileCopyUtils.copy(fileData, target);   // /tmp�� ī���ߴ�
            files[i]=saveName; 
        }        
     }      
      return files;   //��Ʈ�ѷ��� �Ѱܶ�
   }

   public ArrayList<String> getExtNameArray() {
      return extNameArray;
   }

   public void setExtNameArray(ArrayList<String> extNameArray) {
      this.extNameArray = extNameArray;
   }
}