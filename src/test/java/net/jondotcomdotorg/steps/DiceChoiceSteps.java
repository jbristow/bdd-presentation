package net.jondotcomdotorg.steps;

import static org.fest.assertions.api.Assertions.assertThat;
import net.jondotcomdotorg.splitdecision.DiceChoice;
import net.jondotcomdotorg.splitdecision.Die;
import net.jondotcomdotorg.splitdecision.DieColor;
import net.jondotcomdotorg.splitdecision.Points;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class DiceChoiceSteps {
	private DiceChoice choice;
	private Points points;

	@Given("a choice of dice")
	public void diceChoice() {
		choice = new DiceChoice();
	}

	@Given("die $which is $color")
	public void addRedDie(String which, DieColor color) {
		if ("A".equals(which)) {
			choice.setDie1(new Die(color));
		} else if ("B".equals(which)) {
			choice.setDie2(new Die(color));
		}
	}

	@When("you calculate the choice's points")
	public void calculatePoints() {
		points = choice.getPointValue();
	}

	@Then("you should score $number $color points.")
	public void shouldHavePoints(int number, DieColor color) {
		assertThat(points.getColor()).isEqualTo(color);
		assertThat(points.getPoints()).isEqualTo(number);
	}

}
