package com.kryptow.springbootrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.kryptow.springbootrest.property.FileStorageProperties;

import net.coobird.thumbnailator.Thumbnails;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Iterator;
import java.util.UUID;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

@Service
public class FileStorageService {

    private final Path fileStorageLocation;

    @Autowired
    public FileStorageService(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
           // throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    public String storeFile(MultipartFile file,String ext) {
        // Normalize file name
    	  String fileName = UUID.randomUUID().toString();
    	  String fileNameWithExt = fileName  + "."+"jpg";

        try {
            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.fileStorageLocation.resolve(fileNameWithExt);
            Path targetLocation2 = this.fileStorageLocation.resolve(fileName+"_min.jpg");
          //  Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
         //   ImageIO.write(compressImage(file,fileName), "jpg", targetLocation.toFile());
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ImageIO.write(compressImage(file,fileName), "jpg", out);
            InputStream is = new ByteArrayInputStream(out.toByteArray());
            Files.copy(is, targetLocation, StandardCopyOption.REPLACE_EXISTING);
            Thumbnails.of(file.getInputStream())
            .size(100, 100)
            .toFile(targetLocation2.toFile());


        } catch (IOException ex) {
         //   throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
		return fileName;
    }
    private BufferedImage compressImage(MultipartFile file,String filename) {
    	BufferedImage image=null;
    	try {
        image = ImageIO.read(file.getInputStream());
        File compressedImageFile = new File(filename);
        OutputStream os = new FileOutputStream(compressedImageFile);

        Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpg");
        ImageWriter writer = (ImageWriter) writers.next();
        ImageOutputStream ios = ImageIO.createImageOutputStream(os);
        writer.setOutput(ios);

        ImageWriteParam param = writer.getDefaultWriteParam();
        param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        param.setCompressionQuality(0.01f);  // Change the quality value you prefer
        writer.write(null, new IIOImage(image, null, null), param);
        
        
        os.close();
        ios.close();
        writer.dispose();
    	}catch (Exception e) {
			// TODO: handle exception
		}
    	return image;
    }
   

   /* public Resource loadFileAsResource(String fileName) {
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
              //  throw new MyFileNotFoundException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
         //   throw new MyFileNotFoundException("File not found " + fileName, ex);
        }
    } */
}