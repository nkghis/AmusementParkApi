package ci.ics.amusementparkapi;

import ci.ics.amusementparkapi.dto.categorie.CategorieINPUT;
import ci.ics.amusementparkapi.dto.produit.ProduitINPUT;
import ci.ics.amusementparkapi.dto.produit.ProduitOUTPUT;
import ci.ics.amusementparkapi.service.CategorieService;
import ci.ics.amusementparkapi.service.ProduitService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import java.util.List;

@SpringBootApplication
public class AmusementParkApiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = 	SpringApplication.run(AmusementParkApiApplication.class, args);

		ProduitService produitService =ctx.getBean(ProduitService.class);
		List<ProduitOUTPUT> out = produitService.all();
		String l = "";

	}

	@Bean
	ApplicationRunner applicationRunner(Environment environment) {
		return args -> {
			String port = environment.getProperty("server.port");
			String server ="Server start on http://localhost:"+port;
			System.out.println(server);
			//log.info("My Server start on http://localhost: " + environment.getProperty("port") );
		};
	}

	/*@Bean
	CommandLineRunner commandLineRunnerCategorie( CategorieService categorieService){
		return
				args -> {
					categorieService.create(CategorieINPUT.builder().type("ADULTE").description("Uniquement pour les adultes").build());
					categorieService.create(CategorieINPUT.builder().type("MINEUR").description("Uniquement pour les mineurs").build());
					categorieService.create(CategorieINPUT.builder().type("PERSONNE").description("Pour tout le monde").build());
				};
	}

	@Bean
	CommandLineRunner commandLineRunnerProduit(ProduitService produitService){
		return
				args -> {
					produitService.create(ProduitINPUT.builder()
									.nom("ENTREE")
									.image("entre.jpg")
									.description("Ce produit concerne les adultes, il s'agit de leur droit d'entrée sur le site")
									.prix(500)
									.categorie(1L)
							.build());

					produitService.create(ProduitINPUT.builder()
							.nom("BOISSON")
							.image("boisson.jpg")
							.description("Ce produit est une boisson (eau minérale ou soda) il concerne toutes les personnes")
							.prix(500)
							.categorie(3L)
							.build());

					produitService.create(ProduitINPUT.builder()
							.nom("PISCINE")
							.image("piscine.jpg")
							.description("Ce produit donne accès à la piscine pour tout le temps que l'enfant passera sur le site")
							.prix(4500)
							.categorie(2L)
							.build());
				};
	}*/
}
