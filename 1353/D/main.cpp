#include <bits/stdc++.h>

using namespace std;

struct cmp {
  bool operator () (const pair<int, int> &a, const pair<int, int> &b) const {
    int lena = a.second - a.first;
    int lenb = b.second - b.first;
    if (lena==lenb) return a.first < b.first;
    return lena > lenb;
  }
};

void solve () {
  int n;
  cin >> n;
  set<pair<int, int>, cmp> segs;
  segs.insert({0, n-1});

  vector<int> ans(n);
  for (int i=1; i<=n; ++i) {
    pair<int, int> current = *segs.begin();
    segs.erase(segs.begin());

    int id = (current.first + current.second) / 2;
    ans[id] = i;
    if (current.first < id) segs.insert({current.first, id-1});
    if (current.second > id) segs.insert({id+1, current.second});
  }

  for (auto it: ans) cout << it << " ";
  cout << endl;
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
