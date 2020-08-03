package com.codicefiscale.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.jasypt.util.password.ConfigurablePasswordEncryptor;
import org.jasypt.util.text.BasicTextEncryptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codicefiscale.dao.PostRepositoryDao;
import com.codicefiscale.entity.Applicazione;
import com.codicefiscale.entity.Book;
import com.codicefiscale.entity.BookId;
import com.codicefiscale.entity.Bottiglia;
import com.codicefiscale.entity.ComuneItalia;
import com.codicefiscale.entity.Department;
import com.codicefiscale.entity.Etichetta;
import com.codicefiscale.entity.Parametri;
import com.codicefiscale.entity.Post;
import com.codicefiscale.entity.PostComment;
import com.codicefiscale.entity.Student;
import com.codicefiscale.entity.Utente;
import com.codicefiscale.service.ApplicazioneService;
import com.codicefiscale.service.BookService;
import com.codicefiscale.service.BottigliaService;
import com.codicefiscale.service.ComuneService;
import com.codicefiscale.service.EtichettaService;
import com.codicefiscale.service.StudentService;
import com.codicefiscale.service.UtenteService;
import com.codicefiscale.util.CriptaTesto;
import com.codicefiscale.util.EntityNotFoundExceptionById;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Controller
@ResponseBody
//@org.springframework.web.bind.annotation.RestController
//@ComponentScan({"com.codicefiscale.service."})
public class RestController {
	
	final Logger log = LoggerFactory.getLogger(RestController.class);
    
	@Autowired ComuneService comuneService;
	@Autowired UtenteService utenteService;
	@Autowired CriptaTesto criptaTesto;
	@Autowired BookService bookService;
	@Autowired BottigliaService bottigliaService;
	@Autowired EtichettaService etichettaService;
	@Autowired ApplicazioneService applicazioneService;
	@Autowired StudentService studentService;
	@Autowired PostRepositoryDao postRepositoryDao;
	
