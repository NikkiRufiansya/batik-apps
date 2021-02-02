package com.codetalenta.batikindonesia;

public class UrlApi {
    public static String BASE_URL = "http://batikita.herokuapp.com/index.php/batik/";

    public static BatikService getBatikService(){
        return RetrofitClient.getClient(BASE_URL).create(BatikService.class);
    }
}
