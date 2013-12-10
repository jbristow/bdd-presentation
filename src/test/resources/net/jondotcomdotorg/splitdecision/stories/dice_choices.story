Feature: Scoring Rules for Die Choice					 

Scenario: If you kept two red dice, record two red points.
Given a choice of dice
And die A is RED
And die B is RED
When you calculate the choice's points
Then you should score 2 RED points.

Scenario: If you kept two blue dice, record two blue points.
Given a choice of dice
And die A is BLUE
And die B is BLUE
When you calculate the choice's points
Then you should score 2 BLUE points.
