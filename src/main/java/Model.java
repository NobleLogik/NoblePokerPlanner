public class Model{

    private MVC mvc;
    private SimpleRange range;

    public Model(MVC mvc){
        this.mvc = mvc;
        this.range = new SimpleRange();
    }

    public SimpleRange getSimpleRange(){
        return this.range;
    }
}
