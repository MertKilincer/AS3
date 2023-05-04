public abstract class Member {
    private int id;
    private int borrowCount;

    public Member(int id){
        this.id=id;
    }
    public int getId(){
        return id;
    }

    public int getBorrowCount() {
        return borrowCount;
    }

    public void increaseBorrowCount(){
        this.borrowCount += 1;
    }
    public void decreaseBorrowCount(){
        this.borrowCount -= 1;
    }

    public String info() {
        return this.getClass().getName()+String.format("[id:%s]",this.getId());
    }
}
