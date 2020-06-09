package com.grace.mpesaapistkpush;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Constants {

    private String Phone = "254719700918";

    public String getConsumerKey() {
        return "3Flz8PaCHjaawGgeDjlSXEapfA4qNSlI";
    }

    public String getConsumerSecret() {
        return "4NJGIJBPl59qVPlQ";
    }

    public String getPassKey() {
        return "bfb279f9aa9bdbcf158e97dd71a467cd2e0c893059b10f78e6b72ada1ed2c919";
    }

    public String getShortCode() {
        return "174379";
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getTime(){
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("YYYYMMDDhhmmss");
        System.out.println(dateFormat.format(date));
        return dateFormat.format(date);
    }
}
