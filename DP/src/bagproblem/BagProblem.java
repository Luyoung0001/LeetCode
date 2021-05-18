package bagproblem;

public class BagProblem {
    public static void main(String[] args) {
        // 创建宝贝对象
        Treasure t0 = new Treasure(0,0);
        Treasure t1 = new Treasure(2,3);
        Treasure t2 = new Treasure(3,4);
        Treasure t3 = new Treasure(4,5);
        Treasure t4 = new Treasure(5,8);
        // 给宝贝编号，默认为数组下表
        Treasure[] treasures = new Treasure[5];
        treasures[0] = t0;
        treasures[1] = t1;
        treasures[2] = t2;
        treasures[3] = t3;
        treasures[4] = t4;
        // 小偷背包容量为8
        int result = BagPro.maxValue(treasures,8);
        System.out.println(result);
    }
}
class BagPro{
    // 小偷的背包总容量为bagWeightSize
    public static int maxValue(Treasure[] treasuers,int bagWeightSize){
        int[] f = new int[bagWeightSize+1];
        int len = f.length;
        f[0] = 0;
        for(int i = 1; i < len; i++){
            for(int j = 4; j > 0; j--){
                if(i >= treasuers[j].weight){
                    f[i] = Math.max(f[i-1],f[i-treasuers[j].weight]+treasuers[j].value);
                }else{
                    f[i] = f[i-1];
                }
            }
        }
        return f[bagWeightSize];

    }
}
// 定义宝贝数据结构
class Treasure{
    int weight;
    int value;
    public Treasure(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
    public Treasure() {
    }
}
