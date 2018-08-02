// Problem: Obtaining the String (http://codeforces.com/contest/1015/problem/B)
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

int main()
{
    int n, bt = 0, su = 0;
    string s, t;
    string ans;
    cin >> n;
    cin >> s;
    cin >> t;
    char st;
    while(s != t && bt < n)
    {
        while(s[bt] == t[bt] && bt < n)
        {
            bt++;
        }
        if(bt == n) break;
        int up = bt + 1;
        while(s[up] != t[bt] && up < n) up++;
        if(up == n) break;
        rofan(qq, up+1, bt+1)
        {
            if(qq>9)
            {
                ans += '0' + (qq/10);
                ans += '0' + (qq%10);
            }
            else ans += '0' + qq;
            ans += " ";
            st = s[qq];
            s[qq] = s[qq-1];
            s[qq-1] = st;
            su++;
        }
    }
    if(s != t) cout << "-1" << endl;
    else cout << su << endl << ans;
    return 0;
}
