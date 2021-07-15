Feature: Webform
  This feature verifies all combinations of webform flow functionality

  @RegressionTest 
  Scenario: 01 Create an event in Webform -- Chassis
    Given Create an Event in BS webform
      | EquipmentType | EquipmentProvider |
      | Chassis       | AutoTruck Td      |
    When Enter service data in Webform
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    And Enter payment Details -- Cash
    And Enter Driver's Info
    Then verify event created

  @RegressionTest
  Scenario: 02 Create an event in BS Webform -- Trailer
    Given Create an Event in BS webform
      | EquipmentType | EquipmentProvider |
      | Trailer       | AutoTruck Td      |
    When Enter service data in Webform
      | EquipmentType | System                              | Assembly                          |
      | Trailer       | 017 - Tires, Tubes, Liners & Valves | 004 - Inner Tube - Pneumatic Tire |
    And Enter payment Details -- Cash
    And Enter Driver's Info
    Then verify event created

  @RegressionTest
  Scenario: 03 Create an event in BS Webform -- Container
    Given Create an Event in BS webform
      | EquipmentType | EquipmentProvider |
      | Container     | AutoTruck Td      |
    When Enter service data in Webform
      | EquipmentType | System | SubSystem | Service             | Defect    | Location |
      | Container     | Door   | Door Sill | RearDoorSill - Weld | Cut, Torn | Rear     |
    And Enter payment Details -- Cash
    And Enter Driver's Info
    Then verify event created

  @RegressionTest
  Scenario: 04 Create an event in BS Webform -- Power unit
    Given Create an Event in BS webform
      | EquipmentType | EquipmentProvider |
      | Power Unit    | AutoTruck Td      |
    When Enter service data in Webform
      | EquipmentType | System                              | Assembly                          |
      | Power Unit    | 017 - Tires, Tubes, Liners & Valves | 004 - Inner Tube - Pneumatic Tire |
    And Enter payment Details -- Cash
    And Enter Driver's Info
    Then verify event created
