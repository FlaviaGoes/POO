
package gestaohospitalar;

public class Atendimento {
    private int id;
    private String status;
    private Paciente paciente;
    private Medico medico;
    private int contadorId = 0;

    public Atendimento(Paciente paciente, Medico medico) {
        this.id = contadorId++;
        this.status = "ENTRADA";
        this.paciente = paciente;
        this.medico = medico;
    }

    public int getProtocolo() {
        return id;
    }
    
    public void setProtocolo(int protocolo) {
        this.id = protocolo;
    }

    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

    public Paciente getPaciente() {
        return paciente;
    }
    
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }  
    
    public void imprimir(){
        System.out.println("Atendimento Id: " + id);
        System.out.println("Atendimento Status: " + status);
        System.out.println("Médico: " + medico.getNome());
        System.out.println("Paciente: " + paciente.getNome());
        System.out.println("Identidade do Paciente: " + paciente.getIdentidade());
    }
}
