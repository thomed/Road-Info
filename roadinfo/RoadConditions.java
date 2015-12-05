package roadinfo;

public class RoadConditions {

	String roadName;
	String surface;
	String restrictions;
	String weather;
	String updated;

	/**
	 * Creates an object that represents a road and information related to the
	 * driving conditions.
	 * 
	 * @param name
	 *            The name of the road.
	 * @param s
	 *            The condition of the road's surface.
	 * @param w
	 *            Current weather/preciptiation experienced in the canyon.
	 * @param r
	 *            The current restrictions of the road.
	 */
	public RoadConditions(String name, String s, String w, String r, String u) {
		roadName = name;
		surface = s;
		restrictions = r;
		weather = w;
		updated = u;
	}

	/**
	 * Getter method for the name of the road
	 * 
	 * @return A String of the road's name
	 */
	public String getName() {
		return roadName;
	}

	/**
	 * Getter method for the status of the road surface
	 * 
	 * @return A String representing the status of the road surface.
	 */
	public String getSurface() {
		return surface;
	}

	/**
	 * Getter method for vehicle restrictions on the road.
	 * 
	 * @return A String representing the current vehicle restrictions on the
	 *         road.
	 */
	public String getRestrictions() {
		return restrictions;
	}

	@Override
	public String toString() {
		return String
				.format("%s%n\tSurface: %s%n\tWeather: %s%n\tRestrictions: %s%n\tLast Updated: %s%n ",
						roadName, surface, weather, restrictions, updated);
	}
}
