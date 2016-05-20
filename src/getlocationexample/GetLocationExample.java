/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getlocationexample;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;



import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
   


public class GetLocationExample {
    

     private void getIPLocation(String ipStr) throws IOException, GeoIp2Exception{
        File file = new File("/home/ric/GeoLite2/GeoLite2-City.mmdb");
        DatabaseReader reader = new DatabaseReader.Builder(file).build();
        CityResponse response = reader.city(InetAddress.getByName(ipStr));


        System.out.println("City " +response.getCity());
        System.out.println("ZIP Code " +response.getPostal().getCode());
        System.out.println("Country " +response.getCountry());
        System.out.println("Location " +response.getLocation());
    }


  public static void main(String[] argv)throws Exception {
        GetLocationExample gih = new GetLocationExample();
        gih.getIPLocation("210.128.115.149");
        gih.getIPLocation("67.188.26.1");

    }
    
}
