// Problem: Minesweeper (http://codeforces.com/problemset/problem/984/B)
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

ll n, m;
vector<string> qw;
string asd;
bool zxc = true;
ll scol[8] = {-1, -1, -1, 0, 1, 1, 1, 0};
ll srow[8] = {-1, 0, 1, 1, 1, 0, -1, -1};

int main()
{
    cin >> n >> m;
    forn(qq, n) cin >> asd, qw.pb(asd);
    forn(qq, n)
    {
        forn(ww, m)
        {
            int jkl = 0, sb = 0;
            // number field
            if(qw[qq][ww] >= '1' && qw[qq][ww] <= '8')
            {
                jkl = qw[qq][ww] - '0';
            }
            forn(xx, 8) if((qq+scol[xx]>=0) &&
                           (qq+scol[xx]<=(n-1)) &&
                           (ww+srow[xx]>=0) &&
                           (ww+srow[xx]<=(m-1)))
            {
                // invalid case
                if(qw[qq][ww] == '*' && qw[qq+scol[xx]][ww+srow[xx]] == '.') zxc = false;
                if(jkl != 0 && qw[qq+scol[xx]][ww+srow[xx]] == '*') sb++;
                if(!zxc) break;
            }
            if(jkl != 0 && jkl != sb) zxc = false;
            if(!zxc) break;
        }
        if(!zxc) break;
    }
    cout << (zxc ? "YES" : "NO") << endl;
    return 0;
}
