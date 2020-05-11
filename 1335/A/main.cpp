#include <iostream>
#include <vector>
#include <set>

using namespace std;

void solve () {
  int n;
  cin >> n;

  int ans = n / 2;
  cout << (n % 2 == 0 ? ans - 1 : ans) << endl;
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
