Feature: Testing the relocation logic
  Users should be able to relocate the items of an inventory

  Scenario: Move items to other location
  	Given an inventory with the following items
  	| item code | qty | location |
  	| item-1 		| 10 	| loc1  |
  	| item-2 		| 20 	| loc2  |
  	| item-3 		| 30 	| loc3  |
  	| item-4 		| 40 	| loc4  |
    When users relocate the following inventory to the location "loc5"
    | item code | qty | location |
  	| item-1 		| 10 	| loc1  |
    Then the expected inventory is the following
    | item code | qty | location |
  	| item-1 		| 10 	| loc5  |
  	| item-2 		| 20 	| loc2  |
  	| item-3 		| 30 	| loc3  |
  	| item-4 		| 40 	| loc4  |