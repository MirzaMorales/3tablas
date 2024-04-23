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
public class RegistroHogarGasto {
    
    @Id @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;

    @NotEmpty 
   @Column(length = 30)
    private String fecha; 

    @Column(length = 30)
    private String concepto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }


}
