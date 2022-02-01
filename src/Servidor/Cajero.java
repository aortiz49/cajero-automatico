package Servidor;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Cliente.Movimiento;

import java.net.ServerSocket;
import java.net.Socket;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 *
 * @author link
 */

//TODO:
// 1. establish protocol for hashed password
// 2. retrieve hash and perform login
// 3* (verify the transaction) ACID
public class Cajero {

    public static void main(String[] args) throws Exception {



        ServerSocket servidor;
        Socket mov;
        int puerto = 5000;

        System.out.println("Servidor arrancado y esperando conexiones...");
        try {
            boolean x = false;
            servidor = new ServerSocket(puerto);
            while (!x) {//cuando se nos acaben los refrescos paramos el servidor
                System.out.println("Esperando...");
                mov = servidor.accept();


              //  Movimiento gc = new Movimiento(mov);
                //gc.start();
            }
            System.out.println("Servidor finalizado...");
            servidor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

