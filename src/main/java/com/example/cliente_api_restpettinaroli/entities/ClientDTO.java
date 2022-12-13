package com.example.cliente_api_restpettinaroli.entities;
// Genero una clase ClientDTO para poder modelar la información que quiero mostrar al buscar al cliente

public class ClientDTO {
    private String name;
    private String surname;

    // Aquí defino edad, atributo que quiero mostrar al hacer la búsqueda por id del cliente.
    private Integer age;

    public ClientDTO() {
    }

    public ClientDTO(String name, String surname, Integer age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "ClientDTO{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
