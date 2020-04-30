#include <bits/stdc++.h>

using namespace std;
const int INF = 1e9;

vector<vector<int>> g;

void bfs (int s, vector<int>& d) {
  d[s] = 0;
  queue<int> q;
  q.push(s);

  while (!q.empty()) {
    int v = q.front();
    q.pop();
    for (auto to: g[v]) {
      if (d[to] == INF) {
        d[to] = d[v] + 1;
        q.push(to);
      }
    }
  }
}

void solve () {
  int n, m, a, b, c;
  cin >> n >> m >> a >> b >> c;
  --a, --b, --c;

  vector<int> p(m);
  for (auto& it: p) cin >> it;
  sort(p.begin(), p.end());
  vector<long long> pref(m + 1);
  for (int i = 0; i < m; ++i) {
    pref[i + 1] = pref[i] + p[i];
  }

  g = vector<vector<int>>(n);
  for (int i = 0; i < m; ++i) {
    int u, v;
    cin >> u >> v;
    --u, --v;
    g[u].push_back(v);
    g[v].push_back(u);
  }

  vector<int> da(n, INF), db(n, INF), dc(n, INF);
  bfs(a, da);
  bfs(b, db);
  bfs(c, dc);

  long long ans = 1e18;
  for (int i = 0; i < n; ++i) {
    if (da[i] + db[i] + dc[i] > m) continue;
    ans = min(ans, pref[db[i]] + pref[da[i] + db[i] + dc[i]]);
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
    solve();
  } 

  return 0;
}



