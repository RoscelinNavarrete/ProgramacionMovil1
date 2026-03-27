import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Gato01 extends JFrame implements ActionListener {

    JButton[] botones = new JButton[9];
    JButton btnReiniciar;
    boolean turnoX = true;
    Font fuente = new Font("Arial", Font.BOLD, 60);

    int[][] combinaciones = {
        {0,1,2},{3,4,5},{6,7,8}, // filas
        {0,3,6},{1,4,7},{2,5,8}, // columnas
        {0,4,8},{2,4,6}          // diagonales
    };

    public Gato01(){

        setTitle("Juego de Gato");
        setSize(400,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel pJuego = new JPanel(new GridLayout(3,3));

        for(int i=0;i<9;i++){
            botones[i] = new JButton("");
            botones[i].setFont(fuente);
            botones[i].addActionListener(this);
            pJuego.add(botones[i]);
        }

        add(pJuego, BorderLayout.CENTER);

        btnReiniciar = new JButton("Reiniciar Juego");
        btnReiniciar.addActionListener(e -> reiniciar());

        JPanel pOpciones = new JPanel();
        pOpciones.add(btnReiniciar);

        add(pOpciones, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent e){

        JButton boton = (JButton)e.getSource();

        if(turnoX){
            boton.setText("X");
        }else{
            boton.setText("O");
        }

        boton.setEnabled(false);
        turnoX = !turnoX;

        validarGanador();
    }

    public void validarGanador(){

        for(int[] c : combinaciones){

            String a = botones[c[0]].getText();
            String b = botones[c[1]].getText();
            String d = botones[c[2]].getText();

            if(!a.equals("") && a.equals(b) && b.equals(d)){

                JOptionPane.showMessageDialog(this,"Ganó: " + a);
                desactivarBotones();
                return;
            }
        }

        verificarEmpate();
    }

    public void verificarEmpate(){

        boolean lleno = true;

        for(JButton b : botones){
            if(b.getText().equals("")){
                lleno = false;
                break;
            }
        }

        if(lleno){
            JOptionPane.showMessageDialog(this,"Empate");
        }
    }

    public void desactivarBotones(){
        for(JButton b : botones){
            b.setEnabled(false);
        }
    }

    public void reiniciar(){

        for(JButton b : botones){
            b.setText("");
            b.setEnabled(true);
        }

        turnoX = true;
    }

    public static void main(String[] args){

        Gato01 juego = new Gato01();
        juego.setVisible(true);
    }
}
