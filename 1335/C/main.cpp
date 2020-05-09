#include <iostream>
#include <vector>
#include <set>

using namespace std;

void solve () {
  int n;
  cin >> n;

  vector<int> counter(n + 1, 0);
  int mx_counter = 0;
  set<int> member;
  for (int i = 0; i < n; ++i) {
    int in;
    cin >> in;
    ++counter[in];
    mx_counter = max(mx_counter, counter[in]);
    member.insert(in);
  }

  int mx_unique = (int)member.size();
  int ans = max(min(mx_counter-1, mx_unique), min(mx_counter, mx_unique-1));
  cout << ans << endl;
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
