package Game.File;

import Game.Model.Player.Player;

import java.io.*;
import java.util.HashSet;

/**
 * Save all players' scores to the archive
 *
 */

public class Save {

    /**


     save Players' information.
     * @param  players All players.
     * @return Nothing

     */
    public void saveInfo(HashSet<Player> players){
        String pathname = "src/Game/File/info.txt";
        BufferedWriter bw;
        File info = new File(pathname);
        try {
        if(!info.exists()){
            info.createNewFile();
        }

        Writer Info = new FileWriter(info,true);

        bw = new BufferedWriter(Info);

        Read r = new Read();


            for (Player o : players) {
                try {
                    // Winning CurScore will +30
                    if(o.getCurScore()!=0 )
                    {
                        //Assign the score in the archive and the current score to the current player's score
                        // in order to save it as the total score accumulated by the last player
                        o.setScore(r.getScore(o.getName())+o.getCurScore());}

                    // Players who did not win read the score from the archive to continue saving
                    else o.setScore(r.getScore(o.getName()));

                    bw.write(String.valueOf(o));
                    bw.newLine();
                    bw.flush();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
