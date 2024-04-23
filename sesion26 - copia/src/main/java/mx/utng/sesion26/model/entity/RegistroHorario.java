/**
 * @autor:Morales Lezama Mirza Natzielly
 * @category:GDS0622
 * @since: 18-04-2024
 */

package mx.utng.sesion26.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

//long tipo de dato primitivo
//Long: Clase envoltoria  que envuelve al tipo de dato long y le da más propiedades o calquier tipo de dato queempuece con mayusculas
@Entity
public class RegistroHorario {

    @Id @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;

    @NotEmpty 
   @Column(length = 30)
    private String empleado; 

    @Column(length = 30)
    private String horaEntrada; 


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getEmpleado() {
        return empleado;
    }
    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }
    public String getHoraEntrada() {
        return horaEntrada;
    }
    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    
}
