package Cliente;
import Utils.Cifrador;

public class Usuario {

    private String mail;
    private String password;
    private Double saldo;
    private Double limite;

    public Usuario(String mail, String password, Double saldo, Double limite) {
        this.mail = mail;
        this.password = password;
        this.saldo = saldo;
        this.limite = limite;
    }
    public static void main(String[] args) {
    Usuario test = new Usuario("hola","123",13.4,300.0);
    String mail = test.getMail();
    Cifrador cifrador = Utils.Cifrador.nuevoCifrador();
    String cifrado = cifrador.SHA512(mail);

    System.out.println(cifrado);

    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }


}
