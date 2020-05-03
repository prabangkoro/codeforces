#include <bits/stdc++.h>

using namespace std;

void solve () {
  int n;
  cin >> n;
  
  int sumA = (1 << n), sumB = 0;
  for (int i = 1; i < n/2; ++i) {
    sumA += (1 << i);
  }
  for (int i = n/2; i < n; ++i) {
    sumB += (1 << i);
  }
  cout << sumA - sumB << "\n";
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