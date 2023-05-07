public class AddMember implements Command{

    private Member member;
    private final Library library;

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Library getLibrary() {
        return library;
    }

    /**
     * this creates addMember command
     * @param library library that command applied
     * @param type type of the member that can be student or academic
     */
    public AddMember(Library library, String type) {
        this.library=library;
        if (type.equals("A")){
            setMember(new Academic(getLibrary().getMembers().size()+1));//create member
            getLibrary().getAcademicList().add(getMember());//add to specific member list
        } else if (type.equals("S")) {
            setMember(new Student(getLibrary().getMembers().size()+1));//create member
            getLibrary().getStudentList().add(getMember());//add to specific member list
        }
        getLibrary().getMembers().add(getMember());//add to general member list
    }

    @Override
    public void execute() {

        getLibrary().updateOutput("Created new member: "+getMember().info());//execution output
    }
}
