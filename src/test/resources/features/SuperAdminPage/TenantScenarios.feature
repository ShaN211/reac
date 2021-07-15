Feature: Tenant creation 
	This feature verifies all combinations of Tenant creation functionality
 
Scenario: 01 Create a tenant -- Truck Dispatch 
	Given SuperAdmin login 
	Given Create a tenant 
		|TenantType    |NonParticipating|
		|TD			   |False           |
	Then Verify if tenant is created 
	