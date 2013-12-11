Recording and storing points
					 
Scenario: When you add 2 Blue points to the scoreboard, the blue score increases by 2 points.
Given a scoreboard
When you add 2 BLUE points
Then the blue points should increase by 2
And the red points should stay the same.

Scenario: When you add 2 red points to the scoreboard, the red score increases by 2 points.
Given a scoreboard
When you add 2 RED points
Then the red points should increase by 2
And the blue points should stay the same.

