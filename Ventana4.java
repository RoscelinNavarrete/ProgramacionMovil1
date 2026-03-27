import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ventana4 extends JFrame implements ActionListener{

    int ancho, alto;
    JTextField txtEdad;
    JButton btnAceptar;
    JPanel panelBotones;
   
    public Ventana4(){
        ancho = 400;
        alto = 200;
       
        setTitle("Mayor o Menor de Edad");
        setSize(ancho, alto);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        panelBotones = new JPanel();
       
        txtEdad = new JTextField(5);
        btnAceptar = new JButton("Dame tu edad");
       
        btnAceptar.addActionListener(this);
               
        panelBotones.add(txtEdad);
        panelBotones.add(btnAceptar);
       
        add(panelBotones);
    }
   
    public static void main(String[] args) {
        Ventana4 v = new Ventana4();
        v.setVisible(true);
    }  

    @Override
    public void actionPerformed(ActionEvent e) {
       
        String edadTexto = txtEdad.getText();
        int edad = Integer.parseInt(edadTexto);
       
        if(edad >= 18){
            JOptionPane.showMessageDialog(null,"Eres mayor de edad");
        }else{
            JOptionPane.showMessageDialog(null,"Eres menor de edad");
        }
    }
}
