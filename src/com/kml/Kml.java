package com.kml;

import java.io.*;

public class Kml {

    //读取文本文件
    public static String readKml(String filePath) throws Exception {
        File file = new File(filePath);
        BufferedReader reader = null;
        StringBuffer sbf = new StringBuffer();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempStr;
            while ((tempStr = reader.readLine()) != null) {
                sbf.append(tempStr);
            }
            reader.close();
            return sbf.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return sbf.toString();
    }

    //截取文本文件
    public static String[] replaceString(String str){
        String[] strings = str.split(" ");
        //System.out.println(strings.length);
        return strings;
    }

    //输出文本文件
    public static String getStr(String s[] , int num){

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            if(i % num ==0){
                sb.append(s[i]).append(" ");
            }
        }
        sb.append(s[0]);
        return new String(sb);
    }

    //写文件
    public static void writeFile(String str , String destpath) throws IOException {

        FileWriter fw = null;
        try {
            //创建字符输出流对象，负责向文件内写入
            fw = new FileWriter(destpath);
            //将str里面的内容读取到fw所指定的文件中
            fw.write(str);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            if(fw!=null){
                try {
                    fw.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

    }

    public static void run(String filePath , String destPath) throws Exception {
        String s = readKml(filePath);

        String destStr = getStr(replaceString(s) , 2);

        System.out.println(destStr);

        System.out.println(destStr.split(" ").length);

        writeFile(destStr , destPath);
    }


    public static void main(String[] args) throws Exception {

        String srcPath = "D:\\vs\\kml.txt";
        String destPath = "D:\\vs\\kml22.txt";

        run(srcPath , destPath);

        /*for (String s1: strings
             ) {
            System.out.println(s1);
        }*/
    }

}
