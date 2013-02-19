package zutils;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import org.junit.Test;

import zutils.ZUtils.Plugin;
import zutils.core.LogHandler;

public class ZUtilsTest {

	public void test() {
		
		//Zutils.timer().countdown; Zutils.timer().schedule();
		
		String s = ZUtils.from(1,2,3).convert().toString();
		
		String[] s2 = ZUtils.convert(123).toStrings();
		
		// Plugins
		ZUtils.plugin(Plugin.class).faz();
		ZUtils.<Plugin>plugin("plugin").faz();
		
		
		Date data = ZUtils.factory().register(Date.class, Date.class).create(Date.class);
		
		ZUtils.from("foo", "bar").each(new Function() {
			public void run() {
				results.set(params.get());
			}
		});
		
		ZUtils.from("foo", "bar").each(new Function() {
			public void run() {
				//TODO:...
			}
		});
	}
	
	
	@Test
	public void deveriaTerObjeto() {
		assertTrue(ZUtils.from(1,2,3).has(2));
		assertTrue(ZUtils.from(1,2,3).contains(2));
	}
	
	@Test
	public void deveriaTerTresObjeto() {
		assertEquals(3, ZUtils.from(1,2,3).length());
	}
	
	@Test
	public void deveriaConverterStringParaInteiro() {
		assertEquals(5, ZUtils.from("5").convert().toInteger());
	}
	
	@Test
	public void deveriaConverterInteiroParaString() {
		assertEquals("5", ZUtils.from(5).convert().toString());
	}
	
	@Test
	public void deveriaConverterInteiroParaStringEstaticamente() {
		assertEquals("6", ZUtils.convert(6).toString());
	}
	
	@Test
	public void deveriaConverterStringParaInteiroEstaticamente() {
		assertEquals(6, ZUtils.convert("6").toInteger());
	}
	
	@Test
	public void deveriaCriarUmObjetoRegistradoNaFabrica() {
		assertNotNull(ZUtils.factory().register(Calendar.class, GregorianCalendar.class).create(Calendar.class));
	}
	
	@Test
	public void deveriaCriarUmObjetoRegistradoNaFabricaComParametros() {
		assertNotNull(ZUtils.factory().register(Date.class, java.sql.Date.class).create(Date.class, 8, 8, 2008));
	}
	
	@Test
	public void deveriaIterarElementos() {
		assertTrue(ZUtils.from(1,2,3).iterator().hasNext());
	}
	
	@Test
	public void deveriaEnumerarElementos() {
		assertTrue(ZUtils.from(1,2,3).enumerator().hasMoreElements());
	}
	
	@Test
	public void deveriaSerVazio() {
		assertTrue(ZUtils.from().isEmpty());
	}
	
	@Test
	public void deveriaNaoSerVazio() {
		assertTrue(!ZUtils.from(1,2,3).isEmpty());
	}
	
	@Test
	public void deveriaLoggarObjetosEstatico() {
		List<String> results = setupLogger();
		
		ZUtils.log("123", ", Funcionando em: ", 55).log("Fim...");
		
		assertTrue(results.contains("123, Funcionando em: 55"));
		assertTrue(results.contains("Fim..."));
	}
	
	@Test
	public void deveriaLoggarObjetosEErros() {
		List<String> results = setupLogger();
		
		ZUtils.log(new Exception("Excecao"), "Excecao ", 123);
		
		assertTrue(results.contains("Excecao 123"));
	}

	@Test
	public void deveriaLoggarObjetosEmLevelDEBUG() {
		List<String> results = setupLogger();
		
		ZUtils.log(LogHandler.Level.DEBUG, "Level.", "DEBUG");
		
		assertTrue(results.contains("Level.DEBUG"));
	}
	
	@Test
	public void deveriaLoggarObjetosInstancia() {
		List<String> results = setupLogger();
		
		ZUtils.from("Ola mundo",  ", crueu ;-( ").log();
		
		assertTrue(results.contains("Ola mundo, crueu ;-( "));
	}
	
	private List<String> setupLogger() {
		final List<String> results = new ArrayList<String>();
		
		Logger logger = Logger.getLogger("ZUtils");
		logger.addHandler(new Handler() {
			
			@Override
			public void publish(LogRecord record) {
				results.add(record.getMessage());
			}
			
			@Override
			public void flush() {
				// Do nothing
			}
			
			@Override
			public void close() throws SecurityException {
				// Do nothing
			}
		});
		return results;
	}
	
	@Test
	public void deveriaExecutarForEach() {
		ZUtils.from(1, 2, 3, 4).each(new Function() {
			public void run() {
				ZUtils.log("index[", params.get("index"), "] = ", params.get());
			}
		});
	}
	
	@Test
	public void deveriaRegistrarENotificarEventos() {
		ZUtils.events().add("click", this).observer("click", new Function() {
			public void run() {
				ZUtils.log("Ocorreu um click!", " Vindo de : ", params.get("observable"));
				ZUtils.log("Gerador: ", params.get(0));
			}
		}).observer("click", new Function() {
			public void run() {
				ZUtils.log("Outro observer...");
			}
		}).notify("click", "mouse");
	}
	
	
	@Test
	public void deveriaRegistrarENotificarEventosClasse2() {
		// notifica por nome
		ZUtils.event("click").add(new Function() {
			public void run() {
				System.out.println("clicou!!! " + params.get() + " - " + params.get(0));
			}
		});
		
		ZUtils.event("click").notify(this, "teste");
		
		
		// notifica por classe
		ZUtils.event(ZUtils.class).add(new Function() {
			public void run() {
				ZUtils.log(params.get());
				System.out.println(params.get("event"));
			}
		}).notify(null, 1,2,3);
		
		
		// notifica por instancia
		ZUtils.event(this).add(new Function() {
			public void run() {
				ZUtils.log(params.get(0));
				System.out.println(params.get("event"));
			}
		});
		
		ZUtils.event(this).notify(null, 666);
		
	}
	
}
