package sqlbaglantý;

import java.awt.*;
import javax.swing.border.*;
import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class BilgiKontrol extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BilgiKontrol frame = new BilgiKontrol();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection conn = null;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	public void yenile() {
		try {

			String sql = "select * from Tablo";
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void temizle() {
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		textField_4.setText("");
		textField_5.setText("");
	}

	public BilgiKontrol() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 150, 530, 420);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 65, 530, 355);
		contentPane.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(231, 39, 299, 317);
		panel.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JLabel label = new JLabel("");
		label.setToolTipText("G\u00F6r\u00FCnt\u00FCle");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					conn = DriverManager.getConnection("jdbc:sqlite:C://sqlite/bilgiler.db");
					String sql = "select * from Tablo";
					PreparedStatement pst = conn.prepareStatement(sql);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		Image img = new ImageIcon(this.getClass().getResource("/göster.png ")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(186, 298, 46, 58);
		panel.add(label);

		JLabel lblIsim = new JLabel("Ad");
		lblIsim.setForeground(Color.WHITE);
		lblIsim.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIsim.setBounds(10, 27, 46, 14);
		panel.add(lblIsim);

		JLabel lblSoyad = new JLabel("Soyad");
		lblSoyad.setForeground(Color.WHITE);
		lblSoyad.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSoyad.setBounds(10, 66, 46, 14);
		panel.add(lblSoyad);

		JLabel lblAldrn = new JLabel("\u00DCr\u00FCn");
		lblAldrn.setForeground(Color.WHITE);
		lblAldrn.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAldrn.setBounds(10, 110, 46, 14);
		panel.add(lblAldrn);

		JLabel lblMiktar = new JLabel("Miktar");
		lblMiktar.setForeground(Color.WHITE);
		lblMiktar.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMiktar.setBounds(10, 150, 46, 14);
		panel.add(lblMiktar);

		JLabel lblFiyat = new JLabel("Fiyat");
		lblFiyat.setForeground(Color.WHITE);
		lblFiyat.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFiyat.setBounds(10, 196, 46, 14);
		panel.add(lblFiyat);

		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblId.setForeground(Color.WHITE);
		lblId.setBounds(10, 251, 28, 14);
		panel.add(lblId);

		textField = new JTextField();
		textField.setCaretColor(Color.WHITE);
		textField.setForeground(Color.WHITE);
		textField.setColumns(10);
		textField.setBackground(Color.BLACK);
		textField.setBounds(66, 19, 102, 23);
		panel.add(textField);

		textField_1 = new JTextField();
		textField_1.setCaretColor(Color.WHITE);
		textField_1.setForeground(Color.WHITE);
		textField_1.setColumns(10);
		textField_1.setBackground(Color.BLACK);
		textField_1.setBounds(66, 64, 102, 23);
		panel.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setCaretColor(Color.WHITE);
		textField_2.setForeground(Color.WHITE);
		textField_2.setColumns(10);
		textField_2.setBackground(Color.BLACK);
		textField_2.setBounds(66, 108, 102, 23);
		panel.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setCaretColor(Color.WHITE);
		textField_3.setForeground(Color.WHITE);
		textField_3.setColumns(10);
		textField_3.setBackground(Color.BLACK);
		textField_3.setBounds(66, 150, 102, 23);
		panel.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setCaretColor(Color.WHITE);
		textField_4.setForeground(Color.WHITE);
		textField_4.setColumns(10);
		textField_4.setBackground(Color.BLACK);
		textField_4.setBounds(66, 194, 102, 23);
		panel.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setCaretColor(Color.WHITE);
		textField_5.setForeground(Color.WHITE);
		textField_5.setColumns(10);
		textField_5.setBackground(Color.BLACK);
		textField_5.setBounds(49, 247, 36, 23);
		panel.add(textField_5);

		JLabel label_1 = new JLabel("");
		label_1.setToolTipText("Kaydet");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					conn = DriverManager.getConnection("jdbc:sqlite:C://sqlite/bilgiler.db");
					String sql = "insert into Tablo (Ad,Soyad,Urun,Miktar,Fiyat) values(?,?,?,?,?)";
					PreparedStatement pst = conn.prepareStatement(sql);
					pst.setString(1, textField.getText());
					pst.setString(2, textField_1.getText());
					pst.setString(3, textField_2.getText());
					pst.setString(4, textField_3.getText());
					pst.setString(5, textField_4.getText() + " TL");

					pst.execute();
					JOptionPane.showMessageDialog(null, "Baþarý ile kaydedildi");

					pst.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				yenile();
				temizle();
			}

		});
		Image imgn = new ImageIcon(this.getClass().getResource("/kaydet.png ")).getImage();
		label_1.setIcon(new ImageIcon(imgn));
		label_1.setBounds(122, 228, 46, 58);
		panel.add(label_1);

		JLabel label_2 = new JLabel("");
		label_2.setToolTipText("G\u00FCncelle");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {

					String sql = "Update Tablo set ID='" + textField_5.getText() + "',Ad='" + textField.getText()
							+ "' , Soyad='" + textField_1.getText() + "' , Urun='" + textField_2.getText()
							+ "', Miktar='" + textField_3.getText() + "' ,Fiyat='" + textField_4.getText() + " TL"
							+ "'   where ID='" + textField_5.getText() + "'  ";
					PreparedStatement pst = conn.prepareStatement(sql);

					pst.execute();
					JOptionPane.showMessageDialog(null, "Baþarý ile güncellendi");
					pst.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				yenile();
				temizle();
			}
		});
		Image imgg = new ImageIcon(this.getClass().getResource("/güncelle.png ")).getImage();
		label_2.setIcon(new ImageIcon(imgg));
		label_2.setBounds(10, 298, 46, 58);
		panel.add(label_2);

		JLabel label_3 = new JLabel("");
		label_3.setToolTipText("Sil");
		label_3.addMouseListener(new MouseAdapter() {
		 
			public void mouseClicked(MouseEvent e) {
				int action=JOptionPane.showConfirmDialog(null, "Silmekte kararlý mýsýn ?","Sil", JOptionPane.YES_NO_OPTION);
				if(action==0) {
				try {
					conn = DriverManager.getConnection("jdbc:sqlite:C://sqlite/bilgiler.db");
					String sql = "delete from Tablo where ID='" + textField_5.getText() + "' ";
					PreparedStatement pst = conn.prepareStatement(sql);
					pst.execute();
					JOptionPane.showMessageDialog(null, "Baþarý ile silindi");
					pst.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				}
				yenile();
				temizle();
			}
		});
		Image imggn = new ImageIcon(this.getClass().getResource("/sil.png ")).getImage();
		label_3.setIcon(new ImageIcon(imggn));
		label_3.setBounds(79, 298, 46, 57);
		panel.add(label_3);
		
		textField_6 = new JTextField();
		textField_6.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try {
					conn = DriverManager.getConnection("jdbc:sqlite:C://sqlite/bilgiler.db");
					String sql = "select * from Tablo where Ad=?";
					PreparedStatement pst = conn.prepareStatement(sql);
					pst.setString(1,textField_6.getText());
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		textField_6.setForeground(Color.WHITE);
		textField_6.setColumns(10);
		textField_6.setCaretColor(Color.WHITE);
		textField_6.setBackground(Color.BLACK);
		textField_6.setBounds(394, 11, 102, 23);
		panel.add(textField_6);
		
		JLabel lblAra = new JLabel("Ara");
		lblAra.setForeground(Color.WHITE);
		lblAra.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAra.setBounds(338, 13, 46, 14);
		panel.add(lblAra);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 153, 0));
		panel_1.setBounds(0, 0, 530, 65);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblBilgiKontrol = new JLabel("B\u0130LG\u0130 KONTROL");
		lblBilgiKontrol.setForeground(Color.WHITE);
		lblBilgiKontrol.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBilgiKontrol.setBounds(28, 11, 151, 43);
		panel_1.add(lblBilgiKontrol);

		JLabel lblX = new JLabel("X");
		lblX.setToolTipText("Kapat");
		lblX.setBackground(Color.GRAY);
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
		lblX.setForeground(Color.WHITE);
		lblX.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblX.setBounds(484, 19, 19, 27);
		panel_1.add(lblX);

		JLabel label_4 = new JLabel("_");
		label_4.setToolTipText("K\u00FC\u00E7\u00FClt");
		label_4.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setState(ICONIFIED);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				label_4.setForeground(Color.cyan);
			}

			public void mouseExited(MouseEvent e) {
				label_4.setForeground(Color.WHITE);
			}
		});
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_4.setBounds(442, 18, 19, 27);
		panel_1.add(label_4);

	}
}
