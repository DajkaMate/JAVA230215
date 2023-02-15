package dm.nobeldijak;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class DMNobeldijak {
    static ArrayList<nobeldijak_adatok> NAlist = new ArrayList<>();
    public static void main(String[] args) {
        try 
        {
            System.setProperty("file.encoding", "UTF8");
            FileReader fr = new FileReader("nobel.csv");
            BufferedReader br = new BufferedReader(fr);
            String sor = null;
            String fejlec = br.readLine();
            while ((sor = br.readLine())!= null) 
            {                
                String[] dbok = sor.split(";"); 
                if (dbok.length==3)
                {
                    String vnev = " ";
                    nobeldijak_adatok NA = new nobeldijak_adatok(Integer.parseInt(dbok[0]), dbok[1], dbok[2], vnev);
                    NAlist.add(NA);
                }
                else
                {
                    nobeldijak_adatok NA = new nobeldijak_adatok(Integer.parseInt(dbok[0]), dbok[1], dbok[2], dbok[3]);
                    NAlist.add(NA);
                }
            } 
        } 
        catch (Exception e) 
        {
            System.out.println("Hiba: "+ e);
        }
        
        System.out.println("A fájlbeolvasás megtörtént");
        System.out.println("3. Feladat:");
        for (int i = 0; i < NAlist.size(); i++) 
        {
            if (NAlist.get(i).getknev().equals("Arthur B.")) System.out.println("\t"+NAlist.get(i).gettipus());
        }  
        
        System.out.println("4. Feladat:");
        for (int i = 0; i < NAlist.size(); i++) 
        {
            if (NAlist.get(i).gettipus().equals("irodalmi") && NAlist.get(i).getevszam() == 2017) System.out.println("\t"+NAlist.get(i).getvnev() + " " + NAlist.get(i).getknev());
        }  
        
        System.out.println("5. Feladat:");
        for (int i = 0; i < NAlist.size(); i++) 
        {
            if (NAlist.get(i).gettipus().equals("béke") && NAlist.get(i).getvnev().equals(" ") &&(NAlist.get(i).getevszam() > 1990 && NAlist.get(i).getevszam() < 2023)) System.out.println("\t"+NAlist.get(i).getvnev() + " " + NAlist.get(i).getknev());
        }  
        
        System.out.println("6. Feladat:");
        for (int i = 0; i < NAlist.size(); i++) 
        {
            if (NAlist.get(i).getvnev().contains("Curie")) System.out.println("\t"+NAlist.get(i).getvnev() + " " + NAlist.get(i).getknev() + " " + NAlist.get(i).getevszam());
        }  
        
        System.out.println("7. feladat");
        ArrayList<String> tipusok = new ArrayList<>();
        for (int i = 0; i < NAlist.size(); i++) {
            String temp = NAlist.get(i).gettipus();
            for (int j = 0; j < NAlist.size(); j++) 
            {
                if (!tipusok.contains(temp)) tipusok.add(temp);
            }    
        }
        for (int i = 0; i < tipusok.size(); i++) 
        {
            System.out.println("\t" + tipusok.get(i));
        }
        
        try 
        {
            System.setProperty("file.encoding", "UTF8");
            PrintWriter pw = new PrintWriter("orvosi.txt");
            for (int i = 0; i < NAlist.size(); i++)
            {
                if (NAlist.get(i).gettipus().equals("orvosi")) 
                {
                    pw.println(NAlist.get(i).getevszam()+" "+ NAlist.get(i).gettipus() + " " +NAlist.get(i).getvnev()+" "+NAlist.get(i).getknev());
                }
            }
            pw.close();
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }    
    }
}
