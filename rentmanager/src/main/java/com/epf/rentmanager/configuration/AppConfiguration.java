package com.epf.rentmanager.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@Configuration
@ComponentScan({ "com.epf.rentmanager.service","com.epf.rentmanager.persistence","com.epf.rentmanager.dao" })

public class AppConfiguration {
}
