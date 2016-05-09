import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class MagicSquare{
    boolean checkRowCol(int[][] array, int initSum){
        int height = array.length;
        for(int j=0; j<height; j++){
            int vs = 0;
            int hs = 0;
            for(int i=0; i<height; i++){
                vs += array[j][i];
                hs += array[i][j];
            }
            if(initSum != vs || initSum != hs)
                return false;
        }
        return true;
    }
    boolean checkDiagonal(int[][] array, int initSum){
        int len   = array.length;
        int maind  = 0;
        int minord = 0;

        for(int i=0; i<len; i++){
            maind += array[i][i];
            minord += array[len-1-i][i];
        }
        return initSum == maind && initSum == minord;
    }
    
    void perm2(List<Integer> prefix, List<Integer> list){
        if(list.size() == 0){
            for(Integer num : prefix){
                System.out.print(num);
            }
            System.out.println();
        }
        for(int i=0; i<list.size(); i++){
            List<Integer> newList = new ArrayList<Integer>(list);
            List<Integer> newPrefix = new ArrayList(prefix);
            newPrefix.add(newList.get(i));
            newList.remove(i);
            perm2(newPrefix,  newList);
        }
    }

    void test2(){
        int len = 2;
        Integer[] array = new Integer[len*len];
        for(int i=0; i<len*len; i++)
            array[i] = i+1;
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(array));
        List<Integer> prefix = new ArrayList<Integer>();

        MagicSquare m = new MagicSquare();
        m.perm2(prefix, list);
    }
}

