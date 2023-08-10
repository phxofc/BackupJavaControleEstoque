
package util;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class ConverteData {
    
      public java.util.Date convertToAmericanDate(Date pData)throws ParseException {
          
            SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy-MM-dd");
           
            String dataString = formatarDate.format(pData);
            
            if(pData == null || pData.equals("")){
                return null;
            }

            try {
              DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
              return formatter.parse((dataString));
          } catch (ParseException e) {
              throw e;
          }
           
    }
    
}
