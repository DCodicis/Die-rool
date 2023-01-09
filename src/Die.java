public class Die {
    private int numOfSides;
    private int[] statistics;
    private int lastToss;
        
    public Die(){
        this(6);
    }
        
    public Die(int n) {
        numOfSides=n;
        statistics=new int[numOfSides];
    }
        
    public int rollDie(boolean unique){
        int result;
        if (unique) {
            do {
            result=1+(int)(Math.random()*numOfSides);
            } 
            while (result == lastToss);
        } 
        else{
            result=1+(int)(Math.random()*numOfSides);
        }
        lastToss = result;
        statistics[result-1]++;
        return result;
    }

    private int getMostFrequent(){
        int max = 0, most = 0, num = 0;
        for(int i = 0;i<numOfSides; i++){
            max = statistics[i];
            if(max > most){
                most = max;
                num = i + 1;
            }
        }
        return num;
    }
    public int[] getAllMostFrequents(){
        int max = 0, most = 0, num = 0, win = 0;
        for(int i=0;i<numOfSides;i++){
            max = statistics[i];
            if(max > most){
                most = max;
            }
        }
        for(int i=0;i<numOfSides;i++){
            max = statistics[i];
            if(most == max){
                num++;
            }
        }
        int[] winners = new int[num];
        for(int i=0;i<numOfSides;i++){
            max = statistics[i];
            if(most == max){
                winners[win] = i + 1;
                win++;
            }
        }
        return winners;
    }

    public void showStatistics(){
        int k;
        int[] win = getAllMostFrequents();
        for (k=0; k<numOfSides ; k++){
            System.out.println(k+1 + ":" + statistics[k]);
        }
        
        for(int i=0;i<win.length;i++){
            System.out.println("The winners is: "+win[i]);
        }
        
        System.out.println("Most frequent digit is "+getMostFrequent());
    }    
}

