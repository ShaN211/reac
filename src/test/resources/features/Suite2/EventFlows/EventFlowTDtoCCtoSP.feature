Feature: Event Flow between TD to CC to SP

  @RegressionTest @SmokeTest @Sanity
  Scenario: 01 Event From TD to CC --(TD to CC to Sp)--Single ServiceLine--Accept--Completed--Approve
    Given Create a Event-- TD
      | EquipmentType | EquipmentProvider |
      | Power Unit    | AutoTruck         |
    When Enter Service details
      | EquipmentType | System | Assembly | Component | Position     | WorkAccomplished | Reason |
      | Power Unit    |    016 |      007 |       009 | Front Center |              002 |    031 |
    Then Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | TD         | Open   | Dashboard |
      | Single     | TD         | Open   | EventInfo |
    And Assign TD event to -- AutoTruck CC  -- Payment Method - Yes
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
    And Assign TD event to -- AutoTruck SP  -- Payment Method - No
    Then Get Event information from -- CC
    And Verify Event Status
      | StatusType | TenandType | Status                 | Page      |
      | Single     | SP         | Submitted              | Dashboard |
      | Single     | CC         | Submitted              | Dashboard |
      | Double     | SP         | In Process - Submitted | EventInfo |
      | Double     | CC         | In Process - Submitted | EventInfo |
    And Accept Event -- In SP
    Then Get Event information from -- SP
    And Verify Event Status
      | StatusType | TenandType | Status                  | Page      |
      | Single     | SP         | In Process              | Dashboard |
      | Single     | CC         | In Process              | Dashboard |
      | Double     | SP         | In Process - In Process | EventInfo |
      | Double     | CC         | In Process - In Process | EventInfo |
    And Complete Event -- In SP
    Then Get Event information from -- SP
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | SP         | Completed | Dashboard |
      | Single     | CC         | Completed | Dashboard |
      | Single     | SP         | Completed | EventInfo |
      | Single     | CC         | Completed | EventInfo |
    And Approve Event -- In TD
    Then Get Event information from -- CC
    And Verify Event Status
      | StatusType | TenandType | Status   | Page      |
      | Single     | TD         | Approved | Dashboard |
      | Single     | CC         | Approved | Dashboard |
      | Single     | TD         | Approved | EventInfo |
      | Single     | CC         | Approved | EventInfo |

Scenario: 02 Event From TD to CC --(TD to CC to Sp)--Single ServiceLine--Accept--Repaired--Completed--Approve
    Given Create a Event-- TD
      | EquipmentType | EquipmentProvider |
      | Power Unit    | AutoTruck         |
    When Enter Service details
      | EquipmentType | System | Assembly | Component | Position     | WorkAccomplished | Reason |
      | Power Unit    |    016 |      007 |       009 | Front Center |              002 |    031 |
    Then Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | TD         | Open   | Dashboard |
      | Single     | TD         | Open   | EventInfo |
    And Assign TD event to -- AutoTruck CC  -- Payment Method - Yes
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
    And Assign TD event to -- AutoTruck SP  -- Payment Method - No
    Then Get Event information from -- CC
    And Verify Event Status
      | StatusType | TenandType | Status                 | Page      |
      | Single     | SP         | Submitted              | Dashboard |
      | Single     | CC         | Submitted              | Dashboard |
      | Double     | SP         | In Process - Submitted | EventInfo |
      | Double     | CC         | In Process - Submitted | EventInfo |
    And Accept Event -- In SP
    Then Get Event information from -- SP
    And Verify Event Status
      | StatusType | TenandType | Status                  | Page      |
      | Single     | SP         | In Process              | Dashboard |
      | Single     | CC         | In Process              | Dashboard |
      | Double     | SP         | In Process - In Process | EventInfo |
      | Double     | CC         | In Process - In Process | EventInfo |  
    And Repaire Event -- In SP
    Then Get Event information from -- SP
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | SP         | Repaired  | Dashboard |
      | Single     | CC         | Repaired  | Dashboard |
      | Single     | SP         | Repaired  | EventInfo |
      | Single     | CC         | Repaired  | EventInfo |  
    And Complete Event -- In SP
    Then Get Event information from -- SP
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | SP         | Completed | Dashboard |
      | Single     | CC         | Completed | Dashboard |
      | Single     | SP         | Completed | EventInfo |
      | Single     | CC         | Completed | EventInfo |
    And Approve Event -- In TD
    Then Get Event information from -- CC
    And Verify Event Status
      | StatusType | TenandType | Status   | Page      |
      | Single     | TD         | Approved | Dashboard |
      | Single     | CC         | Approved | Dashboard |
      | Single     | TD         | Approved | EventInfo |
      | Single     | CC         | Approved | EventInfo |
      
  @RegressionTest
  Scenario: 03 Event From TD to CC --(TD to CC to Sp)--Single ServiceLine--Accept--Completed--Approve
    Given Create a Event-- TD
      | EquipmentType | EquipmentProvider |
      | Chassis       | AutoTruck         |
    When Enter Service details
      | EquipmentType | System | SubSystem | Service                  | Defect   | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Worn Out | Front    |
    Then Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | TD         | Open   | Dashboard |
      | Single     | TD         | Open   | EventInfo |
    And Assign TD event to -- AutoTruck CC  -- Payment Method - Yes
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
    And Assign TD event to -- AutoTruck SP  -- Payment Method - No
    Then Get Event information from -- SP
    And Verify Event Status
      | StatusType | TenandType | Status                 | Page      |
      | Single     | SP         | Submitted              | Dashboard |
      | Double     | SP         | In Process - Submitted | EventInfo |
    Then Get Event information from -- CC
    And Verify Event Status
      | StatusType | TenandType | Status                 | Page      |
      | Double     | CC         | In Process - Submitted | EventInfo |
      | Single     | CC         | Submitted              | Dashboard |
    And Reject Event -- In SP
    Then Get Event information from -- SP
    And Verify Event Status
      | StatusType | TenandType | Status                | Page      |
      | Single     | SP         | Rejected              | Dashboard |
      | Single     | CC         | Rejected              | Dashboard |
      | Double     | SP         | In Process - Rejected | EventInfo |
      | Double     | CC         | In Process - Rejected | EventInfo |
