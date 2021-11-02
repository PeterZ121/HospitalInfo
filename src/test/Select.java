package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author 32228
 * 选择界面类
 * 功能：准备选择界面，获取用户选择
 */
public class Select extends JFrame{
    JLabel jlbImg;
    JPanel jp;
    JButton adduser,deluser,users,close;
    public Select(){
        jp=new JPanel();
        jp.setLayout(null);

        jlbImg=new JLabel();
        ImageIcon image1=new ImageIcon("C:\\Users\\32228\\Desktop\\IDE\\test\\图片1.jpg");
        Image img1 = image1.getImage();
        img1 = img1.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        image1.setImage(img1);
        jlbImg.setIcon(image1);
        jlbImg.setBounds(25,10,50,50);

        adduser=new JButton("添加患者");
        adduser.setBounds(100,90,180,30);
        deluser=new JButton("删除患者");
        deluser.setBounds(100,120,180,30);
        users=new JButton("患者列表");
        users.setBounds(100,150,180,30);
        close=new JButton("退出系统");
        close.setBounds(100,180,180,30);

        jp.add(jlbImg);jp.add(adduser);jp.add(deluser);jp.add(users);jp.add(close);
        this.add(jp,"Center");this.setTitle("医院管理系统");
        this.setSize(400,300);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        adduser.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                new Adduser();
            }
        });
        deluser.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                new Deluser();
            }
        });
        users.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                new Users();
            }
        });
        close.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}

/**
 * @author 32228
 * 添加用户界面
 * 功能：获取并传递用户输入信息
 */
class Adduser extends JFrame{
    JLabel jlbImg,jlb1,jlb2,jlb3,jlb4,jlb5;
    JPanel jp;
    JTextField xm,xb,nl,bq,xq;
    JButton jb;
    public Adduser() {
        jp=new JPanel();
        jp.setLayout(null);

        jlbImg=new JLabel();
        ImageIcon image1=new ImageIcon("C:\\Users\\32228\\Desktop\\IDE\\test\\图片1.jpg");
        Image img1 = image1.getImage();
        img1 = img1.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        image1.setImage(img1);
        jlbImg.setIcon(image1);
        jlbImg.setBounds(25,10,50,50);

        xm=new JTextField(15);
        xm.setBounds(115,30,180,30);
        jlb1=new JLabel("姓名");
        jlb1.setBounds(300,30,60,15);
        jlb1.setForeground(Color.blue);


        xb=new JTextField(15);
        xb.setBounds(115,60,180,30);
        jlb2=new JLabel("性别");
        jlb2.setBounds(300,60,60,15);
        jlb2.setForeground(Color.blue);


        nl=new JTextField(15);
        nl.setBounds(115,90,180,30);
        jlb3=new JLabel("年龄");
        jlb3.setBounds(300,90,60,15);
        jlb3.setForeground(Color.blue);


        bq=new JTextField(15);
        bq.setBounds(115,120,180,30);
        jlb4=new JLabel("主要病情");
        jlb4.setBounds(300,120,60,15);
        jlb4.setForeground(Color.blue);


        xq=new JTextField(15);
        xq.setBounds(115,150,180,30);
        jlb5=new JLabel("详情");
        jlb5.setBounds(300,150,60,15);
        jlb5.setForeground(Color.blue);


        jb=new JButton("确定");
        jb.setBounds(115,190,180,32);

        this.add(jp,"Center");this.setTitle("添加患者");
        this.setSize(400,300);

        JButton jb0=new JButton("退出添加");
        jb0.setBounds(115,230,180,32);
        jp.add(jb0);

        jp.add(jlbImg);jp.add(jlb1);jp.add(jlb2);jp.add(jlb3);jp.add(jlb4);jp.add(jlb5);
        jp.add(bq);jp.add(xq);jp.add(nl);jp.add(xb);jp.add(xm);jp.add(jb);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);



