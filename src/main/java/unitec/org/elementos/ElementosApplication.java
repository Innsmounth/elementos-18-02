package unitec.org.elementos;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ElementosApplication implements CommandLineRunner {
@Autowired RepositorioMensajitos repoMensa;

	public static void main(String[] args) {
		SpringApplication.run(ElementosApplication.class, args);
	}

    @Override
    public void run(String... strings) throws Exception {
        Mensajitos n = new Mensajitos ("primero","holaa");
        //repoMensa.save(n);
        
        //Probaremos el de buscbar todos
        ArrayList<Mensajitos>mensajitos=(ArrayList<Mensajitos>)repoMensa.findAll();
        for(Mensajitos mensa: mensajitos)
        {
        System.out.println(mensa.getTitulo()); 
        }
        
        //Ahora probaremos en buscar por ID
       Mensajitos m1= repoMensa.findOne(1);
        System.out.println(m1.getTitulo()); 
        
        //Update actualizacion
        
        repoMensa.save(new Mensajitos(1,"otro","malo"));
        
        //borrar
        repoMensa.delete(1);
    }
}
