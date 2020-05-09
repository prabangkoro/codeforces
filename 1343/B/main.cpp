#include <iostream>
#include <vector>
#include <string>
#include <map>

using namespace std;

typedef long long ll;
typedef vector<int> vi;
typedef pair<int, int> pii;
typedef map<int, int> mii;

void solve (int n) {
  if (n == 2 || (n / 2) % 2 != 0) {
    cout << "NO\n";
    return;
  }
  int sum_even = 0;
  int sum_odd = 0;
  cout << "YES\n";
  for (int i = 0; i < n / 2; i++) {
    sum_even += 2 * (i + 1);
    cout << 2 * (i + 1) << " ";
  }
  for (int i = 1; i < n / 2; i++) {
    sum_odd += 2 * i - 1;
    cout << (2 * i - 1) << " ";
  }
  cout << sum_even - sum_odd << "\n";
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
    cin >> inp;
    solve(inp);
  } 

  return 0;
}
