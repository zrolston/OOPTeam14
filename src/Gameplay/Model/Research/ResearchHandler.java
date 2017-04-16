package Gameplay.Model.Research;

import Gameplay.Model.Utility.PlayerID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Willie on 4/15/2017.
 */
public class ResearchHandler {

    private Map<PlayerID, List<Research>> playerResearch;

    public ResearchHandler(PlayerID ... playerIDs) {
        playerResearch = new HashMap<PlayerID, List<Research>>();
        for (PlayerID playerID : playerIDs)
            playerResearch.put(playerID, getAllResearch());
    }

    private List<Research> getAllResearch() {
        List<Research> research = new ArrayList<Research>();
        research.add(new RowboatFactoryResearch());
        research.add(new TruckFactoryResearch());
        research.add(new SteamerFactoryResearch());
        research.add(new OilRigResearch());
        research.add(new )
    }
}
