package net.jondotcomdotorg.splitdecision.steps;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.jondotcomdotorg.splitdecision.DieColor;
import net.jondotcomdotorg.splitdecision.Point;
import net.jondotcomdotorg.splitdecision.ScoreBoard;

import org.jbehave.core.annotations.AsParameterConverter;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class RecordPointsSteps {
	private ScoreBoard scoreboard;
	private int startingBlue;
	private int startingRed;

	@Given("a scoreboard")
	public void givenAScoreboard() {
		scoreboard = new ScoreBoard();
		startingBlue = scoreboard.getBlue();
		startingRed = scoreboard.getRed();
	}

	@When("you add $points points")
	public void youAddXPoints(Point point) {
		scoreboard.add(point);
	}

	@Then("the blue points should increase by $value")
	public void theBluePointsShouldIncrease(int value) {
		assertThat(scoreboard.getBlue()).isEqualTo(startingBlue + value);
	}

	@Then("the red points should stay the same.")
	public void theRedPointsShouldStayTheSame() {
		assertThat(scoreboard.getRed()).isEqualTo(startingRed);
	}

	@Then("the red points should increase by $value")
	public void theRedPointsShouldIncrease(int value) {
		assertThat(scoreboard.getRed()).isEqualTo(startingRed + value);
	}

	@Then("the blue points should stay the same.")
	public void theBluePointsShouldStayTheSame() {
		assertThat(scoreboard.getBlue()).isEqualTo(startingBlue);
	}

	@AsParameterConverter
	public Point getPoints(String input) {
		Pattern pattern = Pattern.compile("(\\d+) (\\w+)");
		Matcher matcher = pattern.matcher(input);

		if (matcher.find()) {
			return new Point(Integer.valueOf(matcher.group(1)),
					DieColor.valueOf(matcher.group(2).toUpperCase()));
		} else {
			throw new IllegalArgumentException(input
					+ " is not able to be converted to points.");
		}

	}
}
