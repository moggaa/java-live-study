package dashboard;
import java.util.*;

public class User {
    List<Boolean> checkList;
    double rate;
    User(int weekSize){
        checkList = new ArrayList<Boolean>();
        for (int i = 0; i < weekSize; i++) {
            checkList.add(Boolean.FALSE);
        }
        rate=0;
    }

    void setRate(int weekSize){
        int sum=0;
        for (Boolean aBoolean : checkList) {
            if (aBoolean){
                sum+=1;
            }
        }
        this.rate = ((double)sum)/weekSize*100;
    }


}
