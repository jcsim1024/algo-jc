package fold.codility;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CandidateTowerswitchDynamic {

    public static  void main(String args[]) {

        var sol = new CandidateTowerswitchDynamic().solution(new String[]{"aab", "cab", "baa", "baa"});
        System.out.println(sol);

    }
    public int solution(String[] T) {
        Map<String, List<String>> groupedByLetters= new HashMap<>();
        //groupedByLetters=Arrays.stream(T)
          //      .collect(Collectors.groupingBy(s -> s.toLowerCase().chars().sorted().toString()),Collectors.flatMapping(t -> t,Collectors.toList()));
        groupedByLetters=Arrays.stream(T)
                .collect(Collectors
                        .groupingBy(s->s.toLowerCase().chars().boxed().sorted().map(Character::toChars).map(String::valueOf).collect(Collectors.joining ()),
                                Collectors.toList()));
        Map<String, List<String>> finalGroupedByLetters = groupedByLetters;
        Map<String, Integer> groupedByTrans;

        groupedByLetters.forEach((s, strings) ->
                {

                }
                );
        var res= 0;
        return res;
    }

}
