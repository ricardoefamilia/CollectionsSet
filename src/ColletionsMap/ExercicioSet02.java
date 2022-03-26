package ColletionsMap;

import java.util.HashMap;
import java.util.Map;

public class ExercicioSet02 {
    public static void main(String[] args) {
        Map<Integer, Integer> dados = new HashMap<>(){{
            put(1,0);
            put(2,0);
            put(3,0);
            put(4,0);
            put(5,0);
            put(6,0);
        }};
        int num=0, x, x1=0, x2=0, x3=0, x4=0, x5=0, x6=0;
        for(x=0; x < 100; x++){
            num = (int) Math.ceil(Math.random() * 6);
            switch (num){
                case 1: dados.put(1,(++x1));break;
                case 2: dados.put(2,(++x2));break;
                case 3: dados.put(3,(++x3));break;
                case 4: dados.put(4,(++x4));break;
                case 5: dados.put(5,(++x5));break;
                case 6: dados.put(6,(++x6));break;
            }
        }
        System.out.println(dados);
        System.out.println(x);
    }
}
