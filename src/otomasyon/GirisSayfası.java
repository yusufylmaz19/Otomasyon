package sqlbaglantý;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class GirisSayfasý {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GirisSayfasý window = new GirisSayfasý();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection conn = null;
	private JTextField uname;
	private JPasswordField pword;

	public GirisSayfasý() {
		initialize();
		conn = girisbaglantý.girisconnector();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setResizable(false);
		frame.setBounds(550, 200, 292, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 153, 0));
		panel.setBounds(0, 0, 292, 56);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblGiriSayfas = new JLabel("G\u0130R\u0130\u015E SAYFASI");
		lblGiriSayfas.setHorizontalAlignment(SwingConstants.CENTER);
		lblGiriSayfas.setHorizontalTextPosition(SwingConstants.CENTER);
		lblGiriSayfas.setForeground(new Color(255, 255, 255));
		lblGiriSayfas.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGiriSayfas.setBounds(10, 11, 119, 29);
		panel.add(lblGiriSayfas);
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblX.setForeground(Color.RED);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblX.setForeground(Color.WHITE);
			}
		});
		lblX.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblX.setForeground(new Color(255, 255, 255));
		lblX.setBounds(266, 18, 16, 14);
		panel.add(lblX);
		
		JLabel lblX_1 = new JLabel("_");
		lblX_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			frame.setState(Frame.ICONIFIED );
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblX_1.setForeground(Color.cyan);
			}
			public void mouseExited(MouseEvent e) {
				lblX_1.setForeground(Color.WHITE);
			}
		});
		lblX_1.setForeground(Color.WHITE);
		lblX_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblX_1.setBounds(237, 11, 16, 23);
		panel.add(lblX_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(0, 54, 292, 246);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblKullancAd = new JLabel("Kullan\u0131c\u0131 Ad\u0131");
		lblKullancAd.setHorizontalTextPosition(SwingConstants.CENTER);
		lblKullancAd.setHorizontalAlignment(SwingConstants.CENTER);
		lblKullancAd.setForeground(Color.WHITE);
		lblKullancAd.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblKullancAd.setBounds(37, 67, 87, 29);
		panel_1.add(lblKullancAd);
		
		JLabel lblifre = new JLabel("\u015Eifre");
		lblifre.setHorizontalTextPosition(SwingConstants.LEADING);
		lblifre.setHorizontalAlignment(SwingConstants.CENTER);
		lblifre.setForeground(Color.WHITE);
		lblifre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblifre.setBounds(37, 117, 65, 29);
		panel_1.add(lblifre);
		
		uname = new JTextField();
		uname.setDisabledTextColor(new Color(255, 255, 255));
		uname.setCaretColor(Color.WHITE);
		uname.setBackground(new Color(0, 0, 0));
		uname.setForeground(new Color(255, 255, 255));
		uname.setBounds(134, 70, 131, 26);
		panel_1.add(uname);
		uname.setColumns(10);
		
		pword = new JPasswordField();
		pword.setForeground(new Color(255, 255, 255));
		pword.setDisabledTextColor(new Color(255, 255, 255));
		pword.setCaretColor(new Color(255, 255, 255));
		pword.setBackground(new Color(0, 0, 0));
		pword.setBounds(134, 120, 131, 26);
		panel_1.add(pword);
		
		JButton btnGiriYap = new JButton("Giri\u015F Yap");
		btnGiriYap.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
					try {
						String sql = "select * from Giris where Username=? and Password=?";
						PreparedStatement pst = conn.prepareStatement(sql);
						pst.setString(1, uname.getText());
						pst.setString(2, pword.getText());
						ResultSet rs = pst.executeQuery();
						int count=0;
						while (rs.next()) {
							count=count+1;
						}
						if(count==1) {
							JOptionPane.showMessageDialog(null, " Kullanýcý adý ve Þifre doðru");							
							BilgiKontrol ctrl= new BilgiKontrol();
							ctrl.setVisible(true);
							frame.dispose();
							
							
						}
						else if(count>1) {
							JOptionPane.showMessageDialog(null, " Klon Kullanýcý");
						}
						else if(count<1) {
							JOptionPane.showMessageDialog(null, " Kullanýcý Adý ve Þifre yanlýþ");
						}
						rs.close();
						pst.close();

					} catch (Exception e) {
						System.out.println(e);
					}
				}
			
		});
		btnGiriYap.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGiriYap.setForeground(Color.WHITE);
		btnGiriYap.setBackground(new Color(51, 204, 255));
		btnGiriYap.setBounds(176, 177, 89, 29);
		panel_1.add(btnGiriYap);
		
		JButton btnIptalEt = new JButton("\u0130ptal Et");
		btnIptalEt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnIptalEt.setForeground(Color.WHITE);
		btnIptalEt.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnIptalEt.setBackground(Color.RED);
		btnIptalEt.setBounds(59, 177, 89, 29);
		panel_1.add(btnIptalEt);
		
		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/kullanýcý.png ")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(10, 67, 28, 29);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("");
		Image imgg = new ImageIcon(this.getClass().getResource("/þifre.png ")).getImage();
		label_1.setIcon(new ImageIcon(imgg));
		label_1.setBounds(10, 117, 28, 24);
		panel_1.add(label_1);
		
	}
}
