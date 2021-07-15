Feature: Equipment inspection DVIR scenarios
  This feature verifies all combinations of DVIR functionality

  @RegressionTest
  Scenario: 01 DVIR - Good
    Given Create a EI event-- TD
      | EquipmentType | EquipmentProvider | EquipmentInspection |
      | Chassis       | AutoTruck         | Post-Trip           |
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
    And Change equipment status -- Good
    And Get DVIR dashboard info
    And Verify DVIR dashboard
      | DVIR status | Equipment Status |
      | Closed      | Good             |

  @RegressionTest
  Scenario: 02 DVIR - Defect
    Given Create a EI event-- TD
      | EquipmentType | EquipmentProvider | EquipmentInspection |
      | Chassis       | AutoTruck         | Post-Trip           |
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
    And Change equipment status -- Defect
    And Get DVIR dashboard info
    And Verify DVIR dashboard
      | DVIR status | Equipment Status |
      | Pending     | Defect           |

  @RegressionTest
  Scenario: 03 DVIR - Defer
    Given Create a EI event-- TD
      | EquipmentType | EquipmentProvider | EquipmentInspection |
      | Chassis       | AutoTruck         | Post-Trip           |
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
    And Change equipment status -- Defer
    And Get DVIR dashboard info
    And Verify DVIR dashboard
      | DVIR status | Equipment Status |
      | Closed      | Deferred         |
