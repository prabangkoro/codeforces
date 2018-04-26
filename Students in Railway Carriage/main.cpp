// Problem: Students in Railway Carriage (http://codeforces.com/problemset/problem/962/B)
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
#define be begin
#define en end
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

ll n, a, b, we = 0;
char qw, er = '*';
int main()
{
    cin >> n >> a >> b;
    forn(qq, n)
    {
        cin >> qw;
        if (qw == '*')
        {
            er='*';
        }
        else if (er == '*' || er == '.')
        {
            if (a>0 && b>0)
            {
                if (a > b) --a,++we,er='a';
                else --b,++we,er='b';
            }
            else if (a > 0) --a,++we,er='a';
            else if (b > 0) --b,++we,er='b';
        }
        else
        {
            if (er=='a' && b > 0) --b,++we,er='b';
            else if (er=='b' && a > 0) --a,++we,er='a';
            else if (er=='a' && b==0) er='.';
            else if (er=='b' && a==0) er='.';
        }
    }
    cout << we << endl;
    return 0;
}
