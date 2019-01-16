public class Sudoku {
//    int combinations = 0;

    boolean solve(int a[][]) {
        boolean hasEmptyCell = false;
            for (int r = 0; r < 9; r++) {
                for (int c = 0; c < 9; c++) {
                    if (!hasEmptyCell && a[r][c] == 0) {
                        for (int elem = 1; elem <= 9; elem++) {
                            if (GFG.isSafe(a, r, c, elem)) {
                                a[r][c] = elem;
                                boolean solved = solve(a);
                                if (solved) {
                                    return true;
                                } else {
                                    a[r][c] = 0;
                                }
                            }
                        }
                        hasEmptyCell = true;
                    }
                }
            }

        return !hasEmptyCell;
    }

//    int absoluteElem(int a[][], int rowIndex, int columnIndex) {
//        int numbersNotVisited = 0;
//        int absentElement = 0;
//        boolean ifVisited[] = new boolean[9];
//        for (int elem = 0; elem < 9; elem++) {
//            if (!isNotInSubGrid(a, elem + 1, rowIndex, columnIndex) ||
//                    inRow(a, elem + 1, rowIndex) || inCol(a, elem + 1, columnIndex)) {
//                ifVisited[elem] = true;
//            }
//        }
//        for (int i = 0; i < 9; i++) {
//
//            if (ifVisited[i]) {
//                numbersNotVisited++;
//                absentElement = i + 1;
//            }
//            if (numbersNotVisited > 1)
//                absentElement = 0;
//
//        }
//        return absentElement;
//    }
//
//    void solve(int a[][]) {
//        while (!hasBeenSolved) {
//            for (int r = 0; r < 9; r++) {
//                for (int c = 0; c < 9; c++) {
//                    if (a[r][c] == 0) {
//                        a[r][c] = absoluteElem(a, r, c);
//                        hasBeenSolved = isSolved(a);
//                    }
//                }
//            }
//        }
//
//
//}

    int[][] copy(int[][] a) {
        int[][] arr = new int[9][9];
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                arr[r][c] = a[r][c];
            }
        }
        return arr;
    }

    boolean isSolved(int a[][]) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (a[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean inRow(int a[][], int elem, int rowIndex) {
        boolean rowCheck = false;
        for (int r = 0; r < 9; r++) {
            if (a[rowIndex][r] == elem) {
                rowCheck = true;
                break;
            }
        }
        return rowCheck;
    }

    boolean inCol(int a[][], int elem, int colIndex) {
        boolean colCheck = false;
        for (int c = 0; c < 9; c++) {
            if (a[c][colIndex] == elem) {
                colCheck = true;
                break;
            }
        }
        return colCheck;
    }

    boolean isNotInSubGrid(int a[][], int elem, int i, int j) {
        int starti = 0, startj = 0, endi = 0, endj = 0;
        if (i >= 0 && i < 3 && j >= 0 && j < 3) {
            starti = 0;
            startj = 0;
            endi = 3;
            endj = 3;
        }
        if (i >= 3 && i < 6 && j >= 0 && j < 3) {
            starti = 3;
            startj = 0;
            endi = 6;
            endj = 3;
        }
        if (i >= 6 && i < 9 && j >= 0 && j < 3) {
            starti = 6;
            startj = 0;
            endi = 9;
            endj = 3;
        }
        if (i >= 0 && i < 3 && j >= 3 && j < 6) {
            starti = 0;
            startj = 3;
            endi = 3;
            endj = 6;
        }
        if (i >= 3 && i < 6 && j >= 3 && j < 6) {
            starti = 3;
            startj = 3;
            endi = 6;
            endj = 6;
        }
        if (i >= 6 && i < 9 && j >= 3 && j < 6) {
            starti = 6;
            startj = 3;
            endi = 9;
            endj = 6;
        }
        if (i >= 0 && i < 3 && j >= 6 && j < 9) {
            starti = 0;
            startj = 6;
            endi = 3;
            endj = 9;
        }
        if (i >= 3 && i < 6 && j >= 6 && j < 9) {
            starti = 3;
            startj = 6;
            endi = 6;
            endj = 9;
        }
        if (i >= 6 && i < 9 && j >= 6 && j < 9) {
            starti = 6;
            startj = 6;
            endi = 9;
            endj = 9;
        }
        for (int k = starti; k < endi; k++) {
            for (int l = startj; l < endj; l++) {
                if (a[k][l] == elem) {
                    return false;
                }
            }
        }
        return true;
    }

    void print(int a[][]) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
