Feature: Reject and Reassign SE feature
  This feature verifies all combinations of Reject SE and Reassign SE  functionality
  
 Scenario: 01 Event from TD to SP --(TD to SP)--Single Service line--Assign event--Accept Event--Reject event
 
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
    Then Get Event information from -- SP
    And Verify Event Status
      | StatusType | TenandType  | Status     | Page      |
      | Single     | TD          | In Process | Dashboard |
      | Single     | TD          | In Process | EventInfo |
      | Single     | SP          | In Process | Dashboard |
      | Single     | SP          | In Process | EventInfo |
    And Reject Event -- In SP
    And Get Event information from -- SP
    And Verify Event Status
      | StatusType | TenandType | Status     | Page      |
      | Single     | SP         | Rejected   | Dashboard |
      | Single     | SP         | Rejected   | EventInfo |
      | Single     | TD         | Rejected   | Dashboard |
      | Single     | TD         | Rejected   | EventInfo |
     
 Scenario: 02 Event from TD to SP2 to SP(TD to SP2(Reject) > TD to SP) --Single Service line--Assign--Reject--Assign--Accept--Complete--Approve
 
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
    And Assign TD event to -- AutoTruck SP2  -- Payment Method - Yes
    And Get Event information from -- SP2
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | TD         | Submitted | Dashboard |
      | Single     | TD         | Submitted | EventInfo |
      | Single     | SP2        | Submitted | Dashboard |
      | Single     | SP2        | Submitted | EventInfo |
    And Reject Event -- In SP2
    And Get Event information from -- SP2
    And Verify Event Status
      | StatusType | TenandType | Status     | Page      |
      | Single     | SP2        | Rejected   | Dashboard |
      | Single     | SP2        | Rejected   | EventInfo |
      | Single     | TD         | Rejected   | Dashboard |
      | Single     | TD         | Rejected   | EventInfo |
      
    And Assign TD event to -- AutoTruck SP  -- Payment Method - Yes
    And Get Event information from -- SP
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | TD         | Submitted | Dashboard |
      | Single     | TD         | Submitted | EventInfo |
      | Single     | SP         | Submitted | Dashboard |
      | Single     | SP         | Submitted | EventInfo |
      
    And Accept Event -- In SP
    Then Get Event information from -- SP
    And Verify Event Status
      | StatusType | TenandType | Status     | Page      |
      | Single     | TD         | In Process | Dashboard |
      | Single     | TD         | In Process | EventInfo |
      | Single     | SP         | In Process | Dashboard |
      | Single     | SP         | In Process | EventInfo |
    And Complete Event -- In SP
    Then Get Event information from -- SP
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | TD         | Completed | Dashboard |
      | Single     | SP         | Completed | Dashboard |
      | Single     | TD         | Completed | EventInfo |
      | Single     | SP         | Completed | EventInfo |
    And Approve Event -- In TD
    Then Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status   | Page      |
      | Single     | TD         | Approved | Dashboard |
      | Single     | SP         | Approved | Dashboard |
      | Single     | TD         | Approved | EventInfo |
      | Single     | SP         | Approved | EventInfo |
    And Get RejectedEvent information from -- SP2
    And Verify RejectedEvent Status
      | StatusType | TenandType | Status     | Page      |
      | Single     | SP2        | Rejected   | Dashboard |
      | Single     | SP2        | Rejected   | EventInfo |
          
