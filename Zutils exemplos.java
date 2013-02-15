// System
class Z {
	public static void main(String[] args) {
		
		Zutils.threadSafe = true;
		Exception e = Zutils.error();
		Exception[] ae = Zutils.errors();
		Exception ee = Zutils.errors(2); // ae[2]
		MyClass mc = new MyClass();
		MyClass m = Zutils.clone(mc);
		byte[] b = Zutils.serialize(m);
		String j = Zutils.json(m);
		String x = Zutils.xml(m);
		
		// Converting
		Zutils.convert(new Conversor());
		String s = Zutils.from(5).convert().toString();
		int i = Zutils.convert("5").toInt(); //.toLong()  .toShort()  ...
		long g = Zutils.convert(5L).toBigDecimal(); 
		int ii = Zutils.convert(33.3333).toInt();
		String jj = Zutils.from(m).toJson();
		String xx = Zutils.from(m).toXML();
		String[] sss = Zutils.from(1,2,3).convert().toStrings();
		Int[] iii = Zutils.from("1", "2", "3").convert().toIntegers();
		
		// Strings
		String s = Zutils.from("a", "b", "c").join(';').toString(); // junta e separa por ponto e virgula
		String[] a = Zutils.from(s).split(';').toString(); // quebra no ponto e virgula
		String abc = Zutils.from("a").add("b").add("c").toString();
		String vazio = Zutils.from("    ").trim().toString(); //trim spaces
		int t = Zutils.from(s).length();
		boolean b = Zutils.from(s).isEmpty();
		Boolean bb = Zutils.from(s).contains("a");
		Boolean bb = Zutils.from(s).has("a");
		
		// Collections
		List<Integer) l = Zutils.from(2,1,3).sort().revert();  // ordena e inverte
		int[] ai = Zutils.from(1, null, 2).trim().toArray(); // remove objetos nulos
		Set<Long> set = Zutils.from(1,2).add(3).add(4).remove(0).toSet(); // {2,3,4}
		int t = Zutils.from(l).length();
		boolean b = Zutils.from(l).isEmpty();
		Int i = Zutils.from(1,2,3).first(); // .last(), at(1)
		
		
		// Lists
		List<Integer> l = Zutils.from(1,2,3).toList();
		List<Integer> ll = Zutils.from(4,5,6).join(l).toList();
		List<Integer> lll = Zutils.from(ll).split(2, 3).toList(); // indice, max
		
		//maps
		Map<Integer, String> m = Zutils.from(1, "a", 2, "b").add(3,"c").toMap();
		
		
		// Logging
		Zutils.log("txt: ", 222);
		Zutils.from("txt: ", 222).log();
		Zutils.logger(new Logger());
		
		
		// Iteration
		Iterator<Integer> it  = Zutils.from(1,2,3).iterator();
		Enumerator<Integer> it  = Zutils.from(1,2,3).enumerator();
		Int t = Zutils.from(1,2,3).each(new Func() {
				public void run() {
						int i = params.get(0);
						results.set("total", results.get("total") + i);
				}
		}).results("total");
		
		
		// Threding
		Zutils.run(new Func()).call(new Func()); // Roda o run na thead e terminando chama call
		Zutils.threads().add(new Func()).run(); //Func, Thread, Runnable
		Zutils.threadPool(new TheadPool());
		
		
		// events
		//Proxy dinamico invocado a cada execucao da classe ou de um metodo.
		MyClass m = Zutils.proxy(MyClass.class, new Func());
		MyClass m = Zutils.proxy(MyClass.class, MyClass.class.getMethod("name"), new Func());
		
		// Registro de disparadores de eventos , ou seja, observados
		Zutils.events(this); // add instance of observable
		Zutils.events(this, "name"); // add instance of observable and event name
		Zutils.events(MyClass.class); // add static observable also supports name
		// adiciona, remove e notifica, por nome, com ou sem parametros
		Zutils.events(new EventServer()).add(this).remove(MyClass.class).notify(params); 
		
		// Adiciona ou remove observadores de eventos, pode ser funcao ou interface observador
		// observa tudo, classe ou instancia
		// onde this implementa Observer ou herda Func
		Zutils.events().register(this, myclass).unregister(this, MyClass.class);
		Zutils.events().register()
		
		Zutils.events() // .contains()  .length()
		Zutils.event(this).add(new Func()); // Instance
		Zutils.event(MyClass.class).add(new Observable()); // .remove()
		Zutils.event(MyClass.class).notify("nome-evento"', 1, "aa", 5.5);
		//Zutil.event(MyClass.class).register(new Func());   //  .unregister(func);

	}
}
