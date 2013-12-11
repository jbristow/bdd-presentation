package net.jondotcomdotorg.splitdecision;

public class ScoreBoard {

	private int red;
	private int blue;

	public ScoreBoard() {
		red = 0;
		blue = 0;
	}

	public void add(Point point) {
		if (point.getColor() == DieColor.RED) {
			addRed(point.getPoints());
		} else if (point.getColor() == DieColor.BLUE) {
			addBlue(point.getPoints());
		}
	}

	private void addBlue(Integer points) {
		blue += points.intValue();
	}

	private void addRed(Integer points) {
		red += points.intValue();
	}

	public int getRed() {
		return red;
	}

	public void setRed(int red) {
		this.red = red;
	}

	public int getBlue() {
		return blue;
	}

	public void setBlue(int blue) {
		this.blue = blue;
	}

}
