package cn.my.hr.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import cn.hr.dao.DeptDao;
import cn.hr.dao.PersonDao;
import cn.hr.model.Person;
/**
 * �����Ա��Ϣ
 * @author 409
 *
 */
public class Panel11 extends JPanel implements ActionListener{
	//JPanel pTitle;  //�����������
	JPanel pContent;  //�����Ա��Ϣ�����������
	JScrollPane js;   //�����Ա��Ϣ���ڵĹ������
	
	JTextField tfPersonId;  //��Ա���
	JTextField tfName;  //����
	JTextField tfSex;   //�Ա�
	JTextField tfBirth;  //��������
	JTextField tfNat;    //����
	JTextField tfAddress; //��ַ
	JTextField tfOther;   //����˵��
	
	JComboBox<String> comboDept;  //������Ϣ
	
	JButton btnAdd;  //����
	JButton btnClear; //���
	
	public Panel11() {
		//����Ϊ���������
		GridBagLayout gridBag = new GridBagLayout();
		GridBagConstraints cons = null;
		setLayout(gridBag);
		
		//��ӱ���
		JLabel lbTitle = new JLabel("�����Ա��Ϣ");
		lbTitle.setFont(new Font("����",0,16));
		cons = new GridBagConstraints();
		cons.gridx = 0;
		cons.gridy = 0;
		gridBag.setConstraints(lbTitle, cons);
		add(lbTitle);
		
		//�����������
		initContent();  //��ʼ�������Ա��Ϣ����
		js = new JScrollPane(pContent);
		js.setPreferredSize(new Dimension(410, 380));
		cons = new GridBagConstraints();
		cons.gridx = 0;
		cons.gridy = 1;
		gridBag.setConstraints(js, cons);
		add(js);
        try {
			addListener();//��Ӽ���
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void initContent() {
		//����������岢���ò��ַ�ʽ
		pContent = new JPanel();
		GridBagLayout layout = new GridBagLayout();
		pContent.setLayout(layout);
		
		GridBagConstraints cons = null;
		
		//��ӵ�1���������Ա��ű�ǩ����Ա����ı�����Ա������ǩ����Ա�����ı���
		//��Ա��ű�ǩ
		JLabel lbPersonId = new JLabel("��Ա���");
		//lbPersonId.setFont(new Font("����",0,12));
		cons = new GridBagConstraints();
		cons.gridx = 0;
		cons.gridy = 0;
		cons.insets = new Insets(10,10,10,1);//�������Ҽ��
		layout.setConstraints(lbPersonId, cons);
		pContent.add(lbPersonId);
		//��Ա����ı���
		tfPersonId = new JTextField(15);
		cons = new GridBagConstraints();
		cons.gridx = 1;
		cons.gridy = 0;
		cons.insets = new Insets(10,1,10,15);
		layout.setConstraints(tfPersonId, cons);
		pContent.add(tfPersonId);
		//��Ա������ǩ
		JLabel lbName = new JLabel("��Ա����");
		cons = new GridBagConstraints();
		cons.gridx = 2;
		cons.gridy = 0;
		cons.insets = new Insets(10,15,10,1);
		layout.setConstraints(lbName, cons);
		pContent.add(lbName);
		//��Ա�����ı���
		tfName = new JTextField(15);
		cons = new GridBagConstraints();
		cons.gridx = 3;
		cons.gridy = 0;
		cons.insets = new Insets(10,1,10,10);
		layout.setConstraints(tfName, cons);
		pContent.add(tfName);
		
		//��ӵ�2��������Ա��ǩ���Ա��ı��򡢳������±�ǩ�����������ı���
		//�Ա��ǩ
		JLabel lbSex = new JLabel("�Ա�");
		cons = new GridBagConstraints();
		cons.gridx = 0;
		cons.gridy = 1;
		cons.insets = new Insets(10,10,10,1);
		layout.setConstraints(lbSex, cons);
		pContent.add(lbSex);
		//�Ա��ı���
		tfSex = new JTextField(15);
		cons = new GridBagConstraints();
		cons.gridx = 1;
		cons.gridy = 1;
		cons.insets = new Insets(10,1,10,15);
		//cons.gridwidth  = 3;
		//cons.anchor = GridBagConstraints.WEST;
		layout.setConstraints(tfSex, cons);
		pContent.add(tfSex);
		//�������±�ǩ
		JLabel lbBirth = new JLabel("��������");
		cons = new GridBagConstraints();
		cons.gridx = 2;
		cons.gridy = 1;
		cons.insets = new Insets(10,15,10,1);
		layout.setConstraints(lbBirth, cons);
		pContent.add(lbBirth);
		//���������ı���
		tfBirth = new JTextField(15);
		cons = new GridBagConstraints();
		cons.gridx = 3;
		cons.gridy = 1;
		cons.insets = new Insets(10,1,10,10);
		layout.setConstraints(tfBirth, cons);
		pContent.add(tfBirth);
		
		//��ӵ�3������������ǩ�������ı��򡢵�ַ��ǩ����ַ�ı���
		//�����ǩ
		JLabel lbNat = new JLabel("����");
		cons = new GridBagConstraints();
		cons.gridx = 0;
		cons.gridy = 2;
		cons.insets = new Insets(10,10,10,1);
		layout.setConstraints(lbNat, cons);
		pContent.add(lbNat);
		//�����ı���
		tfNat = new JTextField(15);
		cons = new GridBagConstraints();
		cons.gridx = 1;
		cons.gridy = 2;
		cons.insets = new Insets(10,1,10,15);
		layout.setConstraints(tfNat, cons);
		pContent.add(tfNat);
		//��ַ��ǩ
		JLabel lbAddress = new JLabel("��ַ");
		cons = new GridBagConstraints();
		cons.gridx = 2;
		cons.gridy = 2;
		cons.insets = new Insets(10,15,10,1);
		layout.setConstraints(lbAddress, cons);
		pContent.add(lbAddress);
		//��ַ�ı���
		tfAddress = new JTextField(15);
		cons = new GridBagConstraints();
		cons.gridx = 3;
		cons.gridy = 2;
		cons.insets = new Insets(10,1,10,10);
		layout.setConstraints(tfAddress, cons);
		pContent.add(tfAddress);
		
		//��ӵ�4����������ű�ǩ�����������б�������ǩ�������ı���
		//���ű�ǩ
		JLabel lbDept = new JLabel("����");
		cons = new GridBagConstraints();
		cons.gridx = 0;
		cons.gridy = 3;
		cons.insets = new Insets(10,10,10,10);
		layout.setConstraints(lbDept, cons);
		pContent.add(lbDept);
		//���������б�
		comboDept = new JComboBox<String>();
		cons = new GridBagConstraints();
		cons.gridx = 1;
		cons.gridy = 3;
		cons.insets = new Insets(10,1,10,15);
		
		DeptDao deptDao = new DeptDao();
		try {
			String[] values = deptDao.getDeptsForSelect();//��ȡ�����б�
			comboDept = new JComboBox(values);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		layout.setConstraints(comboDept, cons);
		pContent.add(comboDept);
		//������ǩ
		JLabel lbOther = new JLabel("����");
		cons = new GridBagConstraints();
		cons.gridx = 2;
		cons.gridy = 3;
		cons.insets = new Insets(10,15,10,1);
		layout.setConstraints(lbOther, cons);
		pContent.add(lbOther);
		//�����ı���
		tfOther = new JTextField(15);
		cons = new GridBagConstraints();
		cons.gridx = 3;
		cons.gridy = 3;
		cons.insets = new Insets(10,1,10,10);
		layout.setConstraints(tfOther, cons);
		pContent.add(tfOther);
		
		//��ӵ�5����������Ӱ�ť����հ�ť��
		//����
		btnAdd = new JButton("����");
		cons = new GridBagConstraints();
		cons.gridx = 0;
		cons.gridy = 4;
		cons.gridwidth = 2;
		cons.insets = new Insets(10,10,10,10);
		layout.setConstraints(btnAdd, cons);
		pContent.add(btnAdd);
		//���
		btnClear = new JButton("���");
		cons = new GridBagConstraints();
		cons.gridx = 2;
		cons.gridy = 4;
		cons.gridwidth = 2;
		cons.insets = new Insets(10,10,10,10);
		layout.setConstraints(btnClear, cons);
		pContent.add(btnClear);
	}
	/**
	 * Ϊ��ť��Ӽ�����
	 * @throws Exception
	 */
	public void addListener() throws Exception{
		btnAdd.addActionListener(this);
		btnClear.addActionListener(this);
	}
	/**
	 * �����հ�ť������ı�������ֵ
	 */
	public void setNull(){
		tfPersonId.setText(null);
		tfName.setText(null);
		tfSex.setText(null);
		tfBirth.setText(null);
		tfAddress.setText(null);
		tfOther.setText(null);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//���ִ�е��¼�
		if(e.getSource()==btnClear){
			setNull();
		}
		//�����Ϣ
		if(e.getSource()==btnAdd){
			PersonDao personDao=new PersonDao();
			Person person=new Person(Long.valueOf(tfPersonId.getText()).longValue(),tfName.getText(),tfSex.getText(),tfBirth.getText(),tfNat.getText(),tfAddress.getText(),comboDept.getSelectedItem().toString(),tfOther.getText());
			personDao.addPerson(person);
		}
		
	} 
}
