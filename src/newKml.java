
import com.kml.Kml;
import de.micromata.opengis.kml.v_2_2_0.Coordinate;

import java.io.File;
import java.util.List;

public class newKml {

    public static String getStr() {

        KmlProperty kmlProperty;
        ParsingKmlUtil parsingKmlUtil = new ParsingKmlUtil();
        File file = new File("D:\\vs\\shanxi.kml");
        kmlProperty = parsingKmlUtil.parseKmlForJAK(file);

        List<KmlPolygon> kmlPolygons = kmlProperty.getKmlPolygons();

        /*for (KmlPolygon k: kmlPolygons
             ) {
            System.out.println(k);
        }*/

        KmlPolygon kmlPolygon = kmlPolygons.get(0);

        List<Coordinate> points = kmlPolygon.getPoints();

        String s = points.toString();

        //System.out.println(s);

        return s;

    }

    //将一条数据转换
    public static void transfer(){
        String str = getStr();
        String[] newStr = str.split(" ");

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < newStr.length; i++) {
            if (i == 0){
                newStr[i].substring(1);
            }
            /*if (i == newStr.length - 1){
                newStr[i].substring(0 , newStr.length - 2);
            }*/
            sb.append(newStr[i]).append("0 ");

        }
        String destStr = sb.toString();
        String srcStr = destStr.substring(1 , destStr.length()-1).replace("]" , ",");

        String[] strings = Kml.replaceString(srcStr);

        System.out.println("改变之前数组长度:" + strings.length);

        String s0 = Kml.getStr(strings , 2);

        System.out.println("改变之前数组长度:" + s0.split(" ").length);

    }


    public static void main(String[] args) {
        transfer();
    }
}


