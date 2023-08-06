package diplom;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class diplom {
	static JFrame jfrm;
	SpringLayout layout;
	JLabel jlabAbout, jlabInstuc, jlabAboutKredit, jlabBG;
	//JTextField;
	static JComboBox<Object> jcbx;
	String items[] = {"Не выбрано", "Потребительские займы", "Ипотечные кредиты", "Автокредитование", "Финансовая аренда(лизинг)"};
	String KreditAbout[][] = {{"","",""}, {"Оформляются для приобретения ", "товаров и расчета за", " предоставляемые услуги."}, {"Долгосрочные займы, ", "целевое назначение которых –", " покупка жилья"},{"Банк выдает клиенту ", "ссуду на покупку", " транспортного средства"},{"Программа, позволяющая получить ", "авто, технику и оборудование", " в пользование"}};
	JButton jbtnNext;
	
	diplom(){
		//основное окно
		jfrm = new JFrame("Скоринг");
		layout = new SpringLayout();
		jfrm.getContentPane().setLayout(new BorderLayout());
        jfrm.setSize(400, 320);
        jfrm.setResizable(false);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        jlabBG = new JLabel(new ImageIcon("C:\\Users\\Nikita\\Desktop\\универ\\diplom\\diplom_prog\\bg1.jpg"));
        
        
        jlabAbout = new JLabel("<html><h1><font face=’helvetica’ size = 4>Описание программы:</h1>" +
                "<font face=’helvetica’ size = 3>" +
                " <p style=\"text-align:left\">Данная программа предназначаена для <br>" +
                " помощи пользователям при взятии кредита. <br>" +
                " Используя введенные пользователем данные <br>" +
                " она определяет, является ли сообразным брать кредит.</p></html>");
        jlabAbout.setPreferredSize(new Dimension(140, 250));
        jlabInstuc = new JLabel("<html><font face=’helvetica’ size = 3>" +
                " <p style=\"text-align:center\">Для начала работы выберите <br>" +
                " необходимый вид кредита <br>" + 
                " для обработки.</p></html>");
        jlabAboutKredit = new JLabel();
        jlabAboutKredit.setPreferredSize(new Dimension(180, 60));
        jcbx = new JComboBox<Object>(items);
        jcbx.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	jlabAboutKredit.setText("<html><font face=’helvetica’ size = 3>" +
            			" <p style=\"text-align:center\">" + KreditAbout[jcbx.getSelectedIndex()][0] + " <br>" +
            			" " + KreditAbout[jcbx.getSelectedIndex()][1] + " <br>" + 
            			" " + KreditAbout[jcbx.getSelectedIndex()][2] + " </p></html>");
            	if (jcbx.getSelectedIndex() == 2)
            		jlabAboutKredit.setPreferredSize(new Dimension(160, 60));
            	else
            		jlabAboutKredit.setPreferredSize(new Dimension(180, 60));
            }
        });
        jbtnNext = new JButton("Продолжить");
        jbtnNext.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		jfrm.dispose();
        		SwingUtilities.invokeLater(new Runnable() {
    	            public void run(){
    	            	try {
    	            		new port_creadit();
    	            	}catch(Exception e){
    	            		System.out.println(e);
    	            	}
    	            }
    	        });
        	}
        });
        
        jfrm.getContentPane().add(jlabBG);
        jlabBG.setLayout(layout);
        
        layout.putConstraint(SpringLayout.WEST, jlabAbout, 10, SpringLayout.WEST, jlabBG);
        layout.putConstraint(SpringLayout.NORTH, jlabAbout, -9, SpringLayout.NORTH, jlabBG);
        layout.putConstraint(SpringLayout.EAST, jlabInstuc, -25, SpringLayout.EAST, jlabBG);
        layout.putConstraint(SpringLayout.NORTH, jlabInstuc, 10, SpringLayout.NORTH, jlabBG);
        layout.putConstraint(SpringLayout.EAST, jcbx, -10, SpringLayout.EAST, jlabBG);
        layout.putConstraint(SpringLayout.NORTH, jcbx, 10, SpringLayout.SOUTH, jlabInstuc);
        layout.putConstraint(SpringLayout.EAST, jlabAboutKredit, -20, SpringLayout.EAST, jlabBG);
        layout.putConstraint(SpringLayout.NORTH, jlabAboutKredit, 10, SpringLayout.SOUTH, jcbx);
        layout.putConstraint(SpringLayout.EAST, jbtnNext, -10, SpringLayout.EAST, jlabBG);
        layout.putConstraint(SpringLayout.SOUTH, jbtnNext, -10, SpringLayout.SOUTH, jlabBG);
        
        jlabBG.add(jlabAbout);
        jlabBG.add(jlabInstuc);
        jlabBG.add(jlabAboutKredit);
        jlabBG.add(jcbx);
        jlabBG.add(jbtnNext);
        jfrm.setVisible(true);
        jfrm.setLocationRelativeTo(null);
        
	}
	
	 public static void main(String args[]) {
	        SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                try{
	                	new diplom();
	                }catch(Exception exc) {
	                	System.out.println(exc);
	                }
	            }
	        });

	    }
}
