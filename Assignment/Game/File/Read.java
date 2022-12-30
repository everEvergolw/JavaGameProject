package Game.File;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Read the player's score from the archive
 * Provide display of all player information
 */
public class Read {


    private  HashMap<String,Integer> hm = new HashMap<>();


    /**
     Construction.
     The reading of the file is done inside
     */
    public  Read() {

        String pathname = "src/Game/File/info.txt";
        File filename = new File(pathname);
        InputStreamReader reader = null;
        try {
            reader = new InputStreamReader(new FileInputStream(filename));

            BufferedReader br = new BufferedReader(reader);
            String line = "";
            line = br.readLine();

            while (line != null) {
                saveHm(line);
                line = br.readLine();
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    /**


     Mine the player's score from the regular expression in string s saved in hm.
     * @param  s Player's toString.

     * @return Nothing.

     */
    private void saveHm(String s){
       // Simple regular expression to read the player's score

        Pattern NameP = Pattern.compile(": (.*),");
        Matcher NameM = NameP.matcher(s);

        Pattern ScoreP = Pattern.compile("(?<=Score - )\\s*\\d*[0-9]*");
        Matcher ScoreM = ScoreP.matcher(s);

        if(NameM .find() && ScoreM .find())
        {

            hm.put(NameM.group(1), Integer.valueOf(ScoreM .group()));
        }



    }


    /**


     get Player's score.
     * @param  name Player's name.

     * @return Player's score or 0.

     */
    public int getScore(String name){
        if(hm.containsKey(name))
            return hm.get(name);
        else return 0;
    }
    public HashMap<String, Integer> getHm() {
        return hm;
    }




    /**


     Show only the top 10 players

     * @return Rank information.

     */

    public String showAll(){
        String s = "RANK TOP TEN\n";
        int count = 1;

        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(hm.entrySet());
        // sort
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue() - o1.getValue());
            }
        });

        for (Map.Entry<String, Integer> entry : list) {
            s = s + count +". " + entry.getKey() + ", Score: " + entry.getValue() +"\n";
            count++;

            if(count ==11)
            break;
        }

        return s;

    }
}
