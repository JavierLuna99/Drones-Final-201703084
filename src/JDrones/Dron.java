//Javier Enrique Luna Díaz
package JDrones;

public class Dron extends Thread{
    private MiX x;
    private MiY y;
    private DibujaDrones panel;
    private int a = 1;
    private int b = 1;
    private int yMax;
    private int xMax;
    private int yMin;
    private int xMin;
    private int algoritmo;
    private RCompartido rc;

    Dron(MiX x, MiY y, DibujaDrones panel, RCompartido rc){
        this.x = x;
        this.y = y;
        this.panel = panel;
        algoritmo = 0;
        this.rc = rc;
    }
    
    public void run(){
        if(this.algoritmo == 1){ //Mutex
            while(true){
                rc.lock();   
                rc.setX(this.x);
                rc.setY(this.y);
                this.y.setMiY(rc.getY().getMiY() + b);
                this.x.setMiX(rc.getX().getMiX() + a);                            
                rc.unlock();        
                if (getY().getMiY() == getyMax())
                    b = -b;
                if (getY().getMiY() == getyMin())
                    b = -b;
                if (getX().getMiX() == getxMax())
                    a = -a;
                if (getX().getMiX() == getxMin())
                    a = -a;
                panel.repaint();
                try {
                    Thread.sleep((int) (Math.random()*7));
                }catch(InterruptedException e){
                }
            }
        }
        else if(this.algoritmo == 2){ //Semáforos
            while(true){
                    rc.acquire();
                    rc.setX(this.x);
                    rc.setY(this.y);
                    this.y.setMiY(rc.getY().getMiY() + b);
                    this.x.setMiX(rc.getX().getMiX() + a); 
                    try{
                        Thread.sleep((int) (Math.random()*7));
                    }catch(InterruptedException e){
                    }
                    rc.release();
                    panel.repaint();
                    if (getY().getMiY() == getyMax())
                        b = -b;
                    if (getY().getMiY() == getyMin())
                        b = -b;
                    if (getX().getMiX() == getxMax())
                        a = -a;
                    if (getX().getMiX() == getxMin())
                        a = -a;                    
            }
        }
        else if(this.algoritmo == 3){ //Monitores
            while(true){
                synchronized(rc){
                    rc.setX(this.x);
                    rc.setY(this.y);
                    this.y.setMiY(rc.getY().getMiY() + b);
                    this.x.setMiX(rc.getX().getMiX() + a);
                }    
                synchronized(panel){        
                    if (getY().getMiY() == getyMax())
                        b = -b;
                    if (getY().getMiY() == getyMin())
                        b = -b;
                    if (getX().getMiX() == getxMax())
                        a = -a;
                    if (getX().getMiX() == getxMin())
                        a = -a;
                    panel.repaint();
                }                
                try{
                    Thread.sleep((int) (Math.random()*10));                  
                }catch(InterruptedException e){
                }
            }    
        }
        else if(this.algoritmo == 4){ //Variable de condición
            while(true){                                               
                try{
                    rc.lock();
                    try{
                        rc.signal();
                        rc.setX(this.x);
                        rc.setY(this.y);
                        this.y.setMiY(rc.getY().getMiY() + b);
                        this.x.setMiX(rc.getX().getMiX() + a);  
                        try{
                            Thread.sleep((int) (Math.random()*7));                
                        }catch(InterruptedException e){
                        }
                    }finally {
                        rc.unlock();
                    }
                    panel.repaint();
                }catch(Exception e){   
                }                       
                if (getY().getMiY() == getyMax())
                    b = -b;
                if (getY().getMiY() == getyMin())
                    b = -b;
                if (getX().getMiX() == getxMax())
                    a = -a;
                if (getX().getMiX() == getxMin())
                    a = -a;             
            }
        }       
    }

    public MiX getX() {
        return x;
    }

    public void setX(MiX x) {
        this.x = x;
    }

    public MiY getY() {
        return y;
    }

    public void setY(MiY y) {
        this.y = y;
    }

    public int getyMax() {
        return yMax;
    }

    public void setyMax(int yMax) {
        this.yMax = yMax;
    }

    public int getxMax() {
        return xMax;
    }

    public void setxMax(int xMax) {
        this.xMax = xMax;
    }

    public int getyMin() {
        return yMin;
    }

    public void setyMin(int yMin) {
        this.yMin = yMin;
    }

    public int getxMin() {
        return xMin;
    }

    public void setxMin(int xMin) {
        this.xMin = xMin;
    }  

    public int getAlgoritmo() {
        return algoritmo;
    }

    public void setAlgoritmo(int algoritmo) {
        this.algoritmo = algoritmo;
    }
     
}
