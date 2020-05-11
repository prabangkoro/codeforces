#include <bits/stdc++.h>

using namespace std;

void solve () {
  long long x, y;
  long long a, b;
  cin >> x >> y;
  cin >> a >> b;

  long long sumA = 0, sumB = 0;
  sumA = b * min(x, y) + a * abs(x - y);
  sumB = a * (x + y);
  // cout << sumA << " " << sumB << endl;
  cout << min(sumA, sumB) << endl;
}
int main()
{
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n;
  cin >> n;
  while (n--) {
    solve();
  }

  return 0;
}