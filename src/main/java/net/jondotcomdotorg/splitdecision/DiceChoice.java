package net.jondotcomdotorg.splitdecision;

import java.util.Arrays;
import java.util.List;

public class DiceChoice {

	private Die die1;
	private Die die2;

	public Die getDie1() {
		return die1;
	}

	public void setDie1(Die die1) {
		this.die1 = die1;
	}

	public Die getDie2() {
		return die2;
	}

	public void setDie2(Die die2) {
		this.die2 = die2;
	}

	public List<Point> getPointValue() {
		if (die1.getColor() == die2.getColor()) {
			return Arrays.asList(new Point(2, die1.getColor()));
		} else if (die1.getValue() > die2.getValue()) {
			return Arrays.asList(new Point(1, die1.getColor()));
		} else if (die1.getValue() < die2.getValue()) {
			return Arrays.asList(new Point(1, die2.getColor()));
		} else {
			return Arrays.asList(new Point(1, die1.getColor()), new Point(1,
					die2.getColor()));
		}
	}
}
