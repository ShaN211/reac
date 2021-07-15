Feature: NPSP event flow
  This feature verifies all combinations of npsp flow functionality

  @RegressionTest @SmokeTest @Sanity
  Scenario: 01 Verify NPSP Event flow Assign -- Accept -- Complete -- Approve
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
    And Assign TD event to -- AutoTruckNPSP -- Payment Method - No
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | TD         | Submitted | EventInfo |
      | Single     | TD         | Submitted | Dashboard |
    And Accept Event -- In TD
    Then Get Event information from -- TD
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
    Then Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | TD         | Completed | EventInfo |
      | Single     | TD         | Completed | Dashboard |
    And Approve Event -- In TD
    Then Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status   | Page      |
      | Single     | TD         | Approved | EventInfo |
      | Single     | TD         | Approved | Dashboard |

  @RegressionTest
  Scenario: 02 Verify NPSP Event flow Assign -- Reject
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
    And Assign TD event to -- AutoTruckNPSP -- Payment Method - No
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | TD         | Submitted | EventInfo |
      | Single     | TD         | Submitted | Dashboard |
    And Reject Event -- In TD
    Then Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status   | Page      |
      | Single     | TD         | Rejected | EventInfo |
      | Single     | TD         | Rejected | Dashboard |

  @RegressionTest
  Scenario: 03 Verify NPSP Event flow Assign -- Accept -- Rejected
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
    And Assign TD event to -- AutoTruckNPSP -- Payment Method - No
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | TD         | Submitted | EventInfo |
      | Single     | TD         | Submitted | Dashboard |
    And Accept Event -- In TD
    Then Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status     | Page      |
      | Single     | TD         | In Process | EventInfo |
      | Single     | TD         | In Process | Dashboard |
    And Reject Event -- In TD
    Then Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status   | Page      |
      | Single     | TD         | Rejected | EventInfo |
      | Single     | TD         | Rejected | Dashboard |

  @RegressionTest
  Scenario: 04 Verify NPSP Event flow Assign -- Accept -- Complete -- Reprocess -- Complete -- Approve
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
    And Assign TD event to -- AutoTruckNPSP -- Payment Method - No
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | TD         | Submitted | EventInfo |
      | Single     | TD         | Submitted | Dashboard |
    And Accept Event -- In TD
    Then Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status     | Page      |
      | Single     | TD         | In Process | EventInfo |
      | Single     | TD         | In Process | Dashboard |
    And Complete Event -- In TD
    Then Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | TD         | Completed | EventInfo |
      | Single     | TD         | Completed | Dashboard |
    And Reprocess Event -- In TD
    Then Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status     | Page      |
      | Single     | TD         | In Process | EventInfo |
      | Single     | TD         | In Process | Dashboard |
    And Complete Event -- In TD
    Then Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | TD         | Completed | EventInfo |
      | Single     | TD         | Completed | Dashboard |
    And Approve Event -- In TD
    Then Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status   | Page      |
      | Single     | TD         | Approved | EventInfo |
      | Single     | TD         | Approved | Dashboard |

  @RegressionTest
  Scenario: 05 Verify NPSP Event flow Assign -- Accept -- Complete -- Reprocess -- Reject
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
    And Assign TD event to -- AutoTruckNPSP -- Payment Method - No
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | TD         | Submitted | EventInfo |
      | Single     | TD         | Submitted | Dashboard |
    And Accept Event -- In TD
    Then Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status     | Page      |
      | Single     | TD         | In Process | EventInfo |
      | Single     | TD         | In Process | Dashboard |
    And Complete Event -- In TD
    Then Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | TD         | Completed | EventInfo |
      | Single     | TD         | Completed | Dashboard |
    And Reprocess Event -- In TD
    Then Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status     | Page      |
      | Single     | TD         | In Process | EventInfo |
      | Single     | TD         | In Process | Dashboard |
    And Reject Event -- In TD
    Then Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status   | Page      |
      | Single     | TD         | Rejected | EventInfo |

  @RegressionTest
  Scenario: 06 Verify NPSP Event flow Assign -- Accept -- Repaired-- Complete -- Approve
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
    And Assign TD event to -- AutoTruckNPSP -- Payment Method - No
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | TD         | Submitted | EventInfo |
      | Single     | TD         | Submitted | Dashboard |
    And Accept Event -- In TD
    Then Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status     | Page      |
      | Single     | TD         | In Process | EventInfo |
      | Single     | TD         | In Process | Dashboard |
    And Complete Event -- In TD
    Then Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | TD         | Completed | EventInfo |
      | Single     | TD         | Completed | Dashboard |
    And Approve Event -- In TD
    Then Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status   | Page      |
      | Single     | TD         | Approved | EventInfo |
      | Single     | TD         | Approved | Dashboard |
      | Single     | TD         | Approved | Dashboard |
