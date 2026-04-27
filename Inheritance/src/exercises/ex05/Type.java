package exercises.ex05;

public enum Type {
	MARGARITA("margarita"), CUATRO_QUESOS("cuatro quesos"), FUNGHI("funghi");

	private String displayName;

	Type(String displayName) {
		this.displayName = displayName;
	}

	public String displayName() {
		return displayName;
	};

	@Override
	public String toString() {
		return displayName;
	}
}
