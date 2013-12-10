package net.jondotcomdotorg.splitdecision;

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

	public Points getPointValue() {
		if (die1.getColor() == die2.getColor()) {
			return new Points(2, die1.getColor());
		} else {
			return null;
		}
	}
}
