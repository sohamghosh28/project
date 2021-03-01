package SeaManifesto;


import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import static javax.swing.UIManager.get;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Soham
 */
public class select {
    public static void main(String args[])throws IOException, ParseException
    {
        JSONParser jsonparser=new JSONParser();
        FileReader reader=new FileReader("C:\\Users\\Soham\\Desktop/SAM_Sample_S_BLSigned.json");
        //assert.hasExtension("json");
        Object ob=jsonparser.parse(reader);
        JSONObject jsonob=(JSONObject)ob;
        Map Header=(HashMap)jsonob.get("HeaderField");
        System.out.println(Header);
        Set k=Header.keySet();
        System.out.println("Key are: "+k);
        Collection v=Header.values();
        System.out.println("Values are: "+v);
        Set e=Header.entrySet();
        System.out.println("Keys and values are: "+e);
        Iterator i=e.iterator();
        while(i.hasNext())
        {
            Map.Entry entry=(Map.Entry) i.next();
            System.out.println(entry.getKey()+" : "+entry.getValue());
         }
        /*JSONArray ar=(JSONArray)jsonob.get("HeaderField");
        for(int i=0;i<ar.size();i++)
        {
            JSONObject HeaderField=(JSONObject) ar.get(i);
            String senderID=(String) HeaderField.get("senderID");
            System.out.println("Sender ID is:"+senderID);
        }*/
        
    }
}
