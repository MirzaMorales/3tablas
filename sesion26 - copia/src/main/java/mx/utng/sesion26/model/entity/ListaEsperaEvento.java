package mx.utng.sesion26.model.entity;


/**
 * @autor:Morales Lezama Mirza Natzielly
 * @category:GDS0622
 * @since: 18-04-2024
 */

 import jakarta.persistence.Column;
 import jakarta.persistence.Entity;
 import jakarta.persistence.Id;
 import jakarta.validation.constraints.NotEmpty;
 import jakarta.persistence.GeneratedValue;
 import jakarta.persistence.GenerationType;

 @Entity
public class ListaEsperaEvento {
    
    
    @Id @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;

    @NotEmpty 
   @Column(length = 30)
    private String nombreEvento; 

    @Column(length = 30)
    private String personas; 


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombreEvento() {
        return nombreEvento;
    }
    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }
    public String getPersonas() {
        return personas;
    }
    public void setPersonas(String personas) {
        this.personas = personas;
    }

    
}
