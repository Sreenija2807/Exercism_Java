import java.util.ArrayList;
import java.util.List;
class PrimeCalculator {

    int nth(int nth) {
        if(nth<1) throw new IllegalArgumentException();
        List<Integer> list=new ArrayList<Integer>();
        list.add(2);
        for(int i=3;list.size()<nth;i++){
            int p=1;
            for(int j=2;j<=Math.sqrt(i);j++){
                if(i%j==0){
                    p=0;
                    break;
                }
            }
            if(p==1)
                list.add(i);
        }
        return list.get(nth-1);
    }

}
