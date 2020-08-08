package cn.bikan8;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lenovo
 */
public class MainFrame extends JFrame {


    private static  DoubleColorBall doubleColorBall = new DoubleColorBall();
    private static SuperLotto superLotto =new SuperLotto();
    private static SimpleDateFormat formatter = new SimpleDateFormat("MM-dd HH:mm:ss");

    public MainFrame()  {
        setTitle("人生财富自由 By:小浩 Vx:4213187");
        setSize(560,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension testSize = getSize();
        setLocation((screenSize.width-testSize.width)/2,(screenSize.height-testSize.height)/2);
        setResizable(false);
        setLayout(null);
        try {
            //注意路径问题  / 表示 从根开始
            String src = "/image/ico.jpg";
            Image image = ImageIO.read(getClass().getResource(src));
            setIconImage(image);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }
    public static void main(String[] args) throws IOException {
        MainFrame mainFrame = new MainFrame();
        JButton doubleColorBallButton = new JButton("生成");
        doubleColorBallButton.setBounds(400,240,70,30);
        JButton superLottoButton = new JButton("生成");
        superLottoButton.setBounds(400,6,70,30);
        JButton  doubleColorBallCopyButton = new JButton("复制");
        JButton  superLottoCopyButton = new JButton("复制");
        doubleColorBallCopyButton.setBounds(400,350,70,30);
        superLottoCopyButton.setBounds(400,120,70,30);
        JLabel doubleColorBallLabel  =new JLabel("随机双色球          注数:");
        JLabel superLottoLabel  =new JLabel("随机大乐透          注数:");
        JLabel message = new JLabel("");
        message.setBounds(330,435,210,30);
        message.setFont(new Font("微软雅黑",Font.BOLD,11));
        doubleColorBallLabel.setBounds(10,240,255,30);
        doubleColorBallLabel.setFont(new Font("微软雅黑",Font.BOLD,25));
        superLottoLabel.setBounds(10,6,255,30);
        superLottoLabel.setFont(new Font("微软雅黑",Font.BOLD,25));
        JTextField  superLottoText = new JTextField();
        JTextField  doubleColorBallText = new JTextField();
        superLottoText.setBounds(265,6,50,30);
        doubleColorBallText.setBounds(265,240,50,30);
        superLottoText.setFont(new Font("微软雅黑",Font.BOLD,21));
        doubleColorBallText.setFont(new Font("微软雅黑",Font.BOLD,21));
        TextArea superLottoTextArea = new TextArea();
        superLottoTextArea.setBounds(10,50,315,180);
        TextArea  doubleColorBallTextArea = new TextArea();
        doubleColorBallTextArea.setBounds(10,280,315,180);
        superLottoTextArea.setFont(new Font("微软雅黑",Font.BOLD,22));
        doubleColorBallTextArea.setFont(new Font("微软雅黑",Font.BOLD,22));
        doubleColorBallTextArea.setEditable(false);
        superLottoTextArea.setEditable(false);

        mainFrame.add(doubleColorBallLabel);
        mainFrame.add(superLottoLabel);
        mainFrame.add(message);
        mainFrame.add(doubleColorBallButton);
        mainFrame.add(superLottoButton);
        mainFrame.add(doubleColorBallCopyButton);
        mainFrame.add(superLottoCopyButton);
        mainFrame.add(superLottoText);
        mainFrame.add(doubleColorBallText);
        mainFrame.add(superLottoTextArea);
        mainFrame.add(doubleColorBallTextArea);
        mainFrame.setVisible(true);
        superLottoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int num = Integer.parseInt(superLottoText.getText());
                    if (num<=0){
                        JOptionPane.showMessageDialog(null,"吃屎去吧！","脑子有坑",JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    String allResult ="";
                   for (int i = 0;i <num;i++){
                       allResult = allResult+ superLotto.getRandomResult()+'\n';
                   }
                    superLottoTextArea.setText(allResult);
                }catch (Exception e1){
                    JOptionPane.showMessageDialog(null,"想啥呢，傻吊！","脑子有坑",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        doubleColorBallButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int num = Integer.parseInt(doubleColorBallText.getText());
                    if (num<=0){
                        JOptionPane.showMessageDialog(null,"吃屎去吧！","脑子有坑",JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    String allResult ="";
                    for (int i = 0;i <num;i++){
                        allResult = allResult+ doubleColorBall.getRandomResult()+'\n';
                    }
                    doubleColorBallTextArea.setText(allResult);
                }catch (Exception e1){
                    JOptionPane.showMessageDialog(null,"想啥呢，傻吊！","脑子有坑",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        superLottoCopyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ("".equals(superLottoTextArea.getText())){
                    JOptionPane.showMessageDialog(null,"空的,你复制个毛线！","脑子有坑",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                StringSelection stsel = new StringSelection(superLottoTextArea.getText());
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stsel, stsel);

                message.setText(formatter.format(new Date())+"你离财富自由又进了一步");


            }
        });
        doubleColorBallCopyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ("".equals(doubleColorBallTextArea.getText())){
                    JOptionPane.showMessageDialog(null,"空的,你复制个毛线！","脑子有坑",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                StringSelection stsel = new StringSelection(doubleColorBallTextArea.getText());
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stsel, stsel);
                message.setText(formatter.format(new Date())+"你离财富自由又进了一步");

            }
        });


    }
}
