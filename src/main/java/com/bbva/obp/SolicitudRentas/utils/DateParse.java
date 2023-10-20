package com.bbva.obp.SolicitudRentas.utils;


import org.springframework.stereotype.Component;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

@Component
public class DateParse {

    private static final String DATE_FORMAT = "dd/MM/yyyy";

    public static XMLGregorianCalendar createGregorianCalendar(String dateStr)  {
        if (dateStr.equals("")) {
            return null;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat( DateParse.DATE_FORMAT );

        try {
            dateFormat.parse(dateStr);
            String[] date = dateStr.split("/");
            XMLGregorianCalendar xCal = DatatypeFactory.newInstance()
                    .newXMLGregorianCalendar();
            xCal.setYear(Integer.parseInt(date[2]));
            xCal.setMonth(Integer.parseInt(date[1]));
            xCal.setDay(Integer.parseInt(date[0]));

            //System.out.println("XMLGregorianCalendar: " + xCal);
            return xCal;
        } catch (ParseException | DatatypeConfigurationException e) {
            e.printStackTrace();
            return null;
        }
    }

}
