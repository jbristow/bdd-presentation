package net.jondotcomdotorg.splitdecision;

public class Die {

	private Integer value;
	private final DieColor color;

	public Die(DieColor color) {
		this.color = color;
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
