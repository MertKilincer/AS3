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

    public AddMember(Library library, String type) {
        this.library=library;
        if (type.equals("A")){
            setMember(new Academic(getLibrary().getMembers().size()+1));
            getLibrary().getAcademicList().add(getMember());

        } else if (type.equals("S")) {
            setMember(new Student(getLibrary().getMembers().size()+1));
            getLibrary().getStudentList().add(getMember());
        }
        getLibrary().getMembers().add(getMember());
    }

    @Override
    public void execute() {

        getLibrary().updateOutput("Created new member: "+getMember().info());
    }
}
