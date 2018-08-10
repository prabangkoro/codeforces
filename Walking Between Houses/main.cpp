// Problem: Walking Between Houses (http://codeforces.com/problemset/problem/1015/D)
// Author: babang

#include <algorithm>
#include <iostream>
#include <map>
#include <set>
#include <vector>
#include <math.h>
#include <stdlib.h>

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
#define rbe rbegin()
#define ren rend()
#define _it iterator
#define revit reverse_iterator
#define YES cout << "YES" << endl
#define NO cout << "NO" << endl
#define br cout << endl
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
    ll n, k, s;
    cin >> n >> k >> s;
    if ((n - 1) * k < s || k > s)
    {
        NO;
    }
    else
    {
        YES;
        ll pos = 1;
        ll dv = s / k;
        ll av = s % k;
        forn(qq, k)
        {
            ll aa = dv;
            if (qq < av) aa++;
            pos += aa;
            if (pos > n) pos -= 2 * aa;
            cout << pos << " ";
        }
    }
    return 0;
}
