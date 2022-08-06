d=[[int(j)
for j in input().split()]
    for i in range(int(input()))]
        r=abs(
            sum(
                [d[i][0]*d[i+1][1]-d[i+1][0]*d[i][1]
        for i in range(-1,len(d)-1)]))/2

print( int(r) 
    if r==int(r)
    else r)