import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
  
class Janela extends JFrame implements ActionListener {
	 
	private static final long serialVersionUID = 6961931855568589985L;
	
	private Container c; 
    private JLabel titulo; 
    private JLabel texto; 
    private JTextArea dtexto;  
    private JRadioButton cripto; 
    private JRadioButton descripto; 
    private ButtonGroup func; 
    private JLabel cifra; 
	private JComboBox<?> numero; 
    private JButton con; 
    private JButton reset; 
    private JLabel saida; 
    private JTextArea dsaida; 
    private JLabel res;
    private String cifras[] 
        = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26"}; 

    public Janela(){ 
        setTitle("Criptágoras"); 
        setBounds(300, 90, 900, 600); 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setResizable(false); 
  
        c = getContentPane(); 
        c.setLayout(null); 
  
        titulo = new JLabel("Criptágoras", SwingConstants.CENTER); 
        titulo.setFont(new Font("Arial", Font.PLAIN, 30)); 
        titulo.setSize(200, 40); 
        titulo.setLocation(380, 30); 
        c.add(titulo); 
  
        texto = new JLabel("Digite seu texto:"); 
        texto.setFont(new Font("Arial", Font.PLAIN, 18)); 
        texto.setSize(200, 40); 
        texto.setLocation(50, 100); 
        c.add(texto); 
  
        dtexto = new JTextArea(); 
        dtexto.setFont(new Font("Arial", Font.PLAIN, 15)); 
        dtexto.setSize(520, 150); 
        dtexto.setLocation(200, 110); 
        c.add(dtexto); 
  
        cripto = new JRadioButton("Criptografar"); 
        cripto.setFont(new Font("Arial", Font.PLAIN, 15)); 
        cripto.setSelected(false); 
        cripto.setSize(110, 30); 
        cripto.setLocation(720, 125); 
        c.add(cripto); 
  
        descripto = new JRadioButton("Descriptografar"); 
        descripto.setFont(new Font("Arial", Font.PLAIN, 15)); 
        descripto.setSelected(false); 
        descripto.setSize(150, 30); 
        descripto.setLocation(720, 150); 
        c.add(descripto); 
  
        func = new ButtonGroup(); 
        func.add(cripto); 
        func.add(descripto); 
  
        cifra = new JLabel("Cifra:"); 
        cifra.setFont(new Font("Arial", Font.PLAIN, 18)); 
        cifra.setSize(150, 20); 
        cifra.setLocation(50, 150); 
        c.add(cifra); 
  
        numero = new JComboBox<Object>(cifras); 
        numero.setFont(new Font("Arial", Font.PLAIN, 15)); 
        numero.setSize(50, 20); 
        numero.setLocation(120, 150); 
        c.add(numero); 
  
        con = new JButton("Continuar"); 
        con.setFont(new Font("Arial", Font.PLAIN, 15)); 
        con.setSize(100, 20); 
        con.setLocation(340, 270); 
        con.addActionListener(this); 
        c.add(con); 
  
        reset = new JButton("Resetar"); 
        reset.setFont(new Font("Arial", Font.PLAIN, 15)); 
        reset.setSize(100, 20); 
        reset.setLocation(460, 270); 
        reset.addActionListener(this); 
        c.add(reset); 
  
        saida = new JLabel("Saída:"); 
        saida.setFont(new Font("Arial", Font.PLAIN, 18)); 
        saida.setSize(200, 40); 
        saida.setLocation(50, 310); 
        c.add(saida); 
        
        dsaida = new JTextArea(); 
        dsaida.setFont(new Font("Arial", Font.PLAIN, 15)); 
        dsaida.setSize(520, 150); 
        dsaida.setLocation(200, 310); 
        dsaida.setLineWrap(true); 
        dsaida.setEditable(false); 
        c.add(dsaida); 
  
        res = new JLabel(""); 
        res.setFont(new Font("Arial", Font.PLAIN, 20)); 
        res.setSize(500, 25); 
        res.setLocation(200, 475); 
        c.add(res); 

        setVisible(true); 
    } 
  
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == con) { 
            if (cripto.isSelected()) {  
                String texto = dtexto.getText();
                String a = (String)numero.getSelectedItem();
                int x = Integer.parseInt(a);
                StringBuffer c = Cifra.criptografar(texto,x);
                String d = c.toString();
                dsaida.setText(d); 
                dsaida.setEditable(false); 
                res.setText("Criptografia realizada com sucesso"); 
            }
            else if (descripto.isSelected()) { 
            	 String texto = dtexto.getText();
            	 String a = (String)numero.getSelectedItem();
                 int x = Integer.parseInt(a);
                 StringBuffer c = Cifra.descriptografar(texto,x);
                 String d = c.toString();
                 dsaida.setText(d); 
                 res.setText("Descriptografia realizada com sucesso"); 
            }  
            else { 
                dsaida.setText("");
                res.setForeground(Color.RED);
                res.setText("Por favor, determine se quer criptografar ou descriptografar seu texto"); 
            } 
        } 
  
        else if (e.getSource() == reset) { 
            String nada = "";
            dtexto.setText(nada);  
            res.setText(nada); 
            dsaida.setText(nada); 
            numero.setSelectedIndex(0); 
        } 
    } 
} 
 
class Execucao { 
  
    public static void main(String[] args) throws Exception 
    { 
        Janela f = new Janela(); 
    } 
} 