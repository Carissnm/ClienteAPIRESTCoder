package com.example.cliente_api_restpettinaroli.entities;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

@Entity
@Table(name = "CLIENTE")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @NotNull Long id;

    @Column(name = "NOMBRE")
    private @NotNull String name;

    @Column(name = "APELLIDO")
    private @NotNull String surname;

    @Column(name = "FECHA_DE_NACIMIENTO")
    private @NotNull LocalDate birthday;



    public Client() {
    }

    public Client(@NotNull String name, @NotNull String surname, @NotNull LocalDate birthday) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
    }

    public Long getId() {
        return id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

}
