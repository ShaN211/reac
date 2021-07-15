Feature: Tech Status feature
  This feature verifies all combinations of tech status functionality
  
 Scenario: 01 Event From from TD to SP -- SCTech(TD to SC to SCTech)--Single Service line--Accept--Assign Tech--Tech Accept--Tech Enroute--Tech Arrived--Tech Repaired--Completed--Approved
 
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
      
     And AssignTech Event -- In SP
     And Get Event information from -- SP
     And Verify Event Status
      | StatusType | TenandType | Status     | Page      |
      | Single     | SP         | In Process | Dashboard |
      | Single     | SP         | In Process | EventInfo |
      | Single     | TD         | In Process | Dashboard |
      | Single     | TD         | In Process | EventInfo |
     And Verify Tech Status
      |TenandType | Status     | Page      |
      |SP         | Assigned   | Dashboard |
      |SP         | Assigned   | EventInfo | 
     	|TD         | Assigned   | Dashboard |
      |TD         | Assigned   | EventInfo |
     	
   
    Given Logout as -- SP
    Given Login as -- SCTech
    
    And TechAccept Event -- In SCTech
    And Get Event information from -- SCTech
    And Verify Event Status
      | StatusType | TenandType| Status     | Page      |
      | Single     | SCTech    | In Process | Dashboard |
      | Single     | SCTech    | In Process | EventInfo |
      | Single     | TD        | In Process | Dashboard |
      | Single     | TD        | In Process | EventInfo |
    And Verify Tech Status
      |TenandType | Status     | Page      |
      |SP         | Accepted   | Dashboard |
      |SP         | Accepted   | EventInfo | 
     	|TD         | Accepted   | Dashboard |
      |TD         | Accepted   | EventInfo |	
      
    And Enroute Event -- In SCTech
    And Get Event information from -- SCTech
    And Verify Event Status
      | StatusType | TenandType| Status     | Page      |
      | Single     | SCTech    | In Process | Dashboard |
      | Single     | SCTech    | In Process | EventInfo |
      | Single     | TD        | In Process | Dashboard |
      | Single     | TD        | In Process | EventInfo |
    And Verify Tech Status
      |TenandType | Status    | Page      |
      |SP         | En Route  | Dashboard |
      |SP         | En Route  | EventInfo |
     	|TD         | En Route  | Dashboard |
      |TD         | En Route  | EventInfo |	 
      
    And TechArrive Event -- In SCTech
    And Get Event information from -- SCTech
    And Verify Event Status
      | StatusType | TenandType| Status     | Page      |
      | Single     | SCTech    | In Process | Dashboard |
      | Single     | SCTech    | In Process | EventInfo |
      | Single     | TD        | In Process | Dashboard |
      | Single     | TD        | In Process | EventInfo |
    And Verify Tech Status
      |TenandType | Status    | Page      |
      |SP         | Arrived   | Dashboard |
      |SP         | Arrived   | EventInfo |
     	|TD         | Arrived   | Dashboard |
      |TD         | Arrived   | EventInfo |	 
    	
    And TechRepair Event -- In SCTech
    And Get Event information from -- SCTech
    And Verify Event Status
      | StatusType | TenandType | Status   | Page      |
      | Single     | SCTech     | Repaired | Dashboard |
      | Single     | SCTech     | Repaired | EventInfo |
      | Single     | TD         | Repaired | Dashnboard|
      | Single     | TD         | Repaired | EventInfo |
      
    Given Logout as -- SCTech
    Given Login as -- SP

    And Get Event information from -- SP   
    And Complete Event -- In SP
    And Get Event information from -- SP
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | SP         | Completed | Dashboard |
      | Single     | SP         | Completed | EventInfo |
      | Single     | TD         | Completed | Dashboard |
      | Single     | TD         | Completed | EventInfo |
    And Verify Tech Status
     |TenandType | Status     | Page       | 
     |SP         | Repaired   | Dashboard  |
     |SP         | Repaired   | EvenTtInfo |
      
    And Approve Event -- In TD
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status   | Page      |
      | Single     | TD         | Approved | Dashboard |
      | Single     | SP         | Approved | Dashboard |
      | Single     | TD         | Approved | EventInfo |
      | Single     | SP         | Approved | EventInfo |
  And Verify Tech Status
     |TenandType | Status     | Page       | 
     |SP         | Repaired   | Dashboard  |
     |SP         | Repaired   | EvenTtInfo |
   
 Scenario: 02 Event From from TD to SP -- SCTech(TD to SC to SCTech)--Single Service line--Accept--Assign Tech--Tech Accept--Tech Enroute--Tech Decline--Completed--Approved
 
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
      
     And AssignTech Event -- In SP
     And Get Event information from -- SP
     And Verify Event Status
      | StatusType | TenandType | Status     | Page      |
      | Single     | SP         | In Process | Dashboard |
      | Single     | SP         | In Process | EventInfo |
      | Single     | TD         | In Process | Dashboard |
      | Single     | TD         | In Process | EventInfo |
     And Verify Tech Status
      |TenandType | Status     | Page      |
      |SP         | Assigned   | Dashboard |
      |SP         | Assigned   | EventInfo | 
     	|TD         | Assigned   | Dashboard |
      |TD         | Assigned   | EventInfo |
     	
   
    Given Logout as -- SP
    Given Login as -- SCTech
    
    And TechAccept Event -- In SCTech
    And Get Event information from -- SCTech
    And Verify Event Status
      | StatusType | TenandType| Status     | Page      |
      | Single     | SCTech    | In Process | Dashboard |
      | Single     | SCTech    | In Process | EventInfo |
      | Single     | TD        | In Process | Dashboard |
      | Single     | TD        | In Process | EventInfo |
    And Verify Tech Status
      |TenandType | Status     | Page      |
      |SP         | Accepted   | Dashboard |
      |SP         | Accepted   | EventInfo | 
     	|TD         | Accepted   | Dashboard |
      |TD         | Accepted   | EventInfo |	
    And Enroute Event -- In SCTech
    And Get Event information from -- SCTech
    And Verify Event Status
      | StatusType | TenandType| Status     | Page      |
      | Single     | SCTech    | In Process | Dashboard |
      | Single     | SCTech    | In Process | EventInfo |
      | Single     | TD        | In Process | Dashboard |
      | Single     | TD        | In Process | EventInfo |
    And Verify Tech Status
      |TenandType | Status    | Page      |
      |SP         | En Route  | Dashboard |
      |SP         | En Route  | EventInfo |
     	|TD         | En Route  | Dashboard |
      |TD         | En Route  | EventInfo |	 
      
    And TechDecline Event -- In SCTech
    
    Given Logout as -- SCTech
    Given Login as -- SP
    And Get Event information from -- SP
    And Verify Event Status
      | StatusType | TenandType| Status     | Page      |
      | Single     | SCTech    | In Process | Dashboard |
      | Single     | SCTech    | In Process | EventInfo |
      | Single     | TD        | In Process | Dashboard |
      | Single     | TD        | In Process | EventInfo |
    And Verify Tech Status
      |TenandType | Status    | Page      |
      |SP         | Declined  | Dashboard |
      |SP         | Declined  | EventInfo |
     	|TD         | Declined  | Dashboard |
      |TD         | Declined  | EventInfo |	 
  	And Reject Event -- In SP
    And Get Event information from -- SP
    And Verify Event Status
      | StatusType | TenandType | Status   | Page      |
      | Single     | SP         | Rejected | Dashboard |
      | Single     | SP         | Rejected | EventInfo |
      | Single     | TD         | Rejected | Dashboard |
      | Single     | TD         | Rejected | EventInfo |
   And Verify Tech Status
      |TenandType | Status    | Page      |
      |SP         | Declined  | Dashboard |
      |SP         | Declined  | EventInfo |
    
    