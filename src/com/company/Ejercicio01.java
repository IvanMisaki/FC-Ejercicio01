package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Ejercicio01 {
    public static void main(String[] args) {
        BufferedReader br = null;

        try {

            br =new BufferedReader(new FileReader("files\\miArchivoCSV.csv"));
            String line = br.readLine();

            //int cantErroneos = 0;
            //int cantOK = 0;
            ArrayList<String> lstOK = new ArrayList<String>();
            ArrayList<String> lstOK_lineas = new ArrayList<String>();
            ArrayList<String> lstError_lineaMalFormada = new ArrayList<String>();
            ArrayList<String> lstError_correoDuplicado = new ArrayList<String>();
            ArrayList<String> lstUsuarios = new ArrayList<String>();

            int contadorLinea = 0;
            while (null!=line) {
                String [] partes = line.split(",");

                if(partes.length!=3){
                    //cantErroneos++;
                    lstError_lineaMalFormada.add(contadorLinea+"");
                }else if(!partes[0].contains("@")){
                    //cantErroneos++;
                    lstError_lineaMalFormada.add(contadorLinea+"");
                }else if(!partes[0].contains(".")){
                    //cantErroneos++;
                    lstError_lineaMalFormada.add(contadorLinea+"");
                }else if(partes[1].trim().length()==0){
                    //cantErroneos++;
                    lstError_lineaMalFormada.add(contadorLinea+"");
                }else if(partes[2].trim().length()==0){
                    //cantErroneos++;
                    lstError_lineaMalFormada.add(contadorLinea+"");
                }else{
                    boolean duplicado = false;
                    for (int i = 0; i < lstOK.size(); i++) {
                        //System.out.println("1---"+lstOK.get(i).split(",")[0]);
                        //System.out.println("2---"+partes[0]);
                        if(partes[0].equals(lstOK.get(i).split(",")[0])){
                            duplicado=true;
                            //System.out.println("acaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
                            break;
                        }else{
                            //System.out.println("acaaa no");
                        }
                    }
                    if(duplicado){
                        //System.out.println("Akiiiiii");
                        //cantErroneos++;
                        lstError_correoDuplicado.add("Linea ("+contadorLinea+") correo ("+partes[0]+")");
                    }else{
                        lstOK.add(line);
                        lstOK_lineas.add(contadorLinea+"");
                        lstUsuarios.add(partes[2]);
                        //cantOK++;
                    }

                }


                line = br.readLine();
                contadorLinea++;
            }

            System.out.println("Lista de Lineas procesadas -> "+lstOK_lineas);
            System.err.println("Lista de Lineas mal formadas -> "+lstError_lineaMalFormada);
            System.err.println("Lista de Correos Duplicados -> "+lstError_correoDuplicado);
            System.out.println("Lista de Usuarios -> "+lstUsuarios);
            System.out.println("Total de lineas OK = "+lstOK_lineas.size()+", " +
                                "total de lineas con correo duplicado = "+lstError_correoDuplicado.size()+", " +
                                "total de lineas mal formadas = "+lstError_lineaMalFormada.size());

        } catch (Exception e) {
            System.out.println("Error");
        } finally {
            if (null!=br) {
                //System.out.println("Fin");
            }
        }
    }
}
