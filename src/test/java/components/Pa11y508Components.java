package components;
import java.io.*;
public class Pa11y508Components {
	public static void test508Accessibilty(String url, String reportName) throws IOException {
		// String url = "";
		// String reportName = "C:\\report\\report439.csv";
		ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "pa11y " + url);
		builder.redirectErrorStream(true);
		Process p = builder.start();
		BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line;
		String errCode = "Error:";
		int count = 0;
		while (true) {
			line = r.readLine();
			if (line == null) {
				break;
			}
			 System.out.println(line);
			if (line.contains(errCode)) {
				count = count + 1;
			}
		}

		System.out.println(count);
		// System.out.println("Number of 508 issue found in test: "+count);
		if (count > 0) {
			System.out.println("508 test for " + url + " failed with " + count
					+ " errors! Detailed report available on: " + reportName);
			// generate508Report(url, reportName);
			System.out.println();
		} 
	}

	public static void generate508Report(String url, String reportName) throws IOException {

		ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "pa11y --reporter csv " + url + "> " + reportName);
		builder.redirectErrorStream(true);
		Process p = builder.start();
		BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line;
		while (true) {
			line = r.readLine();
			if (line == null) {
				break;
			}
			// System.out.println(line);
		}
	}


	public static BufferedReader test508(String url) throws IOException {
		// String url = "";
		// String reportName = "C:\\report\\report439.csv";
		ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "pa11y " + url);
		builder.redirectErrorStream(true);
		Process p = builder.start();
		BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));

		return r;
	
	}
}
