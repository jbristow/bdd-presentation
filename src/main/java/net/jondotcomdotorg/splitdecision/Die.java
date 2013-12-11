package net.jondotcomdotorg.splitdecision;

public class Die {

	private Integer value;
	private final DieColor color;

	public Die(DieColor color) {
		this.color = color;
	}

	public Die(DieColor color, int value) {
		this.color = color;
		this.value = Integer.valueOf(value);
	}

	public DieColor getColor() {
		return color;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

}
