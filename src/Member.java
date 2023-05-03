public abstract class Member {
    private int id;

    public Member(int id){
        this.id=id;
    }
    public int getId(){
        return id;
    }

    public String info() {
        return this.getClass().getName()+String.format("[id:%s]",this.getId());
    }
}
