#include <bits/stdc++.h>

using namespace std;

int get_card (int height) {
  float h = (float)height;
  return (int)(3.0*h*h/2.0 + h/2.0);
}

int get_pyramid (int s) {
  if (s < 2) return 0;
  int n = ceil(sqrt((float)s));

  // cout << "n: " << n << endl;
  while (get_card(n) > s && n > 0) n--;
  // cout << "final n: " << n << " card: " << get_card(n) << endl;
  return 1 + get_pyramid(s - get_card(n));
}

void solve () {
  int n;
  cin >> n;

  // cout << "solving: " << n << endl;
  cout << get_pyramid(n) << endl;
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