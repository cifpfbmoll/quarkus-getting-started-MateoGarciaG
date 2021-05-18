package org.acme.getting.started;

import java.time.LocalDate;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Beer {

    /* 
    En QUARKUS no podemos usar reflection, por lo cual si tenemos un atributo privado, y no tienen GETTER o SETTER pues no vamos a poder asignarle un valor o actualizarlo
    */
    
    /* 
    * Ahora que tengo instalada el: Hibernate-Validotors. Puedo usar anotaciones de Validación
    Página interesante sobre JAVAX.validation:
    https://programmerclick.com/article/80591126011/
    */

    // @NotBlank: Verifique que el valor del elemento de la anotación no esté vacío (no es nulo y la longitud es 0 después de eliminar el primer espacio), que es diferente de @NotEmpty, @NotBlank solo se aplica a la cadena y eliminará el espacio de la cadena durante la comparación
    @NotNull
    @NotBlank
    private String name;
    // MIN() que el valor mínimo sea de 100
    @Min(100)
    private int capacity;

    /* 
    * Custom Validator: Create a custom validate to validate a localDate property's expired
    With: @JsonbDateFormat -> This annotation help us to set a format of the LocalDate when the object Beer it's serializable
    */

    // Utlizamos el @NotExpired Que hemos creado
    // Y hacemos el siguiente CURL
    // curl -d '{"name":"Alhambra", "capacity":500, "expired":"2021-10-01"}' -H "Content-Type: application/json" -X POST http://localhost:8080/hello
    @NotExpired
    @JsonbDateFormat("yyyy-MM-dd")
    private LocalDate expired;


    public Beer() {
    }



    public Beer(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    public LocalDate getExpired() {
        return this.expired;
    }

    public void setExpired(LocalDate expired) {
        this.expired = expired;
    }



    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", capacity='" + getCapacity() + "'" +
            ", expired='" + getExpired() + "'" +
            "}";
    }



}
