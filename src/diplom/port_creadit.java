package diplom;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.MaskFormatter;

public class port_creadit {
	int check_fail;
	JFrame jfrm2;
	JLabel jlabBG2, jlabTitle2;
	SpringLayout layout;
	JTabbedPane jtp;
	JButton jbtnBackToM, jbtnResGen;
	JPanel calc, anceta;
	
	static JFormattedTextField jftfPayDate;
	static JTextField jtfSum, jtfProcent, jtfMonthPay, jtfSrok;
	JLabel jlabAboutKredit, jlabSum, jlabProcent, jlabMonthPay, jlabSrok, jlabPayDate, jlabError, jlabError2;
	JButton jbtnCalendar;
	JButton testBut;
	JLabel jlabBG3;
	
	JScrollPane jspAnceta;
	JButton test2;
	JLabel jlabExistCheckoutAccountStatus, jlabCreditHistory, jlabPurpose, jlabSavings, jlabEmployment, jlabPersStatGender, jlabOtherDebtors, jlabResidenceSince, jlabProperty, jlabAge, jlabOtherPayPlans, jlabHousing, jlabExistingCredits, jlabJob, jlabNumbDepend, jlabTelephone, jlabForeighWork;
	ButtonGroup jbtgExistCheckoutAccountStatus, jbtgCreditHistory, jbtgPurpose, jbtgSavings, jbgtEmployment, jbgtPersStatGender, jbgtOtherDebtors, jbgtProperty, jbgtOtherPayPlans, jbgtHousing, jbgtJob, jbgtTelephone, jbgtForeighWork;
	JTextField jtfResidenceSince, jtfAge, jtfExistingCredits, jtfNumbDepend;
	JLabel jlabBG4;	
	static String targetAttrib[] = new String[20];
	
