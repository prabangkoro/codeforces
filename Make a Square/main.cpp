// Problem: Make a Square (http://codeforces.com/problemset/problem/962/C)
// Author: babang
#include <iostream>
#include <math.h>
#include <string>
#include <sstream>

#define forn(i, n) for (int i = 0; i < n; i++)
#define foran(i, a, n) for (int i = a; i < n; i++)

using namespace std;

string qw;
int df = INT_MAX;
int main()
{
    cin >> qw;
    foran(qq, 1, 1 << qw.length())
    {
        string er;
        forn(ww, qw.length()) if (qq & 1<<ww) er += qw[ww];
        if (er[0] == '0') continue;
        stringstream as(er);
        int sd = 0; as >> sd;
        int zx = sqrt(sd);
        if ((zx*zx) == sd) df = min(df, int(qw.length() - er.length()));
    }
    cout << (df == INT_MAX ? -1 : df);
    return 0;
}
