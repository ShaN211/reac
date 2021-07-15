Feature: Event Flow between TD to SP

  @RegressionTest @SmokeTest @Sanity
  Scenario: 01 Event From from TD to SP -- DSP(TD to SC)--Single Service line--Accept--Completed--Approve
    Given Create a Event-- TD
      | EquipmentType | EquipmentProvider |
      | Power Unit    | AutoTruck         |
    When Enter Service details
      | EquipmentType | System | Assembly        | Component             | Position     | WorkAccomplished | Reason                 |
      | Power Unit    | Brakes | Electric Brakes | Electric Brakes (EBS) | Front Center | Adjust           | Abuse Caused by Driver |
    Then Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | TD         | Open   | Dashboard |
      | Single     | TD         | Open   | EventInfo |
    And Assign TD event to -- AutoTruck SP  -- Payment Method - Yes
    And Get Event information from -- SP
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | TD         | Submitted | Dashboard |
      | Single     | TD         | Submitted | EventInfo |
      | Single     | SP         | Submitted | Dashboard |
      | Single     | SP         | Submitted | EventInfo |
    And Accept Event -- In SP
    And Get Event information from -- SP
    And Verify Event Status
      | StatusType | TenandType | Status     | Page      |
      | Single     | SP         | In Process | Dashboard |
      | Single     | SP         | In Process | EventInfo |
      | Single     | TD         | In Process | Dashboard |
      | Single     | TD         | In Process | EventInfo |
    And Complete Event -- In SP
    And Get Event information from -- SP
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | SP         | Completed | Dashboard |
      | Single     | SP         | Completed | EventInfo |
      | Single     | TD         | Completed | Dashboard |
      | Single     | TD         | Completed | EventInfo |
    And Approve Event -- In TD
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status   | Page      |
      | Single     | SP         | Approved | Dashboard |
      | Single     | SP         | Approved | EventInfo |
      | Single     | TD         | Approved | Dashboard |
      | Single     | TD         | Approved | EventInfo |

  @RegressionTest
  Scenario: 02 Event From from TD to SP -- DSP(TD to SC)--Single Service line--Reject
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
    And Assign TD event to -- AutoTruck SP  -- Payment Method - Yes
    And Get Event information from -- SP
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | TD         | Submitted | Dashboard |
      | Single     | TD         | Submitted | EventInfo |
      | Single     | SP         | Submitted | Dashboard |
      | Single     | SP         | Submitted | EventInfo |
    And Reject Event -- In SP
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status   | Page      |
      | Single     | TD         | Rejected | Dashboard |

  @RegressionTest
  Scenario: 03 Event From from TD to SP -- DSP(TD to SC)--Single Service line--Accept--Repaired--Completed--Approve
    Given Create a Event-- TD
      | EquipmentType | EquipmentProvider |
      | Power Unit    | AutoTruck         |
    When Enter Service details
      | EquipmentType | System | Assembly        | Component             | Position     | WorkAccomplished | Reason                 |
      | Power Unit    | Brakes | Electric Brakes | Electric Brakes (EBS) | Front Center | Adjust           | Abuse Caused by Driver |
    Then Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | TD         | Open   | Dashboard |
      | Single     | TD         | Open   | EventInfo |
    And Assign TD event to -- AutoTruck SP  -- Payment Method - Yes
    And Get Event information from -- SP
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | TD         | Submitted | Dashboard |
      | Single     | TD         | Submitted | EventInfo |
      | Single     | SP         | Submitted | Dashboard |
      | Single     | SP         | Submitted | EventInfo |
    And Accept Event -- In SP
    And Get Event information from -- SP
    And Verify Event Status
      | StatusType | TenandType | Status     | Page      |
      | Single     | SP         | In Process | Dashboard |
      | Single     | SP         | In Process | EventInfo |
      | Single     | TD         | In Process | Dashboard |
      | Single     | TD         | In Process | EventInfo |
    And Repaire Event -- In SP
    And Get Event information from -- SP
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | SP         | Repaired  | Dashboard |
      | Single     | SP         | Repaired  | EventInfo |
      | Single     | TD         | Repaired  | Dashboard |
      | Single     | TD         | Repaired  | EventInfo |
    And Complete Event -- In SP
    And Get Event information from -- SP
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | SP         | Completed | Dashboard |
      | Single     | SP         | Completed | EventInfo |
      | Single     | TD         | Completed | Dashboard |
      | Single     | TD         | Completed | EventInfo |
    And Approve Event -- In TD
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status   | Page      |
      | Single     | SP         | Approved | Dashboard |
      | Single     | SP         | Approved | EventInfo |
      | Single     | TD         | Approved | Dashboard |
      | Single     | TD         | Approved | EventInfo |

  @RegressionTest
  Scenario: 04 Event From from TD to SP -- DSP(TD to SC)--Single Service line--Accept--Reprocess
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
    And Assign TD event to -- AutoTruck SP  -- Payment Method - Yes
    And Get Event information from -- SP
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | TD         | Submitted | Dashboard |
      | Single     | TD         | Submitted | EventInfo |
      | Single     | SP         | Submitted | Dashboard |
      | Single     | SP         | Submitted | EventInfo |
    And Accept Event -- In SP
    And Get Event information from -- SP
    And Verify Event Status
      | StatusType | TenandType | Status     | Page      |
      | Single     | SP         | In Process | Dashboard |
      | Single     | SP         | In Process | EventInfo |
      | Single     | TD         | In Process | Dashboard |
      | Single     | TD         | In Process | EventInfo |
    And Complete Event -- In SP
    And Get Event information from -- SP
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | SP         | Completed | Dashboard |
      | Single     | SP         | Completed | EventInfo |
      | Single     | TD         | Completed | Dashboard |
      | Single     | TD         | Completed | EventInfo |
    And Reprocess Event -- In TD
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status     | Page      |
      | Single     | SP         | In Process | Dashboard |
      | Single     | SP         | In Process | EventInfo |
      | Single     | TD         | In Process | Dashboard |
      | Single     | TD         | In Process | EventInfo |
