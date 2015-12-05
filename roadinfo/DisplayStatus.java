package roadinfo;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Used for quickly getting the road conditions of Little Cottonwood Canyon so
 * that I don't have to go through the arduous process of opening my web browser
 * and navigating to the commuterlink website then scrolling past dozens
 * of other roads that I don't care about. Helpful during ski season when I
 * check this information whenever it's snowing and I want to go skiing.
 * 
 * @author Thomas Walker
 *
 */
public class DisplayStatus {

	static URL commuterlink;
	static Scanner in;
	static String[] info;
	static List<String> infoList;
	static String currentLine;
	static ArrayList<RoadConditions> conditions;

	public static void main(String[] args) {
		conditions = new ArrayList<>();

		// pulls html from the commuter link road information website and places
		// information in scanner
		try {
			commuterlink = new URL(
					"http://511.commuterlink.utah.gov/tats.web.report/");
			in = new Scanner(commuterlink.openStream());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (java.net.UnknownHostException e) {
			System.err.println("Check your connection");
		} catch (IOException e) {
			e.printStackTrace();
		}

		// searches the html table data for roads leading to snowbird (little
		// cottonwood canyon) and constructs RoadCondition objects with data
		while (in.hasNextLine()) {
			currentLine = in.nextLine();
			if (currentLine.contains("Little Cottonwood")) {
				info = currentLine.split("<td>|</td>");
				infoList = Arrays.asList(info);

				conditions.add(new RoadConditions(infoList.get(1), infoList
						.get(5), infoList.get(7), infoList.get(9), infoList
						.get(infoList.size() - 1)));

			}
		}

		// prints the information to the console
		for (RoadConditions rc : conditions) {
			System.out.println(rc.toString());
		}

	}
}
