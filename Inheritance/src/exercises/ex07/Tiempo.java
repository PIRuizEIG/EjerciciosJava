package exercises.ex07;

public class Tiempo {
	private int hours;
	private int minutes;
	private int seconds;

	public Tiempo(int hours, int minutes, int seconds) {
		var newSeconds = toSeconds(hours, minutes, seconds);
		this.hours = newSeconds / 3600;
		this.minutes = (newSeconds % 3600) / 60;
		this.seconds = newSeconds % 60;
	}

	public void suma(int hours, int minutes, int seconds) {
		var tmp = fromSeconds(toSeconds(this) + toSeconds(new Tiempo(hours, minutes, seconds)));
		this.hours = tmp.hours;
		this.minutes = tmp.minutes;
		this.seconds = tmp.seconds;
	}

	public void resta(int hours, int minutes, int seconds) {
		var tmp = fromSeconds(toSeconds(this) - toSeconds(new Tiempo(hours, minutes, seconds)));
		this.hours = tmp.hours;
		this.minutes = tmp.minutes;
		this.seconds = tmp.seconds;
	}
	
	public void suma(Tiempo other) {
		var tmp = fromSeconds(toSeconds(this) + toSeconds(other));
		this.hours = tmp.hours;
		this.minutes = tmp.minutes;
		this.seconds = tmp.seconds;
	}
	
	public void resta(Tiempo other) {
		var tmp = fromSeconds(toSeconds(this) - toSeconds(other));
		this.hours = tmp.hours;
		this.minutes = tmp.minutes;
		this.seconds = tmp.seconds;
	}
	
	public void suma(int seconds) {
		var tmp = fromSeconds(toSeconds(this) + seconds);
		this.hours = tmp.hours;
		this.minutes = tmp.minutes;
		this.seconds = tmp.seconds;
	}
	
	public void resta(int seconds) {
		var tmp = fromSeconds(toSeconds(this) - seconds);
		this.hours = tmp.hours;
		this.minutes = tmp.minutes;
		this.seconds = tmp.seconds;
	}

	@Override
	public String toString() {
		return String.format("%dh %dm %ds", hours, minutes, seconds);
	}

	public static int toSeconds(Tiempo tmp) {
		return tmp.hours * 3600 + tmp.minutes * 60 + tmp.seconds;
	}

	public static int toSeconds(int hours, int minutes, int seconds) {
		return hours * 3600 + minutes * 60 + seconds;
	}

	public static Tiempo fromSeconds(int seconds) {
		int newHours = seconds / 3600;
		int newMinutes = (seconds % 3600) / 60;
		int newSeconds = seconds % 60;
		return new Tiempo(newHours, newMinutes, newSeconds);
	}
}
