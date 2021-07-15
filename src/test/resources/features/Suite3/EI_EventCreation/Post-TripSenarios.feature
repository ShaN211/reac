Feature: Equipment inspection PostTrip scenarios
  This feature verifies all combinations of equipment inspection event creation functionality

  @RegressionTest
  Scenario: 01 Create a IE Event  -- Post-Trip  -- All good
    Given Create a EI event-- TD
      | EquipmentType | EquipmentProvider | EquipmentInspection |
      | Chassis       | AutoTruck         | Post-Trip            |
    And Select Inspection status-- Good to Travel
      | Inspection Categories                                              | Status |
      | Air line connections, hoses, and couplers                          | good   |
      | Brakes                                                             | good   |
      | King pin upper coupling device                                     | good   |
      | Lighting devices, lamps, markers, and conspicuity marking material | good   |
      | Locking pins, clevises, clamps, or hooks                           | good   |
      | Rails or support frames                                            | good   |
      | Sliders or sliding frame lock                                      | good   |
      | Tie down bolsters                                                  | good   |
      | Wheels, rims, lugs, tires                                          | good   |
      | Other                                                              | good   |
    And New Event popup-- No
    Then Verify EI eventinfo

  Scenario: 02 Create a IE Event  -- Post-Trip  -- All good -- New Event yes
    Given Create a EI event-- TD
      | EquipmentType | EquipmentProvider | EquipmentInspection |
      | Chassis       | AutoTruck         | Post-Trip              |
    And Select Inspection status-- Good to Travel
      | Inspection Categories                                              | Status |
      | Air line connections, hoses, and couplers                          | good   |
      | Brakes                                                             | good   |
      | King pin upper coupling device                                     | good   |
      | Lighting devices, lamps, markers, and conspicuity marking material | good   |
      | Locking pins, clevises, clamps, or hooks                           | good   |
      | Rails or support frames                                            | good   |
      | Sliders or sliding frame lock                                      | good   |
      | Tie down bolsters                                                  | good   |
      | Wheels, rims, lugs, tires                                          | good   |
      | Other                                                              | good   |
    And New Event popup-- Yes
    Then Verify EI eventinfo

  @RegressionTest
  Scenario: 03 Create a IE Event  -- Post-Trip  -- defect -- Not safe to drive
    Given Create a EI event-- TD
      | EquipmentType | EquipmentProvider | EquipmentInspection |
      | Chassis       | AutoTruck         | Post-Trip              |
    And Select Inspection status-- NotGood to Travel
      | Inspection Categories                                              | Status |
      | Air line connections, hoses, and couplers                          | good   |
      | Brakes                                                             | defect |
      | King pin upper coupling device                                     | good   |
      | Lighting devices, lamps, markers, and conspicuity marking material | good   |
      | Locking pins, clevises, clamps, or hooks                           | good   |
      | Rails or support frames                                            | good   |
      | Sliders or sliding frame lock                                      | good   |
      | Tie down bolsters                                                  | good   |
      | Wheels, rims, lugs, tires                                          | good   |
      | Other                                                              | good   |
    And New Event popup-- No
    Then Verify EI eventinfo
    And Get DVIR dashboard info
    And Verify DVIR dashboard
      | DVIR status | Equipment Status |
      | Review      | Review           |

  @RegressionTest
  Scenario: 04 Create a IE Event  -- Post-Trip  -- defect -- safe to drive
    Given Create a EI event-- TD
      | EquipmentType | EquipmentProvider | EquipmentInspection |
      | Chassis       | AutoTruck         | Post-Trip              |
    And Select Inspection status-- Good to Travel
      | Inspection Categories                                              | Status |
      | Air line connections, hoses, and couplers                          | good   |
      | Brakes                                                             | defect |
      | King pin upper coupling device                                     | good   |
      | Lighting devices, lamps, markers, and conspicuity marking material | good   |
      | Locking pins, clevises, clamps, or hooks                           | good   |
      | Rails or support frames                                            | good   |
      | Sliders or sliding frame lock                                      | good   |
      | Tie down bolsters                                                  | good   |
      | Wheels, rims, lugs, tires                                          | good   |
      | Other                                                              | good   |
    And New Event popup-- No
    Then Verify EI eventinfo

  @RegressionTest
  Scenario: 05 Create a IE Event  -- Post-Trip  -- defect -- Not safe to drive -- Create service event
    Given Create a EI event-- TD
      | EquipmentType | EquipmentProvider | EquipmentInspection |
      | Chassis       | AutoTruck         | Post-Trip              |
    And Select Inspection status-- NotGood to Travel
      | Inspection Categories                                              | Status |
      | Air line connections, hoses, and couplers                          | good   |
      | Brakes                                                             | defect |
      | King pin upper coupling device                                     | good   |
      | Lighting devices, lamps, markers, and conspicuity marking material | good   |
      | Locking pins, clevises, clamps, or hooks                           | good   |
      | Rails or support frames                                            | good   |
      | Sliders or sliding frame lock                                      | good   |
      | Tie down bolsters                                                  | good   |
      | Wheels, rims, lugs, tires                                          | good   |
      | Other                                                              | good   |
    And New Event popup-- No
    Then Verify EI eventinfo
    And Create a service event
    And Verify Service event data
