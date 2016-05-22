package pwr.swd.MapQuestModel;

/**
 * Created by Patryk on 04.05.2016.
 */
public class MapQuestOptions {

    private Boolean allToAll;

    public MapQuestOptions(boolean allToAll){
        this.allToAll = allToAll;
    }

    public MapQuestOptions(){
        this.allToAll = new Boolean(true);
    }

    public Boolean getAllToAll() {
        return allToAll;
    }

    public void setAllToAll(Boolean allToAll) {
        this.allToAll = allToAll;
    }
}
