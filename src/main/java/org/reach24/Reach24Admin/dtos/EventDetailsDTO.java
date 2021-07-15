package org.reach24.Reach24Admin.dtos;

import java.util.List;

public class EventDetailsDTO {

	private String eventId;
	private String alphaNumEventID;
	private String truckDispatch;
	private String status;
	private boolean loaded;
	private boolean driverWithUnit;
	private boolean refrigerated;
	private String serviceCenter;
	private String techstatus;

	// Equipment
	private String equipmentType;
	private String equipmentNumber;
	private String chassisNumber;
	private String containerNumber;
	private String tractorNumber;
	private String trailerNumber;
	private String equipmentProvider;
	private String associatedTractorNumber;
	private String associatedContainerNumber;
	private String associatedChassisNumber;
	private String associatedTrailerNumber;
	// Address
	private String address;

	// DriverDetails
	private String driverName;
	private String driverPhoneNumber;
	// Billing
	private String referenceNumber;
	// Services
	private List<Services> services;
	
	//DVIR data
	private String dvirNumber;
	private String dvirStatus;
	private String equipmentStatus;

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getAlphaNumEventId() {
		return alphaNumEventID;
	}

	public void setAlphaNumEventId(String alphaNumEventID) {
		this.alphaNumEventID = alphaNumEventID;
	}

	public String getTruckDispatch() {
		return truckDispatch;
	}

	public void setTruckDispatch(String truckDispatch) {
		this.truckDispatch = truckDispatch;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getTechStatus() {
		return techstatus;
	}

	public void setTechStatus(String techstatus)
	{
		this.techstatus = techstatus;
	}
	public boolean getLoaded() {
		return loaded;
	}

	public void setLoaded(boolean loaded) {
		this.loaded = loaded;
	}

	public boolean getDriverWithUnit() {
		return driverWithUnit;
	}

	public void setDriverWithUnit(boolean driverWithUnit) {
		this.driverWithUnit = driverWithUnit;
	}

	public boolean getRefrigerated() {
		return refrigerated;
	}

	public void setRefrigerated(boolean refrigerated) {
		this.refrigerated = refrigerated;
	}

	public String getServiceCenter() {
		return serviceCenter;
	}

	public void setServiceCenter(String serviceCenter) {
		this.serviceCenter = serviceCenter;
	}

	// Equipment
	public String getEquipmentType() {
		return equipmentType;
	}

	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
	}

	public String getEquipmentNumber() {
		return equipmentNumber;
	}

	public void setEquipmentNumber(String equipmentNumber) {
		this.equipmentNumber = equipmentNumber;
	}

	public String getChassisNumber() {
		return chassisNumber;
	}

	public void setChassisNumber(String chassisNumber) {
		this.chassisNumber = chassisNumber;
	}

	public String getEquipmentProvider() {
		return equipmentProvider;
	}

	public void setEquipmentProvider(String equipmentProvider) {
		this.equipmentProvider = equipmentProvider;
	}

	public String getAssociatedTractorNumber() {
		return associatedTractorNumber;
	}

	public void setAssociatedTractorNumber(String associatedTractorNumber) {
		this.associatedTractorNumber = associatedTractorNumber;
	}

	public String getAssociatedChassisNumber() {
		return associatedChassisNumber;
	}

	public void setAssociatedChassisNumber(String associatedChassisNumber) {
		this.associatedChassisNumber = associatedChassisNumber;
	}

	public String getAssociatedContainerNumber() {
		return associatedContainerNumber;
	}

	public void setAssociatedContainerNumber(String associatedContainerNumber) {
		this.associatedContainerNumber = associatedContainerNumber;
	}

	public String getAssociatedTrailerNumber() {
		return associatedTrailerNumber;
	}

	public void setAssociatedTrailerNumber(String associatedTrailerNumber) {
		this.associatedTrailerNumber = associatedTrailerNumber;
	}

	public String getContainerNumber() {
		return containerNumber;
	}

	public void setContainerNumber(String containerNumber) {
		this.containerNumber = containerNumber;
	}

	public String getTractorNumber() {
		return tractorNumber;
	}

	public void setTractorNumber(String tractorNumber) {
		this.tractorNumber = tractorNumber;
	}

	public String getTrailerNumber() {
		return trailerNumber;
	}

	public void setTrailerNumber(String trailerNumber) {
		this.trailerNumber = trailerNumber;
	}

	// Address
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	// Driver Details
	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDriverPhoneNumber() {
		return driverPhoneNumber;
	}

	public void setDriverPhoneNumber(String driverPhoneNumber) {
		this.driverPhoneNumber = driverPhoneNumber;
	}

	// Services
	public List<Services> getServices() {
		return services;
	}

//Billing
	public String getreferenceNumber() {
		return referenceNumber;
	}

	public void setreferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public void setServices(List<Services> services) {
		this.services = services;
	}
	
	public String getDVIRnumber() {
		return dvirNumber;
	}

	public void setDVIRnumber(String dvirNumber) {
		this.dvirNumber = dvirNumber;
	}
	
	public String getdvirStatus() {
		return dvirStatus;
	}

	public void setdvirStatus(String dvirStatus) {
		this.dvirStatus = dvirStatus;
	}
	
	public String getEquipmentStatus() {
		return equipmentStatus;
	}

	public void setEquipmentStatus(String equipmentStatus) {
		this.equipmentStatus = equipmentStatus;
	}
	
	

}
