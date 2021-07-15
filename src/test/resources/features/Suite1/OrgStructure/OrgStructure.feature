Feature: Org Structure
  This feature verifies all combinations of org structure functionality

  @RegressionTest 
  Scenario: 01 Create an Event in TD2 and verify the event info in TD1
    Given Create a Event-- TD2
      | EquipmentType | EquipmentProvider |
      | Chassis       | AutoTruck         |
    When Enter Service details
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    And Get Event information from -- TD1
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | TD1        | Open   | Dashboard |
      | Single     | TD1        | Open   | EventInfo |
      
  @RegressionTest
  Scenario: 02 Create an Event in TD2 and assign the event to SP in TD1
    Given Create a Event-- TD2
      | EquipmentType | EquipmentProvider |
      | Chassis       | AutoTruck         |
    When Enter Service details
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    And Assign TD1 event to -- AutoTruck SP  -- Payment Method - Yes
    And Get Event information from -- SP
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | TD1        | Submitted | Dashboard |
      | Single     | TD1        | Submitted | EventInfo |
      | Single     | SP         | Submitted | Dashboard |
      | Single     | SP         | Submitted | EventInfo |
      
  @RegressionTest
  Scenario: 03 Create an Event in TD2 and assign the event to SP in TD1
    Given Create a Event-- TD2
      | EquipmentType | EquipmentProvider |
      | Container     | AutoTruck         |
    When Enter Service details
      | EquipmentType | System | SubSystem | Service             | Defect    | Location |
      | Container     | Door   | Door Sill | RearDoorSill - Weld | Cut, Torn | Rear     |
    And Assign TD1 event to -- AutoTruck SP  -- Payment Method - Yes
    And Get Event information from -- SP
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | TD1        | Submitted | Dashboard |
      | Single     | TD1        | Submitted | EventInfo |
      | Single     | SP         | Submitted | Dashboard |
      | Single     | SP         | Submitted | EventInfo |
