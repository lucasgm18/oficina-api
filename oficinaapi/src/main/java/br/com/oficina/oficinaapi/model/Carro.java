package br.com.oficina.oficinaapi.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

  @Entity
  @Table(name = "tb_carro")

  public class Carro implements Serializable {
    private  static final long serialVersionUID = 1L;

    @Id
    private String vin;
    private String placa;

    public Carro() {
    }

    public Carro(String vin, String placa) {
        this.vin = vin;
        this.placa = placa;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carro carro = (Carro) o;
        return Objects.equals(vin, carro.vin);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(vin);
    }

    @Override
    public String toString() {
        return "Carro{" +
                "vin='" + vin + '\'' +
                ", placa='" + placa + '\'' +
                '}';
    }
}
