package br.com.tavares.bootcamper.entidades;

public abstract class Conteudo {
    public final double XP_PADRAO = 10d;
    
    private String titulo;
    private String descricao;
    
    public Conteudo() {}    
    public Conteudo(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public abstract double calculaXP();
    
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(XP_PADRAO);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
        result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Conteudo other = (Conteudo) obj;
        if (Double.doubleToLongBits(XP_PADRAO) != Double.doubleToLongBits(other.XP_PADRAO))
            return false;
        if (descricao == null) {
            if (other.descricao != null)
                return false;
        } else if (!descricao.equals(other.descricao))
            return false;
        if (titulo == null) {
            if (other.titulo != null)
                return false;
        } else if (!titulo.equals(other.titulo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "titulo=" + titulo;
    }
}
