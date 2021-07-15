 Feature: Event Creation from TD
  This feature verifies all combinations of event creation functionality

  @RegressionTest @SmokeTest @Sanity
  Scenario: 01 Create a TD Event--Chassis--Single--Brakes
    Given Create a Event-- TD
      | EquipmentType | EquipmentProvider |
      | Chassis       | AutoTruck         |
    When Enter Service details
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | TD         | Open   | Dashboard |
      | Single     | TD         | Open   | EventInfo |

  @RegressionTest
  Scenario: 02 Create a TD Event--Chassis-- Multiple Service line Brakes and Tire
    Given Create a Event-- TD
      | EquipmentType | EquipmentProvider |
      | Chassis       | AutoTruck         |
    When Enter Service details
      | EquipmentType | System          | SubSystem         | Service                                               | Defect                                  | Location |
      | Chassis       | DVIR - Coupling | Coupling - Defect | DVIR-KingPinUpperCoupling - Inspection,RepairRequired | Driver Vehicle Inspection Report (DVIR) | Complete |
      | Chassis       | Tire            | Flap              | Flap - Replace w/new                                  | Worn Out                                | Front    |
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | TD         | Open   | Dashboard |
      | Single     | TD         | Open   | EventInfo |

  @RegressionTest
  Scenario: 03 Create a TD Event--container--Single--Door
    Given Create a Event-- TD
      | EquipmentType | EquipmentProvider |
      | Container     | AutoTruck         |
    When Enter Service details
      | EquipmentType | System | SubSystem | Service             | Defect    | Location |
      | Container     | Door   | Door Sill | RearDoorSill - Weld | Cut, Torn | Rear     |
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | TD         | Open   | Dashboard |
      | Single     | TD         | Open   | EventInfo |

  @RegressionTest
  Scenario: 04 Create a TD Event--container--Multiple--Door and Floor
    Given Create a Event-- TD
      | EquipmentType | EquipmentProvider |
      | container     | AutoTruck         |
    When Enter Service details
      | EquipmentType | System   | SubSystem | Service                 | Defect  | Location |
      | container     | Markings | Decal     | Logo - ReplaceW/New     | Missing | Rear     |
      | container     | Floor    | Threshold | ThresholdPlate - Secure | Loose   | Rear     |
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | TD         | Open   | Dashboard |
      | Single     | TD         | Open   | EventInfo |

  @RegressionTest
  Scenario: 05 Create a TD Event--Tractor-- Single Service line Brakes
    Given Create a Event-- TD
      | EquipmentType | EquipmentProvider |
      | Power Unit    | AutoTruck         |
    When Enter Service details
      | EquipmentType | System | Assembly        | Component             | Position     | WorkAccomplished | Reason                 |
      | Power Unit    | Brakes | Electric Brakes | Electric Brakes (EBS) | Front Center | Adjust           | Abuse Caused by Driver |
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | TD         | Open   | Dashboard |
      | Single     | TD         | Open   | EventInfo |

  @RegressionTest
  Scenario: 06 Create a TD Event--Tractor-- Multiple Service line Brakes and Tire
    Given Create a Event-- TD
      | EquipmentType | EquipmentProvider |
      | Power Unit    | AutoTruck         |
    When Enter Service details
      | EquipmentType | System | Assembly | Component | Position     | WorkAccomplished | Reason |
      | Power Unit    |    017 |      000 |       000 | LFI          |              002 |    015 |
      | Power Unit    |    016 |      007 |       009 | Front Center |              002 |    031 |
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | TD         | Open   | Dashboard |
      | Single     | TD         | Open   | EventInfo |

  @RegressionTest
  Scenario: 07 Create a TD Event--trailer--Single--Brakes
    Given Create a Event-- TD
      | EquipmentType | EquipmentProvider |
      | Trailer       | AutoTruck         |
    When Enter Service details
      | EquipmentType | System | Assembly              | Component              | Position     | WorkAccomplished | Reason                 |
      | Trailer       | Brakes | Brake Master Cylinder | Boot - Master Cylinder | Front Center | Adjust           | Abuse Caused by Driver |
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | TD         | Open   | Dashboard |
      | Single     | TD         | Open   | EventInfo |

  @RegressionTest
  Scenario: 08 Create a TD Event--trailer--Multiple--Brakes and Axles-Front
    Given Create a Event-- TD
      | EquipmentType | EquipmentProvider |
      | Trailer       | AutoTruck         |
    When Enter Service details
      | EquipmentType | System        | Assembly             | Component              | Position           | WorkAccomplished   | Reason                 |
      | Trailer       | Frame         | Cab & Body Mountings | Air Line - Cab Mount   | Center             | Adjust             | Abuse Caused by Driver |
      | Trailer       | Axles - Front | Axles - Front        | Axles - Front Steering | Bottom/Lower Outer | Charge / Discharge | Abuse of Equipment     |
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | TD         | Open   | Dashboard |
      | Single     | TD         | Open   | EventInfo |
