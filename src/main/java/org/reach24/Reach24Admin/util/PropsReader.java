package org.reach24.Reach24Admin.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropsReader {

	public static String filePath;
	public static String configFilesPath = "./src/test/resources/config/";

	public static int timeoutInSeconds;

	// URLs
	public static String adminUrl;
	public static String tdURL;
	public static String td1URL;
	public static String td2URL;
	public static String td3URL;
	public static String spURL;
	public static String sp2URL;
	public static String ccURL;
	public static String amazonURL;
	public static String sctechURL;
	public static String tenantCreatePage;
	public static String tdeventCreatePage;
	public static String td1eventCreatePage;
	public static String td2eventCreatePage;
	public static String td3eventCreatePage;
	public static String speventCreatePage;
	public static String cceventCreatePage;
	public static String amazoneventCreatePage;
	public static String tdEventInfoPage;
	public static String td1EventInfoPage;
	public static String td2EventInfoPage;
	public static String td3EventInfoPage;
	public static String spEventInfoPage;
	public static String ccEventInfoPage;
	public static String sctechEventInfoPage;
	public static String amazonEventInfoPage;
	public static String tdIECreateEventPage;
	public static String dvirDashboardPage;
	public static String sp2EventInfoPage;
	


	// Driver
	public static String driver;

	// Super Admin Credentials
	public static String superAdminUserName;
	public static String superAdminPassword;

	// TD Admin
	public static String tdUserName;
	public static String tdPassword;
	
	//TD1 Admin
	public static String td1UserName;
	public static String td1Password;
	
	//TD2 Admin
	public static String td2UserName;
	public static String td2Password;
	
	//TD3 Admin
	public static String td3UserName;
	public static String td3Password;

	// SP Admin
	public static String spUserName;
	public static String spPassword;
	
	//SP2 Admin
	public static String sp2UserName;
	public static String sp2Password;

	// cc Admin
	public static String ccUserName;
	public static String ccPassword;

	// cc Admin
	public static String amazonUserName;
	public static String amazonPassword;
	
	//SC Tech
	public static String sctechUserName;
	public static String sctechPassword;

	public PropsReader() {

		// Driver
		PropsReader.driver = readPropertiesFile(configFilesPath + "baseConfig.properties").getProperty("Driver");

		PropsReader.adminUrl = readPropertiesFile(getBaseConfig()).getProperty("AdminPage");
		PropsReader.tdURL = readPropertiesFile(getBaseConfig()).getProperty("TDUrl");
		PropsReader.td1URL = readPropertiesFile(getBaseConfig()).getProperty("TD1Url");
		PropsReader.td2URL = readPropertiesFile(getBaseConfig()).getProperty("TD2Url");
		PropsReader.td3URL = readPropertiesFile(getBaseConfig()).getProperty("TD3Url");
		PropsReader.spURL = readPropertiesFile(getBaseConfig()).getProperty("SPUrl");
		PropsReader.ccURL = readPropertiesFile(getBaseConfig()).getProperty("CCUrl");
		PropsReader.amazonURL = readPropertiesFile(getBaseConfig()).getProperty("AmazonUrl");
		PropsReader.sctechURL=readPropertiesFile(getBaseConfig()).getProperty("SCTechUrl");
		PropsReader.sp2URL = readPropertiesFile(getBaseConfig()).getProperty("SP2Url");

		// Pages
		PropsReader.tenantCreatePage = adminUrl.concat("/administration/tenants/new");
		PropsReader.tdeventCreatePage = tdURL.concat("/event/incidents/new");
		PropsReader.td1eventCreatePage = td1URL.concat("/event/incidents/new");
		PropsReader.td2eventCreatePage = td2URL.concat("/event/incidents/new");
		PropsReader.td3eventCreatePage = td3URL.concat("/event/incidents/new");
		PropsReader.speventCreatePage = spURL.concat("/event/incidents/new");
		PropsReader.cceventCreatePage = ccURL.concat("/event/incidents/new");
		PropsReader.amazoneventCreatePage = amazonURL.concat("/event/incidents/new");
		PropsReader.tdEventInfoPage = tdURL.concat("/event/incidents/");
		PropsReader.td1EventInfoPage = td1URL.concat("/event/incidents/");
		PropsReader.td2EventInfoPage = td2URL.concat("/event/incidents/");
		PropsReader.td3EventInfoPage = td3URL.concat("/event/incidents/");
		PropsReader.spEventInfoPage = spURL.concat("/event/incidents/");
		PropsReader.sp2EventInfoPage = sp2URL.concat("/event/incidents/");
		PropsReader.ccEventInfoPage = ccURL.concat("/event/incidents/");
		PropsReader.sctechEventInfoPage = sctechURL.concat("/event/incidents/");
		PropsReader.amazonEventInfoPage = amazonURL.concat("/event/incidents/");
		PropsReader.tdIECreateEventPage = tdURL.concat("/event/equipment_inspections/new");
		PropsReader.dvirDashboardPage = tdURL.concat("/dvirs");

		PropsReader.superAdminUserName = readPropertiesFile(getBaseConfig()).getProperty("SuperAdminUserName");
		PropsReader.superAdminPassword = readPropertiesFile(getBaseConfig()).getProperty("SuperAdminPassword");

		PropsReader.timeoutInSeconds = Integer
				.parseInt(readPropertiesFile(getBaseConfig()).getProperty("TimeoutinSeconds"));

		// TD creds
		PropsReader.tdUserName = readPropertiesFile(getBaseConfig()).getProperty("TDUserName");
		PropsReader.tdPassword = readPropertiesFile(getBaseConfig()).getProperty("TDPassword");
		
		// TD1 creds
		PropsReader.td1UserName = readPropertiesFile(getBaseConfig()).getProperty("TD1UserName");
		PropsReader.td1Password = readPropertiesFile(getBaseConfig()).getProperty("TD1Password");
		
		// TD2 creds
		PropsReader.td2UserName = readPropertiesFile(getBaseConfig()).getProperty("TD2UserName");
		PropsReader.td2Password = readPropertiesFile(getBaseConfig()).getProperty("TD2Password");
		
		// TD3 creds
		PropsReader.td3UserName = readPropertiesFile(getBaseConfig()).getProperty("TD3UserName");
		PropsReader.td3Password = readPropertiesFile(getBaseConfig()).getProperty("TD3Password");
		
		// SP creds
		PropsReader.spUserName = readPropertiesFile(getBaseConfig()).getProperty("SPUserName");
		PropsReader.spPassword = readPropertiesFile(getBaseConfig()).getProperty("SPPassword");
		
		//SP2 creds
		PropsReader.sp2UserName = readPropertiesFile(getBaseConfig()).getProperty("SP2UserName");
		PropsReader.sp2Password = readPropertiesFile(getBaseConfig()).getProperty("SP2Password");
		
		// cc creds
		PropsReader.ccUserName = readPropertiesFile(getBaseConfig()).getProperty("CCUserName");
		PropsReader.ccPassword = readPropertiesFile(getBaseConfig()).getProperty("CCPassword");

		// amazon creds
		PropsReader.amazonUserName = readPropertiesFile(getBaseConfig()).getProperty("AmazonUserName");
		PropsReader.amazonPassword = readPropertiesFile(getBaseConfig()).getProperty("AmazonPassword");
		
		//SCTech creds
		PropsReader.sctechUserName=readPropertiesFile(getBaseConfig()).getProperty("SCTechUserName");
		PropsReader.sctechPassword=readPropertiesFile(getBaseConfig()).getProperty("SCTechPassword");
		
	}

	public static Properties readPropertiesFile(String fileName) {
		FileInputStream fis = null;
		Properties prop = null;
		try {
			fis = new FileInputStream(fileName);
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return prop;
	}

	public String getBaseConfig() {
		String environment = readPropertiesFile(configFilesPath + "baseConfig.properties").getProperty("Environment");
		Properties props = new Properties();

		try {
			props.load(PropsReader.class.getClassLoader().getResourceAsStream("project.properties"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		String mvnEnvironment = props.getProperty("Environment");
		if (environment.equals("${Environment}")) {
			environment = mvnEnvironment;
		}
		try {
			switch (environment.toLowerCase()) {

			case "stage":
				filePath = configFilesPath + "stage/stage.properties";
				break;
			case "testing":
				filePath = configFilesPath + "testing/testing.properties";
				break;
			case "demo":
				filePath = configFilesPath + "ProdDemo/demo.properties";
				break;
			case "prod":
				filePath = configFilesPath + "Prod/prod.properties";
				break;
			case "int":
				filePath = configFilesPath + "integration/int.properties";
				break;
			default:
				throw new Reach24AutomationCustomException("Invalid Environment Selected");

			}
		} catch (Reach24AutomationCustomException e) {
			e.printStackTrace();
		}
		return filePath;
	}

}
