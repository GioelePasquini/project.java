package meteo.meteoapplication.controller;


import meteo.meteoapplication.exceptions.CityException;
import meteo.meteoapplication.exceptions.DatasetException;
import meteo.meteoapplication.exceptions.TypeException;
import meteo.meteoapplication.filter.Filtraggio;
import meteo.meteoapplication.filter.Filtro;
import meteo.meteoapplication.model.*;
import meteo.meteoapplication.service.*;
import meteo.meteoapplication.util.Util;

import java.util.Vector;
import org.json.JSONObject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class simpleRestController {
   
    Vector<JSONObject> obj=new Vector<JSONObject>();
    Util u=new Util();
    Temperatura t;
    Vector<Temperatura> vtemp=new Vector<Temperatura>();
    CurrentService s=new CurrentService();
    Temperatura [] a;
    Object o=new Object();
    Filtraggio f = new Filtraggio();
	HistoricalService h=new HistoricalService();
	Vector<String> v=new Vector<String>();
    
    @GetMapping ("/temp/{names}")
    public Vector<Temperatura> getinfo(@PathVariable String names) throws CityException {
    	String[] splitted=names.split(",");
    	vtemp.clear();
    	for (int i=0; i< splitted.length;i++) {
    		obj=s.ReadFrom(splitted[i],"0","0");
            t=s.datawriter(obj);
            vtemp.add(t);
    	}
    	return vtemp;
    } 
    
    @RequestMapping("/save/{name}/{num_iter}")
    public Vector<Temperatura> oraperora(@PathVariable String name,
                                         @PathVariable int num_iter) { 
        vtemp=u.usetimer(name, num_iter);
        return vtemp;
    }
     
    
	@GetMapping ("/stats")
	public Vector<Object>  stats (@RequestBody Filtro param) throws CityException, DatasetException, TypeException  {
    	Vector<Object> vecret=new Vector<Object>();
    	vecret.clear();
		String[] splitted= param.getCitta().split(",");
		for (int i=0; i<splitted.length; i++) {
			obj=(h.ReadFrom(splitted[i], param.getFirst_day(), param.getLast_day()));
			o=f.Filtered_by_stat(param.getType_stat(),splitted[i],obj);
			vecret.add(o);
		}
		return vecret;
		
	}
	
	@GetMapping ("limit/{type_temp}/{type_rel}/{limit}")
	public Vector<String> limit (@RequestBody Filtro param,
			                     @PathVariable String type_temp,
			                     @PathVariable String type_rel,
			                     @PathVariable double limit) throws CityException, DatasetException, TypeException {
		v.clear();
		String[] splitted= param.getCitta().split(",");
     	v=f.Filtered_by_rel(splitted,param,type_rel, limit,type_temp);
		return v;
	}
	
	
	@GetMapping ("/rangingfrom/{type_temp}/{limitinf}/{limitsup}")
	public Vector<String> rangingfrom (@RequestBody Filtro param,
			                     @PathVariable String type_temp,
			                     @PathVariable double limitinf,
			                     @PathVariable double limitsup) throws CityException, DatasetException {
		v.clear();
		String[] splitted= param.getCitta().split(",");
		v=f.Filtred_by_limits(splitted, limitinf, limitsup, param, type_temp);
		return v;
	}
		
}
