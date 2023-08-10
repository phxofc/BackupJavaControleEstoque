
package util;

public class Formatador {
    
    //converter virgula para ponto
    
    
    public double converterVirgulaParaPonto(String vlr){
    Double valor = Double.parseDouble(vlr.replace(',', '.'));
    return valor;
 }
    
}
