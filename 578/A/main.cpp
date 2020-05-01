#include <bits/stdc++.h>

using namespace std;

const int N = 10;
int rooms[N];

void fill_left_room () {
  int i = 0;
  while (i < N) {
    if (!rooms[i]) break;
    ++i;
  }
  rooms[i] = 1;
}
void fill_right_room () {
  int i = 0;
  while (i < N) {
    if (!rooms[N - i - 1]) break;
    ++i;
  }
  rooms[N - i - 1] = 1;
}

void solve () {
  int n;
  cin >> n;

  string s;
  cin >> s;
  // cout << "s: " << s << "\n";

  for (char& code: s) {
    // cout << "code: " << code << "\n";
    if (code == 'L') {
      fill_left_room();
      continue;
    }
    if (code == 'R') {
      fill_right_room();
      continue;
    }
    int number = code - '0';
    rooms[number] = 0;
  }

  for (int i = 0; i < N; ++i) {
    cout << rooms[i];
  }
}

int main()
{
  ios::sync_with_stdio(0);
  cin.tie(0);

  solve();

  return 0;
}
