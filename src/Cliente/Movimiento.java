package Cliente;

import java.time.DateTimeException;
import java.time.LocalDate;

public class Movimiento {
    private LocalDate fecha;
    private boolean tipo;
    private double valor;
    private Usuario usuario;

    public Movimiento(Usuario usuario) {
        this.usuario = usuario;
    }
}
