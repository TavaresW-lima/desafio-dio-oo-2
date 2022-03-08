package br.com.tavares.bootcamper.entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Bootcamp {
    private List<Dev> devsInscritos = new ArrayList<>();
    private Set<Conteudo> conteudo = new LinkedHashSet<>();
    private LocalDate dataInicio = LocalDate.now();
    private LocalDate dataTermino = dataInicio.plusDays(45);

    public Bootcamp() {}
    public Bootcamp(Set<Conteudo> conteudo) {
        this.conteudo.addAll(conteudo);
    }

    public List<Dev> getDevsInscritos() {
        return devsInscritos;
    }

    public void setDevsInscritos(List<Dev> devsInscritos) {
        this.devsInscritos = devsInscritos;
    }

    public Set<Conteudo> getConteudo() {
        return conteudo;
    }

    public void setConteudo(Set<Conteudo> conteudo) {
        this.conteudo = conteudo;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }
    public LocalDate getDataTermino() {
        return dataTermino;
    }
    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }

    public void inscreverDev(Dev dev) {
        Set<Conteudo> conteudoAAdicionar = 
            this.conteudo
                .stream()
                .filter(cont -> !dev.getConteudoConcluido().contains(cont))
                .collect(Collectors.toCollection(LinkedHashSet::new));

        dev.getConteudoInscrito().addAll(conteudoAAdicionar);
        this.devsInscritos.add(dev);
    }

    public boolean isConcluido(Dev dev) {
        return dev.getConteudoConcluido().containsAll(conteudo);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((conteudo == null) ? 0 : conteudo.hashCode());
        result = prime * result + ((devsInscritos == null) ? 0 : devsInscritos.hashCode());
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
        Bootcamp other = (Bootcamp) obj;
        if (conteudo == null) {
            if (other.conteudo != null)
                return false;
        } else if (!conteudo.equals(other.conteudo))
            return false;
        if (devsInscritos == null) {
            if (other.devsInscritos != null)
                return false;
        } else if (!devsInscritos.equals(other.devsInscritos))
            return false;
        return true;
    }
  
}
