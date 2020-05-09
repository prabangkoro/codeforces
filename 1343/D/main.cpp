#include <iostream>
#include <vector>
#include <string>
#include <map>

using namespace std;

typedef long long ll;
typedef vector<int> vi;
typedef pair<int, int> pii;
typedef map<int, int> mii;


void solve () {
  int n, k;
  cin >> n >> k;

  vector<int> a(n);
  for (auto& it: a) cin >> it;
  vector<int> counter(2 * k + 1);
  for (int i = 0; i < n / 2; i++) {
    ++counter[a[i] + a[n - i - 1]];
  }
  // cout << "counter: ";
  // for (auto& it: counter) cout << it << " ";
  // cout << "\n";

  vector<int> pref(2 * k + 2);
  for (int i = 0; i < n / 2; i++) {
    int left1 = 1 + a[i], right1 = k + a[i];
    int left2 = 1 + a[n - i - 1], right2 = k + a[n - i - 1];

    ++pref[min(left1, left2)];
    --pref[max(right1, right2) + 1];
  }
  for (int i = 1; i <= 2 * k + 1; i++) {
    pref[i] += pref[i - 1];
  }
  int ans = 1e9;
  for (int i = 2; i <= 2 * k; ++i) {
    ans = min(ans, (pref[i] - counter[i]) + (n / 2 - pref[i]) * 2);
  }
  cout << ans << "\n";
}

int main()
{
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n;
  cin >> n;
  while (n) {
    n--;
    int inp;
    solve();
  } 

  return 0;
}


