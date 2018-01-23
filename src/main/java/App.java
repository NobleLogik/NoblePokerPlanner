import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class App{

    static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args){
        log.info("Application startup");
        new MVC();
    }
}
