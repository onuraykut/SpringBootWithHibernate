package com.kryptow.springbootrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.kryptow.springbootrest.property.FileStorageProperties;
import com.kryptow.springbootrest.property.FileStoragePropertiesProfile;

@SpringBootApplication
@EnableConfigurationProperties({
    FileStorageProperties.class,
    FileStoragePropertiesProfile.class
})
public class SpringBootWithHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithHibernateApplication.class, args);
	}

}
