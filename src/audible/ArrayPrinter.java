package audible;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayPrinter {

	public String getArraysStringClockwise(String[][] arrs) {
		// accumulate output while walk through arrays, so this method can be
		// unit tested
		StringBuffer sb = new StringBuffer();
		int rowSize = arrs.length;
		int colSize = arrs[0].length;

		// use those indexes to keep track of boundaries that being traversed
		int rowIndexNorth = 0;
		int rowIndexSouth = rowSize - 1;
		int colIndexWest = 0;
		int colIndexEast = colSize - 1;

		while (true) {
			// walk north edge
			if (rowIndexNorth > rowIndexSouth)
				break;
			for (int i = colIndexWest; i <= colIndexEast; i++) {
				sb.append(arrs[rowIndexNorth][i]);
				sb.append(" ");
			}
			rowIndexNorth++;

			// walk east edge
			if (colIndexEast < colIndexWest)
				break;
			for (int i = rowIndexNorth; i <= rowIndexSouth; i++) {
				sb.append(arrs[i][colIndexEast]);
				sb.append(" ");
			}
			colIndexEast--;

			// walk south edge
			if (rowIndexSouth < rowIndexNorth)
				break;
			for (int i = colIndexEast; i >= colIndexWest; i--) {
				sb.append(arrs[rowIndexSouth][i]);
				sb.append(" ");
			}

			rowIndexSouth--;

			// walk west edge
			if (colIndexWest > colIndexEast)
				break;
			for (int i = rowIndexSouth; i >= rowIndexNorth; i--) {
				sb.append(arrs[i][colIndexWest]);
				sb.append(" ");
			}

			colIndexWest++;

		}

		return sb.toString().toLowerCase().trim();
	}

	private static String[][] readFromReader(BufferedReader reader)
			throws IOException {
		List<String[]> al = new ArrayList<>();
		while (true) {
			String s = reader.readLine();
			if ((s == null) || (s.length() == 0)) {
				break;
			} else {
				al.add(s.trim().split("[\\s]+"));
			}
		}
		
		// check if the size of array are correct before returning
		if(al.size() == 0) throw new IOException("No data found, please refer to README.md for usage.");
		// check if the size of arrays are consistent
		int arraySize = al.get(0).length;
		for(String[] array: al){
			if(array.length != arraySize) throw new IOException("Data was not consistent, please refer to README.md for usage.");
		}
		return al.toArray(new String[al.size()][]);
	}

	public static void main(String[] args) {

		String[][] input = null;
		BufferedReader reader = null;

		if (args.length == 0) {
			// read from command prompt
			reader = new BufferedReader(new InputStreamReader(System.in));
			try {
				input = readFromReader(reader);
			} catch (IOException e) {
				System.out
						.println("There was error while read input from console: "
								+ e.getMessage());
			}
		} else if (args.length == 1) {
			// read input from file
			try {
				reader = new BufferedReader(new FileReader(args[0]));
				input = readFromReader(reader);
			} catch (FileNotFoundException e) {
				System.out.println("Unable to find file specified: "
						+ e.getMessage());
			} catch (IOException e) {
				System.out
						.println("There was error while read input from console: "
								+ e.getMessage());
			}
		} else {
			System.out.println("This program only support 0 or 1 argument for input data, please refer to README.md for usage.");
		}

		ArrayPrinter ap = new ArrayPrinter();
		String result = ap.getArraysStringClockwise(input);
		System.out.println(result);
	}

}
