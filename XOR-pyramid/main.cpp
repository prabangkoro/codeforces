// Problem: XOR-Pyramid (http://codeforces.com/problemset/problem/983/B)
// Author: babang

#include <algorithm>
#include <iostream>
#include <map>
#include <set>
#include <vector>
#include <math.h>

#define forn(i, n) for(int i = 0; i < n; i++)
#define rofn(i, n) for(int i = n-1; i >= 0; i--)
#define foran(i, a, n) for(int i = a; i < n; i++)
#define rofan(i, a, n) for(int i = a-1; i >= n; i--)
#define T() int t; cin>>t; while(t--)
#define scan(x) scanf("%lld",&x)
#define print(x) printf("%lld ",x)
#define eb emplace_back
#define pb push_back
#define mp make_pair
#define fi first
#define se second
#define be begin()
#define en end()
#define YES printf("YES\n")
#define NO printf("NO\n")
#define br printf("\n");

using namespace std;

typedef long long ll;
typedef long double ld;
typedef unsigned long long ull;
typedef vector<ll> vll;
typedef pair<ll, ll> pll;
typedef map<ll, ll> mll;
typedef set<ll, ll> sll;

ll n, q, qwe;
vll l, r, res;

ll aa[5001][5001];
void mapping(ll n)
{
    foran(qq, 1, n)
    {
        foran(ww, 1, n-qq+1)
        {
            aa[ww][ww+qq] = aa[ww][ww+qq-1] ^ aa[ww+1][ww+qq];
        }
    }
    foran(qq, 1, n)
    {
        foran(ww, 1, n-qq+1)
        {
            aa[ww][ww+qq] = max(aa[ww][ww+qq], aa[ww+1][ww+qq]);
            aa[ww][ww+qq] = max(aa[ww][ww+qq], aa[ww][ww+qq-1]);
        }
    }
}

int main()
{
    cin >> n;
    foran(qq, 1, n+1) cin >> qwe, aa[qq][qq] = qwe;
    mapping(n);
    cin >> q;
    forn(qq, q) cin >> qwe, l.pb(qwe), cin >> qwe, r.pb(qwe);
    forn(qq, q)
    {
        // calculation
        ll re = aa[l[qq]][r[qq]];
        res.pb(re);
    }
    forn(qq, q)
    {
        cout << res[qq] << endl;
    }
    return 0;
}
