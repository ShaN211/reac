Feature: Out of Network flow for TD and CC
  This feature verifies Out of Network Flow of a Event

  @RegressionTest @SmokeTest @Sanity
  Scenario: 01 Out of Network for TD -- Single Service Line-- Brakes-- Accept -- Complete -- Approve
    Given Create a Event-- TD
      | EquipmentType | EquipmentProvider |
      | Chassis       | AutoTruck         |
    When Enter Service details
      | EquipmentType | System | SubSystem | Service                  | Defect   | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Worn Out | Front    |
    Then Assign event to outofNetwork -- TD  -- Payment Method - Yes
    Then Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | TD         | Submitted | Dashboard |
      | Single     | TD         | Submitted | EventInfo |
    And Accept Event -- In TD
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status     | Page      |
      | Single     | TD         | In Process | EventInfo |
      | Single     | TD         | In Process | Dashboard |
    And Complete Event -- In TD
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | TD         | Completed | EventInfo |
      | Single     | TD         | Completed | Dashboard |
    And Approve Event -- In TD
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status   | Page      |
      | Single     | TD         | Approved | EventInfo |
      | Single     | TD         | Approved | Dashboard |

  @RegressionTest
  Scenario: 02 Out of Network for TD -- Multiple Service Line-- Brakes and Tire-- Accept -- Complete -- Approve
    Given Create a Event-- TD
      | EquipmentType | EquipmentProvider |
      | Power Unit    | AutoTruck         |
    When Enter Service details
      | EquipmentType | System     | Assembly            | Component             | Position | WorkAccomplished | Reason      |
      | Power Unit    | suspension | Air ride suspension | Air Cylinder Assembly | circular | Balance          | accessories |
      | Power Unit    |        001 |                 001 |                   201 | circular | Balance          | accessories |
    Then Assign event to outofNetwork -- TD  -- Payment Method - Yes
    Then Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | TD         | Submitted | Dashboard |
      | Single     | TD         | Submitted | EventInfo |
    And Accept Event -- In TD
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status     | Page      |
      | Single     | TD         | In Process | EventInfo |
      | Single     | TD         | In Process | Dashboard |
    And Complete Event -- In TD
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | TD         | Completed | EventInfo |
      | Single     | TD         | Completed | Dashboard |
    And Approve Event -- In TD
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status   | Page      |
      | Single     | TD         | Approved | EventInfo |
      | Single     | TD         | Approved | Dashboard |

  @RegressionTest
  Scenario: 03 Out of Network for CC -- Single Service Line-- Brakes-- Accept -- Complete -- Approve
    Given Create a Event-- CC
      | EquipmentType | EquipmentProvider | TruckDispatch |
      | Chassis       | AutoTruck         | AutoTruck TD  |
    When Enter Service details
      | EquipmentType | System | SubSystem | Service                  | Defect   | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Worn Out | Front    |
    Then Get Event information from -- CC
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | TD         | Submitted | Dashboard |
      | Single     | CC         | Submitted | Dashboard |
      | Single     | TD         | Submitted | EventInfo |
      | Single     | CC         | Submitted | EventInfo |
    And Accept Event -- In CC
    Then Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status            | Page      |
      | Single     | TD         | In Process        | Dashboard |
      | Single     | TD         | In Process        | EventInfo |
      | Double     | CC         | In Process - Open | EventInfo |
    Then Get Event information from -- CC
    And Verify Event Status
      | StatusType | TenandType | Status            | Page      |
      | Single     | CC         | Open              | Dashboard |
      | Double     | CC         | In Process - Open | EventInfo |
    Then Assign event to outofNetwork -- CC  -- Payment Method - No
    Then Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status                 | Page      |
      | Single     | TD         | In Process             | Dashboard |
      | Single     | TD         | In Process             | EventInfo |
      | Double     | CC         | In Process - Submitted | EventInfo |
    And Accept Event -- In CC
    Then Get Event information from -- CC
    And Verify Event Status
      | StatusType | TenandType | Status                  | Page      |
      | Single     | TD         | In Process              | Dashboard |
      | Single     | TD         | In Process              | EventInfo |
      | Double     | CC         | In Process - In Process | EventInfo |
    And Complete Event -- In CC
    And Get Event information from -- CC
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | CC         | Completed | EventInfo |
      | Single     | CC         | Completed | Dashboard |
    And Approve Event -- In TD
    And Get Event information from -- CC
    And Verify Event Status
      | StatusType | TenandType | Status   | Page      |
      | Single     | CC         | Approved | EventInfo |
      | Single     | CC         | Approved | Dashboard |

  @RegressionTest
  Scenario: 04 Out of Network for CC -- Multiple Service Line-- Brakes and Tire-- Accept -- Complete -- Approve
    Given Create a Event-- CC
      | EquipmentType | EquipmentProvider | TruckDispatch |
      | Chassis       | AutoTruck         | AutoTruck TD  |
    When Enter Service details
      | EquipmentType | System | SubSystem | Service                  | Defect   | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Worn Out | Front    |
      | Chassis       | Tire   | Flap      | Flap - Replace w/new     | Worn Out | Front    |
    Then Get Event information from -- CC
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | TD         | Submitted | Dashboard |
      | Single     | CC         | Submitted | Dashboard |
      | Single     | TD         | Submitted | EventInfo |
      | Single     | CC         | Submitted | EventInfo |
    And Accept Event -- In CC
    Then Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status            | Page      |
      | Single     | TD         | In Process        | Dashboard |
      | Single     | TD         | In Process        | EventInfo |
      | Double     | CC         | In Process - Open | EventInfo |
    Then Get Event information from -- CC
    And Verify Event Status
      | StatusType | TenandType | Status            | Page      |
      | Single     | CC         | Open              | Dashboard |
      | Double     | CC         | In Process - Open | EventInfo |
    Then Assign event to outofNetwork -- CC  -- Payment Method - No
    Then Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status                 | Page      |
      | Single     | TD         | In Process             | Dashboard |
      | Single     | TD         | In Process             | EventInfo |
      | Double     | CC         | In Process - Submitted | EventInfo |
    And Accept Event -- In CC
    Then Get Event information from -- CC
    And Verify Event Status
      | StatusType | TenandType | Status                  | Page      |
      | Single     | TD         | In Process              | Dashboard |
      | Single     | TD         | In Process              | EventInfo |
      | Double     | CC         | In Process - In Process | EventInfo |
    And Complete Event -- In CC
    And Get Event information from -- CC
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | CC         | Completed | EventInfo |
      | Single     | CC         | Completed | Dashboard |
    And Approve Event -- In TD
    And Get Event information from -- CC
    And Verify Event Status
      | StatusType | TenandType | Status   | Page      |
      | Single     | CC         | Approved | EventInfo |
      | Single     | CC         | Approved | Dashboard |

  @RegressionTest
  Scenario: 05 Out of Network for TD -- Single Service Line-- Brakes-- Accept --Repaired-- Complete -- Approve
    Given Create a Event-- TD
      | EquipmentType | EquipmentProvider |
      | Chassis       | AutoTruck         |
    When Enter Service details
      | EquipmentType | System | SubSystem | Service                  | Defect   | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Worn Out | Front    |
    Then Assign event to outofNetwork -- TD  -- Payment Method - Yes
    Then Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | TD         | Submitted | Dashboard |
      | Single     | TD         | Submitted | EventInfo |
    And Accept Event -- In TD
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status     | Page      |
      | Single     | TD         | In Process | EventInfo |
      | Single     | TD         | In Process | Dashboard |
    And Repaire Event -- In TD
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status   | Page      |
      | Single     | TD         | Repaired | EventInfo |
      | Single     | TD         | Repaired | Dashboard |
    And Complete Event -- In TD
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | TD         | Completed | EventInfo |
      | Single     | TD         | Completed | Dashboard |
    And Approve Event -- In TD
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status   | Page      |
      | Single     | TD         | Approved | EventInfo |
      | Single     | TD         | Approved | Dashboard |
