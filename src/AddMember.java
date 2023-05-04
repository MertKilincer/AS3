public class AddMember implements Command{

    private Member member;
    private Library library;

    public AddMember(Library library,String type) {
        this.library=library;
        if (type.equals("A")){
            this.member=new Academic(library.getMembers().size()+1);
            library.getMembers().add(member);
        } else if (type.equals("S")) {
            this.member=new Student(library.getMembers().size()+1);
            library.getMembers().add(member);
        }
    }

    @Override
    public void execute() {
        library.updateOutput("Created new member: "+member.info());
    }
}