	@AllArgsConstructor
	public class JsonResponseBody{
		@Getter @Setter
		private int server;
		@Getter @Setter
		private Object response;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<JsonResponseBody> create(@RequestBody List<PostComment> review,String valore) {
		log.info(valore);
		
		return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), review));
    }
	
	
	@RequestMapping(value = "/insertPost", method = RequestMethod.POST)
	public ResponseEntity<JsonResponseBody> insertPost(Post post, PostComment review, BindingResult bindingResult) {
	 try {
			List<PostComment> listComment = new ArrayList<PostComment>();
			
			//log.info("=review===>" + review.getReview() + "<====");

			log.info("***Popola i Posts***");
			if (bindingResult.hasErrors()) {
				log.info("******NO BUONO******");
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JsonResponseBody(
						HttpStatus.FORBIDDEN.value(), bindingResult.getAllErrors().get(0).getCode()));
			}
			
			PostComment pc1 = new PostComment();
			pc1.setReview("pc1_New");
			listComment.add(pc1);
			
			PostComment pc2 = new PostComment();
			pc2.setReview("pc2_New");
			listComment.add(pc2);
			
			PostComment pc3 = new PostComment();
			pc3.setReview("pc3_New");
			listComment.add(pc3);
			
			
			//listComment.add(review);

			post.setComments(listComment);
				
					
			Post app = postRepositoryDao.save(post);

			return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), app));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN)
					.body(new JsonResponseBody(HttpStatus.FORBIDDEN.value(), e.toString()));

		}

	}
	
	
	@RequestMapping(value="/insertStudent", method=RequestMethod.POST)
	public ResponseEntity<JsonResponseBody> insertStudent(Student studente, BindingResult bindingResult){
		try {
			log.info("******popola Department******");
			Department dip_01 = new Department();
			//dip_01.setId(new Long(1));
			dip_01.setName("FILOSOFIA");
			
			Department dip_02 = new Department();
			//dip_02.setId(new Long(2));
			dip_02.setName("MATEMATICA");
			
			//Proviamo a ricavare il dipartimento interrogando
			studente.setDepartment(dip_02);
			//Salva il dipartimento
			studentService.saveDepartment(dip_02);
			
			//log.info("******Entrato in Student******");
			//Salva Lo student
			
			
			
			Student studioso = studentService.saveStudent(studente);
        	log.info("******OK******");
        	return ResponseEntity.status(HttpStatus.OK).
        	body(new JsonResponseBody(HttpStatus.OK.value(), studioso));
        }catch(Exception e) {
        	return ResponseEntity.status(HttpStatus.FORBIDDEN).
					body(new JsonResponseBody(HttpStatus.FORBIDDEN.value(),e.toString()));
        }
	}
	
	
	@RequestMapping(value="/insertApplicazione", method=RequestMethod.POST)
	public ResponseEntity<JsonResponseBody> insertApplicazione(Applicazione applicazione, BindingResult bindingResult){
		
		if(bindingResult.hasErrors()) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN)
					.body(new JsonResponseBody(HttpStatus.FORBIDDEN.value(),bindingResult.getAllErrors().get(0).getCode()));
		}
				
		
        try {
        	log.info("******Entrato in InsertApplicazione******");
            Applicazione app = applicazioneService.saveApplicazione(applicazione);
        	
        	log.info("******OK******");
        	return ResponseEntity.status(HttpStatus.OK).
        	body(new JsonResponseBody(HttpStatus.OK.value(), app));
        	
        }catch(Exception e) {
        	
        	return ResponseEntity.status(HttpStatus.FORBIDDEN).
					body(new JsonResponseBody(HttpStatus.FORBIDDEN.value(),e.toString()));
        }
	}
	
	
	@RequestMapping(value="/insertBottiglia",method=RequestMethod.POST)
	public ResponseEntity<JsonResponseBody> insertBottiglia(Bottiglia bottiglia,BindingResult bindingResult ){
			
			log.info("Dentro InserBottiglia");			
			
			if(bindingResult.hasErrors()) {
				return 	ResponseEntity.status(HttpStatus.FORBIDDEN)
						.body(new JsonResponseBody(HttpStatus.FORBIDDEN.value(), bindingResult.getAllErrors().get(0).getCode()));		
			}
		
		try {
			log.info("Insert Bottiglia OKKEI");
			Bottiglia bott = bottigliaService.saveBottiglia(bottiglia);
			
			return ResponseEntity.status(HttpStatus.OK).
					body(new JsonResponseBody(HttpStatus.OK.value(), bott));
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).
					body(new JsonResponseBody(HttpStatus.FORBIDDEN.value(),e.toString()));
		}
		
	}
	
	
	@RequestMapping(value="/deleteItemBottle", method=RequestMethod.GET)
	public ResponseEntity<JsonResponseBody> deleteItemBottle(@RequestParam(value="id") Long id){
	    log.info("Entrato in delete");
		
	    try {			
	    	bottigliaService.deleteItemBottiglia(id);
	    	
	    	return ResponseEntity.status(HttpStatus.OK).
					body(new JsonResponseBody(HttpStatus.OK.value(), "Cancellazione Riga eseguita"));
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).
					body(new JsonResponseBody(HttpStatus.FORBIDDEN.value(),e.toString()));
		}		
	}
	
	
	
	@RequestMapping(value="/allEtichette",method = RequestMethod.GET)
	public ResponseEntity<JsonResponseBody> allEtichette(){
		log.info("sono dentro a all etichette-->");
		try {
			
			List<Etichetta> b1 = etichettaService.getSoloUnaEtichetta();			
			//List<Bottiglia> b2 = bottigliaService.getAllEtichette();
			
			Long totEtichette = etichettaService.getTotaleEtichette();
			
			log.info("TOTALE ETICHETTE----->"+totEtichette.toString());
			
			
			return ResponseEntity.status(HttpStatus.OK).
					body(new JsonResponseBody(HttpStatus.OK.value(), b1));
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).
					body(new JsonResponseBody(HttpStatus.FORBIDDEN.value(),e.toString()));
		}		
	}   
	
	
	
	
	@RequestMapping(value="/fromElenco", method = RequestMethod.GET)
	public ResponseEntity<JsonResponseBody> getElenco(@RequestParam(value="istat") String istat){
		
		log.info("Istat_new-->"+istat);
		
		try {
			log.info("Istat-->"+istat);
			List<ComuneItalia> listaDiComuni = comuneService.getAllRighePerComune(istat);			
		    return ResponseEntity.status(HttpStatus.OK)
		    		.body(new JsonResponseBody(HttpStatus.OK.value(),listaDiComuni));
		
		}catch(Exception e) {
			log.info("Istat-->"+e.toString());			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new JsonResponseBody(HttpStatus.BAD_REQUEST.value(),e.toString()) );
		}
		
	}
	
	//Possiamo Usare @RequestParameter anche per il POST
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ResponseEntity<JsonResponseBody> login(@RequestParam  Map<String,String>  utenza ){
		
		String mySubject=null;
		Date myDate = new Date();
		String myName=utenza.get("user");
		String myPsw =utenza.get("psw");
		String myScope ="user";
		String jwt = null;
		
		try {
			List<Utente> findUtente = utenteService.findUtenteByUser(myName.toString());
			
			if(findUtente.isEmpty()) {
				//NO BUONO
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
									 .body(new JsonResponseBody(HttpStatus.BAD_REQUEST.value(),"Utente non Presente:") );
			}else{				
				if (!(criptaTesto.deCripta(findUtente.get(0).getPsw()).equals(myPsw))) {
					return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						   .body(new JsonResponseBody(HttpStatus.BAD_REQUEST.value(),"Password non corrisponde all utenza associata:") );
				}else {
					mySubject=""+findUtente.get(0).getId();
					jwt=utenteService.generateJwt(mySubject, myDate, myName, myScope);
				}
			}			
				
		}catch(Exception e) {
			log.info("Eccezione==>"+e.toString());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				   .body(new JsonResponseBody(HttpStatus.BAD_REQUEST.value(),"Eccezione: "+e.toString()) );
		}
		return ResponseEntity.status(HttpStatus.OK)
				 .header("jwt", jwt)
				 .body(new JsonResponseBody(HttpStatus.OK.value(),"OK:") );
	}
	
	@RequestMapping(value="/allComuni", method=RequestMethod.GET)
	public ResponseEntity<JsonResponseBody> tuttiIComuni(HttpServletRequest request){
		//String idUtente;
		
		try {
			Map<String, Object> datiRicavati = utenteService.verifyJwtAndGetData(request);
			//Id Utente...
			log.info("----->"+datiRicavati.get("subject"));
			//idUtente = datiRicavati.get("subject").toString();
		    
			//In realtà id Utente lo utilizzo solo per verificare 
			//la corretta identità ma per ricavare la lista dei comuni
			//in realtà non mi serve ...
			
			List<ComuneItalia> listaDiComuni = comuneService.findAll();
			return ResponseEntity.status(HttpStatus.OK)
		    		.body(new JsonResponseBody(HttpStatus.OK.value(),listaDiComuni));	
		
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					   .body(new JsonResponseBody(HttpStatus.BAD_REQUEST.value(),"Eccezione: "+e.toString()) );
			
		}
		
		
	}
	
	
	
	
	@RequestMapping(value="/testValid", method=RequestMethod.GET)	
	public ResponseEntity<JsonResponseBody> testa (@Valid Parametri valore,BindingResult bindingResult){
		log.info("======>"+valore.getParam()+"<======");
		
		if(bindingResult.hasErrors()) {
			log.info("Errore!"+bindingResult.getAllErrors().get(0).getCode());
			return ResponseEntity.status(HttpStatus.FORBIDDEN).
					body(new JsonResponseBody(HttpStatus.FORBIDDEN.value(),bindingResult.getAllErrors()));
		}
		return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), "Utente :"+valore.getParam()));
	}
	
	@RequestMapping(value="/findBook", method=RequestMethod.POST)
	public ResponseEntity<JsonResponseBody> findBook (BookId bookId,BindingResult bindingResult){
		
		log.info("GEt Name->"+bookId.getName());
				
		if(bindingResult.hasErrors()) {
			log.info("Errore!"+bindingResult.getAllErrors());
			return ResponseEntity.status(HttpStatus.FORBIDDEN).
					body(new JsonResponseBody(HttpStatus.FORBIDDEN.value(),bindingResult.getAllErrors()));
		}
		
		List<Book> myBook = bookService.findByIdAuthor(bookId.getAuthor());		
		return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), myBook));
	} 
	
	
	//----
	@RequestMapping(value="/postTestValid", method=RequestMethod.POST)	
	public ResponseEntity<JsonResponseBody> postTesta (@Valid Parametri valore,BindingResult bindingResult){
		log.info("======>"+valore.getParam()+"<======");
		log.info("======>"+valore.getDataInizio());
		
		if(bindingResult.hasErrors()) {
			log.info("Errore!"+bindingResult.getAllErrors());
			return ResponseEntity.status(HttpStatus.FORBIDDEN).
					body(new JsonResponseBody(HttpStatus.FORBIDDEN.value(),bindingResult.getAllErrors()));
		}
		return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), "Utente Risposte POST :"+valore.getParam()));
	}
	
	
	@RequestMapping(value="/insertUtente", method=RequestMethod.POST)
	public ResponseEntity<JsonResponseBody> inserisciUntente(
			@Valid  Utente utente,
			BindingResult bindingResult){		
		
		try {
			String Pxs = utente.getPsw();
			String criptato = criptaTesto.criPta(utente.getPsw());
			String decriptato = criptaTesto.deCripta(criptato);

			log.info("Password Input-->"+Pxs);
			log.info("Password pulito->criptato-->"+criptato);

			List<Utente> findUtente = utenteService.findUtenteByUser(utente.getUsername().toString());

			log.info("findUtente-isEmpty-> "+findUtente.isEmpty());
			if(!findUtente.isEmpty()) {
				log.info("User Già trovata no buono");
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JsonResponseBody(HttpStatus.FORBIDDEN.value(), "Utente :"+utente.getUsername()+" già Presente "));	
			}
			log.info("User Non presente si buono");

			//Per salvare la psw Criptata 
			utente.setPsw(criptato);
			//La Salva
			Utente myutt = utenteService.saveUtente(utente);
			//Per visualizzarla decriptata
			myutt.setPsw(decriptato);

			return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), myutt));	

		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JsonResponseBody(HttpStatus.FORBIDDEN.value(), e.toString()));
		}
	}
	
	
	@RequestMapping(value="/insertComune", method=RequestMethod.POST)
	public ResponseEntity<JsonResponseBody> inserisceRigaComuni(
			@Valid ComuneItalia comuneItalia,BindingResult bindingResult){
		
		log.info("Istat====>"+comuneItalia.getIstat());
		
		if(bindingResult.hasErrors()) {
			log.info("Errore!"+bindingResult.getAllErrors().get(0).getCode());
			return ResponseEntity.status(HttpStatus.FORBIDDEN).
					body(new JsonResponseBody(HttpStatus.FORBIDDEN.value(),bindingResult.getAllErrors().get(0).getCode()));
		}
		
		try {
			log.info("Save Comune Italia OKKEI");
			ComuneItalia myComuneItalia = comuneService.saveComuneItalia(comuneItalia);
			return ResponseEntity.status(HttpStatus.OK).
					body(new JsonResponseBody(HttpStatus.OK.value(),myComuneItalia));
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).
					body(new JsonResponseBody(HttpStatus.FORBIDDEN.value(),e.toString()));
		}
	}
	
	@RequestMapping(value="/deleteItemComune", method=RequestMethod.POST)
	public ResponseEntity<JsonResponseBody> cancellaSingolaRiga(@Valid ComuneItalia comuneItalia, BindingResult bindingResult){
		
		try {
			Integer idDeleted = comuneItalia.getIdIstat();
			log.info("cancellaSingolaRiga-id->"+idDeleted.toString());
			comuneService.deleteItemComuneItalia(comuneItalia);
			return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(),"OK idIstat=" + idDeleted +" is Deleted"));
		
		}catch(EntityNotFoundExceptionById ebd){	
			log.info("Eccezione-Riga Inesistente->"+ebd.toString());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JsonResponseBody(HttpStatus.NOT_FOUND.value(), "ECCEZIONE "+ebd));
			
		}catch(Exception e) {
			log.info("Eccezione-id->"+e.toString());
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JsonResponseBody(HttpStatus.FORBIDDEN.value(), "ECCEZIONE "+e));
		}
	}
	
	@RequestMapping(value="/deleteListComune", method=RequestMethod.POST)
	public ResponseEntity<JsonResponseBody> cancellaListaComuni(@Valid List<ComuneItalia> listaComuneItalia,BindingResult bindingResult){
		try {
			log.info("cancellaListaComuni-->"+listaComuneItalia.get(0));
			comuneService.deleteIGroupComuneItalia(listaComuneItalia);
			return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(),"OK Lista Comuni Cancellata"));
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JsonResponseBody(HttpStatus.FORBIDDEN.value(), "ECCEZZIONe-->"+e));
		}
	}
	
	@RequestMapping(value = "/updateComune",method = RequestMethod.POST)
	public ResponseEntity<JsonResponseBody> updateRigaComuneItalia(@Valid ComuneItalia comuneItalia, BindingResult bindingResult){
		
		if(bindingResult.hasErrors()) {
			log.info("Errore!"+bindingResult.getAllErrors().get(0).getCode());
			return ResponseEntity.status(HttpStatus.FORBIDDEN).
					body(new JsonResponseBody(HttpStatus.FORBIDDEN.value(),bindingResult.getAllErrors().get(0).getCode()));
		}
		
		try {
			log.info("==UPDATE RIGA==");
			ComuneItalia myComuneItalia = comuneService.updateRigaComuneItalia(comuneItalia);
			return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.FORBIDDEN.value(), myComuneItalia));
		}catch(Exception e){
			log.info("==ECCEZIONE UPDATE RIGA==>"+e.toString());
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JsonResponseBody(HttpStatus.FORBIDDEN.value(),e.toString()));
		}	
	}
	
	@Bean
	public BasicTextEncryptor criptazioneTesto() {
		ConfigurablePasswordEncryptor cpe = new ConfigurablePasswordEncryptor();
		cpe.setAlgorithm("SHA-1");
		cpe.setPlainDigest(true);		
		
		BasicTextEncryptor textEncriptor = new BasicTextEncryptor();
		textEncriptor.setPassword("PippoFaLapizza_conlecozzeOffregate1948");
		return textEncriptor;
	}
	
	
	
	
}

