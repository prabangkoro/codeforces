// Problem: Songs Compression (http://codeforces.com/problemset/problem/1015/C)
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
#define YES printf("YES\n")
#define NO printf("NO\n")
#define br printf("\n")
#define ccout(i) cout<<i<<endl

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
    ll n, m;
    ll unc = 0, cmp = 0;
    cin >> n >> m;
    mll diff;
    forn(qq, n)
    {
        ll a, b;
        cin >> a >> b;
        unc += a;
        cmp += b;
        ll df = a - b;
        diff[df] += 1;
    }

    if (cmp > m)
    {
        ccout("-1");
    }
    else if (unc <= m)
    {
        ccout("0");
    }
    else
    {
        ll minc = 0;
        ll com = unc - m;
        for(mll::revit it = diff.rbe; it != diff.ren; ++it)
        {
            ll c = it->first, d = it->second;
            if ((c * d) >= com)
            {
                minc += (com / c);
                if (com % c != 0) minc++;
                break;
            }
            else
            {
                com -= (c * d);
                minc += d;
            }
        }
        ccout(minc);
    }

    return 0;
}
