package Servidor;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.net.Socket;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author link
 */
public class GestionMovimiento extends Thread {

    private PublicKey publicKey;
    private PrivateKey privateKey;
    private String client_public_key;
    private Socket s;
    private String mynum;

    public GestionMovimiento(Socket s) throws Exception {
        this.s = s;
        //publicKey = Asymmetric.generateRSAKeyPair().getPublic();
        //privateKey = Asymmetric.generateRSAKeyPair().getPrivate();
    }

    @Override
    public void run() {

        DataInputStream inputData = null;
        DataOutputStream outputData = null;

        ByteArrayInputStream byteinput = null;
        ByteArrayOutputStream byteout = null;

        try {
            //le envio la lista de los refrescos que ha pedido
            inputData = new DataInputStream(s.getInputStream());
            outputData = new DataOutputStream(s.getOutputStream());

            //System.out.println("Peticion -> "+s.getInetAddress()+" --- "+s.getPort());
            s.setSoLinger(true, 10);//tiempo para que el puerto este abierto

            // recibir llave publica de cliente
            client_public_key = inputData.readUTF();
            System.out.println(client_public_key);

            byte[] encoded = Base64.getDecoder().decode(client_public_key);
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(encoded);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey serverPublicKey = keyFactory.generatePublic(keySpec);
            System.out.println("THIS IS THE CLIENT'S PUBLIC KEY ");
            System.out.println(publicKey);

            outputData.writeUTF(Base64.getEncoder().encodeToString(publicKey.getEncoded()));

            mynum = inputData.readUTF();
            System.out.println("encrypted message: "+mynum);

            //String finalValue = RSAEncryptDecrypt.decryptRSA(mynum.getBytes(),privateKey);
           // System.out.println("final value: "+finalValue);

        } catch (IOException | NoSuchAlgorithmException | InvalidKeySpecException ex) {
           // Logger.getLogger(GestionClientes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                outputData.close();
            } catch (IOException ex) {
                //Logger.getLogger(GestionClientes.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
