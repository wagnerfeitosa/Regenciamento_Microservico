package com.wg.controller_producao.models;

import java.util.HashMap;
import java.util.Map;

public class ListaCb {
	
	private static Map<String,CBAbstract> listaCabos = new HashMap<>();
	
	public static void iniciar() {
		
		listaCabos.put("cb50mm",new Cb50mm());
		listaCabos.put("cb16mm", new Cb16mm());
	}
	
	public static CBAbstract getInstanciaCb(String cb) {
		
		return listaCabos.get(cb);
	}

}
