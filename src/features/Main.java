package features;

/**
 * Simple program to generate a textual representation of numbers
 * @author Tatarski
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(showNumberToText(9999));
    }
    /**
     *
     * @param i no-negative integer number (range 1-9999)
     * @return String representation of input value
     */
    private static String showNumberToText(int i) {
        int value = i;
        String slownie="";
        String [] digitsEl ={"","jeden","dwa","trzy","cztery","pięć", "sześć","siedem","osiem","dziewięć","dziesięć"};
        String [] decnumEl ={"","jede","dwa","trzy","czter","pięt","szes","siedem","osiem","dziewięt",""};
        String [] odecnumEl ={"", "dziesięć", "dwadzieścia", "trzydziesci", "czterdziesci", "piećdziesiąt",
                " sześćdziesiąt", " siedemdziesiąt", " osiemdziesiąt", " dziewięćdziesiąt"};
        String [] hunnumEl ={"","sto","dwieście","trzysta","czterysta","piećset","sześćset","siedemset","osiemset","dziewiećset"};
        String [] tausEl={"","tysiąc","tysiące","tysiące","tysiące","tysięcy","tysięcy","tysięcy","tysięcy","tysięcy","tysięcy",};

        if(value<11){
            slownie=digitsEl[value];
        }else if(value>10&&value<20){
            slownie=decnumEl[value-10]+"naście";
        }else if(value>19&&value<100){
            int dzies=value/10;
            slownie=odecnumEl[value/10]+" "+digitsEl[value-(dzies*10)];
        }else if(value>99&&value<1000){
            int setka = value/100;
            int dziesiatka = value-(setka*100);
            int cyfry1do9 = value-(setka*100);
            slownie=hunnumEl[setka]+""+odecnumEl[dziesiatka/10]+" "+digitsEl[cyfry1do9-((dziesiatka/10)*10)];
        }else if(value>999&&value<2000) {
            int tys = value / 1000;
            int setka = (value - 1000 * tys) / 100;
            int dziesiatka = (value - (setka * 100) - (tys * 1000)) / 10;
            int cyfry1do9 = value - ((tys * 1000) + (setka * 100) + (dziesiatka * 10));
            slownie = "tysiąc " + hunnumEl[setka] + " " + odecnumEl[dziesiatka] + " " + digitsEl[cyfry1do9];

        }else if (value>1999){

            int tys = value / 1000;
            int setka = (value - 1000 * tys) / 100;
            int dziesiatka = (value - (setka * 100) - (tys * 1000)) / 10;
            int cyfry1do9 = value - ((tys * 1000) + (setka * 100) + (dziesiatka * 10));
            slownie = digitsEl[tys] + " " + tausEl[tys] + " " + hunnumEl[setka] + " " + odecnumEl[dziesiatka] + " " + digitsEl[cyfry1do9];
        }
        return slownie;
    }
}
