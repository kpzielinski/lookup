package com.company;

import java.net.InetAddress;
import java.net.UnknownHostException;


public class Lookup {

    public void checkHosts() throws InterruptedException {
        CSVHelper csvHelper = new CSVHelper();
        for (String countryCode : Constants.countries) {
            for (int i = Constants.START_POINT; i <= Constants.END_POINT; i++) {
                //System.out.println(checkHost(buildHostName(countryCode, i)));
                String result = (checkHost(buildHostName(countryCode, i)));
                System.out.println("Zapisuję: " + result);
                csvHelper.writeToCSVFile(result);
                Thread.sleep(1000);
            }
        }
        csvHelper.closeCsvFile();
    }

    private String buildHostName(String countryCode, int i) {
        return new StringBuilder()
                .append(countryCode)
                .append(i)
                .append(".")
                .append("nordvpn.com")
                .toString();
    }

    private String checkHost(String host) {
        try {
            InetAddress inetAddress = InetAddress.getByName(host);
            return buildLine(host, inetAddress.getHostAddress());
        } catch (UnknownHostException e) {
            // e.printStackTrace();
        }
        return host + " " + Constants.UNREACHABLE;
    }

    private String buildLine(String host, String ip) {
        return host + " --> " + ip + " " + CommonHelper.findNow();
    }


}
