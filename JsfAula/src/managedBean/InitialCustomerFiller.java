package managedBean;

import entity.Usuario;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.UUID;

@Startup
@Singleton
public class InitialCustomerFiller {

    @PersistenceContext
    private EntityManager entityManager;

    @PostConstruct
    public void init() {

        System.out.println("Storing three initial customers");

        this.entityManager.persist(criarUsuario("João", "Doe", "doe@ifce.edu.br", LocalDate.of(1990, 12, 12)));
        this.entityManager.persist(criarUsuario("Pedro", "Mustermann", "max@gmail.com", LocalDate.of(1985, 4,
                20)));
        this.entityManager.persist(criarUsuario("Carlos", "Riecks", "philip@ifc.edu.br", LocalDate.of(1995, 9,
                13)));

    }

    private Usuario criarUsuario(String firstName, String lastName, String email, LocalDate dayOfBirth) {
        Usuario result = new Usuario();
        result.setPrimeiroNome(firstName);
        result.setUltimoNome(lastName);
        result.setEmail(email);
        result.setDataNascimento(dayOfBirth);
        result.setId(Long.getLong(UUID.randomUUID().toString().substring(0, 8)));
        return result;
    }
}
