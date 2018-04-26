// Problem: Battleships (http://codeforces.com/problemset/problem/965/B)
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


ll n, k, mx = 0;
vector<string> qw;
vector<vll> sdf;
string ui;
class xy
{
public:
    int x;
    int y;
};
xy asd, fin;
int main()
{
    cin >> n >> k;
    asd.x = 1; asd.y = 1;
    forn(qq, n) cin >> ui, qw.pb(ui), sdf.pb(vll(ui.length(),0));
    forn(qq, n)
    {
        forn(ww, n)
        {
            // update last .
            if (qw[qq][ww] == '.') asd.x=ww+1, asd.y=qq+1;
            bool yy = true, xx = true;
            forn(ee, k)
            {
                if (ww > n - k) xx &= false;
                else if (qw[qq][ww+ee] == '#') xx &= false;
                if (qq > n - k) yy &= false;
                else if (qw[qq+ee][ww] == '#') yy &= false;
                if (!xx && !yy) break;
            }
            if (xx || yy) forn(ee, k)
            {
                if (xx)
                {
                    sdf[qq][ww+ee]++; if (sdf[qq][ww+ee] > mx) mx=sdf[qq][ww+ee], fin.x=ww+ee+1, fin.y=qq+1;
                }
                if (yy)
                {
                    sdf[qq+ee][ww]++; if (sdf[qq+ee][ww] > mx) mx=sdf[qq+ee][ww], fin.x=ww+1, fin.y=qq+ee+1;
                }
            }
        }
    }
    if (!mx)
        cout << asd.y << " " << asd.x << endl ;
    else
        cout << fin.y << " " << fin.x << endl ;
    return 0;
}
