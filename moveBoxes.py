

import sys
import math

# Auto-generated code below aims at helping you parse
# the standard input according to the problem statement.

#HELP friend move X boxe when he take N mn to move 1 boxe and he only has T hours to do it
x = int(input())
n = int(input())
t = int(input())

print(max(0,x-t*60//n))