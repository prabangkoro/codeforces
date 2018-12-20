# Problem:  Letters Rearranging (https://codeforces.com/problemset/problem/1093/B)
# Author: babang

def rearrange (s):
  N = len(s)
  if N == 1: return -1
  for i in range(N // 2):
    if s[i] == s[N-1-i]:
      # palindrome
      if s[i] != s[i+1]:
        stemp = list(s)
        stemp[i], stemp[i+1] = stemp[i+1], stemp[i]
        return ''.join(stemp)
    else:
      return s
  return -1

for i in range(int(input())):
  print(rearrange(input()))