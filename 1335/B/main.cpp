#include <iostream>
#include <vector>
#include <set>

using namespace std;

void solve () {
  int n, a, b;
  cin >> n >> a >> b;
  vector<char> pattern;
  int unique = 1;
  for (int i = 0; i < a; ++i) {
    pattern.push_back(unique - 1 + 'a');
    if (unique < b) {
      ++unique;
    }
  }

  for (int i = 0; i < n; ++i) {
    cout << pattern[i % a];
  }
  cout << endl;
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
