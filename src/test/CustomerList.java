package test;

/**
 * @author 32228
 * 患者列表类
 * 功能：顺序存储患者信息，并提供增加、删除与查找方法
 */
public class CustomerList {

    private Customer[] customers; //{new Customer(), null, null, null, null}
    private int total = 0; //有效元素

    public CustomerList(int totalCustomer){
        customers = new Customer[totalCustomer];
    }

    public boolean addCustomer(Customer customer){
        if(total >= customers.length){//数组已满
            return false;
        }

        customers[total++] = customer;
        return true;
    }

    public boolean deleteCustomer(int index){
        if(index < 0 || index >= total){
            return false;
        }

        for(int i = index; i < total - 1; i++){
            customers[i] = customers[i+1];
        }

        customers[--total] = null;//最后一个有效元素赋值为null
        return true;
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

