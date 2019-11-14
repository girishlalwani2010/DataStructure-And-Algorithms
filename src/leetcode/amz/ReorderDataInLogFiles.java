package leetcode.amz;

import java.util.Arrays;
import java.util.Comparator;

public class ReorderDataInLogFiles {
	
	public static String[] reorderLogFiles(String[] logs) {
		int checkingIndex=logs.length-2, numberIndex=logs.length-1;
		String[] logsSecondPart = new String[logs.length];
				
		for(int i=0; i<logs.length; i++) {
			logsSecondPart[i] = logs[i].split(" ")[1];
		}		
				
		while(checkingIndex>=0) {
			char checkIndChar = logsSecondPart[checkingIndex].charAt(0);
			char numberIndChar = logsSecondPart[numberIndex].charAt(0);
			if(numberIndChar>=97 && numberIndChar<=122) {
				if(checkIndChar>=48 && checkIndChar<=57) {
					String temp = logs[checkingIndex];
					logs[checkingIndex] = logs[numberIndex];
					logs[numberIndex] = temp;
					String temp1 = logsSecondPart[checkingIndex];
					logsSecondPart[checkingIndex] = logsSecondPart[numberIndex];
					logsSecondPart[numberIndex] = temp1;
					numberIndex--;
				}
				checkingIndex--;
			}else {
				numberIndex--;
				checkingIndex--;
			}
			
		}
		
		logsSecondPart = new String[numberIndex+1];
		for(int i=0; i<=numberIndex; i++) {
			logsSecondPart[i] = logs[i];
		}
		
		Arrays.sort(logsSecondPart,new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {
				// TODO Auto-generated method stub
				return str1.substring(str1.indexOf(" ")+1).compareTo(str2.substring(str2.indexOf(" ")+1));
			}
		});
		
		for(int i=0; i<logsSecondPart.length; i++) {
			logs[i] = logsSecondPart[i];
		}
		
		return logs;
		
	}
	
	public String[] reorderLogFiles2(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
            if (!isDigit1 && !isDigit2) {
                int cmp = split1[1].compareTo(split2[1]);
                if (cmp != 0) return cmp;
                return split1[0].compareTo(split2[0]);
            }
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });
        return logs;
    }
	

	public static void main(String[] args) {
		//String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
		String[] logs = {"t kvr", "r 3 1", "i 403", "7 so", "t 54"};
		System.out.println(reorderLogFiles(logs));
	}

}
