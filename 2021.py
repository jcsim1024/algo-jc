# spot 2021


a,*$b=`dd`.split("\n").map &:to_s

$c = 0
for i in 0...$b.size
    for j in 0...$b[0].size
         $c += 1 if $b[i][j] == "2" && j-3 >= 0 && $b[i][j-1] == "0" && $b[i][j-2] == "2" && $b[i][j-3] == "1"
         $c += 1 if $b[i][j] == "2" && i-3 >= 0 && $b[i-1][j] == "0" && $b[i-2][j] == "2" && $b[i-3][j] == "1"
         $c += 1 if $b[i][j] == "2" && i+3 <= $b.size-1 && $b[i+1][j] == "0" && $b[i+2][j] == "2" && $b[i+3][j] == "1"
         $c += 1 if $b[i][j] == "2"&& j+3 <= $b[0].size-1 && $b[i][j+1] == "0" && $b[i][j+2] == "2" && $b[i][j+3] == "1"
    end
end
p $c