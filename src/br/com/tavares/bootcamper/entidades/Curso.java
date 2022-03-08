package br.com.tavares.bootcamper.entidades;

public class Curso extends Conteudo {

    private int cargaHoraria;
    
    public Curso() {}
    public Curso(String titulo, String descricao, int cargaHoraria) {
        super(titulo, descricao);
        this.cargaHoraria = cargaHoraria;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }
    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public double calculaXP() {
        return this.XP_PADRAO + 15d;
    }

    @Override
    public String toString() {
        String toString = super.toString();
        return "Curso [" + toString + " cargaHoraria=" + cargaHoraria + "]";
    }
    
}
