import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class Model{

    private final Logger log = LoggerFactory.getLogger(Model.class);
    private MVC mvc;
    private SimpleRange range;

    public Model(MVC mvc){
        this.mvc = mvc;
        this.range = new SimpleRange();
        log.debug("Model initialized");
    }

    public SimpleRange getSimpleRange(){
        return this.range;
    }

    public void addOrRemoveSimpleHand(SimpleHand h){
        if(this.range.contains(h)){
            log.info("Removing hand {}", h.toString());
            this.range.remove(h);
        }else{
            log.info("Adding hand {}", h.toString());
            this.range.add(h);
        }
        notifyView();
    }

    private void notifyView(){
        this.mvc.getView().notifyModelChanged();
    }
}
