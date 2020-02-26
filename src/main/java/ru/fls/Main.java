package ru.fls;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        InputStream is = Main.class.getResourceAsStream("/test.json");
        try {
            LinkedHashMap<String, LinkedHashMap> receipt = mapper.readValue(is, LinkedHashMap.class);   //java.util.LinkedHashMap
            Set<String> rmKeys = new HashSet<>();
            rmKeys.add("user");
            rmKeys.add("userInn");
            rmKeys.add("buyer");
            rmKeys.add("buyerInn");
            rmKeys.add("operator");
            rmKeys.add("operatorInn");
            rmKeys.add("kktRegId");
            rmKeys.add("machineNumber");
            rmKeys.add("retailPlaceAddress");
            rmKeys.add("retailPlace");
            rmKeys.add("buyerPhoneOrAddress");
            rmKeys.add("fiscalDriveNumber");
            rmKeys.add("fiscalSign");
            rmKeys.add("messageFiscalSign");
            rmKeys.add("properties");
            rmKeys.add("rawData");
            rmKeys.add("paymentAgentData");
            rmKeys.add("providerData");
            rmKeys.add("providerInn");
            rmKeys.add("productCode");

            receipt.keySet().removeAll(rmKeys);

            Map content = receipt.get("content");
            content.keySet().removeAll(rmKeys);
            int unixDateTime = (int) content.get("dateTime");
            String date = Instant.ofEpochSecond(unixDateTime).toString().substring(0, 10);
            Object dateTime = content.put("dateTime", date);


            System.out.println();
            List items = (List) content.get("items");
            for (Object obj : items
            ) {
                Map item = (Map) obj;
                item.keySet().removeAll(rmKeys);
            }

            System.out.println(receipt.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
