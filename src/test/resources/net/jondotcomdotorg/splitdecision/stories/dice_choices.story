Feature: Scoring Rules for Die Choice					 

Scenario: If you kept two red dice, record two red points.
Given a choice of dice
And die A is colored RED
And die B is colored RED
When you calculate the choice's points
Then you should score only 2 RED.

Scenario: If you kept two blue dice, record two blue points.
Given a choice of dice
And die A is colored BLUE
And die B is colored BLUE
When you calculate the choice's points
Then you should score only 2 BLUE.

Scenario: If you kept one red and one blue and red is higher, record one red point.
Given a choice of dice
And die A is colored RED
And die B is colored BLUE
When die A has the value 3
And die B has the value 2
And you calculate the choice's points
Then you should score only 1 RED.

Scenario: If you kept one red and one blue and blue is higher, record one blue point.
Given a choice of dice
And die A is colored RED
And die B is colored BLUE
When die A has the value 2
And die B has the value 3
And you calculate the choice's points
Then you should score only 1 BLUE.

Scenario: If you kept one red and one blue and they are tied, record one blue point and one red point.
Given a choice of dice
And die A is colored RED
And die B is colored BLUE
When die A has the value 5
And die B has the value 5
And you calculate the choice's points
Then you should score both 1 RED and 1 BLUE.
