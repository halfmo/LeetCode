public class GenerateMa {
    public int[][] generateMatrix(int n) {
        int [][] a=new int[n][n];
        int looptime = n/2;
        int startx=0;
        int starty=0;
        int set = 1;
        int nub=1;
        int mid=n/2;
        while(looptime>0){
            int i = startx;
            int j = starty;
            for(;j<starty+n-set;++j){
                a[i][j]=nub++;
            }//左到右
            for(;i<startx+n-set;++i){
                a[i][j]=nub++;
            }//上到下
            for(;j>starty;j--){
                a[i][j]=nub++;
            }//右到左
            for(;i>startx;i--){
                a[i][j]=nub++;
            }//下到上
            looptime--;
            startx+=1;
            starty+=1;
            set+=2;
        }
        if(n%2==1){
            a[mid][mid]=nub;
        }
        return a;

    }
}
