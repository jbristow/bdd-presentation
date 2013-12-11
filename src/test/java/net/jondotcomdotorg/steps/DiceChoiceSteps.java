package net.jondotcomdotorg.steps;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.extractProperty;

import java.util.List;

import net.jondotcomdotorg.splitdecision.DiceChoice;
import net.jondotcomdotorg.splitdecision.Die;
import net.jondotcomdotorg.splitdecision.DieColor;
import net.jondotcomdotorg.splitdecision.Point;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class DiceChoiceSteps {
	private DiceChoice choice;
	private List<Point> points;

	@Given("a choice of dice")
	public void diceChoice() {
		choice = new DiceChoice();
	}

	@Given("die $which is colored $color")
	public void addDie(String which, DieColor color) {
		if ("A".equals(which)) {
			choice.setDie1(new Die(color));
		} else if ("B".equals(which)) {
			choice.setDie2(new Die(color));
		}
	}

	@When("die $which has the value $value")
	public void addDie(String which, int value) {
		if ("A".equals(which)) {
			choice.getDie1().setValue(value);
		} else if ("B".equals(which)) {
			choice.getDie2().setValue(value);
		}
	}

	@When("you calculate the choice's points")
	public void calculatePoints() {
		points = choice.getPointValue();
	}

	@Then("you should score only $number $color.")
	public void shouldHavePoints(int number, DieColor color) {

		assertThat(extractProperty("color").from(points)).containsOnly(color);
		assertThat(extractProperty("points").from(points)).containsOnly(
				Integer.valueOf(number));
	}

	@Then("you should score both $numberA $colorA and $numberB $colorB.")
	public void shouldHavePoints(int numberA, DieColor colorA, int numberB,
			DieColor colorB) {
		assertThat(extractProperty("color").from(points)).containsOnly(colorA,
				colorB);
		assertThat(extractProperty("points").from(points)).containsOnly(
				Integer.valueOf(numberA), Integer.valueOf(numberB));
	}

}
