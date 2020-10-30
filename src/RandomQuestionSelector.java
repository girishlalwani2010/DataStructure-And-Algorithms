import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomQuestionSelector {
	private static final int totalRecords = 260;
//	private static Set<Integer> globalBlackListedRecords = new HashSet<>();

	public static void main(String[] args) throws IOException, InterruptedException {
		File blackListFile = new File("src/done.txt");
		blackListFile.createNewFile();
		InputStream inputStream = new FileInputStream(blackListFile);
		String blackListNumber;
		Set<Integer> blackListed = new HashSet<>();
		int blackListedRecords=0;
		while(true) {
			BufferedReader bufferReader = new BufferedReader(new InputStreamReader(inputStream));
			while ((blackListNumber = bufferReader.readLine()) != null) {
				blackListedRecords++;
				blackListed.add(Integer.parseInt(blackListNumber));
			}
			System.out.println();
			System.out.println("################  Next Batch : [Start:]->"+blackListedRecords+" [End:]->"+(blackListedRecords+10)+"  ################");
			bufferReader = generateNextRandoms(blackListFile, blackListed);
			if(blackListedRecords>=totalRecords) {
				break;
			}
			Thread.sleep(500);
		}
	}

	private static BufferedReader generateNextRandoms(File blackListFile, Set<Integer> blackListed)
			throws FileNotFoundException, IOException {
		InputStream inputStream;
		BufferedReader bufferReader;
		Random random = new Random();
		Set<Integer> notBlackList = new HashSet<>();
		inputStream = new FileInputStream(new File("src/AllLeetCodeQuestion-Solved|Attempted"));
		bufferReader = new BufferedReader(new InputStreamReader(inputStream));
		BufferedWriter blackListWriter = new BufferedWriter(new FileWriter(blackListFile, true));
		for (int i = 0; i < 10;) {
			int nextInt = random.nextInt(totalRecords);
			if (!blackListed.contains(nextInt)) {
				notBlackList.add(nextInt);
				i++;
//				if(globalBlackListedRecords.contains(nextInt)) {
//					System.out.println("Duplicate Record Fetched : "+"["+nextInt+"]");
//				}
				blackListed.add(nextInt);
				blackListWriter.write(String.valueOf(nextInt));
				blackListWriter.write(System.lineSeparator());
			}
		}
		blackListWriter.close();
		String question;
		int lineNo = 0;
		while ((question = bufferReader.readLine()) != null) {
			lineNo++;
			if (notBlackList.contains(lineNo)) {
				System.out.println(question);
			}
		}
		return bufferReader;
	}
}
