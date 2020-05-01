#include <bits/stdc++.h>

using namespace std;

void solve () {
  int n;
  cin >> n;

  map<string, int> db;
  map<string, int>::iterator it;
  while (n--) {
    string user;
    cin >> user;

    it = db.find(user);
    if (it == db.end()) {
      db[user] = 0;
      cout << "OK\n";
    } else {
      db[user] = ++db[user];
      cout << user << db[user] << "\n";
    }
  }
}

int main()
{
  ios::sync_with_stdio(0);
  cin.tie(0);

  solve();

  return 0;
}

