Feature: DCLI Webform
  This feature verifies all combinations of DCLI webform flow functionality

  @RegressionTest 
  Scenario: 01 Create an event in DCLI Webform -- Chassis
    Given Create an Event in DCLI webform
      | EquipmentType | EquipmentProvider |
      | Chassis       | AutoTruck Td      |
    When Enter service data in Webform
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis        | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    And Enter Driver's Info
    Then verify event created
    
     #@RegressionTest 
    #Scenario: 02 Create an event in DCLI Webform -- Powerunit
  #  Given Create an Event in DCLI webform
  #    | SCACcode | EquipmentProvider |
   #   | ANCF     | AutoTruck Td      |
   # When Enter service data in Webform
   #   | EquipmentType | System | Subsystem|Service|
    #  | Power Unit    | Brakes | ABS |ABSECUCable - ReplaceW/New|
   # And Enter payment Details -- Cash
   # And Enter Driver's Info
    #Then verify event created
    
   # @Regression
  #Scenario: 03 Create an event in DCLI Webform -- Container
   
    #Given Create an Event in DCLI webform
   
    #  | EquipmentType | EquipmentProvider |
     # | Container     | AutoTruck Td      |
   # When Enter service data in Webform
    #  | EquipmentType | System | SubSystem | Service             | Defect    | Location |
    #  | Container     | Door   | Door Sill | RearDoorSill - Weld | Cut, Torn | Rear     |
   # And Enter Driver's Info
   # Then verify event created
