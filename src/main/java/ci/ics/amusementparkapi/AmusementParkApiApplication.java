package ci.ics.amusementparkapi;

import ci.ics.amusementparkapi.dto.request.CategorieRequest;
import ci.ics.amusementparkapi.dto.request.ProduitRequest;
import ci.ics.amusementparkapi.entity.*;
import ci.ics.amusementparkapi.enums.Sexe;
import ci.ics.amusementparkapi.repository.*;
import ci.ics.amusementparkapi.service.CategorieService;
import ci.ics.amusementparkapi.service.ProduitService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import java.time.LocalDate;

@SpringBootApplication
public class AmusementParkApiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = 	SpringApplication.run(AmusementParkApiApplication.class, args);



	/*	DetailPass detailPass = new DetailPass();
		String nom = detailPass.getProduit().getNom();*/
		/*ProduitService produitService =ctx.getBean(ProduitService.class);
		List<ProduitResponse> out = produitService.all();
		String l = "";*/

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

/*	@Bean
	CommandLineRunner commandLineRunnerCategorie( CategorieService categorieService){
		return
				args -> {
					categorieService.create(CategorieRequest.builder().type("ADULTE").description("Uniquement pour les adultes").build());
					categorieService.create(CategorieRequest.builder().type("MINEUR").description("Uniquement pour les mineurs").build());
					categorieService.create(CategorieRequest.builder().type("PERSONNE").description("Pour tout le monde").build());
				};
	}

	@Bean
	CommandLineRunner commandLineRunnerProduit(ProduitService produitService){
		return
				args -> {
					produitService.create(ProduitRequest.builder()
									.nom("ENTREE")
									.image("entre.jpg")
									.description("Ce produit concerne les adultes, il s'agit de leur droit d'entrée sur le site")
									.prix(500)
									.categorie(1L)
							.build());

					produitService.create(ProduitRequest.builder()
							.nom("BOISSON")
							.image("boisson.jpg")
							.description("Ce produit est une boisson (eau minérale ou soda) il concerne toutes les personnes")
							.prix(500)
							.categorie(3L)
							.build());

					produitService.create(ProduitRequest.builder()
							.nom("PISCINE")
							.image("piscine.jpg")
							.description("Ce produit donne accès à la piscine pour tout le temps que l'enfant passera sur le site")
							.prix(4500)
							.categorie(2L)
							.build());
				};
	}

	@Bean
	CommandLineRunner commandLineRunnerType(TypeRepository typeRepository){
		return
				args -> {
					typeRepository.save(Type.builder().nom("PREMIUM").build());
					typeRepository.save(Type.builder().nom("MEDIUM").build());
				};
	}

	@Bean
	CommandLineRunner commandLineRunnerCaisse(CaisseRepository caisseRepository){
		return
				args -> {
					caisseRepository.save(Caisse.builder().nom("ENTREE").matricule("ENT001").build());
					caisseRepository.save(Caisse.builder().nom("RESTAURANT").matricule("REST001").build());
				};
	}

	@Bean
	CommandLineRunner commandLineRunnerCaissier(CaissierRepository caissierRepository){
		return
				args -> {
					caissierRepository.save(Caissier.builder().nom("KOKO").prenom("Aya Monique").sexe(Sexe.FEMININ).matricule("MAT001").dateNaissance(LocalDate.of(2000, 7, 23)).build());
					caissierRepository.save(Caissier.builder().nom("KABLAN").prenom("Loukou Mia").sexe(Sexe.FEMININ).matricule("MAT002").dateNaissance(LocalDate.of(1991,1,7)).build());
				};
	}

	@Bean
	CommandLineRunner commandLineRunnerTypePaiement(TypePaiementRepository typePaiementRepository){
		return
				args -> {
					typePaiementRepository.save(TypePaiement.builder().nom("ESPECE").build());
					typePaiementRepository.save(TypePaiement.builder().nom("CARTE BANCAIRE").build());
					typePaiementRepository.save(TypePaiement.builder().nom("CHEQUE").build());
					typePaiementRepository.save(TypePaiement.builder().nom("MOBILE MONEY").build());
				};
	}

	CommandLineRunner commandLineRunnerCoupon(CouponRepository couponRepository){
		return
				args -> {
					couponRepository.save(Coupon.builder().code("111").pourcentage(10).statut(false).build());
					couponRepository.save(Coupon.builder().code("222").pourcentage(10).statut(false).build());
					couponRepository.save(Coupon.builder().code("333").pourcentage(10).statut(false).build());
					couponRepository.save(Coupon.builder().code("444").pourcentage(10).statut(false).build());
				};
	}


*/


}