Scenario: 03 Event from TD to SP2 to SP --(TD to SP2(no response)> TD to SP(reasssign)) --Single Service line--Assign to SP1--Assign to SP2--Accept--Complete--Approve

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
    And Assign TD event to -- AutoTruck SP2  -- Payment Method - Yes
    And Get Event information from -- SP2
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | SP2        | Submitted | Dashboard |
      | Single     | SP2        | Submitted | EventInfo |
      | Single     | TD         | Submitted | Dashboard |
      | Single     | TD         | Submitted | EventInfo |
      
    And Reassign TD event to -- AutoTruck SP  -- Payment Method - Yes
    And Get Event information from -- SP
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | TD         | Submitted | Dashboard |
      | Single     | TD         | Submitted | EventInfo |
      | Single     | SP         | Submitted | Dashboard |
      | Single     | SP         | Submitted | EventInfo |
    And Accept Event -- In SP
    Then Get Event information from -- SP
    And Verify Event Status
      | StatusType | TenandType | Status            | Page      |
      | Single     | SP         | In Process        | Dashboard |
      | Single     | SP         | In Process        | EventInfo |
      | Single     | TD         | In Process        | Dashboard |
      | Single     | TD         | In Process        | EventInfo | 
    And Complete Event -- In SP
    Then Get Event information from -- SP
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | TD         | Completed | Dashboard |
      | Single     | SP         | Completed | Dashboard |
      | Single     | TD         | Completed | EventInfo |
      | Single     | SP         | Completed | EventInfo |
    And Approve Event -- In TD
    Then Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status   | Page      |
      | Single     | TD         | Approved | Dashboard |
      | Single     | SP         | Approved | Dashboard |
      | Single     | TD         | Approved | EventInfo |
      | Single     | SP         | Approved | EventInfo |
     And Get ReassignedEvent information from -- SP2
     And Verify ReassignedEvent Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | SP2        | Reassigned| EventInfo |
    	| Single     | SP2			  | Reassigned| Dashboard |

Scenario: 04 Event from TD to SP2 to SP --(TD to SP2(In Process) > TD to SP(reassign)) Single Service line--Assign to SP1--Accept--In Process--Assign to SP2--Accept--Complete--Approve

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
    And Assign TD event to -- AutoTruck SP2  -- Payment Method - Yes
    And Get Event information from -- SP2
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | SP2        | Submitted | Dashboard |
      | Single     | SP2        | Submitted | EventInfo |
      | Single     | TD         | Submitted | Dashboard |
      | Single     | TD         | Submitted | EventInfo |
    And Accept Event -- In SP2
    Then Get Event information from -- SP2
    And Verify Event Status
      | StatusType | TenandType  | Status            | Page      |
      | Single     | SP2         | In Process        | Dashboard |
      | Single     | SP2         | In Process        | EventInfo |
      | Single     | TD          | In Process        | Dashboard |
      | Single     | TD          | In Process        | EventInfo |   
    And Reassign TD event to -- AutoTruck SP  -- Payment Method - Yes
    And Get Event information from -- SP
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | TD         | Submitted | Dashboard |
      | Single     | TD         | Submitted | EventInfo |
      | Single     | SP         | Submitted | Dashboard |
      | Single     | SP         | Submitted | EventInfo |
    And Accept Event -- In SP
    Then Get Event information from -- SP
    And Verify Event Status
      | StatusType | TenandType | Status            | Page      |
      | Single     | SP         | In Process        | Dashboard |
      | Single     | SP         | In Process        | EventInfo |
      | Single     | TD         | In Process        | Dashboard |
      | Single     | TD         | In Process        | EventInfo | 
    And Complete Event -- In SP
    Then Get Event information from -- SP
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | TD         | Completed | Dashboard |
      | Single     | SP         | Completed | Dashboard |
      | Single     | TD         | Completed | EventInfo |
      | Single     | SP         | Completed | EventInfo |
    And Approve Event -- In TD
    Then Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status   | Page      |
      | Single     | TD         | Approved | Dashboard |
      | Single     | SP         | Approved | Dashboard |
      | Single     | TD         | Approved | EventInfo |
      | Single     | SP         | Approved | EventInfo |
     And Get ReassignedEvent information from -- SP2
     And Verify ReassignedEvent Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | SP2        | Reassigned| EventInfo |
      | Single     | SP2	    | Reassigned| Dashboard |
    	