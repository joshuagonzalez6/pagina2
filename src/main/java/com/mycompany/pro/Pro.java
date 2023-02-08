

package com.mycompany.pro;

import java.util.Calendar;

public class Pro {

    public static void main(String[] args) {
        
    }
    String hora, min, seg, ampm;
    Calendar calendario;
    Thread h1;

    public Reloj() {
        initComponents();
        h1 = new Thread(this);
        h1.start();

        setVisible(true);
    }
        


    private javax.swing.JLabel jLabel1;

                  
 
    @Override
    public void run() {
        Thread ct = Thread.currentThread();
        while (ct == h1) {
            calcula();
            jLabel1.setText(hora + ":" + min + ":" + seg + " " + ampm);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException error) {

            }
        }
    }

    private void calcula() {
        Calendar calendario = new GregorianCalendar();
        Date fechaHoraactual = new Date();
        calendario.setTime(fechaHoraactual);
        ampm = calendario.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";
        if (ampm.equals("PM")) {
            int h = calendario.get(Calendar.HOUR_OF_DAY) - 12;
            hora = h > 9 ? "" + h : "0" + h;
            if(h==00){
                   hora="12";
             }else{
                   hora=h>9?""+h:"0"+h;
             }      
        } else {
            hora = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY) : "0" + calendario.get(Calendar.HOUR_OF_DAY);
        }
        min = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE) : "0" + calendario.get(Calendar.MINUTE);
        seg = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND) : "0" + calendario.get(Calendar.SECOND);
    }
    }

