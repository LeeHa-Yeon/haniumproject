package com.example.haniumproject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

class URLConnector extends Thread {

    String result;
    String testurl;

    public URLConnector(String testurl) {
        this.testurl = testurl;
    }

    public String getResult(){
        String output = request(testurl);
        result = output;
        return result;
    }

    private String request(String url1) {

        //문자열 + 문자열 가능하게 하는 메소드
        StringBuilder output = new StringBuilder();
        try{
            URL url = new URL(url1);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            if(conn != null){
                conn.setReadTimeout(10000);
                conn.setRequestMethod("GET");  //값을 받아오는 형태
                conn.setDoInput(true);   //읽기 모드 지정
                conn.setDoOutput(true);  //쓰기 모드 지정

                if(conn.getResponseCode() == HttpURLConnection.HTTP_OK){

                    InputStream in = conn.getInputStream();
                    InputStreamReader reader = new InputStreamReader(in,"UTF-8");
                    BufferedReader is = new BufferedReader(reader);

                    String text = null;
                    while(true){
                        text = is.readLine();

                        if(text != null){
                            output.append(text);
                        }
                    }

                }

            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output.toString();
    }
}
