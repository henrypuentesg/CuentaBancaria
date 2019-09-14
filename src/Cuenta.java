package CuentaBancaria;

public class Cuenta {
    private int numero;
    private String nombre;
    private int saldo;

    public Cuenta (int numero, String nombre, int saldo){
        this.numero = numero;
        this.nombre = nombre;
        this.saldo = saldo;
    }

    public int darsaldo(){ return this.saldo; }

    public void depositarDinero(int monto){
        saldo += monto;
    }

    public void retirarDinero(int monto){
        saldo -= monto;
    }

    public void transferencia(Cuenta numero, int monto){
        this.saldo -= monto;
        numero.saldo += monto;
    }

    public void cerrarCuenta(Cuenta numero){
        numero = null;
    }
}