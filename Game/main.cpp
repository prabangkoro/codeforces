// Problem: Game (http://codeforces.com/problemset/problem/984/A)
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

int n;
vll qw;
ll asd;

int main()
{
    cin >> n;
    forn(qq, n) cin >> asd, qw.pb(asd);
    // sorting
    sort(qw.be, qw.en);
    if(n%2) cout << qw[n/2] << endl;
    else cout << qw[max(0, n/2-1)] << endl;
    return 0;
}
