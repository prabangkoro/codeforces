/* 
 * File:   main.cpp
 * Author: babang
 * Problem: Petya and String
 * Created on April 24, 2018, 10:13 PM
 */

#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int main() {
    string s, d;
    cin >> s >> d;
    transform(s.begin(), s.end(), s.begin(), ::tolower);
    transform(d.begin(), d.end(), d.begin(), ::tolower);
    if (s.compare(d) < 0) cout << -1;
    else if (s.compare(d) == 0) cout << 0;
    else cout << 1;
    return 0;
}

