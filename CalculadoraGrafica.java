import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculadoraGrafica extends JFrame {

    JTextField n1, n2;
    JButton btnSum, btnRes, btnDiv, btnMul;
    JLabel txtRes;
    Font fuente = new Font("Courier", Font.BOLD, 40);

    public CalculadoraGrafica() {

        setTitle("casio");
        setSize(600,400);
        setLayout(new GridLayout(4,1));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel números
        JPanel panelNumeros = new JPanel(new GridLayout(1,2));

        n1 = new JTextField();
        n2 = new JTextField();

        n1.setFont(fuente);
        n2.setFont(fuente);

        panelNumeros.add(n1);
        panelNumeros.add(n2);

        // Panel botones
        JPanel panelBotones = new JPanel(new GridLayout(1,4));

        btnSum = new JButton("+");
        btnRes = new JButton("-");
        btnMul = new JButton("*");
        btnDiv = new JButton("/");

        btnSum.setFont(fuente);
        btnRes.setFont(fuente);
        btnMul.setFont(fuente);
        btnDiv.setFont(fuente);

        panelBotones.add(btnSum);
        panelBotones.add(btnRes);
        panelBotones.add(btnMul);
        panelBotones.add(btnDiv);

        // Resultado
        txtRes = new JLabel("0");
        txtRes.setFont(fuente);

        add(panelNumeros);
        add(panelBotones);
        add(txtRes);

        // Eventos botones

        btnSum.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                double a = Double.parseDouble(n1.getText());
                double b = Double.parseDouble(n2.getText());
                txtRes.setText(String.valueOf(a+b));
            }
        });

        btnRes.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                double a = Double.parseDouble(n1.getText());
                double b = Double.parseDouble(n2.getText());
                txtRes.setText(String.valueOf(a-b));
            }
        });

        btnMul.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                double a = Double.parseDouble(n1.getText());
                double b = Double.parseDouble(n2.getText());
                txtRes.setText(String.valueOf(a*b));
            }
        });

        btnDiv.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                double a = Double.parseDouble(n1.getText());
                double b = Double.parseDouble(n2.getText());
                txtRes.setText(String.valueOf(a/b));
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new CalculadoraGrafica();
    }
}
