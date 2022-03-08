import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import br.com.tavares.bootcamper.entidades.Bootcamp;
import br.com.tavares.bootcamper.entidades.Conteudo;
import br.com.tavares.bootcamper.entidades.Curso;
import br.com.tavares.bootcamper.entidades.Dev;
import br.com.tavares.bootcamper.entidades.Mentoria;

public class App {
    public static void main(String[] args) throws Exception {
        Conteudo curso1 = new Curso("Java 1", "Curso de Java básico", 10);
        Conteudo curso2 = new Curso("Java 2", "Curso intermediário de Java", 18);
        Conteudo curso3 = new Curso("Java 3", "Curso Avançado de Java", 20);
        Conteudo mentoria1 = new Mentoria("Aplicação com Java e Angular", "Integrando back-end Java com front em Angular", LocalDate.now());
        Conteudo cursoAvulso = new Curso("Angular Essencial", "Os fundamentos para desenvolver aplicações Angular completas", 20);

        Bootcamp bootcamp = new Bootcamp(
            new LinkedHashSet<Conteudo>(){{
                add(curso1);
                add(curso2);
                add(curso3);
                add(mentoria1);
            }}
        );

        Dev dev1 = new Dev("William");
        dev1.getConteudoInscrito().add(cursoAvulso);
        dev1.getConteudoInscrito().add(curso1);
        dev1.concluirConteudo(curso1);

        System.out.println("ANTES DO BOOTCAMP");
        System.out.println(dev1);

        bootcamp.inscreverDev(dev1);
        
        System.out.println("APÓS INSCRIÇÃO NO BOOTCAMP");
        System.out.println(dev1);
        System.out.println("BOOTCAMP CONCLUÍDO? " + bootcamp.isConcluido(dev1));

        dev1.concluirConteudo(curso2);
        dev1.concluirConteudo(curso3);
        dev1.concluirConteudo(mentoria1);

        System.out.println("DEPOIS DE CONCLUIR TODO O CONTEÚDO DO BOOTCAMP");
        System.out.println("BOOTCAMP CONCLUÍDO? " + bootcamp.isConcluido(dev1));
        System.out.println("XP TOTAL DO DEV AGORA: " + dev1.getTotalXP());
    }
}
