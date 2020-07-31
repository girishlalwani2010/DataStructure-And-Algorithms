package bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class SlidingPuzzle {
    public int slidingPuzzle(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        Set<String> visited = new HashSet<>();
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        
        String curr = "";
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                curr += board[i][j];
            }
        }
        if (curr.equals("123450")) return 0;
        
        Queue<String> queue = new LinkedList<>();
        queue.add(curr);
        visited.add(curr);
        int minLen = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String currStr = queue.poll();
                int index = currStr.indexOf('0');
                for (int i = 0; i < dirs.length; i++) {
                    int m = index/col + dirs[i][0];
                    int n = index%col + dirs[i][1];
                    if (m >= 0 && m < row && n >= 0 && n < col) {
                        int nextIndex = m*col + n;
                        String nextStr = swap(currStr, index, nextIndex);
                        if (nextStr.equals("123450")) return minLen;
                        if (!visited.contains(nextStr)) {
                            queue.add(nextStr);
                            visited.add(nextStr);
                        }
                    }
                }
            }
            minLen++;
        }
        return -1;
    }
    
    private String swap(String str, int i, int j) {
        //System.out.println(str + ":" + i + ":" + j);
        char[] charArray = str.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return new String(charArray);
    }
}