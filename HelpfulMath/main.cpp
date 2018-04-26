/* 
 * File:   main.cpp
 * Author: babang
 * Problem: Helpful Math
 * Created on April 25, 2018, 5:14 AM
 */

#include <iostream>
#include <string>
#include <vector>
#include <sstream>
#include <algorithm>

#define forn(i, n) for(int i = 0; i < n; i++)
#define pb push_back

using namespace std;

int main() {
    string qw; cin >> qw;
    stringstream ss(qw);
    vector<int> we;
    int i;
    
    while (ss >> i) {
        we.pb(i);
        if (ss.peek() == '+') ss.ignore();
    }
    sort(we.begin(), we.end());
    forn(qq, we.size()-1) cout << we[qq] << '+';
    cout << we[we.size()-1];
    return 0;
}