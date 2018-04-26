// Problem: Mahmoud and Ehab and the message (http://codeforces.com/problemset/problem/959/B)
// Author: babang

#include <algorithm>
#include <iostream>
#include <map>
#include <set>
#include <vector>

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

ll n, k, m, as, rt = 0;
vll asd;
char ins[21];
map<string, int> zxc;
mll xcv, wer;
int main()
{
    cin >> n >> k >> m;
    forn(qq, n) cin >> ins, zxc[ins] = qq;
    forn(qq, n) cin >> as, asd.pb(as);
    forn(qq, k)
    {
        ll sd = INT_MAX, df;
        vll zx;
        cin >> as;
        forn(ww, as)
        {
            cin >> df; zx.pb(df-1);
            xcv[df-1] = qq;
            sd = min(sd, asd[df-1]);
            wer[qq] = sd;
        }
        //forn(ww, as) if (as > 1) asd[zx[ww]] = sd;
    }
    forn(qq, m)
    {
        cin >> ins;
//        rt += asd[zxc[ins]];
        rt += wer[xcv[zxc[ins]]];
    }
    cout << rt;
    return 0;
}
