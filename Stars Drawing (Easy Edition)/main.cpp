// Problem: Stars Drawing (Easy Edition) (http://codeforces.com/problemset/problem/1015/E1)
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
    ll n, m, sdf = 0;
    cin >> n >> m;
    vector < string > asd;
    vector < vector < bool > > stmap;
    vector < bool > minstmap;
    forn(qq, n)
    {
        string ss;
        cin >> ss;
        asd.pb(ss);
        minstmap.clear();
        ll aa = ss.length();
        while(aa--)
        {
            if (ss[ss.length() - aa - 1] == '.') minstmap.pb(true);
            else minstmap.pb(false), sdf++;
        }
        stmap.pb(minstmap);
    }

    ll sumres = 0;
    vector < string > dfg;
    if (!sdf)
    {
        ccout("-1");
    }
    else
    {
        forn(qq, n)
        {
            forn(ww, m)
            {
                if (qq == 0 || qq == (n - 1) ||
                    ww == 0 || ww == (m - 1) ||
                    asd[qq][ww] == '.') continue;
                ll jk = 1;
                while (jk <= min(n, m))
                {
                    if ((qq + jk) >= n || (qq - jk) < 0) break;
                    if ((ww + jk) >= m || (ww - jk) < 0) break;
                    if (asd[qq + jk][ww] == '*' &&
                        asd[qq - jk][ww] == '*' &&
                        asd[qq][ww + jk] == '*' &&
                        asd[qq][ww - jk] == '*')
                    {
                        stmap[qq][ww] = true;
                        stmap[qq + jk][ww] = true;
                        stmap[qq - jk][ww] = true;
                        stmap[qq][ww + jk] = true;
                        stmap[qq][ww - jk] = true;
                        sumres++;
                        string os;
                        stringstream ss;
                        ss << (qq + 1);
                        ss << " ";
                        ss << (ww + 1);
                        ss << " ";
                        ss << jk;
                        os = ss.str();
                        dfg.pb(os);
                    }
                    jk++;
                }
            }
        }
        bool res = true;
        forn(qq, n)
        {
            forn(ww, m)
            {
                res &= stmap[qq][ww];
            }
        }
        if (res)
        {
            ccout(sumres);
            for (vector < string > :: iterator it = dfg.be; it != dfg.en; ++it)
            {
                cout << *it << endl;
            }
        }
        else
        {
            ccout("-1");
        }
    }
    return 0;
}
