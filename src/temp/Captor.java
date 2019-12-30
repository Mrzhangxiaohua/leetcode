package temp;

/**
 * @Description:
 * @Author: zf
 * @Date: 2019/9/18 19:48
 */
public class Captor {
    static int quo(int x, int y) throws myexp{
        if (y<0){
            throw new myexp("除数不为fu");
        }
        return 2;
    }

    public static void main(String[] args) {
        try {
            int rse = quo(3,-1);
        }catch (myexp e){
            System.out.println(e.getMess());
        }
    }
}
