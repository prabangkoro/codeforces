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
  int s = 2;
  int divider = (1 << s) - 1;
  while (divider <= n && (n % divider) != 0) {
    s++;
    divider = (1 << s) - 1;
  }
  cout << (n / divider) << "\n";
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