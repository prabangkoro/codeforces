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
  int n;
  cin >> n;

  ll max_consecutive;
  cin >> max_consecutive;
  ll sum_alternate = 0;
  for (int i = 1; i < n; i++) {
    ll a;
    cin >> a; 
    // alternating
    if ((max_consecutive < 0 && a > 0) ||
    (max_consecutive > 0 && a < 0)) {
      sum_alternate += max_consecutive;
      max_consecutive = a;
      continue;
    }
    max_consecutive = max(a, max_consecutive);
  }
  cout << sum_alternate + max_consecutive << "\n";
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

