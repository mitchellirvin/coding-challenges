//

import java.util.*;

public class CaptureRegionsOnABoard {
	static class Coordinate {
		int row;
		int col;
		public Coordinate(int row, int col) { this.row = row; this.col = col; }
	}

	static ArrayList<Coordinate> region;

	public static void solve(ArrayList<ArrayList<Character>> a) {
	    if (a.size() <= 1) {
	        return;
	    } else if (a.get(0).size() <= 1) {
	        return;
	    }

	    int[][] visited = new int[a.size()][a.get(0).size()];

	    for (int row = 0; row < a.size(); row++) {
	        for (int col = 0; col < a.get(0).size(); col++) {
	            if (visited[row][col] != 1) {
					region = new ArrayList<>();
                    if (!isRegionEdgeAdjacent(a, visited, row, col)) {
						captureRegion(a);
					}
	            }
	        }
	    }
	}

	public static boolean isRegionEdgeAdjacent(ArrayList<ArrayList<Character>> board,
	       int[][] visited, int row, int col) {
        if (board.get(row).get(col) != 'O') {
            return false;
        }

        boolean isEdgeAdjacent = false;

	    if (row == 0 || row == (board.size() - 1)
	            || col == 0 || col == (board.get(0).size() - 1)) {
            isEdgeAdjacent = true;
        }

        visited[row][col] = 1;
		region.add(new Coordinate(row, col));

        if (row > 0) {
            if (visited[row - 1][col] != 1) {
                isEdgeAdjacent |= isRegionEdgeAdjacent(board, visited, row - 1, col);
            }
        }
        if (row < board.size() - 1) {
            if (visited[row + 1][col] != 1) {
                isEdgeAdjacent |= isRegionEdgeAdjacent(board, visited, row + 1, col);
            }
        }
        if (col > 0) {
            if (visited[row][col - 1] != 1) {
                isEdgeAdjacent |= isRegionEdgeAdjacent(board, visited, row, col - 1);
            }
        }
        if (col < board.get(0).size() - 1) {
            if (visited[row][col + 1] != 1) {
                isEdgeAdjacent |= isRegionEdgeAdjacent(board, visited, row, col + 1);
            }
        }

	    return isEdgeAdjacent;
    }

	public static void captureRegion(ArrayList<ArrayList<Character>> board) {
		for (Coordinate c : region) {
			board.get(c.row).set(c.col, 'X');
		}
	}

    public static ArrayList<Character> populateChars(String s) {
        ArrayList<Character> chars = new ArrayList<Character>();
        for (char c : s.toCharArray()) {
          chars.add(c);
        }
        return chars;
    }

    public static void printBoard(ArrayList<ArrayList<Character>> board) {
        for (ArrayList<Character> row : board) {
            for (char c : row) {
                System.out.print(c + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Character>> board = new ArrayList<>();
        board.add(populateChars("OOOXXXO"));
        board.add(populateChars("XXXOOXO"));
        board.add(populateChars("XXOXOXO"));
        board.add(populateChars("OXOXOXO"));
        board.add(populateChars("XXOXOXX"));
        board.add(populateChars("XOOOXXO"));
        board.add(populateChars("OXXOXOO"));
        board.add(populateChars("OXOOXOX"));
		printBoard(board);
        solve(board);
		System.out.println("Captured: ");
		printBoard(board);
    }
}
