package com.neoflex.calculator.services;

import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalDate;

@Service
public class CalculateService {
    public String calculateVacationPay(int salary,int days,String date){
        if(date!="") {
            String[] a = date.split("-");
            //Праздничные дни
            LocalDate JanuaryHolidaysStart  = LocalDate.of(2022,1,1);
            LocalDate JanuaryHolidaysEnd  = LocalDate.of(2022,1,8);

            LocalDate FebruaryHolidaysStart  = LocalDate.of(2022,2,22);
            LocalDate FebruaryHolidaysEnd  = LocalDate.of(2022,2,24);

            LocalDate MarchHolidaysStart  = LocalDate.of(2022,3,7);
            LocalDate MarchHolidaysEnd  = LocalDate.of(2022,3,9);

            LocalDate MayHolidaysStart  = LocalDate.of(2022,5,1);
            LocalDate MayHolidaysEnd = LocalDate.of(2022,5,5);
            LocalDate MayHolidaysStart1  = LocalDate.of(2022,5,9);
            LocalDate MayHolidaysEnd1  = LocalDate.of(2022,5,11);

            LocalDate JuneHolidaysStart  = LocalDate.of(2022,6,12);
            LocalDate JuneHolidaysEnd  = LocalDate.of(2022,6,14);

            LocalDate NovemberHolidayDay  = LocalDate.of(2022,11,4);

            int year = Integer.parseInt(a[0]);
            int day = Integer.parseInt(a[2]);
            int month = Integer.parseInt(a[1]);
            LocalDate d = LocalDate.of(year, month, day);
            int count = 0; //Количество праздничных дней выпавших на отпуск
            for (int i = days; i > 0; i--) {
                if(d.getMonthValue()==JanuaryHolidaysStart.getMonthValue()){
                    if(d.getDayOfMonth()>=JanuaryHolidaysStart.getDayOfMonth() && d.getDayOfMonth()<=JanuaryHolidaysEnd.getDayOfMonth()){
                        count++;
                    }
                }
                if(d.getMonthValue()==FebruaryHolidaysStart.getMonthValue()){
                    if(d.getDayOfMonth()>=FebruaryHolidaysStart.getDayOfMonth() && d.getDayOfMonth()<=FebruaryHolidaysEnd.getDayOfMonth()){
                        count++;
                    }
                }
                if(d.getMonthValue()==MarchHolidaysStart.getMonthValue()){
                    if(d.getDayOfMonth()>=MarchHolidaysStart.getDayOfMonth() && d.getDayOfMonth()<=MarchHolidaysEnd.getDayOfMonth()){
                        count++;
                    }
                }
                if(d.getMonthValue()==MayHolidaysStart.getMonthValue()){
                    if(d.getDayOfMonth()>=MayHolidaysStart.getDayOfMonth() && d.getDayOfMonth()<=MayHolidaysEnd.getDayOfMonth() ||
                            d.getDayOfMonth()>=MayHolidaysStart1.getDayOfMonth() && d.getDayOfMonth()<=MayHolidaysEnd1.getDayOfMonth()){
                        count++;
                    }
                }
                if(d.getMonthValue()==JuneHolidaysStart.getMonthValue()){
                    if(d.getDayOfMonth()>=JuneHolidaysStart.getDayOfMonth() && d.getDayOfMonth()<=JuneHolidaysEnd.getDayOfMonth()){
                        count++;
                    }
                }
                if(d.getMonthValue()==NovemberHolidayDay.getMonthValue()){
                    if(d.getDayOfMonth()==NovemberHolidayDay.getDayOfMonth()){
                        count++;
                    }
                }
                d = d.plusDays(1);
            }
            days=days-count;
        }
        DecimalFormat decimalFormat = new DecimalFormat( "#.###" );
        double vacPay = (salary*12)/12/29.3 * days;
        return decimalFormat.format(vacPay);
    }
}
