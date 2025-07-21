package com.cms.cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CmsApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(CmsApplication.class, args);
		}catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}
