//Javier Enrique Luna Díaz
package JDrones;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RCompartido {
    private MiX x;
    private MiY y;
    private Semaphore s;
    private Lock m;
    private Condition c;
    
    RCompartido(){
        s = new Semaphore(1,true);
        m = new ReentrantLock();
        c = m.newCondition();
    }

    /**
     * @return the x
     */
    public MiX getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(MiX x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public MiY getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(MiY y) {
        this.y = y;
    }
    
    public void acquire(){
        try{
            s.acquire();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void release(){
        s.release();
    }

    public void lock(){
        m.lock();
    }
    
    public void unlock(){
        m.unlock();
    }
    
    public boolean tryLock(){
        return m.tryLock();
    }
    
    public void signal(){
        try{
            c.signal();
        }catch(Exception e){
        }
    }
    
    public void await(){
        try{
            c.await();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
       
}
