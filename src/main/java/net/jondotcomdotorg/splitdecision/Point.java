package net.jondotcomdotorg.splitdecision;


public class Point {
	private Integer points;
	private DieColor color;

	public Point(int points, DieColor color) {
		this.points = Integer.valueOf(points);
		this.color = color;
	}

	public DieColor getColor() {
		return color;
	}

	public void setColor(DieColor color) {
		this.color = color;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	@Override
	public String toString() {
		return "Points [points=" + points + ", color=" + color + "]";
	}

}
