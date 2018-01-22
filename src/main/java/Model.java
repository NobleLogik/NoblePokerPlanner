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

    public void addOrRemoveSimpleHand(SimpleHand h){
        if(this.range.contains(h)){
            this.range.remove(h);
        }else{
            this.range.add(h);
        }
        notifyView();
    }

    private void notifyView(){
        this.mvc.getView().notifyModelChanged();
    }
}
