@RegressionTest
Feature: Payment functionality

  Scenario: 01 Event From AMAZON to CC --(AMAZON to CC to Sp)--Single ServiceLine--Accept--Repaired--Completed--Approve
    Given Create a Event-- Amazon
      | EquipmentType | EquipmentProvider |
      | Power Unit    | AutoTruck         |
    When Enter Service details
      | EquipmentType | System | Assembly | Component | Position     | WorkAccomplished | Reason |
      | Power Unit    |    016 |      007 |       009 | Front Center |              002 |    031 |
    Then Get Event information from -- AMAZON
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | AMAZON         | Open   | Dashboard |
      | Single     | AMAZON         | Open   | EventInfo |
    And Assign Amazon event to -- AutoTruck CC  -- Payment Method - Yes
    Then Get Event information from -- CC
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | AMAZON         | Submitted | Dashboard |
      | Single     | CC         | Submitted | Dashboard |
      | Single     | AMAZON         | Submitted | EventInfo |
      | Single     | CC         | Submitted | EventInfo |
    And Accept Event -- In CC
    Then Get Event information from -- AMAZON
    And Verify Event Status
      | StatusType | TenandType | Status            | Page      |
      | Single     | AMAZON         | In Process        | Dashboard |
      | Single     | AMAZON         | In Process        | EventInfo |
      | Double     | CC         | In Process - Open | EventInfo |
    Then Get Event information from -- CC
    And Verify Event Status
      | StatusType | TenandType | Status            | Page      |
      | Single     | CC         | Open              | Dashboard |
      | Double     | CC         | In Process - Open | EventInfo |
    And Assign Amazon event to -- AutoTruck SP  -- Payment Method - No
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
      | StatusType | TenandType | Status   | Page      |
      | Single     | SP         | Repaired | Dashboard |
      | Single     | CC         | Repaired | Dashboard |
      | Single     | SP         | Repaired | EventInfo |
      | Single     | CC         | Repaired | EventInfo |
    And Complete Event -- In SP
    Then Get Event information from -- SP
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | SP         | Completed | Dashboard |
      | Single     | CC         | Completed | Dashboard |
      | Single     | SP         | Completed | EventInfo |
      | Single     | CC         | Completed | EventInfo |
    And Approve Event -- In AMAZON
    Then Get Event information from -- CC
    And Verify Event Status
      | StatusType | TenandType | Status   | Page      |
      | Single     | AMAZON         | Approved | Dashboard |
      | Single     | CC         | Approved | Dashboard |
      | Single     | AMAZON         | Approved | EventInfo |
      | Single     | CC         | Approved | EventInfo |

  @RegressionTest
  Scenario: 02 Event From from AMAZON to SP -- DSP(AMAZON to SC)--Single Service line--Accept--Repaired--Completed--Approve
    Given Create a Event-- Amazon
      | EquipmentType | EquipmentProvider |
      | Power Unit    | AutoTruck         |
    When Enter Service details
      | EquipmentType | System | Assembly        | Component             | Position     | WorkAccomplished | Reason                 |
      | Power Unit    | Brakes | Electric Brakes | Electric Brakes (EBS) | Front Center | Adjust           | Abuse Caused by Driver |
    Then Get Event information from -- AMAZON
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | AMAZON         | Open   | Dashboard |
      | Single     | AMAZON         | Open   | EventInfo |
    And Assign Amazon event to -- AutoTruck SP  -- Payment Method - Yes
    And Get Event information from -- SP
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | AMAZON         | Submitted | Dashboard |
      | Single     | AMAZON         | Submitted | EventInfo |
      | Single     | SP         | Submitted | Dashboard |
      | Single     | SP         | Submitted | EventInfo |
    And Accept Event -- In SP
    And Get Event information from -- SP
    And Verify Event Status
      | StatusType | TenandType | Status     | Page      |
      | Single     | SP         | In Process | Dashboard |
      | Single     | SP         | In Process | EventInfo |
      | Single     | AMAZON         | In Process | Dashboard |
      | Single     | AMAZON         | In Process | EventInfo |
    And Repaire Event -- In SP
    And Get Event information from -- SP
    And Verify Event Status
      | StatusType | TenandType | Status   | Page      |
      | Single     | SP         | Repaired | Dashboard |
      | Single     | SP         | Repaired | EventInfo |
      | Single     | AMAZON         | Repaired | Dashboard |
      | Single     | AMAZON         | Repaired | EventInfo |
    And Complete Event -- In SP
    And Get Event information from -- SP
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | SP         | Completed | Dashboard |
      | Single     | SP         | Completed | EventInfo |
      | Single     | AMAZON         | Completed | Dashboard |
      | Single     | AMAZON         | Completed | EventInfo |
    And Approve Event -- In AMAZON
    And Get Event information from -- AMAZON
    And Verify Event Status
      | StatusType | TenandType | Status   | Page      |
      | Single     | SP         | Approved | Dashboard |
      | Single     | SP         | Approved | EventInfo |
      | Single     | AMAZON         | Approved | Dashboard |
      | Single     | AMAZON         | Approved | EventInfo |

  Scenario: 03 Event From AMAZON to CC --(AMAZON to CC to Sp)--Single ServiceLine--Accept--Completed--Approve
    Given Create a Event-- Amazon
      | EquipmentType | EquipmentProvider |
      | Power Unit    | AutoTruck         |
    When Enter Service details
      | EquipmentType | System | Assembly | Component | Position     | WorkAccomplished | Reason |
      | Power Unit    |    016 |      007 |       009 | Front Center |              002 |    031 |
    Then Get Event information from -- Amazon
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | AMAZON     | Open   | Dashboard |
      | Single     | AMAZON     | Open   | EventInfo |
    And Assign Amazon event to -- AutoTruck CC  -- Payment Method - Yes
    Then Get Event information from -- CC
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | AMAZON     | Submitted | Dashboard |
      | Single     | CC         | Submitted | Dashboard |
      | Single     | AMAZON     | Submitted | EventInfo |
      | Single     | CC         | Submitted | EventInfo |
    And Accept Event -- In CC
    Then Get Event information from -- Amazon
    And Verify Event Status
      | StatusType | TenandType | Status            | Page      |
      | Single     | AMAZON     | In Process        | Dashboard |
      | Single     | AMAZON     | In Process        | EventInfo |
      | Double     | CC         | In Process - Open | EventInfo |
    Then Get Event information from -- CC
    And Verify Event Status
      | StatusType | TenandType | Status            | Page      |
      | Single     | CC         | Open              | Dashboard |
      | Double     | CC         | In Process - Open | EventInfo |
    And Assign CC event to -- AutoTruck SP  -- Payment Method - No
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
    And CompleteAmazon Event -- In SP
    Then Get Event information from -- SP
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | SP         | Completed | Dashboard |
      | Single     | CC         | Completed | Dashboard |
      | Single     | SP         | Completed | EventInfo |
      | Single     | CC         | Completed | EventInfo |
    And Approve Event -- In Amazon
    Then Get Event information from -- CC
    And Verify Event Status
      | StatusType | TenandType | Status   | Page      |
      | Single     | AMAZON     | Approved | Dashboard |
      | Single     | CC         | Approved | Dashboard |
      | Single     | AMAZON     | Approved | EventInfo |
      | Single     | CC         | Approved | EventInfo |
