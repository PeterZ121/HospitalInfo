package test;

/**
 * @author 32228
 * 程序入口
 * 功能：实例化登陆界面，实例化患者列表
 */
public class Regulation {
    public static CustomerList cl = new CustomerList(1000);
    public static void main(String[] args){
        Windows login=new Windows();
    }
}