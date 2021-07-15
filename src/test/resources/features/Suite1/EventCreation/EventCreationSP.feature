Feature: Event Creation from SP
  This feature verifies all combinations of event creation functionality

  @RegressionTest @SmokeTest @Sanity
  Scenario: 01 Create a SP Event--Chassis--Single--Brakes
    Given Create a Event-- SP
      | EquipmentType | EquipmentProvider | TruckDispatch |
      | Chassis       | AutoTruck         | AutoTruck TD  |
    When Enter Service details
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    And Get Event information from -- SP
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | SP         | Submitted | Dashboard |
      | Single     | SP         | Submitted | EventInfo |

  @RegressionTest
  Scenario: 02 Create a SP Event--Chassis-- Multiple Service line Brakes and Tire
    Given Create a Event-- SP
      | EquipmentType | EquipmentProvider | TruckDispatch |
      | Chassis       | AutoTruck         | AutoTruck TD  |
    When Enter Service details
      | EquipmentType | System          | SubSystem         | Service                                               | Defect                                  | Location |
      | Chassis       | DVIR - Coupling | Coupling - Defect | DVIR-KingPinUpperCoupling - Inspection,RepairRequired | Driver Vehicle Inspection Report (DVIR) | Complete |
      | Chassis       | Tire            | Flap              | Flap - Replace w/new                                  | Worn Out                                | Front    |
    And Get Event information from -- SP
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | SP         | Submitted | Dashboard |
      | Single     | SP         | Submitted | EventInfo |

  @RegressionTest
  Scenario: 03 Create a SP Event--Tractor-- Single Service line Brakes
    Given Create a Event-- SP
      | EquipmentType | EquipmentProvider | TruckDispatch |
      | Power Unit    | AutoTruck         | AutoTruck TD  |
    When Enter Service details
      | EquipmentType | System     | Assembly            | Component             | Position | WorkAccomplished | Reason      |
      | Power Unit    | suspension | Air ride suspension | Air Cylinder Assembly | circular | Balance          | accessories |
    And Get Event information from -- SP
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | SP         | Submitted | Dashboard |
      | Single     | SP         | Submitted | EventInfo |

  @RegressionTest
  Scenario: 04 Create a SP Event--Tractor-- Multiple Service line Brakes and Tire
    Given Create a Event-- SP
      | EquipmentType | EquipmentProvider | TruckDispatch |
      | Power Unit    | AutoTruck         | AutoTruck TD  |
    When Enter Service details
      | EquipmentType | System     | Assembly            | Component             | Position | WorkAccomplished | Reason      |
      | Power Unit    | suspension | Air ride suspension | Air Cylinder Assembly | circular | Balance          | accessories |
      | Power Unit    |        001 |                 001 |                   201 | circular | Balance          | accessories |
    And Get Event information from -- SP
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | SP         | Submitted | Dashboard |
      | Single     | SP         | Submitted | EventInfo |

  @RegressionTest
  Scenario: 05 Create a SP Event--container--Single--Door
    Given Create a Event-- SP
      | EquipmentType | EquipmentProvider | TruckDispatch |
      | Container     | AutoTruck         | AutoTruck TD  |
    When Enter Service details
      | EquipmentType | System | SubSystem | Service             | Defect    | Location |
      | Container     | Door   | Door Sill | RearDoorSill - Weld | Cut, Torn | Rear     |
    And Get Event information from -- SP
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | SP         | Submitted | Dashboard |
      | Single     | SP         | Submitted | EventInfo |

  @RegressionTest
  Scenario: 06 Create a SP Event--container--Multiple--Door and Floor
    Given Create a Event-- SP
      | EquipmentType | EquipmentProvider | TruckDispatch |
      | container     | AutoTruck         | AutoTruck TD  |
    When Enter Service details
      | EquipmentType | System | SubSystem | Service                 | Defect    | Location |
      | container     | Door   | Door Sill | RearDoorSill - Weld     | Cut, Torn | Rear     |
      | container     | Floor  | Threshold | ThresholdPlate - Secure | Loose     | Rear     |
    And Get Event information from -- SP
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | SP         | Submitted | Dashboard |
      | Single     | SP         | Submitted | EventInfo |

  @RegressionTest
  Scenario: 07 Create a SP Event--trailer--Single--Brakes
    Given Create a Event-- SP
      | EquipmentType | EquipmentProvider | TruckDispatch |
      | Trailer       | AutoTruck         | AutoTruck TD  |
    When Enter Service details
      | EquipmentType | System | Assembly              | Component              | Position | WorkAccomplished | Reason                 |
      | Trailer       | Brakes | Brake Master Cylinder | Boot - Master Cylinder | Center   | Adjust           | Abuse Caused by Driver |
    And Get Event information from -- SP
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | SP         | Submitted | Dashboard |
      | Single     | SP         | Submitted | EventInfo |

  @RegressionTest
  Scenario: 08 Create a SP Event--trailer--Multiple--Brakes and Axles-Front
    Given Create a Event-- SP
      | EquipmentType | EquipmentProvider | TruckDispatch |
      | Trailer       | AutoTruck         | AutoTruck TD  |
    When Enter Service details
      | EquipmentType | System           | Assembly             | Component            | Position           | WorkAccomplished   | Reason                 |
      | Trailer       | Frame            | Cab & Body Mountings | Air Line - Cab Mount | Center             | Adjust             | Abuse Caused by Driver |
      | Trailer       | Electrical Group | Electrical Group     | Electrical Group     | Bottom/Lower Outer | Charge / Discharge | Abuse of Equipment     |
    And Get Event information from -- SP
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | SP         | Submitted | Dashboard |
      | Single     | SP         | Submitted | EventInfo |
