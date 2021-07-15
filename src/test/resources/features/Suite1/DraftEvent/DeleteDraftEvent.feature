Feature: Delete Draft Event
  This feature verifies all combinations of Draft event Deletion functionality after creation

  @RegressionTest
  Scenario: 01 Create a TD Draft Event--Chassis--Single--Brakes
    Given Create a DraftEvent-- TD
      | EquipmentType | EquipmentProvider | chassisNumber | associatedTractorNumber |
      | Chassis       | AutoTruck         |               |                         |
   	Then Delete the DraftEvent

  @RegressionTest
  Scenario: 02 Create a TD Draft Event--Trailer--Single--Brakes
    Given Create a DraftEvent-- TD
      | EquipmentType | EquipmentProvider | chassisNumber | associatedTractorNumber |
      | Trailer       | AutoTruck         |               |                         |
    Then Delete the DraftEvent

  @RegressionTest
  Scenario: 03 Create a TD Draft Event--Power unit--Single--Brakes
    Given Create a DraftEvent-- TD
      | EquipmentType | EquipmentProvider | chassisNumber | associatedTractorNumber |
      | Power unit    | AutoTruck         |               |                         |
    Then Delete the DraftEvent
    
    @RegressionTest
  Scenario: 04 Create a SP Event--Chassis--Single--Brakes
    Given Create a DraftEvent-- SP
      | EquipmentType | EquipmentProvider | TruckDispatch |
      | Chassis       | AutoTruck         | AutoTruck TD  |
    Then Delete the DraftEvent

  @RegressionTest
  Scenario: 05 Create a SP Event--trailer--Multiple--Brakes and Axles-Front
    Given Create a DraftEvent-- SP
      | EquipmentType | EquipmentProvider | TruckDispatch |
      | Trailer       | AutoTruck         | AutoTruck TD  |
    Then Delete the DraftEvent
    
    @RegressionTest
  Scenario: 06 Create a CC Event--Chassis--Single--Brakes
    Given Create a DraftEvent-- CC
      | EquipmentType | EquipmentProvider | TruckDispatch |
      | Chassis       | AutoTruck         | AutoTruck TD  |
    Then Delete the DraftEvent
    
    @RegressionTest
  Scenario: 07 Create a CC Event--trailer--Multiple--Brakes and Axles-Front
    Given Create a DraftEvent-- CC
      | EquipmentType | EquipmentProvider | TruckDispatch |
      | Trailer       | AutoTruck         | AutoTruck TD  |
		Then Delete the DraftEvent