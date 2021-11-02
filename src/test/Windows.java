package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author 32228
 * 登录窗口界面类
 * 功能：准备登录界面，获取账号密码
 */
public class Windows extends JFrame{
    JLabel jlbImg,jlbReg,jlbPsw;
    JPanel jp;
    JTextField jtf;
    JPasswordField jpf;
    JButton jbLogin;

    public Windows() {

        jp=new JPanel();
        jp.setLayout(null);

        jlbImg=new JLabel();
        ImageIcon image1=new ImageIcon("C:\\Users\\32228\\Desktop\\IDE\\test\\图片1.jpg");
        Image img1 = image1.getImage();
        img1 = img1.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        image1.setImage(img1);
        jlbImg.setIcon(image1);
        jlbImg.setBounds(25,10,50,50);

        jlbReg=new JLabel("账号");
        jlbReg.setBounds(300,16,60,15);
        jlbReg.setForeground(Color.blue);

        jlbPsw=new JLabel("密码");
        jlbPsw.setBounds(300,46,60,15);
        jlbPsw.setForeground(Color.blue);

        jtf=new JTextField(15);
        jtf.setBounds(115,10,180,30);

        jpf=new JPasswordField(15);
        jpf.setBounds(115,35,180,30);

        jbLogin=new JButton("登录");
        jbLogin.setBounds(100,100,180,32);

        jp.add(jlbImg);jp.add(jlbReg);jp.add(jlbPsw);jp.add(jtf);jp.add(jpf);jp.add(jbLogin);
        this.add(jp,"Center");this.setTitle("医院管理系统（账号密码均为“1”）");
        this.setSize(400,200);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        ButtonListener bl=new ButtonListener();
        jbLogin.addActionListener(bl);
        bl.setJt1(jtf);
        bl.setJt2(jpf);
        bl.setJt3(this);
    }
}

/**
 * @author 32228
 * 登录按钮监视类
 * 功能：根据账号密码，确认成功后实例化选择界面
 */
class ButtonListener implements ActionListener{
    private JFrame jf;
    private JTextField jt1;
    private JTextField jt2;

    public void setJt1(JTextField jtext) {
        jt1=jtext;
    }

    public void setJt2(JTextField jtext) {
        jt2=jtext;
    }

    public void setJt3(JFrame jframe) {
        jf=jframe;
    }

    public void actionPerformed(ActionEvent e) {

        String user=jt1.getText();
        String pass=jt2.getText();
        jf.setVisible(false);

        if(user.equals("1")&&pass.equals("1")) {//账号密码
            Select in=new Select();
        }else {
            JOptionPane jop=new JOptionPane();
            JOptionPane.showMessageDialog(jop,"错误-限管理员登录");
            Windows login=new Windows();
        }
    }
}