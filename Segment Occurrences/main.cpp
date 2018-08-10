// Problem: Segment Occurrences (http://codeforces.com/problemset/problem/1016/B)
// Author: babang

#include <algorithm>
#include <iostream>
#include <map>
#include <set>
#include <vector>
#include <math.h>
#include <stdlib.h>
#include <string>
#include <sstream>

#define forn(i, n) for(int i = 0; i < n; i++)
#define rofn(i, n) for(int i = n-1; i >= 0; i--)
#define foran(i, a, n) for(int i = a; i < n; i++)
#define rofan(i, a, n) for(int i = a-1; i >= n; i--)
#define whee(n) while(n--)
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
#define rbe rbegin()
#define ren rend()
#define _it iterator
#define revit reverse_iterator
#define YES cout << "YES" << endl
#define NO cout << "NO" << endl
#define NL cout << endl
#define ccout(i) cout << i << endl

using namespace std;

typedef long long ll;
typedef long double ld;
typedef unsigned long long ull;
typedef vector<ll> vll;
typedef pair<ll, ll> pll;
typedef map<ll, ll> mll;
typedef set<ll, ll> sll;

int main()
{
    ll n, m, q;
    cin >> n >> m >> q;
    string s, t;
    cin >> s >> t;
    ll aa[1001];
    ll sum = 0;
    foran(qq, 1, n - m + 2)
    {
        if (s.substr(qq - 1, m) == t) sum++;
        aa[qq] = sum;
    }
    forn(qq, q)
    {
        ll l, r;
        cin >> l >> r;
        if (m > n || (r - l + 1) < m)
        {
            ccout("0");
        }
        else
        {
            ccout(aa[r - m + 1] - aa[l - 1]);
        }
    }
    return 0;
}
