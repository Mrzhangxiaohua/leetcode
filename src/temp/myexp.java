package temp;

/**
 * @Description:
 * @Author: zf
 * @Date: 2019/9/18 19:47
 */
public class myexp extends Exception{
    String mess;
    public myexp(String Errormes){
        mess = Errormes;
    }
    public String getMess(){
        return mess;
    }
}
