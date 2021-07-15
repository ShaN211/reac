Feature: Webform creation using SCAC code

  Scenario: 01 Create an event in BS Webform scac
    Given Create an Event in BS webform scac
      | SCACcode | EquipmentType |
      | ANCF     | Power Unit    |
    When Enter service data in Webform
      | EquipmentType | System                              | Assembly                          |
      | Power Unit    | 017 - Tires, Tubes, Liners & Valves | 004 - Inner Tube - Pneumatic Tire |
    And Enter payment Details -- Cash 
    And Enter Driver's Info
    Then verify event created
  
  Scenario: 02 Create an event in DCLI Webform scac
    Given Create an Event in DCLI webform scac
      | SCACcode | EquipmentType | EquipmentProvider |
      | ANCF     | Chassis       | AutoTruck Td      |
      
    When Enter service data in Webform
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    And Enter Driver's Info
    Then verify event created

    