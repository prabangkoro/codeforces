#include <bits/stdc++.h>

using namespace std;

vector<long long> cnt(200001, 0);
vector<pair<int, int>> primes[200002];

void prm_factors () {
  for (int i = 2; i <= 200000; ++i) {
    if (primes[i].empty()) {
      for (int j = i; j <= 200000; j += i) {
        int q = j;
        pair<int, int> nxt = {i, 0};
        while (q%i == 0) {
          q /= i;
          ++nxt.second;
        }
        primes[j].push_back(nxt);
      }
    }
  }
}

long long gcd (long long a, long long b) {
  if (a==0) return b;
  return gcd(b % a, a);
}

void solve () {
}

int main()
{
  ios::sync_with_stdio(0);
  cin.tie(0);

  prm_factors();
  solve();

  return 0;
}
