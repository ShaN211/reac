Feature: Event Creation from TD using Advance search
  This feature verifies all combinations of event creation functionality
      
  @RegressionTest @SmokeTest @Sanity
  Scenario: 01 Create a TD Event--AD search - Create
    Given Create an Event using AdvanceSearch-- TD
      | EquipmentType | EquipmentProviderType | EquipmentProvider |
      | Chassis       | Create                |                   |
    When Enter Service details
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | TD         | Open   | Dashboard |
      | Single     | TD         | Open   | EventInfo |
      
      
  @RegressionTest @SmokeTest @Sanity
  Scenario: 02 Create a TD Event--AD search - Search
    Given Create an Event using AdvanceSearch-- TD
      | EquipmentType | EquipmentProviderType | EquipmentProvider |
      | Chassis       | Search                | Autotruck TD      |
    When Enter Service details
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | TD         | Open   | Dashboard |
      | Single     | TD         | Open   | EventInfo |
      
  @test @RegressionTest @SmokeTest @Sanity
  Scenario: 03 Create a TD Event--AD search - Walkin
    Given Create an Event using AdvanceSearch-- TD
      | EquipmentType | EquipmentProviderType | EquipmentProvider |
      | Chassis       | Walkin                |                   |
    When Enter Service details
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | TD         | Open   | Dashboard |
      | Single     | TD         | Open   | EventInfo |
      
  @RegressionTest
  Scenario: 04 Create a TD Event--AD search - Create
    Given Create an Event using AdvanceSearch-- TD
      | EquipmentType | EquipmentProviderType | EquipmentProvider |
      | Power Unit       | Create             |                   |
     When Enter Service details
      | EquipmentType | System     | Assembly            | Component             | Position | WorkAccomplished | Reason      |
      | Power Unit    | suspension | Air ride suspension | Air Cylinder Assembly | circular | Balance          | accessories |
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | TD         | Open   | Dashboard |
      | Single     | TD         | Open   | EventInfo |
      
      
  @RegressionTest
  Scenario: 05 Create a TD Event--AD search - Search
    Given Create an Event using AdvanceSearch-- TD
      | EquipmentType | EquipmentProviderType | EquipmentProvider |
      | Power Unit    | Search                | Autotruck TD      |
    When Enter Service details
      | EquipmentType | System     | Assembly            | Component             | Position | WorkAccomplished | Reason      |
      | Power Unit    | suspension | Air ride suspension | Air Cylinder Assembly | circular | Balance          | accessories |
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | TD         | Open   | Dashboard |
      | Single     | TD         | Open   | EventInfo |
      
  @test @RegressionTest
  Scenario: 06 Create a TD Event--AD search - Walkin
    Given Create an Event using AdvanceSearch-- TD
      | EquipmentType | EquipmentProviderType | EquipmentProvider |
      | Power Unit    | Walkin                |                   |
    When Enter Service details
      | EquipmentType | System     | Assembly            | Component             | Position | WorkAccomplished | Reason      |
      | Power Unit    | suspension | Air ride suspension | Air Cylinder Assembly | circular | Balance          | accessories |
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | TD         | Open   | Dashboard |
      | Single     | TD         | Open   | EventInfo |
      
      
   @RegressionTest
  Scenario: 07 Create a TD Event--AD search - Create
    Given Create an Event using AdvanceSearch-- TD
      | EquipmentType | EquipmentProviderType | EquipmentProvider |
      | Container       | Create             |                   |
    When Enter Service details
      | EquipmentType | System | SubSystem | Service             | Defect    | Location |
      | Container     | Door   | Door Sill | RearDoorSill - Weld | Cut, Torn | Rear     |
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | TD         | Open   | Dashboard |
      | Single     | TD         | Open   | EventInfo |
      
      
  @RegressionTest
  Scenario: 08 Create a TD Event--AD search - Search
    Given Create an Event using AdvanceSearch-- TD
      | EquipmentType | EquipmentProviderType | EquipmentProvider |
      | Container    | Search                | Autotruck TD      |
   When Enter Service details
      | EquipmentType | System | SubSystem | Service             | Defect    | Location |
      | Container     | Door   | Door Sill | RearDoorSill - Weld | Cut, Torn | Rear     |
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | TD         | Open   | Dashboard |
      | Single     | TD         | Open   | EventInfo |
      
  @test @RegressionTest
  Scenario: 09 Create a TD Event--AD search - Walkin
    Given Create an Event using AdvanceSearch-- TD
      | EquipmentType | EquipmentProviderType | EquipmentProvider |
      | Container    | Walkin                |                   |
   When Enter Service details
      | EquipmentType | System | SubSystem | Service             | Defect    | Location |
      | Container     | Door   | Door Sill | RearDoorSill - Weld | Cut, Torn | Rear     |
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | TD         | Open   | Dashboard |
      | Single     | TD         | Open   | EventInfo |
      
      
  @RegressionTest
  Scenario: 10 Create a TD Event--AD search - Create
    Given Create an Event using AdvanceSearch-- TD
      | EquipmentType | EquipmentProviderType | EquipmentProvider |
      | Trailer       | Create             |                   |
    When Enter Service details
      | EquipmentType | System | Assembly | Component | Position | WorkAccomplished | Reason                 |
      | Trailer       |    071 |      000 |       000 | Center   | Adjust           | Abuse Caused by Driver |
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | TD         | Open   | Dashboard |
      | Single     | TD         | Open   | EventInfo |
      
      
  @RegressionTest
  Scenario: 08 Create a TD Event--AD search - Search
    Given Create an Event using AdvanceSearch-- TD
      | EquipmentType | EquipmentProviderType | EquipmentProvider |
      | Trailer       | Search                | Autotruck TD      |
    When Enter Service details
      | EquipmentType | System | Assembly | Component | Position | WorkAccomplished | Reason                 |
      | Trailer       |    071 |      000 |       000 | Center   | Adjust           | Abuse Caused by Driver |
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | TD         | Open   | Dashboard |
      | Single     | TD         | Open   | EventInfo |
      
  @test @RegressionTest
  Scenario: 09 Create a TD Event--AD search - Walkin
    Given Create an Event using AdvanceSearch-- TD
      | EquipmentType | EquipmentProviderType | EquipmentProvider |
      | Trailer       | Walkin                |                   |
    When Enter Service details
      | EquipmentType | System | Assembly | Component | Position | WorkAccomplished | Reason                 |
      | Trailer       |    071 |      000 |       000 | Center   | Adjust           | Abuse Caused by Driver |
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | TD         | Open   | Dashboard |
      | Single     | TD         | Open   | EventInfo |
      
      
      
      