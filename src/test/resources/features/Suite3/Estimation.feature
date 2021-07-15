@RegressionTest
Feature: Estimation functionality


      
  Scenario: 01 Estimation scenario -- auto approval
      Given Create a Event-- TD
      | EquipmentType | EquipmentProvider |
      | Chassis       | AutoTruck TD        |
    When Enter Service details
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | TD         | Open   | Dashboard |
      | Single     | TD         | Open   | EventInfo |
    And Assign TD event to -- AutoTruck SP2  -- Payment Method - Yes
    And Get Event information from -- SP2
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | TD         | Submitted | Dashboard |
      | Single     | TD         | Submitted | EventInfo |
      | Single     | SP2        | Submitted | Dashboard |
      | Single     | SP2        | Submitted | EventInfo |
    And Estimate Event -- In SP2
    And Get Event information from -- SP2
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | SP2        | Estimating| EventInfo |
    And Prepare estimate
      | Estimate     | Amount |
      | Discount     | 	0			|
      | Taxable      | 	0			|
      | NonTaxable   | 	0			|
      | Tax 				 | 10     |
      | Parts 			 | 10			|
      | Labor				 | 10			|
      | Oil					 | 10			|
      | NewTires		 | 10			|
      | UsedTires		 | 10			|
      | TradeIn			 | 	0			|
      | Sublet			 | 10			|
      | RoadCall		 | 10			|
      | EnvWasteTax  | 10 		|
    And Get Event information from -- SP2
    And Verify Event Status
      | StatusType | TenandType | Status           | Page      |
      | Single     | SP2        | Estimate Approved| EventInfo |
    And Accept Event -- In SP2
    And Get Event information from -- SP2
    And Verify Event Status
      | StatusType | TenandType | Status     | Page      |
      | Single     | SP2        | In Process | Dashboard |
      | Single     | SP2        | In Process | EventInfo |
      | Single     | TD         | In Process | Dashboard |
      | Single     | TD         | In Process | EventInfo |
    And Complete Event -- In SP2
    And Get Event information from -- SP2
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | SP2        | Completed | Dashboard |
      | Single     | SP2        | Completed | EventInfo |
      | Single     | TD         | Completed | Dashboard |
      | Single     | TD         | Completed | EventInfo |
    And Approve Event -- In TD
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status   | Page      |
      | Single     | SP2        | Approved | Dashboard |
      | Single     | SP2        | Approved | EventInfo |
      | Single     | TD         | Approved | Dashboard |
      | Single     | TD         | Approved | EventInfo |
      
      
   Scenario: 02 Estimation scenario -- approval from fleet
    Given Create a Event-- TD
      | EquipmentType | EquipmentProvider |
      | Chassis       | AutoTruck TD        |
    When Enter Service details
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | TD         | Open   | Dashboard |
      | Single     | TD         | Open   | EventInfo |
    And Assign TD event to -- AutoTruck SP2  -- Payment Method - Yes
    And Get Event information from -- SP2
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | TD         | Submitted | Dashboard |
      | Single     | TD         | Submitted | EventInfo |
      | Single     | SP2         | Submitted | Dashboard |
      | Single     | SP2         | Submitted | EventInfo |
    And Estimate Event -- In SP2
    And Get Event information from -- SP2
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | SP2        | Estimating| EventInfo |
    And Prepare estimate
      | Estimate     | Amount |
      | Discount     | 	0			|
      | Taxable      | 	0			|
      | NonTaxable   | 	0			|
      | Tax 				 | 10     |
      | Parts 			 | 100		|
      | Labor				 | 100		|
      | Oil					 | 100		|
      | NewTires		 | 100		|
      | UsedTires		 | 100		|
      | TradeIn			 | 	0			|
      | Sublet			 | 100		|
      | RoadCall		 | 100		|
      | EnvWasteTax  | 100 		|
    And Verify Event Status
      | StatusType | TenandType | Status   | Page      |
      | Single     | SP2        | Estimated| EventInfo |
    And ApproveEstimate Event -- In TD
    And Verify Event Status
      | StatusType | TenandType | Status            | Page      |
      | Single     | SP2        | Estimate Approved | EventInfo |
    And Accept Event -- In SP2
    And Get Event information from -- SP2
    And Verify Event Status
      | StatusType | TenandType | Status     | Page      |
      | Single     | SP2        | In Process | Dashboard |
      | Single     | SP2        | In Process | EventInfo |
      | Single     | TD         | In Process | Dashboard |
      | Single     | TD         | In Process | EventInfo |
    And Complete Event -- In SP2
    And Get Event information from -- SP2
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | SP2        | Completed | Dashboard |
      | Single     | SP2        | Completed | EventInfo |
      | Single     | TD         | Completed | Dashboard |
      | Single     | TD         | Completed | EventInfo |
    And Approve Event -- In TD
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status   | Page      |
      | Single     | SP2        | Approved | Dashboard |
      | Single     | SP2        | Approved | EventInfo |
      | Single     | TD         | Approved | Dashboard |
      | Single     | TD         | Approved | EventInfo |
      
   Scenario: 03 Estimation scenario -- Discount calculation
      Given Create a Event-- TD
      | EquipmentType | EquipmentProvider |
      | Chassis       | AutoTruck TD        |
    When Enter Service details
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | TD         | Open   | Dashboard |
      | Single     | TD         | Open   | EventInfo |
    And Assign TD event to -- AutoTruck SP2  -- Payment Method - Yes
    And Get Event information from -- SP2
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | TD         | Submitted | Dashboard |
      | Single     | TD         | Submitted | EventInfo |
      | Single     | SP2         | Submitted | Dashboard |
      | Single     | SP2         | Submitted | EventInfo |
    And Estimate Event -- In SP2
    And Get Event information from -- SP2
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | SP2        | Estimating| EventInfo |
    And Prepare estimate
      | Estimate     | Amount |
      | Discount     | 	50		|
      | Taxable      | 	20		|
      | NonTaxable   | 	15		|
      | Tax 				 | 10     |
      | Parts 			 | 100		|
      | Labor				 | 100		|
      | Oil					 | 100		|
      | NewTires		 | 100		|
      | UsedTires		 | 100		|
      | TradeIn			 | 	15		|
      | Sublet			 | 100		|
      | RoadCall		 | 100		|
      | EnvWasteTax  | 100 		|
    And Verify Event Status
      | StatusType | TenandType | Status   | Page      |
      | Single     | SP2        | Estimated| EventInfo |
      
    Scenario: 04 Estimation scenario -- reject estimate from fleet
      Given Create a Event-- TD
      | EquipmentType | EquipmentProvider |
      | Chassis       | AutoTruck TD        |
    When Enter Service details
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | TD         | Open   | Dashboard |
      | Single     | TD         | Open   | EventInfo |
    And Assign TD event to -- AutoTruck SP2  -- Payment Method - Yes
    And Get Event information from -- SP2
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | TD         | Submitted | Dashboard |
      | Single     | TD         | Submitted | EventInfo |
      | Single     | SP2         | Submitted | Dashboard |
      | Single     | SP2         | Submitted | EventInfo |
    And Estimate Event -- In SP2
    And Get Event information from -- SP2
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | SP2        | Estimating| EventInfo |
    And Prepare estimate
      | Estimate     | Amount |
      | Discount     | 	0			|
      | Taxable      | 	0			|
      | NonTaxable   | 	0			|
      | Tax 				 | 100    |
      | Parts 			 | 100		|
      | Labor				 | 100		|
      | Oil					 | 100		|
      | NewTires		 | 100		|
      | UsedTires		 | 100		|
      | TradeIn			 | 	0			|
      | Sublet			 | 100		|
      | RoadCall		 | 100		|
      | EnvWasteTax  | 100 		|
    And Verify Event Status
      | StatusType | TenandType | Status   | Page      |
      | Single     | SP2        | Estimated| EventInfo |
    And RejectEstimate Event -- In TD
    And Get Event information from -- SP2
    And Verify Event Status
      | StatusType | TenandType | Status            | Page      |
      | Single     | SP2        | Estimate Rejected | EventInfo |
    And Prepare estimate
      | Estimate     | Amount |
      | Discount     | 	0			|
      | Taxable      | 	0			|
      | NonTaxable   | 	0			|
      | Tax 				 | 100    |
      | Parts 			 | 100		|
      | Labor				 | 100		|
      | Oil					 | 100		|
      | NewTires		 | 100		|
      | UsedTires		 | 150		|
      | TradeIn			 | 	0			|
      | Sublet			 | 100		|
      | RoadCall		 | 100		|
      | EnvWasteTax  | 100 		|
    And Verify Event Status
      | StatusType | TenandType | Status   | Page      |
      | Single     | SP2        | Estimated| EventInfo |
    And ApproveEstimate Event -- In TD
    And Verify Event Status
      | StatusType | TenandType | Status            | Page      |
      | Single     | SP2        | Estimate Approved | EventInfo |
    And Accept Event -- In SP2
    And Get Event information from -- SP2
    And Verify Event Status
      | StatusType | TenandType | Status     | Page      |
      | Single     | SP2        | In Process | Dashboard |
      | Single     | SP2        | In Process | EventInfo |
      | Single     | TD         | In Process | Dashboard |
      | Single     | TD         | In Process | EventInfo |
    And Complete Event -- In SP2
    And Get Event information from -- SP2
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | SP2        | Completed | Dashboard |
      | Single     | SP2        | Completed | EventInfo |
      | Single     | TD         | Completed | Dashboard |
      | Single     | TD         | Completed | EventInfo |
    And Approve Event -- In TD
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status   | Page      |
      | Single     | SP2        | Approved | Dashboard |
      | Single     | SP2        | Approved | EventInfo |
      | Single     | TD         | Approved | Dashboard |
      | Single     | TD         | Approved | EventInfo |
    
    