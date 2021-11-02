package test;

/**
 * @author 32228
 * 患者列表类
 * 功能：顺序存储患者信息，并提供增加、删除与查找方法
 */


//自定义异常
class ArrayIsFull extends Exception{
    public ArrayIsFull(String message){
        super(message);
    }
}

class ArrayIndexOut extends Exception{
    public ArrayIndexOut(String message){
        super(message);
    }
}



public class CustomerList {

    private Customer[] customers; //{new Customer(), null, null, null, null}
    private int total = 0; //有效元素

    public CustomerList(int totalCustomer){
        customers = new Customer[totalCustomer];
    }


    public void judgeAddCustomer(Customer customer) throws ArrayIsFull{

        if (this.total >= this.customers.length){
            throw new ArrayIsFull("错误:患者列表已满！");
        }
        customers[total++] = customer;
    }

    public void judgeIndexCustomer(int index) throws ArrayIndexOut{

        if(index < 0 || index >= total){
            throw new ArrayIndexOut("错误:患者编号错误，或该患者未进入信息系统！");
        }

        for(int i = index; i < total - 1; i++){
            customers[i] = customers[i+1];
        }
        customers[--total] = null;//最后一个有效元素赋值为null
    }

    public void addCustomer(Customer customer){
        try{
            System.out.println("正在判断患者列表大小");
            judgeAddCustomer(customer);

        }
        catch(ArrayIsFull e){
            System.out.println(e.getMessage());
        }

    }

    public void deleteCustomer(int index){
       try{
           System.out.println("正在搜索患者信息");
           judgeIndexCustomer(index);
       }catch(ArrayIndexOut e){
           System.out.println(e.getMessage());
       }

    }

    public Customer[] getAllCustomers(){
        Customer[] custs = new Customer[total];

        for(int i = 0; i < total; i++){
            custs[i] = customers[i];
        }

        return custs;
    }

    public Customer getCustomer(int index){
        if(index < 0 || index >= total){
            return null;
        }

        return customers[index];
    }


}

