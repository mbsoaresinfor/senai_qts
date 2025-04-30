/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula;

/**
 *
 * @author fatec.senai
 */
public class ValidaCarro {
    public boolean validaIdCarro(int id){            	       
        if(id < 0 ){
          return false;
        }        
        return true;
        
    }
	
	 public boolean validaModelCarro(String modelo){            
       
        if(modelo.length() <= 20 ){
          return true;
        }        
        return false;
        
    }
	
	 public boolean validaMarcaCarro(String marca){            
		 if(marca == null) {
			 return false;
		 }
        if(marca.equals("VW") || marca.equals("GM") ){
          return true;
        }        
        return false;
        
    }
	 
	 public boolean validaPlacaCarro(String placa){            
	       
	        if(placa.length() == 8) {
	          return true;
	        }	        
	        return false;
	        
	 }
	 
	 public boolean validaAnoFabricacao(int ano){            
	       
	        if(ano > 1980) {
	          return true;
	        }        
	        return false;	        
	    }
	 
	 public boolean validaPrecoFabricacao(float valor){            
	       
	        if(valor > 1 && valor < 50000) {
	          return true;
	        }	        
	        return false;	        
	    }

}
