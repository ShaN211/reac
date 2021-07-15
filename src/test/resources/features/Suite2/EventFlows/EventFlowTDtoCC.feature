Feature: Event Flow TD to CC
  This feature verifies end to end Flow of a Event

  @RegressionTest @SmokeTest @Sanity
  Scenario: 01 Event From TD to CC --(TD to CC)--Single ServiceLine--Accept--Completed--Approve
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
    And Assign TD event to -- AutoTruck CC -- Payment Method - Yes
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
    And Complete Event -- In CC
    Then Get Event information from -- CC
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | TD         | Completed | Dashboard |
      | Single     | CC         | Completed | Dashboard |
      | Single     | TD         | Completed | EventInfo |
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
  Scenario: 02 Event From from TD to CC -- DSP(TD to CC)--Multiple Service line--Reject
    Given Create a Event-- TD
      | EquipmentType | EquipmentProvider |
      | Trailer       | AutoTruck         |
    When Enter Service details
      | EquipmentType | System        | Assembly             | Component              | Position           | WorkAccomplished   | Reason                 |
      | Trailer       | Frame         | Cab & Body Mountings | Air Line - Cab Mount   | Center             | Adjust             | Abuse Caused by Driver |
      | Trailer       | Axles - Front | Axles - Front        | Axles - Front Steering | Bottom/Lower Outer | Charge / Discharge | Abuse of Equipment     |
    Then Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | TD         | Open   | Dashboard |
      | Single     | TD         | Open   | EventInfo |
    And Assign TD event to -- AutoTruck CC  -- Payment Method - Yes
    And Get Event information from -- CC
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | TD         | Submitted | Dashboard |
      | Single     | TD         | Submitted | EventInfo |
      | Single     | CC         | Submitted | Dashboard |
      | Single     | CC         | Submitted | EventInfo |
    And Reject Event -- In CC
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status   | Page      |
      | Single     | TD         | Rejected | Dashboard |

  @RegressionTest
  Scenario: 03 Event From from TD to CC -- DSP(TD to CC)--Single Service line--Accept--Reprocess
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
    And Get Event information from -- CC
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | TD         | Submitted | Dashboard |
      | Single     | TD         | Submitted | EventInfo |
      | Single     | CC         | Submitted | Dashboard |
      | Single     | CC         | Submitted | EventInfo |
    And Accept Event -- In CC
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status            | Page      |
      | Single     | TD         | In Process        | EventInfo |
      | Single     | TD         | In Process        | Dashboard |
      | Double     | CC         | In Process - Open | EventInfo |
    Then Get Event information from -- CC
    And Verify Event Status
      | StatusType | TenandType | Status            | Page      |
      | Single     | CC         | Open              | Dashboard |
      | Double     | CC         | In Process - Open | EventInfo |
    And Complete Event -- In CC
    And Get Event information from -- CC
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | CC         | Completed | Dashboard |
      | Single     | CC         | Completed | EventInfo |
      | Single     | TD         | Completed | Dashboard |
      | Single     | TD         | Completed | EventInfo |
    And Reprocess Event -- In TD
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status     | Page      |
      | Single     | CC         | In Process | Dashboard |
      | Single     | CC         | In Process | EventInfo |
      | Single     | TD         | In Process | Dashboard |
      | Single     | TD         | In Process | EventInfo |
