//Javier Enrique Luna Díaz
package JDrones;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.util.ArrayList;

public class DibujaDrones extends JPanel{
    private NumDron n;
    private BufferedImage ima;
    private ArrayList<Ellipse2D> circulos;
    private ArrayList<Dron> drones;
    
    DibujaDrones(BufferedImage ima){
        setBackground(Color.GREEN);
        this.ima =ima;
        circulos = new ArrayList<Ellipse2D>();
    }
    
    public void paintComponent(Graphics g){
        int f = 0;
        int f2 = 0;
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.drawImage(ima, 0, 0, this);
        g2.setColor(Color.black);
        if(this.getN() != null){
            if(this.getN().getConta() > 0){
                for(Dron d:drones){
                    f2 = 0;
                    for(Ellipse2D c:circulos){
                        if(f == f2){
                            c.setFrame(d.getX().getMiX(), d.getY().getMiY(), 20, 20);
                            g2.fill((Ellipse2D)c);                    
                        }
                        f2++;
                    }
                    f++;        
                }
            }
        }
        g2.setColor(Color.white);
    }
    
    public void CreaCirculo(){
        circulos.add(new Ellipse2D.Double());
    }

    public ArrayList<Dron> getDrones() {
        return drones;
    }

    public void setDrones(ArrayList<Dron> drones) {
        this.drones = drones;
    }

    public NumDron getN() {
        return n;
    }

    public void setN(NumDron n) {
        this.n = n;
    }
}