	port_creadit() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new machine_learn();
			}
		});
		jfrm2 = new JFrame("�������");
		layout = new SpringLayout();
        jfrm2.getContentPane().setLayout(new BorderLayout());
        jfrm2.setSize(600, 325);
        jfrm2.setResizable(false);
        jfrm2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jlabBG2 = new JLabel(new ImageIcon("C:\\Users\\Nikita\\Desktop\\������\\diplom\\diplom_prog\\bg1.jpg"));
        jlabBG2.setLayout(layout);
        
        jlabTitle2 = new JLabel("��������������� �����");
        jlabTitle2.setFont(new Font("Dialog", 1, 18));
        
        jbtnBackToM  = new JButton("< �����");
		jbtnResGen = new JButton("��������� >");
		
		jbtnBackToM.addActionListener(new ActionListener(){
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e){
				jfrm2.dispose();
				diplom.jfrm.show();
			}
		});
        
        //�������
        jtp = new JTabbedPane();
        calc = new JPanel();
        anceta = new JPanel();
        jtp.addTab("�����������", calc);
        jtp.addTab("������� ���������� ������", anceta);
        calc.setLayout(new BorderLayout());
        anceta.setLayout(new BorderLayout());
        jtp.setPreferredSize(new Dimension(591, 238));
        
        calc_tab();
        anceta_tab();
        
        layout.putConstraint(SpringLayout.NORTH, jlabTitle2, 10, SpringLayout.NORTH, jlabBG2);
		layout.putConstraint(SpringLayout.WEST, jlabTitle2, 180, SpringLayout.WEST, jlabBG2);
		layout.putConstraint(SpringLayout.NORTH, jtp, 55, SpringLayout.NORTH, jlabBG2);
		layout.putConstraint(SpringLayout.WEST, jtp, -3, SpringLayout.WEST, jlabBG2);
		layout.putConstraint(SpringLayout.NORTH, jbtnBackToM, 10, SpringLayout.NORTH, jlabBG2);
		layout.putConstraint(SpringLayout.WEST, jbtnBackToM, 10, SpringLayout.WEST, jlabBG2);
		layout.putConstraint(SpringLayout.NORTH, jbtnResGen, 10, SpringLayout.NORTH, jlabBG2);
		layout.putConstraint(SpringLayout.EAST, jbtnResGen, -10, SpringLayout.EAST, jlabBG2);
        
		jfrm2.getContentPane().add(jlabBG2);
		jlabBG2.add(jlabTitle2);
		jlabBG2.add(jtp);
		jlabBG2.add(jbtnBackToM);
		jlabBG2.add(jbtnResGen);
		jfrm2.setVisible(true);
		jfrm2.setLocationRelativeTo(null);
		
	}
	
	//��� ������������
	@SuppressWarnings("deprecation")
	public void calc_tab(){
		jlabSum = new JLabel("����� �������");
		jtfSum = new JTextField();
		jtfSum.setPreferredSize(new Dimension(100, 20));
		
		jlabProcent = new JLabel("���������� �������");
		jtfProcent = new JTextField();
		jtfProcent.setPreferredSize(new Dimension(100, 20));
		
		jlabMonthPay = new JLabel("����������� �������");
		jtfMonthPay = new JTextField();
		jtfMonthPay.setPreferredSize(new Dimension(100, 20));
		jtfMonthPay.setEditable(false);
		
		jlabSrok = new JLabel("���� ������ (� �������)");
		jtfSrok = new JTextField();
		jtfSrok.setPreferredSize(new Dimension(40, 20));
		
		jlabPayDate = new JLabel("���� ������ ������");
		try {
			jftfPayDate = new JFormattedTextField(new MaskFormatter("##.##.####"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		jftfPayDate.setPreferredSize(new Dimension(100, 20));
		
		jlabError = new JLabel("������� ������� ����, ��������� �������");
		jlabError.hide();
		jlabError2 = new JLabel("������� ������� ������, ��������� �������");
		jlabError2.hide();
		
		jlabBG3 = new JLabel(new ImageIcon("E:\\prog\\bg1.jpg"));
		jlabBG3.setLayout(layout);
		
		jbtnCalendar = new JButton("������������� ��������� ������");
		testBut = new JButton("����");
		
		//��������� �����
		jtfSum.addKeyListener(keyAdapter);
		jtfListener(jtfSum);
		
		jtfProcent.addKeyListener(keyAdapter);
		jtfListener(jtfProcent);

		jtfSrok.addKeyListener(keyAdapter);
		jtfListener(jtfSrok);
		
		
		jbtnCalendar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				jlabError.hide();
				jlabError2.hide();
				correct_data_check(jftfPayDate.getText());
				if (check_fail == 0) {
					SwingUtilities.invokeLater(new Runnable() {
	    	            public void run() {
	    	                try {
								new ExcelWorker();
							} catch (ParseException | NumberFormatException e) {
								e.printStackTrace();
								jftfPayDate.setText("");
								jlabError2.show();
							}
	    	            }
	    	        });
				}
				else {
					jftfPayDate.setText("");
					jlabError.show();
				}
				
			}
		});
		
		testBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtfSum.setText("500000");
				jtfProcent.setText("12");
				jtfSrok.setText("24");
				jftfPayDate.setText("31.04.2021");
			}
		});
		
		layout.putConstraint(SpringLayout.NORTH, jlabSum, 20, SpringLayout.NORTH, jlabBG3);
		layout.putConstraint(SpringLayout.WEST, jlabSum, 30, SpringLayout.WEST, jlabBG3);
		layout.putConstraint(SpringLayout.NORTH, jtfSum, 20, SpringLayout.NORTH, jlabBG3);
		layout.putConstraint(SpringLayout.WEST, jtfSum, 15, SpringLayout.EAST, jlabSum);
		layout.putConstraint(SpringLayout.NORTH, jlabProcent, 20, SpringLayout.SOUTH, jlabSum);
		layout.putConstraint(SpringLayout.WEST, jlabProcent, 30, SpringLayout.WEST, jlabBG3);
		layout.putConstraint(SpringLayout.NORTH, jtfProcent, 16, SpringLayout.SOUTH, jtfSum);
		layout.putConstraint(SpringLayout.WEST, jtfProcent, 15, SpringLayout.EAST, jlabProcent);
		layout.putConstraint(SpringLayout.NORTH, jlabMonthPay, 20, SpringLayout.SOUTH, jlabProcent);
		layout.putConstraint(SpringLayout.WEST, jlabMonthPay, 30, SpringLayout.WEST, jlabBG3);
		layout.putConstraint(SpringLayout.NORTH, jtfMonthPay, 16, SpringLayout.SOUTH, jtfProcent);
		layout.putConstraint(SpringLayout.WEST, jtfMonthPay, 15, SpringLayout.EAST, jlabMonthPay);
		layout.putConstraint(SpringLayout.NORTH, jlabSrok, 20, SpringLayout.NORTH, jlabBG3);
		layout.putConstraint(SpringLayout.WEST, jlabSrok, 100, SpringLayout.EAST, jtfSum);
		layout.putConstraint(SpringLayout.NORTH, jtfSrok, 20, SpringLayout.NORTH, jlabBG3);
		layout.putConstraint(SpringLayout.WEST, jtfSrok, 15, SpringLayout.EAST, jlabSrok);
		layout.putConstraint(SpringLayout.NORTH, jlabPayDate, 20, SpringLayout.SOUTH, jlabSrok);
		layout.putConstraint(SpringLayout.WEST, jlabPayDate, 68, SpringLayout.EAST, jtfProcent);
		layout.putConstraint(SpringLayout.NORTH, jftfPayDate, 16, SpringLayout.SOUTH, jtfSrok);
		layout.putConstraint(SpringLayout.WEST, jftfPayDate, 15, SpringLayout.EAST, jlabPayDate);
		layout.putConstraint(SpringLayout.NORTH, jlabError, 9, SpringLayout.SOUTH, jftfPayDate);
		layout.putConstraint(SpringLayout.EAST, jlabError, -15, SpringLayout.EAST, jlabBG3);
		layout.putConstraint(SpringLayout.NORTH, jlabError2, 9, SpringLayout.SOUTH, jftfPayDate);
		layout.putConstraint(SpringLayout.EAST, jlabError2, -15, SpringLayout.EAST, jlabBG3);
		layout.putConstraint(SpringLayout.SOUTH, jbtnCalendar, -15, SpringLayout.SOUTH, jlabBG3);
		layout.putConstraint(SpringLayout.EAST, jbtnCalendar, -15, SpringLayout.EAST, jlabBG3);
		layout.putConstraint(SpringLayout.SOUTH, testBut, -15, SpringLayout.NORTH, jbtnCalendar);
		layout.putConstraint(SpringLayout.EAST, testBut, -15, SpringLayout.EAST, jlabBG3);
		
		calc.add(jlabBG3);
		jlabBG3.add(jlabSum);
		jlabBG3.add(jtfSum);
		jlabBG3.add(jlabProcent);
		jlabBG3.add(jtfProcent);
		jlabBG3.add(jlabMonthPay);
		jlabBG3.add(jtfMonthPay);
		jlabBG3.add(jlabSrok);
		jlabBG3.add(jtfSrok);
		jlabBG3.add(jlabPayDate);
		jlabBG3.add(jftfPayDate);
		jlabBG3.add(jbtnCalendar);
		jlabBG3.add(jlabError);
		jlabBG3.add(jlabError2);
		//jlabBG3.add(testBut);
	}
	
	//��� ������� ���������� ������
	public void anceta_tab(){
		jlabBG4 = new JLabel(new ImageIcon("E:\\prog\\bg2.jpg"));
		jlabBG4.setLayout(layout);
		jlabBG4.setPreferredSize(new Dimension(550, 1045));
		jspAnceta = new JScrollPane(jlabBG4);
		
		
		jlabExistCheckoutAccountStatus = new JLabel("������ �������� �����");
		jbtgExistCheckoutAccountStatus = new ButtonGroup();
		JRadioButton jrb1ExistCheckoutAccountStatus = new JRadioButton("< 0 ���");
		JRadioButton jrb2ExistCheckoutAccountStatus = new JRadioButton("0 < ... < 9000 ���");
		JRadioButton jrb3ExistCheckoutAccountStatus = new JRadioButton("> 9000 ���");
		JRadioButton jrb4ExistCheckoutAccountStatus = new JRadioButton("��� �������� �����");
		JRadioButton BGExistCheck[] = {jrb1ExistCheckoutAccountStatus, jrb2ExistCheckoutAccountStatus,
				jrb3ExistCheckoutAccountStatus, jrb4ExistCheckoutAccountStatus};
		jbtgExistCheckoutAccountStatus.add(jrb1ExistCheckoutAccountStatus);
		jbtgExistCheckoutAccountStatus.add(jrb2ExistCheckoutAccountStatus);
		jbtgExistCheckoutAccountStatus.add(jrb3ExistCheckoutAccountStatus);
		jbtgExistCheckoutAccountStatus.add(jrb4ExistCheckoutAccountStatus);
		jbtgExistCheckoutAccountStatus.getSelection();
		
		jlabCreditHistory = new JLabel("��������� �������");
		jbtgCreditHistory = new ButtonGroup();
		JRadioButton jrb1CreditHistory = new JRadioButton("�� ���� �������/��� ������� ��������� � ����");
		JRadioButton jrb2CreditHistory = new JRadioButton("��� ������� � ������ ����� �������� �������");
		JRadioButton jrb3CreditHistory = new JRadioButton("������� ������� �� ������� ���������� �������");
		JRadioButton jrb4CreditHistory = new JRadioButton("�������� � ��������� � �������");
		JRadioButton jrb5CreditHistory = new JRadioButton("�������� � ��������� �� �������� �������");
		JRadioButton BGCredit[] = {jrb1CreditHistory, jrb2CreditHistory, jrb3CreditHistory, jrb4CreditHistory, 
									jrb5CreditHistory};
		jbtgCreditHistory.add(jrb1CreditHistory);
		jbtgCreditHistory.add(jrb2CreditHistory);
		jbtgCreditHistory.add(jrb3CreditHistory);
		jbtgCreditHistory.add(jrb4CreditHistory);
		jbtgCreditHistory.add(jrb5CreditHistory);
		
		jlabPurpose = new JLabel("���� �������");
		jbtgPurpose = new ButtonGroup();
		JRadioButton jrb1Purpose = new JRadioButton("������ (�����)");
		JRadioButton jrb2Purpose = new JRadioButton("������ (�/�)");
		JRadioButton jrb3Purpose = new JRadioButton("������/������������");
		JRadioButton jrb4Purpose = new JRadioButton("�����/�����������");
		JRadioButton jrb5Purpose = new JRadioButton("������� �������");
		JRadioButton jrb6Purpose = new JRadioButton("������");
		JRadioButton jrb7Purpose = new JRadioButton("��������");
		JRadioButton jrb8Purpose = new JRadioButton("�����");
		JRadioButton jrb9Purpose = new JRadioButton("��������������");
		JRadioButton jrb10Purpose = new JRadioButton("������");
		JRadioButton jrb11Purpose = new JRadioButton("������");
		JRadioButton BGPurpose[] = {jrb1Purpose, jrb2Purpose, jrb3Purpose, jrb4Purpose, jrb5Purpose, jrb6Purpose, 
				jrb7Purpose, jrb8Purpose, jrb9Purpose, jrb10Purpose, jrb11Purpose};
		jbtgPurpose.add(jrb1Purpose);
		jbtgPurpose.add(jrb2Purpose);
		jbtgPurpose.add(jrb3Purpose);
		jbtgPurpose.add(jrb4Purpose);
		jbtgPurpose.add(jrb5Purpose);
		jbtgPurpose.add(jrb6Purpose);
		jbtgPurpose.add(jrb7Purpose);
		jbtgPurpose.add(jrb8Purpose);
		jbtgPurpose.add(jrb9Purpose);
		jbtgPurpose.add(jrb10Purpose);
		jbtgPurpose.add(jrb11Purpose);
		
		jlabSavings = new JLabel("������ �������������� �����");
		jbtgSavings = new ButtonGroup();
		JRadioButton jrb1Savings = new JRadioButton("... <  4500 ���");
		JRadioButton jrb2Savings = new JRadioButton("4500 <= ... <  21500 ���");
		JRadioButton jrb3Savings = new JRadioButton("21500 <= ... < 43000 ���");
		JRadioButton jrb4Savings = new JRadioButton("... >= 43000 ���");
		JRadioButton jrb5Savings = new JRadioButton("�� ��������/��� �������������� �����");
		JRadioButton BGSavings[] = {jrb1Savings, jrb2Savings, jrb3Savings, jrb4Savings, jrb5Savings}; 
		jbtgSavings.add(jrb1Savings);
		jbtgSavings.add(jrb2Savings);
		jbtgSavings.add(jrb3Savings);
		jbtgSavings.add(jrb4Savings);
		jbtgSavings.add(jrb5Savings);
		
		jlabEmployment = new JLabel("���� ������ �� ������� ������� �����");
		jbgtEmployment = new ButtonGroup();
		JRadioButton jrb1Employment = new JRadioButton("�����������");
		JRadioButton jrb2Employment = new JRadioButton("... < 1 ����");
		JRadioButton jrb3Employment = new JRadioButton("1  <= ... < 4 ���");
		JRadioButton jrb4Employment = new JRadioButton("4  <= ... < 7 ���");
		JRadioButton jrb5Employment = new JRadioButton(".. >= 7 ���");
		JRadioButton BGEmployed[] = {jrb1Employment, jrb2Employment, jrb3Employment, jrb4Employment, jrb5Employment};
		jbgtEmployment.add(jrb1Employment);
		jbgtEmployment.add(jrb2Employment);
		jbgtEmployment.add(jrb3Employment);
		jbgtEmployment.add(jrb4Employment);
		jbgtEmployment.add(jrb5Employment);
		
		jlabPersStatGender = new JLabel("�������� ���������/���");
		jbgtPersStatGender = new ButtonGroup();
		JRadioButton jrb1PersStatGender = new JRadioButton("������� : ��������/�� ����� ������");
		JRadioButton jrb2PersStatGender = new JRadioButton("������� : ���������/�� ����� ������/�������");
		JRadioButton jrb3PersStatGender = new JRadioButton("������� : ������");
		JRadioButton jrb4PersStatGender = new JRadioButton("������� : �����/������");
		JRadioButton jrb5PersStatGender = new JRadioButton("������� : �� �������");
		JRadioButton BGPersStatGender[] = {jrb1PersStatGender, jrb2PersStatGender, jrb3PersStatGender, jrb4PersStatGender, 
											jrb5PersStatGender};
		jbgtPersStatGender.add(jrb1PersStatGender);
		jbgtPersStatGender.add(jrb2PersStatGender);
		jbgtPersStatGender.add(jrb3PersStatGender);
		jbgtPersStatGender.add(jrb4PersStatGender);
		jbgtPersStatGender.add(jrb5PersStatGender);
		
		jlabOtherDebtors = new JLabel("������ ����������/����������");
		jbgtOtherDebtors = new ButtonGroup();
		JRadioButton jrb1OtherDebtors = new JRadioButton("���");
		JRadioButton jrb2OtherDebtors = new JRadioButton("���������");
		JRadioButton jrb3OtherDebtors = new JRadioButton("����������");
		JRadioButton BGOtherDebtors[] = {jrb1OtherDebtors, jrb2OtherDebtors, jrb3OtherDebtors};
		jbgtOtherDebtors.add(jrb1OtherDebtors);
		jbgtOtherDebtors.add(jrb2OtherDebtors);
		jbgtOtherDebtors.add(jrb3OtherDebtors);
		
		jlabResidenceSince = new JLabel("��������� � ������ ������� ");
		jtfResidenceSince = new JTextField();
		jtfResidenceSince.setPreferredSize(new Dimension(20, 20));
		JLabel jlabLet = new JLabel(" ���");
		
		jlabProperty = new JLabel("��������� � �������������");
		jbgtProperty = new ButtonGroup();
		JRadioButton jrb1Property = new JRadioButton("������������ ");
		JRadioButton jrb2Property = new JRadioButton("������� ����� ������������� ��������/����������� �����");
		JRadioButton jrb3Property = new JRadioButton("����������/������");
		JRadioButton jrb4Property = new JRadioButton("����������/��� �������������");
		JRadioButton BGProperty[] = {jrb1Property, jrb2Property, jrb3Property, jrb4Property};
		jbgtProperty.add(jrb1Property);
		jbgtProperty.add(jrb2Property);
		jbgtProperty.add(jrb3Property);
		jbgtProperty.add(jrb4Property);
		
		jlabAge = new JLabel("�������");
		jtfAge = new JTextField();
		jtfAge.setPreferredSize(new Dimension(20, 20));
		JLabel jlabLet2 = new JLabel(" ���");
		
		jlabOtherPayPlans = new JLabel("������ ���� �������");
		jbgtOtherPayPlans = new ButtonGroup();
		JRadioButton jrb1OtherPayPlans = new JRadioButton("��������� ������ ��������");
		JRadioButton jrb2OtherPayPlans = new JRadioButton("������� � ���������");
		JRadioButton jrb3OtherPayPlans = new JRadioButton("���");
		JRadioButton BGOtherPayPlans[] = {jrb1OtherPayPlans, jrb2OtherPayPlans, jrb3OtherPayPlans};
		jbgtOtherPayPlans.add(jrb1OtherPayPlans);
		jbgtOtherPayPlans.add(jrb2OtherPayPlans);
		jbgtOtherPayPlans.add(jrb3OtherPayPlans);
		
		jlabHousing = new JLabel("����� ����������");
		jbgtHousing = new ButtonGroup();
		JRadioButton jrb1Housing = new JRadioButton("������������ �����");
		JRadioButton jrb2Housing = new JRadioButton("����� � �������������");
		JRadioButton jrb3Housing = new JRadioButton("���������� �����");
		JRadioButton BGHousing[] = {jrb1Housing, jrb2Housing, jrb3Housing};
		jbgtHousing.add(jrb1Housing);
		jbgtHousing.add(jrb2Housing);
		jbgtHousing.add(jrb3Housing);
		
		jlabExistingCredits = new JLabel("���������� ������� ��������");
		jtfExistingCredits = new JTextField();
		jtfExistingCredits.setPreferredSize(new Dimension(20, 20));
		
		jlabJob = new JLabel("��������� ���������� ���������");
		jbgtJob = new ButtonGroup();
		JRadioButton jrb1Job = new JRadioButton("�����������/�������, �� ��������");
		JRadioButton jrb2Job = new JRadioButton("�������, ��������");
		JRadioButton jrb3Job = new JRadioButton("����������/��������");
		JRadioButton jrb4Job = new JRadioButton("������������/������� ���������������/����������������������� ����������/��������������");
		JRadioButton BGJob[] = {jrb1Job, jrb2Job, jrb3Job, jrb4Job};
		jbgtJob.add(jrb1Job);
		jbgtJob.add(jrb2Job);
		jbgtJob.add(jrb3Job);
		jbgtJob.add(jrb4Job);
		
		jlabTelephone = new JLabel("�������");
		jbgtTelephone = new ButtonGroup();
		JRadioButton jrb1Telephone = new JRadioButton("���");
		JRadioButton jrb2Telephone = new JRadioButton("����, ��������������� �� ����� �������");
		JRadioButton BGTelephone[] = {jrb1Telephone, jrb2Telephone};
		jbgtTelephone.add(jrb1Telephone);
		jbgtTelephone.add(jrb2Telephone);
		
		jlabForeighWork = new JLabel("�������� ����������� ����������");
		jbgtForeighWork = new ButtonGroup();
		JRadioButton jrb1ForeighWork = new JRadioButton("��");
		JRadioButton jrb2ForeighWork = new JRadioButton("���");
		JRadioButton BGForeighWork[] = {jrb1ForeighWork, jrb2ForeighWork};
		jbgtForeighWork.add(jrb1ForeighWork);
		jbgtForeighWork.add(jrb2ForeighWork);
		ButtonGroup ButtonGroups[] = {jbtgExistCheckoutAccountStatus, jbtgCreditHistory, jbtgPurpose, jbtgSavings, jbgtEmployment, jbgtPersStatGender,
				jbgtOtherDebtors, jbgtProperty, jbgtOtherPayPlans, jbgtHousing, jbgtJob};
		JRadioButton[] ButtonGroupGroup[] = {BGExistCheck, BGCredit, BGPurpose, BGSavings, BGEmployed, BGPersStatGender, BGOtherDebtors, BGProperty, BGOtherPayPlans, BGHousing, BGJob, BGTelephone, BGForeighWork};
		String reformedAttrib[][] = {{"<0", "0<=X<9000", ">=9000", "no checking"}, {"no credits/all paid", "all paid", "existing paid", "delayed previously", "critical/other existing credit"}, {"new car", "used car", "furniture/equipment", "radio/tv", "domestic appliance", "repairs", "education", "vacation", "retraining", "business", "other"}, {"<100", "100<=X<500", "500<=X<1000", ">=1000", "no known savings"}, {"unemployed", "<1", "1<=X<4", "4<=X<7", ">=7"}, {"male div/sep", "female div/dep/mar", "male single", "male mar/wid", "female single"}, {"none", "co applicant", "guarantor"}, {"real estate", "life insurance", "car", "no known property"}, {"bank", "stores", "none"}, {"rent", "own", "for free"}, {"unemp/unskilled non res", "unskilled resident", "skilled", "high qualif/self emp/mgmt"}, {"none", "yes"}, {"yes", "no"}};
		
		jbtnResGen.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
        			if (jtfResidenceSince.getText().equals("") | jtfAge.getText().equals("") | jtfExistingCredits.getText().equals("") | jtfSum.getText().equals("") | jtfSrok.getText().equals("") | jtfProcent.getText().equals("")) {
        				JOptionPane.showMessageDialog(jfrm2, "������: ���� ��� ��������� ����� ������ �� ���������", "������", JOptionPane.ERROR_MESSAGE);
        				return;
        			}
        			for (int i = 0; i < ButtonGroups.length; i++) {
        				if (ButtonGroups[i].getSelection() == null) {
        					JOptionPane.showMessageDialog(jfrm2, "������: �� ��� ������ ������ ��������", "������", JOptionPane.ERROR_MESSAGE);
        					return;
        				}
        			}
        			for (int i = 0; i < ButtonGroupGroup.length; i++) {
        				for (int j = 0; j < ButtonGroupGroup[i].length; j++) {
        					JRadioButton[] p = ButtonGroupGroup[i];
        					if (p[j].isSelected()) {
        						targetAttrib[i] = reformedAttrib[i][j];
        					}
        				}
        			}
        			targetAttrib[13] = jtfResidenceSince.getText();
        			targetAttrib[14] = jtfAge.getText();
        			targetAttrib[15] = jtfExistingCredits.getText();
        			targetAttrib[16] = jtfSum.getText();
        			targetAttrib[17] = jtfSrok.getText();
        			targetAttrib[18] = jtfProcent.getText();
        			targetAttrib[19] = "0";
        			
        			machine_learn.machine_predict();
        			
        			if (machine_learn.prediction.equals("good")) {
        				JOptionPane.showMessageDialog(jfrm2, "�����������! ��� ������, ��������� �����, �������", "�������� ������������", JOptionPane.INFORMATION_MESSAGE);
        			}else {
        				JOptionPane.showMessageDialog(jfrm2, "� ���������, ��� ������, ��������� �����, �� �������", "�������� ������������", JOptionPane.INFORMATION_MESSAGE);
        			}
        		}catch(Exception e1) {
        			e1.printStackTrace();
        		}
        	}
        });
		
		test2 = new JButton("����");
		test2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				jrb1ExistCheckoutAccountStatus.setSelected(true);
				jrb1CreditHistory.setSelected(true);
				jrb1Purpose.setSelected(true);
				jrb1Savings.setSelected(true);
				jrb1Employment.setSelected(true);
				jrb1PersStatGender.setSelected(true);
				jrb1OtherDebtors.setSelected(true);
				jrb1Property.setSelected(true);
				jrb1OtherPayPlans.setSelected(true);
				jrb1Housing.setSelected(true);
				jrb1Job.setSelected(true);
				jrb1Telephone.setSelected(true);
				jrb1ForeighWork.setSelected(true);
				jtfResidenceSince.setText("5");
				jtfAge.setText("22");
				jtfExistingCredits.setText("1");
			}
		});
		
		layout.putConstraint(SpringLayout.NORTH, jlabExistCheckoutAccountStatus, 5, SpringLayout.NORTH, jlabBG4);
		layout.putConstraint(SpringLayout.WEST, jlabExistCheckoutAccountStatus, 30, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jrb1ExistCheckoutAccountStatus, 0, SpringLayout.SOUTH, jlabExistCheckoutAccountStatus);
		layout.putConstraint(SpringLayout.WEST, jrb1ExistCheckoutAccountStatus, 50, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jrb2ExistCheckoutAccountStatus, -5, SpringLayout.SOUTH, jrb1ExistCheckoutAccountStatus);
		layout.putConstraint(SpringLayout.WEST, jrb2ExistCheckoutAccountStatus, 50, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jrb3ExistCheckoutAccountStatus, -5, SpringLayout.SOUTH, jrb2ExistCheckoutAccountStatus);
		layout.putConstraint(SpringLayout.WEST, jrb3ExistCheckoutAccountStatus, 50, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jrb4ExistCheckoutAccountStatus, -5, SpringLayout.SOUTH, jrb3ExistCheckoutAccountStatus);
		layout.putConstraint(SpringLayout.WEST, jrb4ExistCheckoutAccountStatus, 50, SpringLayout.WEST, jlabBG4);
		
		layout.putConstraint(SpringLayout.NORTH, jlabCreditHistory, 5, SpringLayout.NORTH, jlabBG4);
		layout.putConstraint(SpringLayout.WEST, jlabCreditHistory, 210, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jrb1CreditHistory, 0, SpringLayout.SOUTH, jlabCreditHistory);
		layout.putConstraint(SpringLayout.WEST, jrb1CreditHistory, 230, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jrb2CreditHistory, -5, SpringLayout.SOUTH, jrb1CreditHistory);
		layout.putConstraint(SpringLayout.WEST, jrb2CreditHistory, 230, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jrb3CreditHistory, -5, SpringLayout.SOUTH, jrb2CreditHistory);
		layout.putConstraint(SpringLayout.WEST, jrb3CreditHistory, 230, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jrb4CreditHistory, -5, SpringLayout.SOUTH, jrb3CreditHistory);
		layout.putConstraint(SpringLayout.WEST, jrb4CreditHistory, 230, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jrb5CreditHistory, -5, SpringLayout.SOUTH, jrb4CreditHistory);
		layout.putConstraint(SpringLayout.WEST, jrb5CreditHistory, 230, SpringLayout.WEST, jlabBG4);
		
		layout.putConstraint(SpringLayout.NORTH, jlabPurpose, 15, SpringLayout.SOUTH, jrb4ExistCheckoutAccountStatus);
		layout.putConstraint(SpringLayout.WEST, jlabPurpose, 30, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jrb1Purpose, 0, SpringLayout.SOUTH, jlabPurpose);
		layout.putConstraint(SpringLayout.WEST, jrb1Purpose, 50, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jrb2Purpose, -5, SpringLayout.SOUTH, jrb1Purpose);
		layout.putConstraint(SpringLayout.WEST, jrb2Purpose, 50, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jrb3Purpose, -5, SpringLayout.SOUTH, jrb2Purpose);
		layout.putConstraint(SpringLayout.WEST, jrb3Purpose, 50, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jrb4Purpose, -5, SpringLayout.SOUTH, jrb3Purpose);
		layout.putConstraint(SpringLayout.WEST, jrb4Purpose, 50, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jrb5Purpose, -5, SpringLayout.SOUTH, jrb4Purpose);
		layout.putConstraint(SpringLayout.WEST, jrb5Purpose, 50, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jrb6Purpose, -5, SpringLayout.SOUTH, jrb5Purpose);
		layout.putConstraint(SpringLayout.WEST, jrb6Purpose, 50, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jrb7Purpose, -5, SpringLayout.SOUTH, jrb6Purpose);
		layout.putConstraint(SpringLayout.WEST, jrb7Purpose, 50, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jrb8Purpose, -5, SpringLayout.SOUTH, jrb7Purpose);
		layout.putConstraint(SpringLayout.WEST, jrb8Purpose, 50, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jrb9Purpose, -5, SpringLayout.SOUTH, jrb8Purpose);
		layout.putConstraint(SpringLayout.WEST, jrb9Purpose, 50, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jrb10Purpose, -5, SpringLayout.SOUTH, jrb9Purpose);
		layout.putConstraint(SpringLayout.WEST, jrb10Purpose, 50, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jrb11Purpose, -5, SpringLayout.SOUTH, jrb10Purpose);
		layout.putConstraint(SpringLayout.WEST, jrb11Purpose, 50, SpringLayout.WEST, jlabBG4);
		
		layout.putConstraint(SpringLayout.NORTH, jlabSavings, 5, SpringLayout.SOUTH, jrb5CreditHistory);
		layout.putConstraint(SpringLayout.WEST, jlabSavings, 210, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jrb1Savings, 0, SpringLayout.SOUTH, jlabSavings);
		layout.putConstraint(SpringLayout.WEST, jrb1Savings, 230, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jrb2Savings, -5, SpringLayout.SOUTH, jrb1Savings);
		layout.putConstraint(SpringLayout.WEST, jrb2Savings, 230, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jrb3Savings, -5, SpringLayout.SOUTH, jrb2Savings);
		layout.putConstraint(SpringLayout.WEST, jrb3Savings, 230, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jrb4Savings, -5, SpringLayout.SOUTH, jrb3Savings);
		layout.putConstraint(SpringLayout.WEST, jrb4Savings, 230, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jrb5Savings, -5, SpringLayout.SOUTH, jrb4Savings);
		layout.putConstraint(SpringLayout.WEST, jrb5Savings, 230, SpringLayout.WEST, jlabBG4);
		
		layout.putConstraint(SpringLayout.NORTH, jlabEmployment, 15, SpringLayout.SOUTH, jrb11Purpose);
		layout.putConstraint(SpringLayout.WEST, jlabEmployment, 30, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jrb1Employment, 0, SpringLayout.SOUTH, jlabEmployment);
		layout.putConstraint(SpringLayout.WEST, jrb1Employment, 50, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jrb2Employment, -5, SpringLayout.SOUTH, jrb1Employment);
		layout.putConstraint(SpringLayout.WEST, jrb2Employment, 50, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jrb3Employment, -5, SpringLayout.SOUTH, jrb2Employment);
		layout.putConstraint(SpringLayout.WEST, jrb3Employment, 50, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jrb4Employment, -5, SpringLayout.SOUTH, jrb3Employment);
		layout.putConstraint(SpringLayout.WEST, jrb4Employment, 50, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jrb5Employment, -5, SpringLayout.SOUTH, jrb4Employment);
		layout.putConstraint(SpringLayout.WEST, jrb5Employment, 50, SpringLayout.WEST, jlabBG4);
		
		layout.putConstraint(SpringLayout.NORTH, jlabPersStatGender, 5, SpringLayout.SOUTH, jrb5Savings);
		layout.putConstraint(SpringLayout.WEST, jlabPersStatGender, 210, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jrb1PersStatGender, 0, SpringLayout.SOUTH, jlabPersStatGender);
		layout.putConstraint(SpringLayout.WEST, jrb1PersStatGender, 230, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jrb2PersStatGender, -5, SpringLayout.SOUTH, jrb1PersStatGender);
		layout.putConstraint(SpringLayout.WEST, jrb2PersStatGender, 230, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jrb3PersStatGender, -5, SpringLayout.SOUTH, jrb2PersStatGender);
		layout.putConstraint(SpringLayout.WEST, jrb3PersStatGender, 230, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jrb4PersStatGender, -5, SpringLayout.SOUTH, jrb3PersStatGender);
		layout.putConstraint(SpringLayout.WEST, jrb4PersStatGender, 230, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jrb5PersStatGender, -5, SpringLayout.SOUTH, jrb4PersStatGender);
		layout.putConstraint(SpringLayout.WEST, jrb5PersStatGender, 230, SpringLayout.WEST, jlabBG4);
		
		layout.putConstraint(SpringLayout.NORTH, jlabOtherDebtors, 15, SpringLayout.SOUTH, jrb5PersStatGender);
		layout.putConstraint(SpringLayout.WEST, jlabOtherDebtors, 210, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jrb1OtherDebtors, 0, SpringLayout.SOUTH, jlabOtherDebtors);
		layout.putConstraint(SpringLayout.WEST, jrb1OtherDebtors, 230, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jrb2OtherDebtors, -5, SpringLayout.SOUTH, jrb1OtherDebtors);
		layout.putConstraint(SpringLayout.WEST, jrb2OtherDebtors, 230, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jrb3OtherDebtors, -5, SpringLayout.SOUTH, jrb2OtherDebtors);
		layout.putConstraint(SpringLayout.WEST, jrb3OtherDebtors, 230, SpringLayout.WEST, jlabBG4);
		
		layout.putConstraint(SpringLayout.NORTH, jlabResidenceSince, 5, SpringLayout.SOUTH, jrb3OtherDebtors);
		layout.putConstraint(SpringLayout.WEST, jlabResidenceSince, 190, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jtfResidenceSince, 5, SpringLayout.SOUTH, jrb3OtherDebtors);
		layout.putConstraint(SpringLayout.WEST, jtfResidenceSince, 5, SpringLayout.EAST, jlabResidenceSince);
		layout.putConstraint(SpringLayout.NORTH, jlabLet, 5, SpringLayout.SOUTH, jrb3OtherDebtors);
		layout.putConstraint(SpringLayout.WEST, jlabLet, 5, SpringLayout.EAST, jtfResidenceSince);
		
		layout.putConstraint(SpringLayout.NORTH, jlabProperty, 15, SpringLayout.SOUTH, jrb5Employment);
		layout.putConstraint(SpringLayout.WEST, jlabProperty, 30, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jrb1Property, 0, SpringLayout.SOUTH, jlabProperty);
		layout.putConstraint(SpringLayout.WEST, jrb1Property, 50, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jrb2Property, -5, SpringLayout.SOUTH, jrb1Property);
		layout.putConstraint(SpringLayout.WEST, jrb2Property, 50, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jrb3Property, -5, SpringLayout.SOUTH, jrb2Property);
		layout.putConstraint(SpringLayout.WEST, jrb3Property, 50, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jrb4Property, -5, SpringLayout.SOUTH, jrb3Property);
		layout.putConstraint(SpringLayout.WEST, jrb4Property, 50, SpringLayout.WEST, jlabBG4);
		
		layout.putConstraint(SpringLayout.NORTH, jlabAge, 5, SpringLayout.SOUTH, jrb4Property);
		layout.putConstraint(SpringLayout.WEST, jlabAge, 30, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jtfAge, 5, SpringLayout.SOUTH, jrb4Property);
		layout.putConstraint(SpringLayout.WEST, jtfAge, 5, SpringLayout.EAST, jlabAge);
		layout.putConstraint(SpringLayout.NORTH, jlabLet2, 5, SpringLayout.SOUTH, jrb4Property);
		layout.putConstraint(SpringLayout.WEST, jlabLet2, 5, SpringLayout.EAST, jtfAge);
		
		layout.putConstraint(SpringLayout.NORTH, jlabOtherPayPlans, 15, SpringLayout.SOUTH, jlabLet2);
		layout.putConstraint(SpringLayout.WEST, jlabOtherPayPlans, 30, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jrb1OtherPayPlans, 0, SpringLayout.SOUTH, jlabOtherPayPlans);
		layout.putConstraint(SpringLayout.WEST, jrb1OtherPayPlans, 50, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jrb2OtherPayPlans, -5, SpringLayout.SOUTH, jrb1OtherPayPlans);
		layout.putConstraint(SpringLayout.WEST, jrb2OtherPayPlans, 50, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jrb3OtherPayPlans, -5, SpringLayout.SOUTH, jrb2OtherPayPlans);
		layout.putConstraint(SpringLayout.WEST, jrb3OtherPayPlans, 50, SpringLayout.WEST, jlabBG4);
		
		layout.putConstraint(SpringLayout.NORTH, jlabHousing, 35, SpringLayout.SOUTH, jrb4Property);
		layout.putConstraint(SpringLayout.WEST, jlabHousing, 230, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jrb1Housing, 0, SpringLayout.SOUTH, jlabHousing);
		layout.putConstraint(SpringLayout.WEST, jrb1Housing, 250, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jrb2Housing, -5, SpringLayout.SOUTH, jrb1Housing);
		layout.putConstraint(SpringLayout.WEST, jrb2Housing, 250, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jrb3Housing, -5, SpringLayout.SOUTH, jrb2Housing);
		layout.putConstraint(SpringLayout.WEST, jrb3Housing, 250, SpringLayout.WEST, jlabBG4);
		
		layout.putConstraint(SpringLayout.NORTH, jlabExistingCredits, 5, SpringLayout.SOUTH, jrb3OtherPayPlans);
		layout.putConstraint(SpringLayout.WEST, jlabExistingCredits, 30, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jtfExistingCredits, 5, SpringLayout.SOUTH, jrb3OtherPayPlans);
		layout.putConstraint(SpringLayout.WEST, jtfExistingCredits, 5, SpringLayout.EAST, jlabExistingCredits);
		
		layout.putConstraint(SpringLayout.NORTH, jlabJob, 10, SpringLayout.SOUTH, jtfExistingCredits);
		layout.putConstraint(SpringLayout.WEST, jlabJob, 30, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jrb1Job, 0, SpringLayout.SOUTH, jlabJob);
		layout.putConstraint(SpringLayout.WEST, jrb1Job, 50, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jrb2Job, -5, SpringLayout.SOUTH, jrb1Job);
		layout.putConstraint(SpringLayout.WEST, jrb2Job, 50, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jrb3Job, -5, SpringLayout.SOUTH, jrb2Job);
		layout.putConstraint(SpringLayout.WEST, jrb3Job, 50, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jrb4Job, -5, SpringLayout.SOUTH, jrb3Job);
		layout.putConstraint(SpringLayout.WEST, jrb4Job, 50, SpringLayout.WEST, jlabBG4);
		
		layout.putConstraint(SpringLayout.NORTH, jlabTelephone, 5, SpringLayout.SOUTH, jrb4Job);
		layout.putConstraint(SpringLayout.WEST, jlabTelephone, 30, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jrb1Telephone, 0, SpringLayout.SOUTH, jlabTelephone);
		layout.putConstraint(SpringLayout.WEST, jrb1Telephone, 50, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jrb2Telephone, -5, SpringLayout.SOUTH, jrb1Telephone);
		layout.putConstraint(SpringLayout.WEST, jrb2Telephone, 50, SpringLayout.WEST, jlabBG4);
		
		layout.putConstraint(SpringLayout.NORTH, jlabForeighWork, 5, SpringLayout.SOUTH, jrb2Telephone);
		layout.putConstraint(SpringLayout.WEST, jlabForeighWork, 30, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jrb1ForeighWork, 0, SpringLayout.SOUTH, jlabForeighWork);
		layout.putConstraint(SpringLayout.WEST, jrb1ForeighWork, 50, SpringLayout.WEST, jlabBG4);
		layout.putConstraint(SpringLayout.NORTH, jrb2ForeighWork, -5, SpringLayout.SOUTH, jrb1ForeighWork);
		layout.putConstraint(SpringLayout.WEST, jrb2ForeighWork, 50, SpringLayout.WEST, jlabBG4);
		
		layout.putConstraint(SpringLayout.SOUTH, test2, -5, SpringLayout.SOUTH, jlabBG4);
		layout.putConstraint(SpringLayout.EAST, test2, -5, SpringLayout.EAST, jlabBG4);
		
		jlabBG4.add(jlabExistCheckoutAccountStatus);
		jlabBG4.add(jrb1ExistCheckoutAccountStatus);
		jlabBG4.add(jrb2ExistCheckoutAccountStatus);
		jlabBG4.add(jrb3ExistCheckoutAccountStatus);
		jlabBG4.add(jrb4ExistCheckoutAccountStatus);
		
		jlabBG4.add(jlabCreditHistory);
		jlabBG4.add(jrb1CreditHistory);
		jlabBG4.add(jrb2CreditHistory);
		jlabBG4.add(jrb3CreditHistory);
		jlabBG4.add(jrb4CreditHistory);
		jlabBG4.add(jrb5CreditHistory);
		
		jlabBG4.add(jlabPurpose);
		jlabBG4.add(jrb1Purpose);
		jlabBG4.add(jrb2Purpose);
		jlabBG4.add(jrb3Purpose);
		jlabBG4.add(jrb4Purpose);
		jlabBG4.add(jrb5Purpose);
		jlabBG4.add(jrb6Purpose);
		jlabBG4.add(jrb7Purpose);
		jlabBG4.add(jrb8Purpose);
		jlabBG4.add(jrb9Purpose);
		jlabBG4.add(jrb10Purpose);
		jlabBG4.add(jrb11Purpose);
		
		jlabBG4.add(jlabSavings);
		jlabBG4.add(jrb1Savings);
		jlabBG4.add(jrb2Savings);
		jlabBG4.add(jrb3Savings);
		jlabBG4.add(jrb4Savings);
		jlabBG4.add(jrb5Savings);
		
		jlabBG4.add(jlabEmployment);
		jlabBG4.add(jrb1Employment);
		jlabBG4.add(jrb2Employment);
		jlabBG4.add(jrb3Employment);
		jlabBG4.add(jrb4Employment);
		jlabBG4.add(jrb5Employment);
		
		jlabBG4.add(jlabPersStatGender);
		jlabBG4.add(jrb1PersStatGender);
		jlabBG4.add(jrb2PersStatGender);
		jlabBG4.add(jrb3PersStatGender);
		jlabBG4.add(jrb4PersStatGender);
		jlabBG4.add(jrb5PersStatGender);
		
		jlabBG4.add(jlabOtherDebtors);
		jlabBG4.add(jrb1OtherDebtors);
		jlabBG4.add(jrb2OtherDebtors);
		jlabBG4.add(jrb3OtherDebtors);

		jlabBG4.add(jlabResidenceSince);
		jlabBG4.add(jtfResidenceSince);
		jlabBG4.add(jlabLet);
		
		jlabBG4.add(jlabProperty);
		jlabBG4.add(jrb1Property);
		jlabBG4.add(jrb2Property);
		jlabBG4.add(jrb3Property);
		jlabBG4.add(jrb4Property);
		
		jlabBG4.add(jlabAge);
		jlabBG4.add(jtfAge);
		jlabBG4.add(jlabLet2);
		
		jlabBG4.add(jlabOtherPayPlans);
		jlabBG4.add(jrb1OtherPayPlans);
		jlabBG4.add(jrb2OtherPayPlans);
		jlabBG4.add(jrb3OtherPayPlans);
		
		jlabBG4.add(jlabHousing);
		jlabBG4.add(jrb1Housing);
		jlabBG4.add(jrb2Housing);
		jlabBG4.add(jrb3Housing);
		
		jlabBG4.add(jlabExistingCredits);
		jlabBG4.add(jtfExistingCredits);
		
		jlabBG4.add(jlabJob);
		jlabBG4.add(jrb1Job);
		jlabBG4.add(jrb2Job);
		jlabBG4.add(jrb3Job);
		jlabBG4.add(jrb4Job);
		
		jlabBG4.add(jlabTelephone);
		jlabBG4.add(jrb1Telephone);
		jlabBG4.add(jrb2Telephone);
		
		jlabBG4.add(jlabForeighWork);
		jlabBG4.add(jrb1ForeighWork);
		jlabBG4.add(jrb2ForeighWork);
		
		
		anceta.add(jspAnceta, BorderLayout.CENTER);
	}
	
	//����� �������� ������
	public void Month_pay_raschet() {
		float EPC = 0, sum = 0, MonthPay;
			if (jtfProcent.getText().equals("")) {
				EPC = 0;
			}else {EPC = (Float.parseFloat(jtfProcent.getText()) / 12) / 100;}
			if (jtfSum.getText().equals("")) {
				sum = 0;
			}else {sum = Integer.parseInt(jtfSum.getText());}
			if (jtfSrok.getText().equals("")) {
				MonthPay = (float) (sum * (EPC * Math.pow(1 + EPC, 0)) / (Math.pow(1 + EPC, 0) - 1));
			}else {MonthPay = (float) (sum * (EPC * Math.pow(1 + EPC, Integer.parseInt(jtfSrok.getText()))) / (Math.pow(1 + EPC, Integer.parseInt(jtfSrok.getText())) - 1));}
			jtfMonthPay.setText("" + MonthPay);
	}
	
	public void jtfListener(JTextField jtf) {
		jtf.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				Month_pay_raschet();
			}
			public void removeUpdate(DocumentEvent e) {
				Month_pay_raschet();
			}
			public void insertUpdate(DocumentEvent e) {
				Month_pay_raschet();
			}
		});
	}
	
	void correct_data_check(String curMonth) {
			check_fail = 0;
			curMonth = curMonth.replace(".", ",");
			String[] curMonthArray = curMonth.split(",");
			if ((Integer.parseInt(curMonthArray[0]) > 31) | (Integer.parseInt(curMonthArray[1]) > 12)) {
				check_fail = 1;
			}
			else {
				if((Integer.parseInt(curMonthArray[0]) > 30) & ((Integer.parseInt(curMonthArray[1]) % 2) == 0)) {
					check_fail = 1;
				}
			}
	}
	
	
	//�������� �� ���� ������ ����
	void key_check(KeyEvent e) {
		char a = e.getKeyChar();
	       if (!Character.isDigit(a) && (a != '.') && (a != '\b')) {
	         e.consume();
	       }
	}
	
	KeyAdapter keyAdapter = new KeyAdapter(){
		public void keyTyped(KeyEvent e) {
			key_check(e);
		}
	};
}