        jb0.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        jb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String name = xm.getText();
                String gender = xb.getText();
                String age = nl.getText();
                String phone = bq.getText();
                String email = xq.getText();
                if(name.equals("")) {
                    JOptionPane jop=new JOptionPane();
                    JOptionPane.showMessageDialog(jop,"错误-请至少输入患者姓名");
                    return;
                }
                // 将散列数据封装进 Customer 对象
                Customer cust = new Customer(name, gender, age, phone, email);
                // 调用 CustomerList 中的 addCustomer 添加客户信息
                Regulation.cl.addCustomer(cust);
                dispose();
            }
        });
    }
}

/**
 * @author 32228
 * 用户列表类
 * 功能：显示用户列表
 */
class Users{
    public Users() {
        Customer[] customers = Regulation.cl.getAllCustomers();
        JFrame jf=new JFrame("患者列表");
        JPanel jp=new JPanel(new GridLayout(customers.length<20? 20:customers.length,0,5,5));

        if (customers.length == 0) {
            JLabel jlbNone=new JLabel("没有记录！");
            jlbNone.setSize(100,20);
            jlbNone.setForeground(Color.blue);
            jp.add(jlbNone);
        } else {
            JTextField head=new JTextField();
            head.setBounds(10,10,760,18);
            head.setText("编号\t姓名\t性别\t年龄\t主要病情\t\t详情");
            head.setEditable(false);
            jp.add(head);
        }

        for (int i = 0; i < customers.length; i++) {
            String a=(i + 1) + "\t" + customers[i].getDetails();
            JTextField x=new JTextField();
            x.setBounds(10,30+i*20,760,18);
            x.setText(a);
            x.setEditable(false);
            jp.add(x);
        }

        JButton jb=new JButton("确定");
        jb.setBounds(350,720,100,30);
        jp.add(jb);

        JScrollPane jsp=new JScrollPane(jp);
        jf.add(jsp);
        jf.setSize(800,800);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setVisible(true);
        jb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                jf.dispose();
            }
        });
    }
}

/**
 * @author 32228
 * 输出界面类
 * 功能：获取并传递删除患者编号
 */
class Deluser{
    public Deluser() {
        JFrame jf=new JFrame("删除患者");
        JPanel jp=new JPanel();
        jp.setLayout(null);

        JLabel jlb=new JLabel("请输入待删除患者编号");
        jlb.setBounds(50,10,150,30);
        jlb.setForeground(Color.blue);
        jp.add(jlb);

        JTextField num=new JTextField(15);
        num.setBounds(50,45,150,30);
        jp.add(num);

        JButton jb=new JButton("确定");
        jb.setBounds(200,45,100,30);
        jp.add(jb);

        JButton jb0=new JButton("退出删除");
        jb0.setBounds(150,150,100,30);
        jp.add(jb0);

        jf.add(jp);
        jf.setSize(400,300);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setVisible(true);

        jb0.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                jf.dispose();
            }
        });

        Listener bl=new Listener();
        jb.addActionListener(bl);
        bl.setJt1(num);
    }
}
/**
 * @author 32228
 * 删除按钮监视类
 * 功能：检查患者编号是否合法，并弹出确认窗口
 */
class Listener implements ActionListener{
    private JTextField jtf;
    public void setJt1(JTextField jtext) {
        jtf=jtext;
    }
    public void actionPerformed(ActionEvent e) {
        if(jtf.getText().equals("")) {
            JOptionPane jop=new JOptionPane();
            JOptionPane.showMessageDialog(jop,"错误-请输入患者编号");
            return;
        }
        Customer cust = Regulation.cl.getCustomer(Integer.parseInt(jtf.getText()) - 1);
        if (cust == null) {
            JOptionPane jop=new JOptionPane();
            JOptionPane.showMessageDialog(jop,"错误-无此编号患者");
        } else {
            String str = "删除患者"+cust.getName()+"?";
            JOptionPane jop=new JOptionPane();
            int is=JOptionPane.showConfirmDialog(jop, str, "提示",JOptionPane.OK_CANCEL_OPTION);
            if(is==JOptionPane.OK_OPTION) {
                Regulation.cl.deleteCustomer(Integer.parseInt(jtf.getText()) - 1);
            }else {

            }
        }
    }
}

