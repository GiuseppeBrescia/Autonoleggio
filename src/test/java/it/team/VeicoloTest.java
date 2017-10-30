package it.team;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.team.config.AppConfig;
import it.team.config.HibernateConfiguration;
import it.team.model.Alimentazione;
import it.team.model.Categoria;
import it.team.model.Cliente;
import it.team.model.Colore;
import it.team.model.Veicolo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class, HibernateConfiguration.class })
@WebAppConfiguration
@Transactional

public class VeicoloTest {
	
private Veicolo veicolo;
	
	@Autowired
	private WebApplicationContext ctx;

	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}

	private ObjectMapper mapper = new ObjectMapper();

	@Test	//test saveVeicolo OK
	public void testSaveCliente() throws Exception {
		veicolo = new Veicolo();
		
		veicolo.setMarca("fiat");
		veicolo.setModello("panda");
		veicolo.setAlimentazione(Alimentazione.BENZINA);
		veicolo.setCategoria(Categoria.UTILITARIA);
		veicolo.setColore(Colore.BIANCO);
		veicolo.setTarga("coione");
		
		mockMvc.perform(
				post("/veicolo/add").content(mapper.writeValueAsString(veicolo)).contentType(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isCreated());
	}
	
	@Test	//test getListVeicoli OK
	public void testGetListVeicoli() throws Exception {
		
		mockMvc.perform(get("/veicolo/getList")).andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)).andDo(print());
		
	}

}
