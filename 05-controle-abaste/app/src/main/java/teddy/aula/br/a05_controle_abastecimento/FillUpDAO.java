package teddy.aula.br.a05_controle_abastecimento;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class FillUpDAO {

    private static ArrayList<FillUp> Cache = new ArrayList<FillUp>();
    public static final String fileName = "Fillup.txt";

    public static boolean fileSave (Context context, FillUp object)
    {
        Cache.add(object);
        String save = "";
        save +=  object.getKilometers() + "&";
        save +=  object.getLiters() + "&";
        save +=  object.getDate() + "&";
        save +=  object.getGasStation() + "\n";

        File refFile = new File(context.getFilesDir().getPath() + fileName);

        try
        {
            FileWriter writer = new FileWriter(refFile, true);
            writer.write(save);
            writer.close();
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public static ArrayList<FillUp> getList (Context context)
    {
        Cache = new ArrayList<FillUp>();

        File refFile = new File(context.getFilesDir().getPath() + fileName);
        try
        {
            FileReader reader = new FileReader(refFile);
            BufferedReader lineReader = new BufferedReader(reader);

            String fillUpLine = null;

            while((fillUpLine = lineReader.readLine()) != null)
            {
                String [] lineParts =fillUpLine.split("&");
                FillUp fillUp = new FillUp();
                fillUp.setKilometers(Double.parseDouble(lineParts[0]));
                fillUp.setLiters(Double.parseDouble(lineParts[1]));
                fillUp.setDate(lineParts[2]);
                fillUp.setGasStation(lineParts[3]);

                Cache.add(fillUp);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }
        return Cache;
    }
}
