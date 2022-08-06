package fold.codility;

public class SandAsphaltSwitchSum {

    public static  void main(String args[]) {

//        var R= "ASAASS";

        var R= "AS";

        var sol = new SandAsphaltSwitchSum().solution(R);
        System.out.println(sol);

    }
    public int solution(String R) {
        var minutes =Integer.MAX_VALUE;


        for (int i = 0; i <=R.length(); i++) {
            var scoot = R.substring(0,i);

            var noScoot = R.substring(i,R.length());
            System.out.println(scoot+"X"+ noScoot);

            var time = scoot.chars().map(operand -> time(false,operand)).sum();
            System.out.println("time scoot"+time);

            var timeFoot= noScoot.chars().map(operand -> time(true,operand)).sum();
            time +=timeFoot;
            System.out.println("time foot "+timeFoot + "time = " + time);
            if (minutes>= time ){
                minutes = time;
            }
        }
        return minutes;
    }

    int time(boolean onfoot,int road){
        var val =0;
        switch (road) {
            case 'A':
                if (onfoot){
                 val =20;
                }else {
                  val =5;
                }
                break;
            case 'S':
                if (onfoot){
                    val =30;
                }else {
                    val =40;
                }
                break;
            default:
                System.out.println("KO");
        };

        return val;
    }
}
