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
            this.member=new Academic(library.getMembers().size()+1);

            library.getAcademicList().add(member);
        } else if (type.equals("S")) {
            this.member=new Student(library.getMembers().size()+1);
            library.getStudentList().add(member);
        }
    }

    @Override
    public void execute() {
        library.getMembers().add(member);
        library.updateOutput("Created new member: "+member.info());
    }
}
