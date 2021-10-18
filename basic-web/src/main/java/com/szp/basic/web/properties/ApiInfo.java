package com.szp.basic.web.properties;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;
import lombok.Data;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;

@Data
public class ApiInfo {

	private String title;
	private String description;
	private String termsOfServiceUrl;
	private Contact contact;
	private String license;
	private String licenseUrl;
	private String version;
	private List<VendorExtension> vendorExtensions = newArrayList();
}
