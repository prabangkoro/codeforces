#include <iostream>
#include <vector>
#include <set>

using namespace std;

void solve () {
  int sudoku[9][9];
  for (int i = 0; i < 9; ++i) {
    string s;
    cin >> s;
    for (int j = 0; j < 9; ++j) {
      sudoku[i][j] = s[j] - '0';
    }
  }

  ++sudoku[0][0], sudoku[0][0] = sudoku[0][0]>9 ? 1 : sudoku[0][0];
  ++sudoku[3][1], sudoku[3][1] = sudoku[3][1]>9 ? 1 : sudoku[3][1];
  ++sudoku[6][2], sudoku[6][2] = sudoku[6][2]>9 ? 1 : sudoku[6][2];
  ++sudoku[1][3], sudoku[1][3] = sudoku[1][3]>9 ? 1 : sudoku[1][3];
  ++sudoku[4][4], sudoku[4][4] = sudoku[4][4]>9 ? 1 : sudoku[4][4];
  ++sudoku[7][5], sudoku[7][5] = sudoku[7][5]>9 ? 1 : sudoku[7][5];
  ++sudoku[2][6], sudoku[2][6] = sudoku[2][6]>9 ? 1 : sudoku[2][6];
  ++sudoku[5][7], sudoku[5][7] = sudoku[5][7]>9 ? 1 : sudoku[5][7];
  ++sudoku[8][8], sudoku[8][8] = sudoku[8][8]>9 ? 1 : sudoku[8][8];

  for (int i = 0; i < 9; ++i) {
    for (int j = 0; j < 9; ++j) {
      cout << sudoku[i][j];
    }
    cout << endl;
  }
}

int main()
{
  ios::sync_with_stdio(0);
  cin.tie(0);

  int t;
  cin >> t;
  while (t--) {
    solve();
  }

  return 0;
}
