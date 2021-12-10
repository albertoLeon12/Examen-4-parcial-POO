package examen4;

import java.io.IOException;
import java.io.*;

public class Examen4 {
    public static void main(String[] args) throws IOException {
        try {
            RandomAccessFile f = new RandomAccessFile("empleados.dat","rw");
            long nregistros=f.length()/76;
            f.seek(66);
            for(int i =0; i<nregistros;i++){

                double sHro=f.readDouble();
                byte hro=f.readByte(); 
                double sueldo=0; 
                
                if(hro>=40 && hro<=50){
                    sueldo = 40*sHro;
                    sueldo += (hro-40)*1.5*sHro;
                    
                }else if(hro>50) {
                    sueldo = 40*sHro;
                    sueldo += 10*1.5*sHro;
                    sueldo += (hro-50)*2*sHro;
                }else{
                    sueldo = hro*sHro;
                }
                System.out.println(sueldo);
                f.writeDouble(sueldo);
                f.skipBytes(66);

            }
            f.close();
        } catch (IOException ex) {
            System.out.println("Error: "+ex);
        }
    }    
}
