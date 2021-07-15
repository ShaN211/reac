Feature: Draft Event Creation from TD
  This feature verifies all combinations of Draft event creation functionality

  @RegressionTest @SmokeTest @Sanity
  Scenario: 01 Create a TD Draft Event--Chassis--Single--Brakes
    Given Create a DraftEvent-- TD
      | EquipmentType | EquipmentProvider |chassisNumber |associatedTractorNumber|
      | Chassis       | AutoTruck         |              |                       |

      
  @RegressionTest
  Scenario: 02 Create a TD Draft Event--Tractor--Single--Brakes
    Given Create a DraftEvent-- TD
      | EquipmentType | EquipmentProvider |chassisNumber |associatedTractorNumber|
      | Tractor       | AutoTruck         |              |                       |
      
      
  @RegressionTest
  Scenario: 03 Create a TD Draft Event--Trailer--Single--Brakes
    Given Create a DraftEvent-- TD
      | EquipmentType | EquipmentProvider |chassisNumber |associatedTractorNumber|
      | Trailer       | AutoTruck         |              |                       |
   
  @RegressionTest
  Scenario: 04 Create a TD Draft Event--Power unit--Single--Brakes
    Given Create a DraftEvent-- TD
      | EquipmentType | EquipmentProvider |chassisNumber |associatedTractorNumber|
      | Power unit       | AutoTruck         |              |                       |
      