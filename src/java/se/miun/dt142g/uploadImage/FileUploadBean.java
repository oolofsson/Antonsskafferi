/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.miun.dt142g.uploadImage;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;
import javax.faces.context.ExternalContext;

/**
 *
 * @author Sebastian
 */
 
@ManagedBean(name="jsfFileUploadBean")
@RequestScoped
 
public class FileUploadBean implements Serializable{
 
String relativeWebPath = "/";
FacesContext context = FacesContext.getCurrentInstance();
ExternalContext externalContext = context.getExternalContext();
ServletContext servletContext = (ServletContext) externalContext.getContext();
String absoluteDiskPath = servletContext.getRealPath(relativeWebPath);
        
    private static final long serialVersionUID = 1L;
 
    private String name;
    private Part file;
 
    public Part getFile() {
        return file;
    }
 
    public void setFile(Part file) {
        this.file = file;
    }
 

 
    public String processFileUpload() throws IOException{
 
        try{
            File f = new File(absoluteDiskPath + "image.png");
            f.delete();
        }
        catch(Exception e){
            e.printStackTrace();
        }
       
        Part uploadedFile=getFile();
         final Path destination = Paths.get(absoluteDiskPath + "image.png");
 
 
            if (null!=uploadedFile) {
 
                InputStream bytes = uploadedFile.getInputStream();
 
                  Files.copy(bytes, destination);
            }
 
        return null;
    }
 
 
    public static String getSubmittedFileName(Part filePart)
    {
        String header = filePart.getHeader("content-disposition");
        if(header == null)
            return null;
        for(String headerPart : header.split(";"))
        {
            if(headerPart.trim().startsWith("filename"))
            {
                return headerPart.substring(headerPart.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}